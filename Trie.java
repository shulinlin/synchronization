
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
	//		count = 0;
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
			if(node.childlist[getindex(c)]==null){
			node.childlist[getindex(c)] = new Node(c);
			}
			node = node.childlist[getindex(c)];
		}
//		node.childlist[getindex(s.charAt(s.length()-1))] = new Node(s.charAt(s.length()-1));
		 node.word = true;
		
		
	}
	public void search(String s){
		Node node  = root;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(node.childlist[getindex(c)]==null){
				System.out.println("false");
				return;
			}
			if(node.childlist[getindex(c)].word){
				System.out.println("true");
				return;
			}
			
			node = node.childlist[getindex(c)];
		}
		System.out.println("false");
	}
	public static void main(String[] args){
		Trie t = new Trie();
		t.insert("hello");
		t.insert("gg");
		t.insert("eesama");
		t.insert("shulin");
		t.insert("mmeda");
		t.insert("mmd");
		t.insert("gggsima");
		t.insert("hei");
		t.insert("yo");
		
		t.search("ale");
		t.search("mmd");
		t.search("eesama");
		t.search("hello");
		t.search("hei");
		t.search("mmeda");
//		t.search("eesama");
//		t.search("shulin");
//		t.search("mmeda");
//		t.search("mmd");
//		t.search("gggsima");
//		t.search("hei");
//		t.search("yo");
	}
}
