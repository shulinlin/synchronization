import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Linearprobing {

	private static class Node{
		String key = "null";
		Node(String key){
			this.key = key;
		}
		Node(){
			key = "null";
		}
	}
	private int count;
	private Node[] table;
	private int[] hist;
	private final int hash(String key){
		int hash = key.length();
		for(int i=0;i<key.length();i++){
			hash = 31*hash+key.charAt(i);
		}
		return Math.abs(hash)%table.length;
	}
	public void grow(){
		Node[] table1 = new Node[2*table.length];
		String[] temp = new String[count];
		int j=0;
		for(int i=0;i<table.length;i++){
			if(table[i]==null)
				continue;
			temp[j]= table[i].key;
			j++;
		}
		table= table1;
		//		System.out.println("count is "+count);
		count=0;
		for(String s:temp)	
			add(s);

	}

	public Linearprobing(int init){
		table = new Node[init];
		hist = new int[init];
	}
	public void load() throws FileNotFoundException{
		File f= new File("test.txt");
		Scanner s = new Scanner(f);
		while(s.hasNext()){
			String word = s.next();
			add(word);
		}
	}
	public void add(String word){
		display();
		if(2*count>table.length)
			grow();
		display();
		int pos = hash(word);
		System.out.println(pos+" ");
		while(table[pos]!=null){
			if(table[pos].key.equals(word)){
				return;
			}
			pos++;
			if(pos>table.length-1)
				pos=0;
		}
		table[pos]= new Node(word);
		count++;
	}
	public boolean search(String word){
		int pos = hash(word);
		while(table[pos]!=null){
			if(table[pos].key.equals(word))
				return true;
			pos++;
			if(pos>=table.length)
				pos=0;
		}
		return false;
	}
	public void display(){
		for(int i=0;i<table.length;i++){
			if(table[i]==null){
				System.out.print("null"+"\t");
				continue;
			}
			System.out.print(table[i].key+"\t");

		}
		System.out.println();
	}
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("dict.txt");
		Scanner s = new Scanner(f);
		s.close();
		Linearprobing l = new Linearprobing(1);
//		while(s.hasNext()){
//			l.add(s.next());
//		}
//		s.close();
		String[] str = {"aa","abc","abcd","itouch","ggs"};
		for(String ss:str)
			l.add(ss);
		l.display();
		System.out.println(l.search("aa"));
		System.out.println(l.search("hello"));
		System.out.println(l.search("aab"));

	}
}
