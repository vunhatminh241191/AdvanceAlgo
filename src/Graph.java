
public class Graph {
	
	Node[] nodes = new Node[ConstantVariable.NUMBER_OF_VERTICES];
	
	public Graph (){}
	
	public void addEdge(int sv, int ev) {
        Node node = nodes[sv];
        Node node_ev = nodes[ev];
        
        if (node_ev == null){
        	node_ev = new Node(ev);}
        if(node == null) {
            node = new Node(sv);
            nodes[sv] = node;
            node.addEdge(node_ev);
            node.degree++;}
        else {
            node.addEdge(node_ev);
            node.degree++;}
	}

}
