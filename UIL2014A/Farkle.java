import java.io.*;
import java.util.*;

public class Farkle {

	static void solve(long seed, int repeats) {

		List<Integer> ave = new ArrayList();// stores number of tries to get sequence
		List<Integer> list = new ArrayList();// stores each individual entries each series of rolls
		Random rand = new Random(seed);

		for (int i = 0; i < 100; i++) {
			int count = 1; // number of repeats
			int check = rand.nextInt(6) + 1; // roll
			list.add(check); // add roll value to list
			int prev = check; // stores previous roll
			// this loop keeps rolling until repeat target is met.
			// then it breaks and stores number of rolls to meet target in ave
			while (true) {
				check = rand.nextInt(6) + 1;
				list.add(check);
				// check to see if same as before
				if (check == prev) {
					count++;

				}
				// if not start looking again
				else {
					count = 1;
					prev = check;
				}
				// check to see if repeats has been met
				if (count == repeats) {
					ave.add(list.size());
					//print out first series of rolls once successful
					if (ave.size() == 1)
						list.stream().forEach(System.out::print);//looking COOL!!!!
					//we are done start another sequence
					list = new ArrayList();
					break;//kicks us out of while loop
				}
			}

		}
		//computer sum of elements in ave.
		double d = ave.stream().reduce(0, (a, b) -> a + b);
		System.out.printf("\n%.1f\n", d / ave.size());
		ave.clear();

	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("farkle.dat"));
		while (scan.hasNext()) {
			long seed = scan.nextLong();
			int repeats = scan.nextInt();
			solve(seed, repeats);

		}

	}

}
