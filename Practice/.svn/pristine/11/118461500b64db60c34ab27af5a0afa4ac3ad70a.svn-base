package ua.nure.zhazhkyi.Practice6.part4;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    List<Node> nodes;
    List<Edge> edges;

    Graph(int verticesCount) {
        nodes = new ArrayList<>();
        for (int i = 0; i < verticesCount; i++) {
            nodes.add(new Node(i));
        }
        edges = new ArrayList<>();
    }

    class Node {
        Integer number;
        StringBuilder nodeEntry;

        int getNumber() {
            return number;
        }

        Node(Integer value) {
            number = value;
        }

        List<Edge> connectedEdges = new ArrayList<>();

        String getEdges() {
            nodeEntry = new StringBuilder();
            for (Edge edge : connectedEdges) {
                nodeEntry.append(edge.getName()).append(" ");
            }
            return nodeEntry.toString();
        }
    }

    class Edge {
        Node start;
        Node end;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (!start.equals(edge.start)) return false;
            return end.equals(edge.end);
        }

        @Override
        public int hashCode() {
            int result = start.hashCode();
            result = 31 * result + end.hashCode();
            return result;
        }

        public Node getStart() {
            return start;
        }

        public Node getEnd() {
            return end;
        }

        Edge(Node n1, Node n2) {
            start = n1;
            end = n2;
        }

        public String getName() {
            StringBuilder name = new StringBuilder();
            name.append(start.getNumber()).append(" - ")
                    .append(end.getNumber()).append("; ");
            name.setLength(name.length() - 1);
            return name.toString();
        }

    }

    public boolean addEdge(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            System.out.println("No such node!");
            return false;
        }
        Edge edge = new Edge(n1, n2);
        if (nodes.size() != 0) {
            for (Edge checkingEdge : edges) {
                if (edge.equals(checkingEdge)) {
                    System.out.println("Such edge already exists!");
                    return false;
                }
            }
        }
        n1.connectedEdges.add(edge);
        n2.connectedEdges.add(edge);
        edges.add(edge);
        return true;
    }

    public boolean removeEdge(Edge edge) {
        if (edges.size() == 0) {
            System.out.println("Graph has no edges");
            return false;
        }
        for (Edge checkEdge : edges) {
            if (edge.equals(checkEdge)) {
                edge.getStart().connectedEdges.remove(edge);
                edge.getEnd().connectedEdges.remove(edge);
                edges.remove(edge);
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append("node:").append(node.getNumber()).append("(")
                    .append(node.getEdges()).append(")")
                    .append(System.lineSeparator());
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }
}
