import java.util.*;
import java.io.*;

public class Pr131 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pr131.dat"));
		int noSets = scan.nextInt();
		int[][] arr = new int[50][50];
		Map<String, Integer> map = new TreeMap();
		int x = 0;// x is index
		// goal of the while loop is to establish map and adjacency matrix
		while (noSets-- > 0) {
			String inp1 = scan.next();
			String inp2 = scan.next();
			if (!map.containsKey(inp1))
				map.put(inp1, x++);
			if (!map.containsKey(inp2))
				map.put(inp2, x++);
			arr[map.get(inp1)][map.get(inp2)] = 1;

		}
		// now bring in the source and goal
		noSets = scan.nextInt();
		here: while (noSets-- > 0) {
			String start = scan.next();
			String goal = scan.next();
			int intStart = map.get(start);
			int intGoal = map.get(goal);
			//System.out.println("intGOal " +intGoal);
			Deque<Integer> que = new LinkedList();
			que.addLast(intStart);
			que.addLast(0);
			int[][] newArr = new int[map.size()][map.size()];
			for (int i = 0; i < map.size(); i++){
				for (int j = 0; j < map.size(); j++)
					newArr[i][j] = arr[i][j];
				//System.out.println(Arrays.toString(newArr[i]));
			}
			while (!que.isEmpty()) {
				System.out.println("Que "+que);
				int check = que.poll();
				//System.out.println("check: "+ check);
				int score = que.poll();
				//System.out.println("score: "+ score);
				if (check == intGoal) {
					System.out.println(score);
					continue here;
				}
				for (int j = 0; j < map.size(); j++)
					if (newArr[check][j] != 0) {
						que.addLast(j);
						que.addLast(score + 1);
					newArr[check][j] = 0;
					}

			}
			que.clear();
			System.out.println("no path");

		}
	}

}
