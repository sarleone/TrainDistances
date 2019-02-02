public class Main {
    private Graph graph;

    public static void main (String args[]) {
        Main program = new Main();
        program.go();
    }

    private void go() {
        makeGraph();
        try {
            System.out.print("Output #1: ");
            System.out.println(pathLength("ABC"));
            System.out.print("Output #2: ");
            System.out.println(pathLength("AD"));
            System.out.print("Output #3: ");
            System.out.println(pathLength("ADC"));
            System.out.print("Output #4: ");
            System.out.println(pathLength("AEBCD"));
            System.out.print("Output #5: ");
            System.out.println(pathLength("AED"));
        } catch (IllegalArgumentException e) {
            System.out.print("NO SUCH ROUTE");
        }
    }

    private void makeGraph(){
        graph = new Graph();
        graph.insertEdge(5, "A", "B");
        graph.insertEdge(4, "B", "C");
        graph.insertEdge(8, "C", "D");
        graph.insertEdge(8, "D", "C");
        graph.insertEdge(6, "D", "E");
        graph.insertEdge(5, "A", "D");
        graph.insertEdge(2, "C", "E");
        graph.insertEdge(3, "E", "B");
        graph.insertEdge(7, "A", "E");
    }

    public int getEdgeLength(String nodeFromName, String nodeToName) throws IllegalArgumentException {
        Node from = graph.getNode(nodeFromName);
        Edge edge = from.findEdgeTo(nodeToName);
        if (edge == null) {
            throw new IllegalArgumentException("No path from " + nodeFromName + " to " + nodeToName);
        }
        return edge.getDistance();
    }

    public int pathLength (String nodeNames) {
        int distance = 0;
        String fromNodeName = nodeNames.substring(0,1);
        String toNodeName = null;
        for(int i=1; i < nodeNames.length(); i++) {
            toNodeName = nodeNames.substring(i, i+1);
            distance += getEdgeLength(fromNodeName, toNodeName);
            fromNodeName = toNodeName;
        }
        return distance;
    }
}
