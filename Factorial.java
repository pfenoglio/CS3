import java.io.*;
import java.util.*;
public class Factorial {

	static int findZeros(int n) {
		return n==0? 0:(n%5==0?1+findZeros(n/10):0);
		
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("fac.dat"));
		int noSets = scan.nextInt();
		int sum = 0;
		while(noSets-->0) {
			int check = scan.nextInt();
			for(int i = 5; i<=check; i+=5) {
				String str = Integer.toString(i, 5);
				sum+=findZeros(Integer.parseInt(str));
			}
				System.out.println(sum);
				sum = 0;
			
			
		}

	}

}
