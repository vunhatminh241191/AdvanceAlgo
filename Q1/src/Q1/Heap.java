package Q1;

import java.util.ArrayList;

public class Heap
{
	Vertex[] array;
	int size;
	public Heap(ArrayList<Vertex> vertex)
	{
		array = new Vertex[vertex.size()+1];
		size = vertex.size();
		for (int i=0; i<vertex.size(); i++)
		{
			array[i+1] = vertex.get(i);
			array[i+1].setHeapPosition(i+1);
		}
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void initHeap()  // O(VLogV)
	{
	    for(int i=size/2; i>=1; i--)
	    	  MaxHeapify(i);
	}

	public void MaxHeapify(int i)  // O(LogV)
	{
		int lt = 2*i, rt = 2*i+1;
		int largest;
		if(lt <= size && array[lt].compareTo(array[i]) > 0)
			largest = lt;
		else
			largest = i;
		if(rt <= size && array[rt].compareTo(array[largest]) > 0)
			largest = rt;
		if(largest != i)
		{
			Vertex temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			array[i].setHeapPosition(i);
			array[largest].setHeapPosition(largest);
			MaxHeapify(largest);
		}
	}
	
	public Vertex getLargest()  // O(LogV)
	{
		Vertex maxVertex = array[1];
		
		array[1] = array[size];
		array[1].setHeapPosition(1);
		size--;
		
		MaxHeapify(1);
		
		return maxVertex;
	}
}
