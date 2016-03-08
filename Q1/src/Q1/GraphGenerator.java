package Q1;

import java.util.ArrayList;

public class GraphGenerator
{
	public static ArrayList<Vertex> initRandomGraph(int totalVertex, int totalEdge)
	{
		ArrayList<Vertex> vertex = new ArrayList<>();
		
		for (int i = 0; i < totalVertex; i++)
		{
			vertex.add(new Vertex(i));
		}

		for (int i=0; i<totalEdge; i++)
		{
			Vertex vert1 = vertex.get(main.random.nextInt(totalVertex));
			Vertex vert2 = vertex.get(main.random.nextInt(totalVertex));
			boolean inserted = vert1.addEdge(vert2);
			
			if (inserted)
				vert2.addEdge(vert1);
			else
				i--;
		}
		
		/*
		for (int i = 0; i < count; i++)
		{
			for (int j = 0; j < avgEdge; j++)
			{
				Vertex vertChoose = vertex.get(main.random.nextInt(count));
				boolean inserted = vertex.get(i).addEdge(vertChoose);
				if (!inserted)
					j--;
			}
		}*/
		return vertex;
	}
}
