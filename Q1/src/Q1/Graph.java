package Q1;

import java.util.ArrayList;

public class Graph
{
	ArrayList<Vertex> vertex;
	Heap Sat_Adj_Heap;

	public Graph(int count, int avgEdge)  
	{
		vertex = GraphGenerator.initRandomGraph(count, avgEdge);
	}
	
	public void HeapInit() // O(VlogV)
	{
		Sat_Adj_Heap = new Heap(vertex);
		Sat_Adj_Heap.initHeap();
	}
	
	public void Coloring(Vertex vertex, int color)
	{
		vertex.Coloring(color, Sat_Adj_Heap);     // O(VlogV) ->  Sum = O(ElogV)
	}
	
	public int getNotColoredVertex()
	{
		return Sat_Adj_Heap.getSize();
	}
	
	public Vertex getVertex(int index)
	{
		return vertex.get(index);
	}
	
	public Vertex getMaxAdjacencyDegreeVertex() //O(V)
	{
		int maxCount = -1;
		Vertex choose = null;
		for (Vertex v : vertex)
		{
			int Degree = v.AdjacencyDegree();
			if (Degree > maxCount)
			{
				maxCount = Degree;
				choose = v;
			}
		}
		return choose;
	}
	
	public Vertex getMaximalSatAdjVertex()
	{
		return Sat_Adj_Heap.getLargest();
	}
	
	public boolean ColorVerify()
	{
		for (Vertex v : vertex)
		{
			boolean test = v.colorVerify();
			if (!test)
				return false;
		}
		return true;
	}
}
