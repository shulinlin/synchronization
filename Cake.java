import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cake {

	private char[] cake;
	private int r,c,used=0;
	Cake(int r,int c){
		this.r =r;
		this.c = c;
		cake = new char[r*c];
	}
	public void div(String init){
		for(int i=0;i<init.length();i++){
			cake[i] = init.charAt(i);
			if(cake[i]!='?')
				used++;
		}
		if(used==r*c)
			return;
		while(used!=r*c){
			distribution(cake);
		}

	}
	public void distribution(char[] cake){
		int i=0;
		while(i<r*c){
			if(cake[i]=='?'){
				i++;
				continue;
			}
			if(i-1>=0&&i%c!=0){
				if(cake[i-1]=='?'){
					cake[i-1] = cake[i];
					used++;
					i++;
					continue;
				}
				
			}
			if(i+1<r*c&&(i+1)%c!=0){
				if(cake[i+1]=='?'){
					cake[i+1]=cake[i];
					i++;
					used++;	
					i++;
					continue;
				}
				
			}
			 if(i+c<r*c){ 
				if(cake[i+c]=='?'){
					cake[i+c] = cake[i];
					used++;
					i++;
					continue;
				}
				
			}
			 if(i-c>=0){
				if(cake[i-c]=='?'){
					cake[i-c] = cake[i];
					used++;
					i++;
					continue;
				}
				
			}
			 i++;
		}
		
	}
	public void display(){
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(cake[i*r+j]);
			}
			System.out.println();
		}
			
	}
	public static void main(String[] args) throws FileNotFoundException{
		int row,col,tstcase;
		String init = "";
		File f = new File("test.txt");
		Scanner s = new Scanner(f);
		tstcase = Integer.parseInt(s.next());
		for(int i=0;i<tstcase;i++){
			row = Integer.parseInt(s.next());
			col = Integer.parseInt(s.next());
			Cake c = new Cake(row,col);
			for(int j=0;j<row;j++){
				init+=s.next();
			}
			c.div(init);
			c.display();
			init = "";
		}
		
	}
}
