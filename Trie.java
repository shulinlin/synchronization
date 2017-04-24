import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trie {
	private Node root;
	char[] cha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public Trie(){
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
	public String search(String s){
		Node node  = root;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(node.childlist[getindex(c)]==null){
//				System.out.println("false");
				return s;
			}
			
			
			node = node.childlist[getindex(c)];
		}
		if(node.word){
//			System.out.println("true");
			return node.translation;
		}
//		System.out.println("false");
		return s;
	}
	public static void main(String[] args) throws FileNotFoundException{
		Trie t = new Trie();
		File f = new File("dict.txt");
		File f1 = new File("hw5.txt");
		Scanner s = new Scanner(f);
	//	t.insert("have");
//		t.insert("has");
		t.search("havebaby");
		t.search("have");
//		while(s.hasNextLine()){
//			t.insert(s.nextLine());
//		}
//		System.out.println("insert completed");
//		Scanner s1 = new Scanner(f1);
//		while(s1.hasNextLine()){
//			t.search(s1.nextLine());
//		}
	}
}
