package seleniumPractice;

import java.util.Arrays;

public class MutableVsImmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 20, 50, 10, 5, 25, 30, 35 };
		System.out.println(Arrays.toString(a));
		Arrays.sort(a); // Mutable , its changing the original array of positions
		System.out.println(Arrays.toString(a));
		
		// immutable
		
		String s= "Welcome";
		
		System.out.println(s);  // Welcome
		s.concat(" to Dinesh Center");
		
		System.out.println(s); // Welcome -- this is immutable , original value can not change
		
		String contactString=s.concat(" to Dinesh Center");
		System.out.println(contactString);  // if we are storing into different variable then its a mutable.
	}

}
