package Graph;

import java.util.*;

public class List {
	private LinkedList<Integer> array[];
	private int vertice;
	public List(int vertice){
		this.vertice = vertice;
		array = new LinkedList[vertice];
		for(int i=0;i<vertice;i++)
			array[i] = new LinkedList<Integer>();
	}
	public void add(int from,int to){
		array[from].add(to);
	}
	public boolean isAdjacent(int from,int to){
		if(array[from].contains(to))
			return true;
		return false;
	}
	public void allAdjacent(int from){
		for(int i:array[from])
			System.out.print(i+" ");
		System.out.println();
	}
	public static void main(String[] args){
		List list = new List(4);
		list.add(0,1);
		list.add(0,2);
		list.add(0,3);
		list.add(1,0);
		list.add(1,3);
		list.add(2,0);
		list.add(2,3);
		list.add(3,1);
		list.add(3,2);
		System.out.println(list.isAdjacent(2, 1));
		list.allAdjacent(3);
	}
}
class Vertice{
	
}
