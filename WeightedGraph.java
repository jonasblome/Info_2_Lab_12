import java.util.ArrayList;
import java.util.Random;

public class WeightedGraph implements Graph {
    private double[][] adjacencyMatrix;
    private Random rand;
    private ArrayList<Vertex> graph = new ArrayList<>();
    private static String[] names = parsePossibleNames();

    public WeightedGraph(int nodes, int edges){
        rand = new Random();
        adjacencyMatrix = createAdjacencyMatrix(nodes, edges);
        graph = createGraphFromAdjacencyMatrix(adjacencyMatrix, names);
    }
    
    public WeightedGraph(double[][] adjacencyMatrix) {
    	rand = new Random();//testing with seed
    	this.adjacencyMatrix = adjacencyMatrix;
    	graph = createGraphFromAdjacencyMatrix(adjacencyMatrix, names);
    }

    @Override
    public String dijkstraForRandomPoints(Mode mode){
        int start = rand.nextInt(graph.size());
        int end = rand.nextInt(graph.size());
        return dijkstra(start, end, mode);
    }
    
	@Override
    public String dijkstra(int start, int end, Mode mode){
		return null;
    }

    public Vertex nextNodeToExplore(){
		return null;
        //todo
    }

    private double[][] createAdjacencyMatrix(int nodes, int edges){
		return adjacencyMatrix;
        //todo
    }

    private ArrayList<Vertex> createGraphFromAdjacencyMatrix(double[][] adjMat, String[] names){
		return graph;
        //todo
    }

    private void reset(){
        for (Vertex v : graph){
            v.reset();
        }
    }

    public String toString(){
		return null;
        //todo
    }

    private static String[] parsePossibleNames(){
		return names;
        //todo
    }

    public int getVertexCount(){
		return 0;
        //todo
    }
    
    @Override
    public int getEdgeCount(){
		return 0;
    }

    public enum Mode{
        CHEAPEST,SHORTEST
    }
}
