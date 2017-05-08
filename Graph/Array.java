package Graph;

import java.util.*;

public class Array {
	private int[][] array;
	private int ver;
	private boolean visited[];
	private boolean visited1[];
	public Array(int ver){
		this.ver = ver;
		array = new int[ver][ver];
		visited = new boolean[ver];
		visited1 = new boolean[ver];
	}
	public void setv(int from,int to){
		array[from][to]=1;
	}
	public boolean isAdjacent(int from,int to){
		if(array[from][to]!=0)
			return true;
		return false;
	}
	public void allAdjacent(int from){
		for(int i=0;i<ver;i++){
			if(array[from][i]!=0){
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
	public void DFSrecursive(int start){
		System.out.print(start+" ");
		for(int i=0;i<ver;i++){
			visited[start]=true;
			if(array[start][i]!=0){
				if(visited[i])
					continue;
			DFSrecursive(i);
			}
		}
	}
	public void DFSiterator(int start){
		Stack<Integer> st = new Stack<Integer>();
		st.push(start);
		visited1[start] = true;
		while(!st.isEmpty()){
			int v = st.pop();
			System.out.print(v+" ");
			for(int i=0;i<ver;i++){
				if(array[v][i]!=0){
					if(visited1[i])
						continue;
					visited1[i] = true;
					st.push(i);
				}
			}
		}
		
	}
	public static void main(String[] args){
		Array arr = new Array(7);
		arr.setv(0, 1);
		arr.setv(0, 2);
		arr.setv(0, 4);
		arr.setv(1, 0);
		arr.setv(1, 3);
		arr.setv(1, 5);
		arr.setv(2, 0);
		arr.setv(2, 6);
		arr.setv(3, 1);
		arr.setv(4, 0);
		arr.setv(4, 5);
		arr.setv(5, 1);
		arr.setv(5, 4);
		arr.setv(6, 2);
		arr.DFSrecursive(0);
		System.out.println();
		arr.DFSiterator(0);
		
//		System.out.println(arr.isAdjacent(1, 2));
//		arr.allAdjacent(1);
//		arr.allAdjacent(0);
//		arr.allAdjacent(2);
//		arr.allAdjacent(3);
		
		
	}
}
