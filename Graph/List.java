package Graph;

import java.util.*;

public class List {
	private LinkedList<Integer> array[];
	private boolean visited[];
	private boolean visited1[];
	private boolean visited2[];
	private int vertice;
	public List(int vertice){
		this.vertice = vertice;
		array = new LinkedList[vertice];
		for(int i=0;i<vertice;i++)
			array[i] = new LinkedList<Integer>();
		visited = new boolean[vertice];
		visited1 = new boolean[vertice];
		visited2 = new boolean[vertice];
	}
	public void add(int from,int to){
		array[from].add(to);
		array[to].add(from);
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
	public void DFSrecursive(int start){
		System.out.print(start+" ");
		visited[start] = true;
		for(int i:array[start]){
			if(!visited[i]&&isAdjacent(start, i))
				DFSrecursive(i);
		}
	}
	public void DFSiterator(int start){
		Stack<Integer> st = new Stack<Integer>();
		st.push(start);
		visited1[start] = true;
		boolean tail = false;
		System.out.print(start+" ");
		while(!st.isEmpty()){
			int v = st.peek();
			for(int i:array[v]){
				if(!visited1[i]&&isAdjacent(v, i)){
					st.push(i);
					visited1[i] = true;
					System.out.print(i+" ");
					break;
				}	
				if(array[v].getLast()==i)
					tail = true;
			}
			if(tail){
				st.pop();
				tail = false;
			}
		}
	}
	public void BFSiterator(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited2[start] =true;
		while(!q.isEmpty()){
			int v = q.poll();
			System.out.print(v+" ");
			for(int i:array[v]){
				if(!visited2[i]&&isAdjacent(v, i)){
					q.offer(i);
					visited2[i] = true;
					
				}
			}
		}
	}
	public static void main(String[] args){
		List list = new List(7);
		list.add(0, 1);
		list.add(0, 2);
		list.add(0, 4);
		list.add(1, 3);
		list.add(1, 5);
		list.add(2, 6);
		list.add(4, 5);
		list.DFSrecursive(0);
		System.out.println();
		list.DFSiterator(0);
		System.out.println();
		list.BFSiterator(0);
//		list.allAdjacent(3);
	}
}
