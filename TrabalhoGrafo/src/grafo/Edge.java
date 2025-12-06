package grafo;

public class Edge {
    public String destino;
    public int peso;

    public Edge(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return destino + "(" + peso + ")";
    }
}
