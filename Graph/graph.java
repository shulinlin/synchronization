package Graph;

/**
 * Created by jerry on 5/3/17.
 */
import java.util.*;
import java.lang.System;
class vertex{
    char label;
    boolean wasVisited;

    public vertex(char vertex){
        this.label = vertex;
        wasVisited = false;
    }
}
public class graph {
    final int MAX_VERTEX = 9;// the maximum number of vertices is 20
    vertex[]  V;
    double[][] adjacency;
    int numOfVertex;
    TreeSet<Double> weight;
    public graph(){
        V = new vertex[MAX_VERTEX];
        adjacency = new double[MAX_VERTEX][MAX_VERTEX];
        numOfVertex = 0;
        weight = new TreeSet<Double>();
    }

    public void addVertex(char v){
        V[numOfVertex++] = new vertex(v);
    }

    public void addDirectedEdge(int start, int end){
        adjacency[start][end] = 1;
    }

    public void addUndirectedEdge(int start, int end , double w){
        adjacency[start][end] = w;
        adjacency[end][start] = w;
        weight.add(w);
    }
    public void showWeight(){
        for(Double d: weight)
            System.out.print(d+"  ");
    }

    public void showAdjacencyMatrix(){
        for(int i = 0; i<MAX_VERTEX; i++){
            for(int j = 0; j<MAX_VERTEX; j++){
                    System.out.print(adjacency[i][j]+"  ");
            }

            System.out.println(" ");
            System.out.println(" ");
        }
        System.out.println("----------------------");
    }

    public int getUnVisitedVertex(int index){
        for(int i = 0;i<numOfVertex; i++){
            if(adjacency[index][i] == 1 && !V[i].wasVisited)
                return i;
        }
        return -1;
    }

    public void dfs(){
        init();
        V[0].wasVisited = true;
        System.out.println("This is 0: "+V[0].label);
        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        while(!st.isEmpty()){
            int index = getUnVisitedVertex(st.peek());
            if(index == -1)
            {
                st.pop();
            }
            else{
                V[index].wasVisited = true;
                System.out.println("This is "+index+": "+V[index].label);
                st.push(index);
            }
        }
    }

    public void bfs(){
        init();
        V[0].wasVisited = true;
        System.out.println("This is 0: "+V[0].label);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int index = 0;
            while((index = getUnVisitedVertex(q.peek()))!= -1){
                V[index].wasVisited = true;
                System.out.println("This is "+index +": "+V[index].label);
                q.offer(index);
            }
            q.poll();
        }
    }
    public void init(){
        for(int i = 0; i<numOfVertex; i++){
            V[i].wasVisited = false;
        }
    }

    public LinkedList<Integer> prime(int startVertex){
        LinkedList<Integer> ans = new LinkedList<Integer>();
        ans.add(startVertex);
        while(ans.size()<numOfVertex){
            int[] edge = new int[2];
            double min = 10;
            for(int k = 0; k<ans.size(); k++){
                for(int i = 0; i<numOfVertex; i++){
                    if(adjacency[ans.get(k)][i]<min && adjacency[ans.get(k)][i]!= 0 && !ans.contains(i)){
                        edge[0] = ans.get(k);
                        edge[1] = i;
                        min = adjacency[ans.get(k)][i];
                        //System.out.println(ans.get(k)+" "+i);
                    }
                }
            }
            System.out.println("This is edge between:"+V[edge[0]].label+" "+V[edge[1]].label+" weight: "+adjacency[edge[0]][edge[1]]);
            ans.add(edge[1]);
        }

        return ans;
    }

    public void kruskal(){
        int treePath = numOfVertex-1;
        LinkedList<Integer> ans = new LinkedList<Integer>();
        while(weight.size()>0 && treePath>0){
            double min = weight.pollFirst();
            System.out.println(min);
            ArrayList<int[]> edge = new ArrayList<int[]>();
            for(int i = 0; i<numOfVertex; i++){
                for(int j = 0; j<numOfVertex; j++){
                    if(ans.contains(i)&&ans.contains(j))
                        continue;
                    else if(adjacency[i][j]==min&&adjacency[i][j]!= 0){
                        edge.add(new int[]{i,j});
                        min = adjacency[i][j];
                    }
                }
            }

            for(int[] a: edge){
                if(ans.contains(a[0])&&ans.contains(a[1]))
                    continue;
                System.out.println("This is edge between:"+V[a[0]].label+" "+V[a[1]].label+" weight: "+adjacency[a[0]][a[1]]);
                treePath--;
                if(!ans.contains(a[0]))
                    ans.add(a[0]);
                if(!ans.contains(a[1]))
                    ans.add(a[1]);

            }
        }
    }
    public void showPrime(int startVertex){
        LinkedList<Integer> list = prime(startVertex);
        for(Integer a: list){
            System.out.println(V[a].label);
        }
    }
    public static void main(String[] args){
        graph g = new graph();
        g.addVertex('0');
        g.addVertex('1');
        g.addVertex('2');
        g.addVertex('3');
        g.addVertex('4');
        g.addVertex('5');
        g.addVertex('6');
        g.addVertex('7');
        g.addVertex('8');
        g.addUndirectedEdge(0, 1, 0.4);//1
        g.addUndirectedEdge(0, 7, 0.8);//2
        g.addUndirectedEdge(1, 2, 0.8);//3
        g.addUndirectedEdge(1, 7, 1.1);//4
        g.addUndirectedEdge(2, 8, 0.2);//5
        g.addUndirectedEdge(2, 5, 0.4);//6
        g.addUndirectedEdge(2, 3, 0.7);//7
        g.addUndirectedEdge(3, 4, 0.9);//8
        g.addUndirectedEdge(3, 5, 1.4);//9
        g.addUndirectedEdge(4, 5, 0.1);//10
        g.addUndirectedEdge(5, 6, 0.2);//11
        g.addUndirectedEdge(6, 7, 0.1);//12
        g.addUndirectedEdge(6, 8, 0.6);//13
        g.addUndirectedEdge(7, 8, 0.7);//14
        //g.showAdjacencyMatrix();
        //g.showPrime(0);
        g.showWeight();
        g.kruskal();

    }

}
