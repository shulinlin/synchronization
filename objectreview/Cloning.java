package objectreview;

import java.util.*;

public class Cloning{
	public static void main(String[] args){
//		ArrayList<B> arr = new ArrayList<B>();
//		String[] name={"jerry","tom","ekland"};
//		for(String i:name)
//			arr.add(new B(i,25,true));
//		@SuppressWarnings("unchecked")
//		ArrayList<B> arr1 = (ArrayList<B>) arr.clone();
//		for(B i:arr1)
//			System.out.println(i);
//		B b = arr.get(0);
//		b.setname("fku");
//		for(B i:arr1)
//			System.out.println(i);
		String nam="ss";
		HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		hash.put('c', 3);
		hash.put('a', 3);
		System.out.println(hash.get('c'));
		System.out.println(hash.get('a'));
		int i =6;
		String str = Integer.toString(i);
	}
}
