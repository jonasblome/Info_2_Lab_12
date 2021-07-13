import java.util.HashMap;

public class Vertex implements Node, Comparable<Vertex> {

    private int index;
    private String name;
    private HashMap<Vertex, Double> neighbours = new HashMap<Vertex, Double>();

    //temporary fields, get reset every time the pathfinding algorithm is called
    private boolean explored;
    private double distanceFromStartingNode;
    private Vertex previousNode;

    public Vertex(int index, String name){
        this.index = index;
        this.name = name;
        this.explored = false;
        this.distanceFromStartingNode = Double.POSITIVE_INFINITY;
        this.previousNode = null;
    }

    public void reset(){
    	explored = false;
    	distanceFromStartingNode = Double.POSITIVE_INFINITY;
    	previousNode = null;
    }

    public void explore(WeightedGraph.Mode mode){
    	explored = true;
    }
    
    @Override
    public void addNeighbour(Node node, double distance){
    	neighbours.put((Vertex) node, distance);
    }

    public boolean setDistanceAndPrevNode(double shortestDistanceCandidate, Node prevNodeCandidate){
    	if (shortestDistanceCandidate < distanceFromStartingNode) {
    		distanceFromStartingNode = shortestDistanceCandidate;
    		previousNode = (Vertex) prevNodeCandidate;
    	}
		return true;
	}

    @Override
    public boolean equals(Object o){
        Vertex v = (Vertex) o;
        return index == v.getIndex();
    }

    public HashMap<Vertex, Double> getNeighbours(){
        return neighbours;
    }

    public Node getPreviousNode(){
        return previousNode;
    }

    public int getIndex(){
        return index;
    }

    public boolean getExplored(){
        return explored;
    }

    public String getName(){
        return name;
    }

    public double getDistanceFromStartingNode(){
        return distanceFromStartingNode;
    }

	@Override
	public int compareTo(Vertex o) {
		return Double.compare(distanceFromStartingNode, o.getDistanceFromStartingNode());
	}
}
