package Q1;

import java.util.Random;

import org.apache.commons.lang3.time.StopWatch;

public class main
{
	public static Random random = new Random("Q1".hashCode());

	// Graph has V, E
	public static int DSaturAlgoritm(Graph graph)  // Total: O((V+E)LogV) // Total: O(V^2+ELogV) // Total: O(VC + (V+E)LogV)
	{
		int ColorNumber = 1;
		
		graph.HeapInit();  // O(VLogV)
		
		Vertex FirstVertex = graph.getMaxAdjacencyDegreeVertex();  // O(V)
		graph.Coloring(FirstVertex, 1);
		
		while (graph.getNotColoredVertex() > 0)    //O(V)
		{
			Vertex Max_Sat_Adj_Vertex = graph.getMaximalSatAdjVertex();    // O(logV)

			int color = Max_Sat_Adj_Vertex.ChooseSmallestColor();   // O(V)
			graph.Coloring(Max_Sat_Adj_Vertex, color);  // O(VlogV)    Total: O(ElogV)
			

			if (color > ColorNumber)
				ColorNumber = color;
		}

		return ColorNumber;
	}
	private static int[] V = new int[] {10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000};
	private static int[] E = new int[] {500000, 1000000, 1500000, 2000000, 2500000, 3000000, 3500000, 4000000, 4500000, 5000000};
	
	//private static int[] V = new int[] {500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000};
	//private static int[] E = new int[] {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000};
	public static void main(String[] args)
	{
		StopWatch sw;
		
		for (int i=0; i<100; i++)
		{
			Graph graph = new Graph(10000, 50000);
			DSaturAlgoritm(graph);
		}
		
		for (int i=0; i<V.length; i++)
		{
			long timeSum = 0;
			int repeat = 10;
			for (int j=0; j<repeat; j++)
			{
				sw = new StopWatch();
				
				Graph graph = new Graph(V[i], E[i]);
				
				sw.start();
				int color = DSaturAlgoritm(graph);
				sw.stop();
				
				System.out.println("Color Number: " + color);
				timeSum += sw.getNanoTime();
				//graph.ColorVerify();
			}
			System.out.println("V: " + V[i] + " E: " + E[i] + "Time: " + (timeSum / 10) + "ns");
		}

	}

}
