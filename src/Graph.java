import java.util.*;
public class Graph {
    private List<Node> nodes;
    private HashSet<Edge> edges;
    private HashMap<String, Node> nodeMap;

    public Graph() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public Graph(List<Node> nodes, List<Node> edges) {
        this.nodes = new ArrayList<>();
        this.edges = new HashSet<>();
        this.nodeMap = new HashMap<>();
    }

    public Node insertNode(String nodeName) {
        Node node = new Node(nodeName);
        nodes.add(node);
        nodeMap.put(nodeName, node);

        return node;
    }

    public Node getNode(String nodeName) {
        Node node = nodeMap.get(nodeName);
        if (node == null) {
            node = insertNode(nodeName);
        }
        return node;
    }

    public void insertEdge(int edgeWeight, String nodeFromName, String nodeToName) {
        Node from = getNode(nodeFromName);
        Node to = getNode(nodeToName);
        Edge edge = new Edge(edgeWeight, from, to);
        from.addEdge(edge);
        edges.add(edge);
    }

}

