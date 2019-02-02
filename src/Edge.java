public class Edge {
    private int distance;
    private Node nodeFrom;
    private Node nodeTo;

    public Edge(int distance, Node nodeFrom, Node nodeTo) {
        this.distance = distance;
        this.nodeFrom = nodeFrom;
        this.nodeTo = nodeTo;
    }

    public Node toNode() {
        return nodeTo;
    }

    public int getDistance() {
        return distance;
    }
}
