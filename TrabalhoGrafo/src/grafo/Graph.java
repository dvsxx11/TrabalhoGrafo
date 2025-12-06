package grafo;

import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adj = new HashMap<>();
    private boolean direcionado;

    public Graph(boolean direcionado) {
        this.direcionado = direcionado;
    }

    public void addVertex(String v) {
        adj.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(String origem, String destino, int peso) {
        addVertex(origem);
        addVertex(destino);

        adj.get(origem).add(new Edge(destino, peso));

        if (!direcionado) {
            adj.get(destino).add(new Edge(origem, peso));
        }
    }

    public void printGraph() {
        for (String v : adj.keySet()) {
            System.out.print(v + " -> ");
            for (Edge e : adj.get(v)) {
                System.out.print(e.destino + "(" + e.peso + ") ");
            }
            System.out.println();
        }
    }

    public Map<String, List<Edge>> getAdj() {
        return adj;
    }
}
