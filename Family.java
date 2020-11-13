/*6
John father Jake
Mary sibling John
Nigel father Jake
Mary mother Amanda
Mary sibling Aaron
Mary sibling Zeke
*/
import java.io.*;
import java.util.*;

public class Family {
	// basic idea is to store the names in a map <name,ArrayList>
	// in ArrayList index 0 = father, index 1 = mother, others are siblings
	static Map<String, List<String>> map = new TreeMap();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("family.dat"));
		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			String name1 = scan.next();
			String rel = scan.next();
			String name2 = scan.next();

			if (!map.containsKey(name1)) {
				map.put(name1, new ArrayList());
				map.get(name1).add("Unknown");
				map.get(name1).add("Unknown");
			}
			if (!map.containsKey(name2)) {
				map.put(name2, new ArrayList());
				map.get(name2).add("Unknown");
				map.get(name2).add("Unknown");
			}
			if (rel.equals("father"))
				map.get(name1).set(0, name2);
			else if (rel.equals("mother"))
				map.get(name1).set(1, name2);
			// now for the siblings--this would not work for transitive siblings!
			else {
				map.get(name1).add(name2);
				map.get(name2).add(name1);

			}

		}

		for (Map.Entry<String, List<String>> ent : map.entrySet()) {
			System.out.println(ent.getKey());
			System.out.println("Father: " + ent.getValue().get(0));
			System.out.println("Mother: " + ent.getValue().get(1));
			Set<String> set = new TreeSet();
			// now sort the siblings and print them out.
			for (int i = 2; i < ent.getValue().size(); i++)
				set.add(ent.getValue().get(i));
			if (set.size() == 0) {
				System.out.println();
				continue;
			} else {
				for (String s : set)
					System.out.print("Sibling: " + s + "\n");
				System.out.println();
			}

		}

	}

}
