package NewSite.Connections;

import java.io.File;
import java.util.*;

public class pr130 {
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("pr130.dat"));
		TreeMap<String, Integer> map = new TreeMap<String,Integer>();
		boolean[][] graph = new boolean[500][500];
		int v = file.nextInt();
		int x = 0;
		while(v-->0)
		{
		  String a = file.next();
		  String b = file.next();
		  if(!map.containsKey(a))
		    map.put(a,x++);
		  if(!map.containsKey(b))
		    map.put(b,x++);
		  graph[map.get(a)][map.get(b)] = true;
		  graph[map.get(b)][map.get(a)] = true;
		}
		v = file.nextInt();
		A: while(v-->0)
		{
		  int a = map.get(file.next());
		  int b = map.get(file.next());
		  Queue<Integer> q = new LinkedList<>();
		  q.add(a);
		  q.add(0);
		  while(!q.isEmpty())
		  {
		    int n = q.poll();
		    int d = q.poll();
		    if(n==b)
		    {
		        System.out.println(d);
		        continue A;
		    }
		    for(int c = 0; c < graph.length; c++)
		    {
		      if(graph[n][c])
		      {
		        q.add(c);
		        q.add(d+1);
		      }
		    }
		  }
		  System.out.println(-1);
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		new pr130().run();
	}
}
