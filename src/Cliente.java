import java.util.ArrayList;

public class Cliente {
    String nome;
    ArrayList<Pedido> pedidos;

    public Cliente(String nome) {
        this.nome = nome;
        pedidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void addPedido(Pedido p) {
        this.pedidos.add(p);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
