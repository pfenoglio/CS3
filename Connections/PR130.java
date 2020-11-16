/*6
A B
B C
C D
D E
E F
B G
2
A F
A G
*/

import java.io.File;
import java.util.*;

public class PR130 {
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("pr130.dat"));
		
		TreeMap<String, Integer> map = new TreeMap<String,Integer>();
		
		//this is the adjacency matrix
		boolean[][] graph = new boolean[500][500];
		// input number of edges
		int v = file.nextInt();
		
		//x stores the unique integer associated with a node
		int x = 0;
		while(v-->0)
		{
		  String a = file.next();
		  String b = file.next();
		  if(!map.containsKey(a))
		    map.put(a,x++);
		  if(!map.containsKey(b))
		    map.put(b,x++);
		  //builds/fills the adjacency matrix
		  graph[map.get(a)][map.get(b)] = true;
		  graph[map.get(b)][map.get(a)] = true;
		}
		//now to finish this is the start and goals in pairs
		v = file.nextInt();
		A: while(v-->0)
		{
		  int a = map.get(file.next());
		  //b stores the number of steps to get to the goal 
		  int b = map.get(file.next());
		  //this is the key to the breadth first search
		  //each time we are at a node we load the adjacent nodes into the que
		  //in this case we add pairs, first the node and second the number of steps to 
		  //get to athat node
		  Queue<Integer> q = new LinkedList<>();
		  q.add(a);
		  q.add(0);
		  while(!q.isEmpty())
		  {
		    int n = q.poll();
		    int d = q.poll();
		    // our goal is b, if n == b we are done
		    if(n==b)
		    {
		        System.out.println(d);
		        //hey we are using a label here!
		        continue A;
		    }
		    //here we are adding the adjacent nodes into the queue 
		    for(int c = 0; c < graph.length; c++)
		    {
		      if(graph[n][c])
		      {
		        q.add(c);
		        //Nice step huh?
		        q.add(d+1);
		      }
		    }
		  }
		  //we failed to get to the goal.
		  System.out.println(-1);
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		//I have no idea why we are using this architecture. ?????
		new PR130().run();
	}
}
