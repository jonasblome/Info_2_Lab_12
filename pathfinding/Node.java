package pathfinding;

import pathfinding.WeightedGraph.Mode;

public interface Node {
	public void reset();
	public void explore(Mode mode);
	public void addNeigbour(Node node, double distance);
	
	public boolean setDistanceAndPrevNode(double shortestDistanceCandidate, Node prevNodeCandidate);
	public double getDistanceFromStartingNode();
	public Node getPreviousNode();
	public int getIndex();
	public boolean getExplored();
	public String getName();
}
