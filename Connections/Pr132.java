import java.io.*;
import java.util.*;

public class Pr132 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr132.dat"));
		// take care of input
		int[][] arr = new int[100][100];
		int noSets = scan.nextInt();
		Map<String, Integer> map = new TreeMap();
		int index = 0;
		while (noSets-- > 0) {
			String inp1 = scan.next();
			String inp2 = scan.next();
			int dist = scan.nextInt();
			if (!map.containsKey(inp1))
				map.put(inp1, index++);
			if (!map.containsKey(inp2))
				map.put(inp2, index++);
			arr[map.get(inp1)][map.get(inp2)] = dist;
			arr[map.get(inp2)][map.get(inp1)] = dist;

		}
		//Here is what map is
		System.out.println(map);
		//here is arr
		for(int i = 0; i<map.size(); i++)
			System.out.println(Arrays.toString(arr[i]));

		int noTrys = scan.nextInt();
		while (noTrys-- > 0) {
			
			int[] dist = new int[map.size()];
			for (int i = 0; i < map.size(); i++)
				dist[i] = Integer.MAX_VALUE;
			
			boolean[] visited = new boolean[map.size()];
			int start = map.get(scan.next());
			int end = map.get(scan.next());


			Deque<Integer> que = new LinkedList();
			que.add(start);
			dist[start] = 0;

			while (!que.isEmpty()) {
				int check = que.poll();
				visited[check] = true;
				for (int i = 0; i < map.size() ; i++) {
				if(!visited[i]&&arr[check][i]>0) {
					dist[i] = Math.min(dist[check] + arr[check][i], dist[i]);
					que.add(i);
				}
				}

			}
			System.out.println(dist[end]);
		}

	}

}
