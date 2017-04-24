import java.util.ArrayList;

public class Perfecthash {

	private class Node{
		
		ArrayList<Integer> num = new ArrayList<Integer>(3);
		int val;
		Node[] subnode;
		Node(int n){
			num.add(n);
		}
	}
	private Node[] table;
	private Node[] subnode = new Node[3];
	private int count;
	public Perfecthash(int inial){
		table = new Node[inial];
	}
	public final int hash1(int num){
		return num%table.length;
	}
	public final int hash2(int num){
	
		return num%subnode.length;
	}
	public void grow(ArrayList<Integer> num){
		Node[] temp = new Node[subnode.length+2];
		subnode = temp;
		subadd(num);
			
		
	}
	public void add(int key){
		count++;
		int pos = hash1(key);
		if(table[pos]!=null){
			table[pos].num.add(key);
			table[pos].subnode = subnode;
			subadd(table[pos].num);
		}
		table[pos] = new Node(key);
		
	}
	public void subadd(ArrayList<Integer> num) {
		// TODO Auto-generated method stub
		for(int i:num){
			int pos2 = hash2(i);
			if(subnode[pos2]!=null){
					grow(num);
					return;
			}
			subnode[pos2] = new Node(i);
			
		}
		
	}
	public boolean search(int i){
		int pos = hash1(i);
		for(int number:table[pos].num){
			if(number==i)
				return true;
		}
		return false;
			
	}
	public static void main(String[] args){
		Perfecthash ph = new Perfecthash(10);
		int[] str={9,12,34,20,12};
		for(int number:str)
			ph.add(number);
		System.out.println(ph.search(13));
		System.out.println(ph.search(12));
		System.out.println(ph.search(15));
			
	}
}
