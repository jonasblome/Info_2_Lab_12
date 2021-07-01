package pathfinding;
import defaultpackage.WeightedGraph.Mode;

public interface Graph {
	public int getVertexCount();
	public int getEdgeCount();
	public String dijkstraForRandomPoints(Mode mode);
	public String dijkstra(int startIndex, int endIndex, Mode mode);
}
