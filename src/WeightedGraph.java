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

    @Override
    public String dijkstraForRandomPoints(Mode mode){
        int start = rand.nextInt(graph.size());
        int end = rand.nextInt(graph.size());
        return dijkstra(start, end, mode);
    }

    public String dijkstra(int start, int end, Mode mode){
    //TODO
    }

    public Vertex nextNodeToExplore(){
        //todo
    }

    private double[][] createAdjacencyMatrix(){
        //todo
    }

    private ArrayList<Vertex> createGraphFromAdjacencyMatrix(double[][] adjMat, String[] names){
        //todo
    }

    private void reset(){
        for (Vertex v : graph){
            v.reset();
        }
    }

    public String toString(){
        //todo
    }

    private static String[] parsePossibleNames(){
        //todo
    }

    public int getVertexCount(){
        //todo
    }

    public int getEdgeCount(){
        //todo
    }

    public enum Mode{
        CHEAPEST,SHORTEST
    }
}
