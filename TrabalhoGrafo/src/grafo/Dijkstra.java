package grafo;

import java.util.*;

public class Dijkstra {

    public static Map<String, Integer> dijkstra(Graph graph, String inicio) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, List<Edge>> adj = graph.getAdj();

        for (String v : adj.keySet()) {
            dist.put(v, Integer.MAX_VALUE);
        }

        dist.put(inicio, 0);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.peso));
        pq.add(new Edge(inicio, 0));

        while (!pq.isEmpty()) {
            Edge atual = pq.poll();
            String verticeAtual = atual.destino;

            for (Edge e : adj.get(verticeAtual)) {
                int novaDist = dist.get(verticeAtual) + e.peso;

                if (novaDist < dist.get(e.destino)) {
                    dist.put(e.destino, novaDist);
                    pq.add(new Edge(e.destino, novaDist));
                }
            }
        }

        return dist;
    }
}
