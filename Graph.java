public interface Graph {
	public int getVertexCount();
	public int getEdgeCount();
	public String dijkstraForRandomPoints(WeightedGraph.Mode mode);
	public String dijkstra(int start, int end, WeightedGraph.Mode mode);
}
