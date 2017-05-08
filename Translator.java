import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.glass.events.KeyEvent;
import javafx.event.*;


public class Translator extends JFrame implements ActionListener{
	Translator(Trie dict){
		super("Translator");
		setSize(600,600);
		Container c = getContentPane();
		JButton clear = new JButton("Clear");
		JButton translate = new JButton("Translate");
		JTextArea t1 = new JTextArea(20,100);
		JTextArea t2 = new JTextArea(20,100);
		t2.setEditable(false);
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		//	menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext();
		menubar.add(menu);
		JMenuItem open = new JMenuItem("Open");
		//	open.setMnemonic(KeyEvent.VK_A);
		menu.add(open);
		JMenuItem save = new JMenuItem("Save");
		//	save.setMnemonic(KeyEvent.VK_A);
		menu.add(save);
		JMenuItem quit = new JMenuItem("Quit");
		//	quit.setMnemonic(KeyEvent.VK_A);
		menu.add(quit);
		JPanel p1= new JPanel(new GridLayout(1, 2,10,10));
		JPanel p2 = new JPanel(new GridLayout(1, 2,10,10));
		c.add(BorderLayout.CENTER,p1);
		c.add(BorderLayout.SOUTH,p2);
		c.add(BorderLayout.NORTH,menubar);
		p1.add(t1);
		p1.add(t2);
		p2.add(clear);
		p2.add(translate);
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t1.setText("");
				t2.setText("");
			}
		});
		translate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] txt = t1.getText().split(" ");
				String trans = "";
				for(String i : txt)
					trans+=dict.search(i);
				t2.setText(trans);

			}
		});
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser choose = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("dat","txt");
				choose.setFileFilter(filter);
				choose.showOpenDialog(null);
				File f1 = choose.getSelectedFile();
				String dis="";
				try {
					Scanner s1 = new Scanner(f1);
					while(s1.hasNextLine()){
						dis+=s1.next();
					}
					t1.setText(dis);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser sav = new JFileChooser();
				sav.showSaveDialog(null);
				String path = sav.getSelectedFile().toString();
				try{
					FileWriter writer = new FileWriter(path);
					writer.write(t1.getText()+" ");
					writer.flush();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		});
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
		});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws FileNotFoundException{

		Trie dict = new Trie();
		Translator t = new Translator(dict);
		File f = new File("dict.dat");
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			dict.insert(s.next(),s.next());
		}
		s.close();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
class Trie1 {
	private Node root;
	char[] cha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public Trie1(){
		root = new Node();
		root.word = false;
	}
	class Node{
		char content;
		String translation;
		boolean word;
		int count;
		Node[] childlist = new Node[26];
		public Node(char a){

			content = a;
			word = false;
			//		count = 0;
		}
		public Node(){

		}

	}
	public int getindex(char c){
		for(int i= 0;i<cha.length;i++){
			if(c==cha[i]){
				return i;
			}
		}
		return -1;
	}
	public void insert(String s,String translation){
		Node node = root;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(node.childlist[getindex(c)]==null){
				node.childlist[getindex(c)] = new Node(c);
			}
			node = node.childlist[getindex(c)];
		}
		//		node.childlist[getindex(s.charAt(s.length()-1))] = new Node(s.charAt(s.length()-1));
		node.word = true;
		node.translation = translation;


	}
}
//	public String search(String s){
//		Node node  = root;
//		for(int i=0;i<s.length();i++){
//			char c = s.charAt(i);
//			if(node.childlist[getindex(c)]==null){
//				//				System.out.println("false");
//				return "";
//			}
//
//
//			node = node.childlist[getindex(c)];
//		}
//		if(node.word){
//			//			System.out.println("true");
//			return node.translation;
//		}
//		//		System.out.println("false");
//		return "";
//	}
//}
//class Trie {
//	private Node root;
//	char[] cha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//	public Trie(){
//		root = new Node();
//		root.word = false;
//	}
//	 class Node{
//		 char content;
//		 String translation;
//		boolean word;
//		int count;
//		Node[] childlist = new Node[26];
//		public Node(char a){
//
//			content = a;
//			word = false;
//	//		count = 0;
//		}
//		public Node(){
//
//		}
//
//	}
//	public int getindex(char c){
//		for(int i= 0;i<cha.length;i++){
//			if(c==cha[i]){
//				return i;
//			}
//		}
//		return -1;
//	}
//	public void insert(String s,String translation){
//		Node node = root;
//		for(int i=0;i<s.length();i++){
//			char c = s.charAt(i);
//			if(node.childlist[getindex(c)]==null){
//			node.childlist[getindex(c)] = new Node(c);
//			}
//			node = node.childlist[getindex(c)];
//		}
////		node.childlist[getindex(s.charAt(s.length()-1))] = new Node(s.charAt(s.length()-1));
//		 node.word = true;
//		 node.translation = translation;
//		
//		
//	}
//	public String search(String s){
//		Node node  = root;
//		for(int i=0;i<s.length();i++){
//			char c = s.charAt(i);
//			if(node.childlist[getindex(c)]==null){
////				System.out.println("false");
//				return s;
//			}
//			
//			
//			node = node.childlist[getindex(c)];
//		}
//		if(node.word){
////			System.out.println("true");
//			return node.translation;
//		}
////		System.out.println("false");
//		return s;
//	}
//}
