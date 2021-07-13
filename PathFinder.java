public class PathFinder {
    public static void main(String[] args){
	    double[][] adjMat = getAdjacencyMatrix();
	    
	    WeightedGraph graph = new WeightedGraph(5, 7);
	    //System.out.println(graph);
	    System.out.println(graph.dijkstra(0, 4, WeightedGraph.Mode.CHEAPEST));
	    System.out.println("");
	    System.out.println("");
	
	    WeightedGraph graph2 = new WeightedGraph(25, 25);
	    System.out.println(graph2.dijkstraForRandomPoints(WeightedGraph.Mode.CHEAPEST));
	}
	
	private static double[][] getAdjacencyMatrix(){
		return null;
	}
}