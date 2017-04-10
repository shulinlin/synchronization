
public class Boggle {

	private char[] boggle = new char[16];
	private boolean[] isused = new boolean[16];
	Boggle(){
		for(int i=0;i<boggle.length;i++){
			find(i);
		}
	}
	public void find(int i){
		
	}
	public static void main(String[] args){
		Tri t = new Tri();
		
	}
}
class Tri{
	public class Node{
		Node[] child = new Node[26]; 
		char key;
		boolean isword;
		Node(char c){
			key = c;
			isword = false;
		}
		Node(){

		}
	}
	Node root = new Node();
	public void add(String key){
		Node temp = root;
		for(int i=0;i<key.length();i++){
			if(root.child[key.charAt(i)-'a']==null){
				root.child[key.charAt(i)-'a'] = new Node(key.charAt(i));
			}
			root = root.child[key.charAt(i)-'a'];
		}
			root.isword = true;
			root = temp;

		
	}
	public boolean contains(String key){
		Node temp = root;
		for(int i=0;i<key.length();i++){
			if(temp.child[key.charAt(i)-'a']==null)
				return false;
			temp = temp.child[key.charAt(i)-'a'];
		}
		return temp.isword; 
	}
	public boolean containsprefix(String pre){
		Node temp = root;
		for(int i=0;i<pre.length();i++){
			if(temp.child[pre.charAt(i)-'a']!=null)
				temp = temp.child[pre.charAt(i)-'a'];
			else
				return false;
		}
		for(int j=0;j<26;j++){
			if(temp.child[j]==null)
				continue;
			else
				return true;
		}
		return false;
	}
}
