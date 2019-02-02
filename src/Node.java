import java.util.*;
public class Node {
    private String name;
    private List<Edge> edges;
    private boolean visited;

    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList<Edge>();
        this.visited = false;
    }
    public void addEdge (Edge edge) {
        edges.add(edge);
    }
    public String getName() {
        return name;
    }

    public Iterator<Edge> getEdges() {
        return edges.iterator();
    }

    public Edge findEdgeTo(String nodeName) {
        for (Edge edge: edges) {
            if(edge.toNode().getName().equals(nodeName)) {
                return edge;
            }
        }
        return null;
    }
}

