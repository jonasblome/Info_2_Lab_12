public class PathFinder {
    public static void main(String[] args){
//	    double[][] adjMat = getAdjacencyMatrix();
	    
	    WeightedGraph graph = new WeightedGraph(5, 14);
//	    System.out.println(graph);
	    System.out.println(graph.dijkstra(0, 4, WeightedGraph.Mode.CHEAPEST));
	    System.out.println("");
	    System.out.println(graph.dijkstra(0, 4, WeightedGraph.Mode.SHORTEST));
	    System.out.println("");
	
//	    WeightedGraph graph2 = new WeightedGraph(30, 60);
//	    System.out.println(graph2.dijkstra(0, 10, WeightedGraph.Mode.CHEAPEST));
//	    System.out.println("");
//	    System.out.println(graph2.dijkstra(0, 10, WeightedGraph.Mode.SHORTEST));
//	    System.out.println("");
//	    System.out.println(graph2.dijkstraForRandomPoints(WeightedGraph.Mode.SHORTEST));
	}
	
	private static double[][] getAdjacencyMatrix(){
		return null;
	}
}