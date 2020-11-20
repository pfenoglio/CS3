/*
input
4
amanaplanacanalpanama
aaaaaf
wowwow1
1234

output





*/
import java.io.*;
import java.util.*;
public class Pal3 {

	
	private static int palindrome(String str, int left, int right) {
		if(left==right)
			return 1;
		//System.out.println("left "+left+" Right "+right);
		StringBuilder str2 = new StringBuilder(str.substring(left, right));
	
		if(str.substring(left,right).equals(str2.reverse().toString())) {
			return str.substring(left,right).length();
		}
		return 0;
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pal1.dat"));
		int count = scan.nextInt();
		scan.nextLine();
		while (count-- > 0) {
			List<Integer> list = new ArrayList();
			String str = scan.nextLine().replaceAll(" ", "").toLowerCase();
			int uberMax = 0;
			for(int i = 0; i<str.length(); i++) {
				int max = -2;
				for(int j = str.length(); j>i; j--) {
					max = Math.max(max, palindrome(str,i,j));
					
				}
				uberMax = Math.max(uberMax, max);
			}
			System.out.println(uberMax);
		
		}	

	}

}
