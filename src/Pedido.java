import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Alimento> items;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        items = new ArrayList<>();
    }

    public void adicionarAoPedido(Alimento i) {
        this.items.add(i);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void showItems() {
        for (Alimento i: items) {
            System.out.println(i.getNome() + " - " + i.getPreco());
        }
    }

    public double taxService() {
        double valorTotal = 0;
        for (Alimento i: items) {
            valorTotal += i.getPreco();
        }
        return (valorTotal * 0.1);
    }

    public double valorTotal() {
        double valorTotal = 0;
        for (Alimento i: items) {
            valorTotal += i.getPreco();
        }
        return valorTotal * 1.1;
    }

}
