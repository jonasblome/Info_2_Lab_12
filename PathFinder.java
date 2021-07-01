public class PathFinder {
    public static void main(String[] args){
	    double[][] adjMat = getAdjacencyMatrix();
	
	    WeightedGraph graph = new WeightedGraph(adjMat);
	    System.out.println(graph);
	    System.out.println(graph.dijkstra(0, 4, WeightedGraph.Mode.CHEAPEST));
	    System.out.println(graph.dijkstra(0, 4, WeightedGraph.Mode.CHEAPEST));
	
	    WeightedGraph graph2 = new WeightedGraph(30, 65);
	    System.out.println(graph2.dijkstraForRandomPoints(WeightedGraph.Mode.CHEAPEST));
	}
	
	private static double[][] getAdjacencyMatrix(){
		return null;
		
	}
}
