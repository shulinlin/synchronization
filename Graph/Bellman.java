package Graph;

public class Bellman {
	class Edge{
		int src,dest,weight;
		Edge(){
			src = dest = weight = 0;
		}
	}
	int E,V;
	Edge edge[];
	public Bellman(int E,int V){
		this.E = E;
		this.V = V;
		edge = new Edge[E];
		for(int i=0;i<E;i++){
			edge[i] = new Edge();
		}
	}
	public int[] bellmanford(int src){

// first step :initialize
		int v = V;int e = E;
		int dist[] = new int[v];
		for(int i=0;i<v;i++){
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
//second step :
		for(int i=1;i<v;i++){
			
			for(int j=0;j<e;j++){
				int u = edge[j].src;
				int d = edge[j].dest;
				int weight = edge[j].weight;
				if(dist[u]!=Integer.MAX_VALUE&&dist[u]+weight<dist[d])
					dist[d] = dist[u]+weight;
			}
		}
// third step:	check for negative-weight cycles
		for(int j=0;j<e;j++){
			int u = edge[j].src;
			int d = edge[j].dest;
			int weight = edge[j].weight;
			if(dist[u]!=Integer.MAX_VALUE&&dist[u]+weight<dist[d])
				System.out.println("Negative weight");
		}
		return dist;
		
	}
	public static void main(String[] args){
		
	}
}

