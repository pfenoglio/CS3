
/*
input
4
amanaplanacanalpanama
aaaaaf
wowwow1
1234

output
21
5
6
1




*/
import java.io.*;
import java.util.*;

public class Pal4 {

	private static int palindrome(String str, int left, int right) {
		if (left == right)
			return 1;

		StringBuilder str2 = new StringBuilder(str.substring(left, right));

		if (str.substring(left, right).equals(str2.reverse().toString()))
			return str.substring(left, right).length();

		return Math.max(palindrome(str, left + 1, right), palindrome(str, left, right - 1));

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pal.dat"));
		int count = scan.nextInt();
		scan.nextLine();
		while (count-- > 0) {
			String str = scan.nextLine().replaceAll(" ", "").toLowerCase();

			System.out.println(palindrome(str, 0, str.length()));

		}
	}
}
