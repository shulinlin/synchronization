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
	public boolean isConnected(int from,int to){
		if(array[from].isEmpty())
			return false;
		else return DFSiterator(from).contains(to);
	}
	public void allAdjacent(int from){
		for(int i:array[from])
			System.out.print(i+" ");
		System.out.println();
	}
	public void DFSrecursive(int start){
		visited = new boolean[vertice];
		System.out.print(start+" ");
		visited[start] = true;
		for(int i:array[start]){
			if(!visited[i]&&isAdjacent(start, i))
				DFSrecursive(i);
		}
	}
	public ArrayList<Integer> DFSiterator(int start){
		visited1 = new boolean[vertice];
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		dfs.add(start);
		st.push(start);
		visited1[start] = true;
		boolean tail = false;
//		System.out.print(start+" ");
		while(!st.isEmpty()){
			int v = st.peek();
			for(int i:array[v]){
				if(!visited1[i]&&isAdjacent(v, i)){
					st.push(i);
					visited1[i] = true;
					dfs.add(i);
//					System.out.print(i+" ");
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
		return dfs;
	}
	public void BFSiterator(int start){
		visited2 = new boolean[vertice];
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
//		list.add(0, 1);
//		list.add(0, 2);
//		list.add(0, 4);
//		list.add(1, 3);
//		list.add(1, 5);
//		list.add(2, 6);
//		list.add(4, 5);
		list.add(2, 3);
		list.add(1, 2);
		System.out.println(list.isConnected(4, 0));
//		System.out.println(list.isConnected(1, 4));
//		list.DFSrecursive(0);
//		System.out.println();
//		System.out.print(list.DFSiterator(0));
////		System.out.print(list.DFSiterator(0));
//		System.out.println();
//		list.BFSiterator(0);
////		list.allAdjacent(3);
	}
}
