import java.util.ArrayList;

public class Matrix {

	private ArrayList<Integer> list = new ArrayList<Integer>(10);
	Matrix(int key){
		list.add(key);
	}
	public void disp(){
		for(int i:list){
			System.out.println(i);
		}
	}
	public static void main(String[] args){
		
	}
}
