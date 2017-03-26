import java.io.*;
import java.util.*;

public class Hashmap {
	private static class Node {
		String key;
		Node next;
		Node(String k) { key = k;  }
	}
	private Node[] table;
	private int used;
	private int[] hist;
	private final int hash(String word) {
		int hash = word.length();
		for (int i = 0; i < word.length(); i++)
			hash = 31*hash + word.charAt(i);
		return Math.abs(hash) % (table.length);
	}
	public Hashmap(int initialSize) {
		table = new Node[initialSize];
		used = 0;
		hist = new int[initialSize];
	}

	public void load(String filename) throws Exception {
		FileReader r = new FileReader(filename);
		Scanner s = new Scanner(r);
		while (s.hasNext()) {
			String word = s.next();
			add(word);
		}
		s.close();
	}
	public void add(String word) {
		int pos = hash(word);
		Node current = table[pos];
		Node temp = new Node(word);
		temp.next = table[pos];
		table[pos] = temp;
		used++;
		hist[pos]++;
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
		for (int i = 0; i < hist.length; i++) {
			System.out.println(i + "\t" + hist[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Hashmap m = new Hashmap(26);
		m.load("dict.txt");
		File f = new File("hw8.dat");
		Scanner s = new Scanner(f);
		while(s.hasNext()){
			System.out.println(m.contains(s.next()));
		}
		m.printHist();
	}
}