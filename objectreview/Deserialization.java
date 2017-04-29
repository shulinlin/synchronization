package objectreview;

import java.io.*;

public class Deserialization {
	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("F:\\test.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		A a2 = (A)ois.readObject();
		ois.close();
		fis.close();
		System.out.println("Deserialization is completed !");
		System.out.println(a2);
	}
}
