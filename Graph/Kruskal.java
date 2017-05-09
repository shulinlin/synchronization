package Graph;
import java.util.*;

public class Kruskal {
	static class Edge{
		char vertex1,vertex2;
		int weight;
		Edge(){
			vertex1=vertex2;
			weight = 0;
		}
		public String toString(){
			return weight+" ";
		}
	}
	Edge[] edge;
	int v,e;
	List list1;
	public Kruskal(int v,int e){
		this.v = v;
		this.e = e;
		edge = new Edge[e];
		for(int i=0;i<e;i++){
			edge[i] = new Edge();
		}
	}
	public ArrayList<Integer> method(){
		ArrayList<Edge> tree = new ArrayList<Edge>();
		ArrayList<Edge> ans = new ArrayList<Edge>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
 		list1 = new List(v);
		for(Edge e:edge)
			tree.add(e);
		Collections.sort(tree,new Comparator<Edge>(){

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.weight-o2.weight;
			}
		});
//		for(Edge e:tree)
//			System.out.print(e);
		for(int i=0;i<tree.size();i++){
			int v1 = tree.get(i).vertex1-'A';
//			System.out.print(v1);
			int v2 = tree.get(i).vertex2-'A';
//			System.out.print(v2);
			if(i<=1){
			list1.add(v1, v2);
			answer.add(tree.get(i).weight);
			continue;
			}
			if(!list1.isConnected(v1, v2)){
				list1.add(v1, v2);
				answer.add(tree.get(i).weight);
			}
				
		}
		return answer;
	}
	public static void main(String[] args){
		Kruskal kru = new Kruskal(5,5);
			kru.edge[0].vertex1='A';
			kru.edge[0].vertex2='B';
			kru.edge[0].weight = 1;
			kru.edge[1].vertex1='B';
			kru.edge[1].vertex2='C';
			kru.edge[1].weight = 3;
			kru.edge[2].vertex1='C';
			kru.edge[2].vertex2='D';
			kru.edge[2].weight = 2;
			kru.edge[3].vertex1='D';
			kru.edge[3].vertex2='E';
			kru.edge[3].weight = 5;
			kru.edge[4].vertex1='E';
			kru.edge[4].vertex2='A';
			kru.edge[4].weight = 4;
			
		
		System.out.print(kru.method());
	}
}
