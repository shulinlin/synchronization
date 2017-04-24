import java.util.Locale;

public class Boggletest {
	private char[] table = new char[9];
	private boolean[] visited = new boolean[9];
	private String word = "";
	private int length = 0;
	Boggletest(char[] letters){
		for(int i=0;i<letters.length;i++){
			table[i] = letters[i];
		}
		for(int i=0;i<visited.length;i++){
			visited[i] = false;
		}
		backtracking(0,word,'l');
	}
	public void backtracking(int i,String word,char from){
			if(word.length()!=4){
				word+=table[i];
				visited[i]=true;
				if((i+1)%3!=0&&from!='r')
					backtracking(i+1,word,'l');
				if(i%3!=0&&from!='l')
					backtracking(i-1,word,'r');
				if(i+3<table.length&&from!='d')
					backtracking(i+3,word,'u');
				if(i-3>=0&&from!='u')
					backtracking(i-3,word,'d');
			}
			else{
				System.out.println(word);
			}
	}
	public static void main(String[] args){
		String s ="Abo";
		s= s.toLowerCase(Locale.ROOT);
		System.out.println(s);
		for(int i=0;i<s.length();i++){
			System.out.println(s.charAt(i)-'a');
		}
	}

}
