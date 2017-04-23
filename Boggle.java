import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Boggle{

	private char[] boggle = new char[16];
	private boolean[] isused = new boolean[16];
	private String prefix = "";
	private int length=0;
	Boggle(Tri t,char[] c){
		for(int i=0;i<c.length;i++){
			boggle[i] = c[i];
		}
		//		for(char s:boggle)
		//		System.out.print(s);
		for(int i=0;i<boggle.length;i++){
			find(i,t,prefix);
			prefix = "";
		}
	}
	public void reset(int i){
		isused[i] = false;
	}
	public void find(int i,Tri t,String word){

		word += boggle[i];
		isused[i] = true;
		if(t.contains(word)&&word.length()>=3){
			System.out.println("i have "+word);
		}
		if(t.containsprefix(word)){
			if((i+1)%4!=0&&!isused[i+1]){
				find(i+1,t,word);
				reset(i+1);
			}
			if(i+5<16&&(i+1)%4!=0&&!isused[i+5]){
				find(i+5,t,word);
				reset(i+5);
			}
			if(i+4<16&&!isused[i+4]){
				find(i+4,t,word);
				reset(i+4);
			}
			if(i+3<16&&i%4!=0&&!isused[i+3]){
				find(i+3,t,word);
				reset(i+3);
			}
			if(i%4!=0&&!isused[i-1]){
				find(i-1,t,word);
				reset(i-1);
			}
			if(i-5>=0&&i%4!=0&&!isused[i-5]){
				find(i-5,t,word);
				reset(i-5);
			}
			if(i-4>=0&&!isused[i-4]){
				find(i-4,t,word);
				reset(i-4);
			}
			if(i-3>=0&&(i+1)%4!=0&&!isused[i-3]){
				find(i-3,t,word);
				reset(i-3);
			}
			//			if(i-5>=0&&
		}
		reset(i);

		//		System.out.println("i dont have "+word);
		//		prefix = "";

	}
	public static void main(String[] args) throws FileNotFoundException{
		Tri t = new Tri();
		int n;
		File f1 = new File("dict.txt");
		File f2 = new File("boggle.dat");
		Scanner s = new Scanner(f1);
		while(s.hasNext()){
			t.add(s.next());
		}
		s.close();
		s = new Scanner(f2);
		n = s.nextInt();
		char[] bog = new char[n*n];
		int i=0;
		while(s.hasNext()){
			bog[i] = s.next().charAt(0);
			i++;
		}
		Boggle b = new Boggle(t,bog);

	}
}
class Tri{
	private String word;
	public class Node{
		Node[] child = new Node[26]; 
		char key;
		boolean isword;
		Node(char c){
			key = c;
			isword = false;
		}
		Node(){

		}
	}
	Node root = new Node();
	public void add(String key){
		key =key.toLowerCase(Locale.ROOT);
		Node temp = root;
		for(int i=0;i<key.length();i++){
				if(root.child[key.charAt(i)-'a']==null){
				root.child[key.charAt(i)-'a'] = new Node(key.charAt(i));
			}
			root = root.child[key.charAt(i)-'a'];
			}
//		}
		root.isword = true;
		root = temp;


	}
	public boolean contains(String key){
		Node temp = root;
		for(int i=0;i<key.length();i++){
			if(temp.child[key.charAt(i)-'a']==null)
				return false;
			temp = temp.child[key.charAt(i)-'a'];
		}
		return temp.isword; 
	}
	public boolean containsprefix(String pre){
		Node temp = root;
		for(int i=0;i<pre.length();i++){
			if(temp.child[pre.charAt(i)-'a']!=null)
				temp = temp.child[pre.charAt(i)-'a'];
			else
				return false;
		}
		for(int j=0;j<26;j++){
			if(temp.child[j]==null)
				continue;
			else
				return true;
		}
		return false;
	}
}
