import java.io.*;
import java.util.*;

public class Collation {
static String key;
	static Comparator<String> com = (a, b) -> {

		return (ch(a, b));
		

	};

	static int ch(String a, String b) {

		if (a.length() == 0 && b.length() != 0)
			return -1;
		if(a.length()!=0 && b.length()==0)
			return 1;
		if(a.charAt(0)!=b.charAt(0))
			return key.indexOf(a.charAt(0))-key.indexOf(b.charAt(0));
		 return ch(a.substring(1),b.substring(1));
		
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("col.dat"));
		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			 key = scan.next();
			List<String> list = new ArrayList();
			int noWords = scan.nextInt();
			while (noWords-- > 0) 
				list.add(scan.next());
			list.sort(com);	
			list.stream().forEach(a->System.out.print(a+" "));
			System.out.println();
			

		}

	}

}
