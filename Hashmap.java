import java.io.*;
import java.util.*;

public class Hashmap {
	//  private String[] keys;
	//	private int values[];

	private static class Node {
		String key;
		int val;
		Node next;
		Node(String k, int v) { key = k; val = v; }
	}
	private Node[] table;
	private int used;
	private int[] hist;
	private final int hash(String word) {
		int sum = word.length();
		for (int i = 0; i < word.length(); i++)
			sum = sum << 13 + sum << 3 + word.charAt(i) + sum >> 17;
		return sum & (table.length-1);
	}
	private void grow() {
		// double in size, reinsert all elements
	}
	public Hashmap(int initialSize) {
		table = new Node[initialSize];
		used = 0;
		hist = new int[12];
	}

	public void load(String filename) throws Exception {
		FileReader r = new FileReader(filename);
		Scanner s = new Scanner(r);
		int count = 0;
		while (s.hasNext()) {
			String word = s.next();
			add(word, count++);
		}
		s.close();
	}

	public void add(String word, int v) {
		
		int pos = hash(word);
	//	System.out.println(pos);
		Node current = table[pos];
		Node temp = current;
		int count = 1;
		while(temp!=null){
			current = temp;
			temp = temp.next;
			current.next = temp;
		}
//		while (table[pos] != null) {
//			if (table[pos].key.equals(word)) {
//				table[pos].val = v;
//				if (count > 11)
//					count = 11;
//				hist[count]++;
//				return;
//			}
			temp = new Node(word,v);
//		}
		// guaranteed that table[pos].key == null
		used++;
		if(count>11)
			count=11;
		hist[count]++;
	}

	public boolean contains(String word) {
		int pos = hash(word);
		Node temp = table[pos];
		while (temp != null) {
			if (temp.key.equals(word))
				return true;
			temp = temp.next;
			
		}
		return false;
	}
	public void printHist() {
		for (int i = 1; i < 12; i++) {
			System.out.println(i + "\t" + hist[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Hashmap m = new Hashmap(1000);
		m.load("dict.txt");
		//	m.load("c++keywords.dat");
		/*
				Integer v = m.get("cat");
		if (v != nullptr) {
			cout << v.intValue() << '\n';
		}
		 */
		System.out.println(m.contains("hello"));
		System.out.println(m.contains("aa"));
		m.printHist();
	}
}