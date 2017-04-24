import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fileimport {

	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("dict.dat");
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			System.out.println(s.next());
		}
		s.close();
	}
}
