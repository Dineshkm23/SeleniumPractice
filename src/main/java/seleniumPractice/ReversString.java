package seleniumPractice;

public class ReversString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="Dinesh";
		String rev="";
		System.out.println(s.length()-1);
		for(int i=s.length()-1; i>=0 ;i--) {
			System.out.println(s.charAt(i));
			 rev=rev+s.charAt(i);	
		}
		System.out.println(rev);
		
		String s1="Ambuja";
		
		char[] arr=s1.toCharArray();
		
		//System.out.println(arr);
		rev="";
		System.out.println(arr.length);
		for (int i = arr.length-1; i >=0; i--) {
			System.out.println(arr[i]);
			rev= rev+arr[i];
		}
		System.out.println(rev);
		
		
		StringBuffer sf= new StringBuffer("Kumar");
		System.out.println(sf.reverse());
		
		StringBuilder sb= new StringBuilder("Automation");
		System.out.println(sb.reverse());
	}
}