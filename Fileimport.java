import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fileimport {

	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("dict.dat");
<<<<<<< HEAD
		String words ;
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			words = s.next();
		}
=======
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			System.out.println(s.next());
		}
		s.close();
>>>>>>> 62c54fd7d09f887b05690a77604a75978c0b2a47
	}
}
