
public class Trie {
	private Node root;
	char[] cha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public Trie(){
		root = new Node();
		root.word = false;
	}
	private class Node{
		char content;
		boolean word;
		int count;
		Node[] childlist = new Node[26];
		public Node(char a){

			content = a;
			word = false;
			count = 0;
		}
		public Node(){

		}

	}
	public int getindex(char c){
		for(int i= 0;i<cha.length;i++){
			if(c==cha[i]){
				return i;
			}
		}
		return -1;
	}
	public void insert(String s){
		Node node = root;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			node = node.childlist[getindex(s.charAt(i))];
		}
	}
	public static void main(String[] args){

	}
}
