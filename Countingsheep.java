import java.util.ArrayList;

public class Countingsheep {

	private ArrayList<Integer> count = new ArrayList<Integer>(1);
	public Countingsheep(int n){
		int temp = n;
		int mul = 1;
		while(temp*mul<1000000){
			temp = mul*n;
			while(temp!=0){
				if(count.contains(temp%10)){
					temp = temp/10;
					continue;
				}
				count.add(temp%10);
				temp = temp/10;
			}
			if(count.size()==10){
				System.out.println(mul*n);
				return;

			}
			mul++;
		}

		System.out.println("insomnia");
	}
	public static void main(String[] args){
		Countingsheep s = new Countingsheep(0);
	}
}
