<<<<<<< HEAD
=======
package Graph;

>>>>>>> 40dceafd0e983baeedf152dd6dabbceb35b0ec10
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class testG {
	final static int MAX=10;
	private int [][] G=new int[MAX][MAX];
	private int v;
	public testG(int v){
		this.v=v;
	}
	public void addE(int i,int j){
		G[i][j]=G[j][i]=1;
	}
	public void addEEW(int i,int j,int w){
		G[i][j]=G[j][i]=w;
	}
	public void addEW(int i,int j,int w){
		G[i][j]=w;
	}
	public boolean isAdjacent(int i,int j){
		if(G[i][j]!=0)
			return true;
		return false;
	}
	public void bfs(){
		boolean[] visited=new boolean[v];
		Queue<Integer> q=new LinkedList();
		q.add(0);
		visited[0]=true;
		while(!q.isEmpty()){
			int now = q.poll();
			for(int i=0;i<v;i++){
				if(!visited[i]&&isAdjacent(now, i)){
					visited[i]=true;
					q.offer(i);
					System.out.println(i);
				}
			}
		}
	}
	public void dfs(){
		boolean[] visited=new boolean[v];
		Stack<Integer> s=new Stack();
		s.push(0);
		visited[0]=true;
		while(!s.isEmpty()){
			int now=s.peek();
			boolean f=false;
			for(int i=0;i<v;i++){
				if(!visited[i]&&isAdjacent(now, i)){
					visited[i]=true;
					s.push(i);
					System.out.println(i);
					f=true;
					break;
				}
			}
			if(!f)
				s.pop();
		}
	}
	
	public void BellmanFord(int now){
		int[] dist=new int[v];
		for(int i=0;i<v;i++){
			dist[i]=2000;
		}
		dist[now]=0;
		for(int k=0;k<v;k++)
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				if(isAdjacent(i, j)){
					if(dist[i]+G[i][j]<dist[j]){
						dist[j]=dist[i]+G[i][j];
					}
				}
			}
		}
		for(int i=0;i<dist.length;i++){
			if(dist[i]!=2000)
				System.out.println(dist[i]);
			else
				System.out.println("INF");
		}
	}
	public void FloydWarshall(int start,int end){
		int[][] dist=new int[v][v];
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				dist[i][j]=G[i][j];
				if(G[i][j]==0)
					dist[i][j]=2000;
				if(i==j)
					dist[i][j]=0;
			}
		}
		for(int k=0;k<v;k++){
			for(int i=0;i<v;i++){
				for(int j=0;j<v;j++){
		            if(dist[i][k]+dist[k][j]<dist[i][j]){
			              dist[i][j]=dist[i][k]+dist[k][j];
			        }
		        }
			}
		}
		if(dist[start][end]!=2000)
			System.out.println(dist[start][end]);
		else
			System.out.println("INF");

	}
	public void dfs2(int now,boolean[] visited){
		visited[now]=true;
		for(int i=0;i<v;i++){
			if(isAdjacent(now, i)&&!visited[i]){
				System.out.println(i);
				dfs2(i,visited);
			}
		}
	}
	
	public void findallAdjacent(int now){
		for(int i=0;i<v;i++){
			if(isAdjacent(now, i))
				System.out.println(i);
		}
	}
	public testG Prim(int now){
		testG a=new testG(v);
		HashMap<Integer,Integer> used=new HashMap<>();
		HashMap<Integer,Integer> have=new HashMap<>();
		for(int i=0;i<v;i++){
			have.put(i,1);
		}
		have.remove(now);
		used.put(now, 1);
		while(!have.isEmpty()){
			int min=2000;
			int tmp=-1;
			int tmpx=-1;
			for(int x : used.keySet()){
				for(int i=0;i<v;i++){
					if(i!=x&&have.containsKey(i)&&isAdjacent(i, x)){
						if(G[x][i]<min){
							tmp=i;
							tmpx=x;
							min=G[x][i];
						}
					}
				}
			}
			a.addEEW(tmp, tmpx , min);
			have.remove(tmp);
			used.put(tmp, 1);
		}
		return a;
	}
	
	static class Edge{
		int a,b,w;
		public Edge(int a,int b,int w){
			this.a=a;
			this.b=b;
			this.w=w;
		}
	}
	public boolean isConnected(int a,int b){
		boolean[] visited=new boolean[v];
		Queue<Integer> q=new LinkedList();
		q.add(a);
		visited[a]=true;
		while(!q.isEmpty()){
			int now = q.poll();
			for(int i=0;i<v;i++){
				if(!visited[i]&&isAdjacent(now, i)){
					visited[i]=true;
					q.offer(i);
					if(i==b)
						return true;
				}
			}
		}
		return false;
	}
	public testG Kruskal(int now){
		testG a=new testG(v);
		ArrayList<Edge> e=new ArrayList<>();
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				if(i<j&&isAdjacent(i, j))
					e.add(new Edge(i,j,G[i][j]));
			}
		}
		Collections.sort(e, new Comparator<Edge>() {
	        @Override public int compare(Edge p1, Edge p2) {
	            return p1.w- p2.w;
	        }
	    });
		int p=0;
		int linenumber=0;
		while(linenumber<v-1){
			Edge tmp=e.get(p);
			p++;
			if(a.isConnected(tmp.a, tmp.b))
				continue;
			a.addEEW(tmp.a, tmp.b, tmp.w);
			linenumber++;
		}
		return a;
	}
	
	public void print(){
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				System.out.print(G[i][j]+"\t");
			}
			System.out.println();
			System.out.println();
		}
	}
	public static void main(String[] args){
		testG a=new testG(7);
		a.addEW(0, 1, 3);
		a.addEW(3, 0, 1);
		a.addEW(3, 6, 4);
		a.addEW(5, 3, 2);
		a.addEW(1, 2, 1);
		a.addEW(1, 4, 2);
		a.addEW(1, 5, 3);
		a.addEW(2, 0, 9);
		a.bfs();
		System.out.println();
		a.dfs();
		System.out.println();
		a.dfs2(0, new boolean[7]);
		System.out.println();
		a.findallAdjacent(0);
		System.out.println();
		a.BellmanFord(0);
		a.FloydWarshall(3, 4);
		System.out.println();
		System.out.println();
		testG b=new testG(7);
		b.addEEW(0, 1, 5);
		b.addEEW(0, 2, 3);
		b.addEEW(0, 3, 9);
		b.addEEW(0, 5, 1);
		b.addEEW(1, 5, 7);
		b.addEEW(1, 6, 4);
		b.addEEW(1, 3, 1);
		b.addEEW(3, 2, 3);
		b.addEEW(2, 4, 2);
		b.addEEW(5, 6, 2);
		testG c=b.Prim(0);
		c.print();
		System.out.println();
		testG d=b.Kruskal(0);
		d.print();
	}
}
