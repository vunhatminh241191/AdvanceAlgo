package Q1;

import java.util.ArrayList;
import java.util.HashSet;

public class Vertex 
{
	private int _VertexID;
	private int _color;
	private int _posHeap;
	private ArrayList<Vertex> _adjVert;
	private HashSet<Integer> _adjColor;
	private int _adjColorVertexCount;

	public Vertex(int VertexID)
	{
		_VertexID = VertexID;
		_adjVert = new ArrayList<>();
		_adjColor = new HashSet<>();
		_color = 0;
		_adjColorVertexCount = 0;
	}
	
	public boolean addEdge(Vertex v)
	{
		
		if (!isAdjacency(v) && this != v)
		{
			_adjVert.add(v);
			return true;
		}
		return false;
	}

	public boolean isAdjacency(Vertex v)
	{
		for (Vertex theVert : _adjVert)
		{
			if (theVert == v) return true;
		}
		return false;
	}

	public boolean isColored()
	{
		return _color != 0;
	}

	public int AdjacencyDegree()
	{
		return _adjVert.size();
	}

	public int SaturationDegree()
	{
		if (AdjacencyDegree() == _adjColorVertexCount) { return _adjColor.size(); }
		return _adjColor.size() + 1;
	}

	public int getColor()
	{
		return _color;
	}

	public void setHeapPosition(int pos)
	{
		_posHeap = pos;
	}

	public int getHeapPosition()
	{
		return _posHeap;
	}

	private void setAdjColor(int color)
	{
		_adjColor.add(new Integer(color));
		_adjColorVertexCount++;
	}

	public void Coloring(int n, Heap heap)
	{
		_color = n;
		for (Vertex v : _adjVert)
		{
			v.setAdjColor(n);
			heap.MaxHeapify(v.getHeapPosition());
		}
	}

	// <0 when this is smaller than v
	public int compareTo(Vertex v)
	{
		int ThisSatDeg = SaturationDegree();
		int vSatDeg = v.SaturationDegree();
		
		if (ThisSatDeg - vSatDeg != 0)
			return ThisSatDeg - vSatDeg;
		else 
		{
			int ThisAdjDeg = AdjacencyDegree();
			int vAdjDeg = v.AdjacencyDegree();
			return ThisAdjDeg - vAdjDeg;
		}
	}
	
	public int ChooseSmallestColor()
	{
		for (int i=1;;i++)
		{
			if (!_adjColor.contains(new Integer(i)))
			{
				return i;
			}
		}
	}
	
	public boolean colorVerify()
	{
		for (Vertex v : _adjVert)
		{
			if (v.getColor() == getColor())
			{
				System.out.println("Color Same: " + v._VertexID + ", " + _VertexID);
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		String ret = "[vID: "+ _VertexID +", ";
		ret += "vColor: " + _color + ", ";
		ret += "AdjDeg: " + AdjacencyDegree() + ", ";
		ret += "SatDeg: " + SaturationDegree() + ", ";
		ret += "HeapPos: " + _posHeap + "]";
		
		return ret + "\r\n";
	}
}
