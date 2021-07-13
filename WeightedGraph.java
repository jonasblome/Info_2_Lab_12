import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
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
		for(Vertex vertex : graph) {
			vertex.setDistanceAndPrevNode(Double.POSITIVE_INFINITY, null);
		}
		
		Vertex currentVertex;
		PriorityQueue<Vertex> unexploredVertices = new PriorityQueue<Vertex>();
		unexploredVertices.add(graph.get(start));
		graph.get(start).setDistanceAndPrevNode(0, null);
		Vertex destination = graph.get(end);
		
		while(!destination.getExplored()) {
			currentVertex = (Vertex) unexploredVertices.poll();
			HashMap<Vertex, Double> neighbours = currentVertex.getNeighbours();
			currentVertex.explore(mode);
			for(Vertex neighbour : neighbours.keySet()) {
				neighbour.setDistanceAndPrevNode(currentVertex.getDistanceFromStartingNode() + neighbours.get(neighbour), neighbour);
				unexploredVertices.add(neighbour);
			}
		}
		
		currentVertex = destination;
		String path = "";
		
		while(currentVertex != graph.get(start)) {
			path = path + currentVertex.getName() + ", ";
			currentVertex = (Vertex) currentVertex.getPreviousNode();
		}
		return path;
    }
	
    public Vertex nextNodeToExplore(){
		return null;
    }
    
    private double[][] createAdjacencyMatrix(int nodes, int edges){
    	//fill the empty matrix with all zeros
    	adjacencyMatrix = new double[nodes][nodes];
    	for(int x = 0; x < nodes; x++) {
			for(int y = 0; y < nodes; y++) {
				adjacencyMatrix[x][y] = 0;
			}
		}
    	
    	//fill random entries with random weights.
    	//dont overwrite existing weights. dont overwrite diagonal zeros.
    	for(int i = 0; i < edges; i++) {
    		int randX = rand.nextInt(nodes);
    		int randY = rand.nextInt(nodes);
    		int randWeight = rand.nextInt(10) + 1;
    		if ((adjacencyMatrix[randX][randY] != 0) || (randX != randY)) {
    			i--;
    		}
    		else {
    			adjacencyMatrix[randX][randY] = randWeight;
    		}
    	}
    	
		return adjacencyMatrix;
    }

    private ArrayList<Vertex> createGraphFromAdjacencyMatrix(double[][] adjMat, String[] names){
    	//add all vertices to new graph
    	for(int i = 0; i < adjMat.length; i++) {
    		Vertex newVertex = new Vertex(i, names[i]);
    		graph.add(newVertex);
    	}
    	
    	//for every vertex, add all neighbors from matrix with weighted connections
    	for(int x = 0; x < adjMat.length; x++) {
    		Vertex vertex = graph.get(x);
    		
    		//if a matrix entry is not 0 add it to the vertex neighbors
    		for(int y = 0; y < adjMat.length; y++) {
    			if (adjMat[x][y] != 0) {
            		vertex.addNeighbour(graph.get(y), adjMat[x][y]);
    			}
    		}
    	}
		return graph;
    }

    private void reset(){
        for (Vertex v : graph){
            v.reset();
        }
    }

    public String toString(){
		String graphString = "";
		for(Vertex vertex : graph) {
			String neighbourVertices = "";
			HashMap<Vertex, Double> vertexNeighbours = vertex.getNeighbours();
			for(Vertex neighbour : vertexNeighbours.keySet()) {
				neighbourVertices += neighbour.getName() + " (" + vertexNeighbours.get(neighbour) + ")"+ ", ";
			}
			graphString = graphString + vertex.getName() + ": " + neighbourVertices + "\n";
		}
    	return graphString;
    }

    private static String[] parsePossibleNames(){
    	String[] newNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R"};
		return newNames;
    }

    public int getVertexCount(){
		return 0;
    }
    
    @Override
    public int getEdgeCount(){
		return 0;
    }

    public enum Mode{
        CHEAPEST,SHORTEST
    }
}
