import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Graph graph = ReadingGraph();
		
		GraphColoring graph_coloring = new GraphColoring(graph);
		System.out.println(graph_coloring.NumberOfColor());
		for (Node n: graph.nodes) {
			System.out.println(n.value);
			System.out.println(n.color);
			System.out.println("====");
		}
	}
	
	public static Graph ReadingGraph() throws Exception{	
		BufferedReader reader = new BufferedReader(new FileReader(new File(ConstantVariable.FILE)));
        String line = reader.readLine();
        ConstantVariable.NUMBER_OF_VERTICES = Integer.parseInt(line.trim());
        Graph graph = new Graph();
        line = reader.readLine();
        while (line != null) {
        	String[] vertices = line.trim().split(" ");
        	graph.addEdge(Integer.parseInt(vertices[0]) -1, Integer.parseInt(vertices[1]) -1);
        	line = reader.readLine();
        }
        reader.close();
		return graph;
	}

}
