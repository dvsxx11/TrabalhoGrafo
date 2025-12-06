import grafo.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("==== Grafo de Rotas ====");

        Graph grafo = new Graph(false);

        grafo.addEdge("Teresina", "Altos", 40);
        grafo.addEdge("Teresina", "Timon", 10);
        grafo.addEdge("Altos", "Campo Maior", 35);
        grafo.addEdge("Teresina", "União", 55);
        grafo.addEdge("Timon", "Caxias", 70);

        System.out.println("\nGrafo (cidades e distâncias):");
        grafo.printGraph();

        System.out.println("\nMenor caminho a partir de Teresina:");
        var distancias = Dijkstra.dijkstra(grafo, "Teresina");

        for (var d : distancias.entrySet()) {
            System.out.println("→ Até " + d.getKey() + ": " + d.getValue() + " km");
        }
    }
}
