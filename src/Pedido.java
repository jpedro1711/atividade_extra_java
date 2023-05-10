import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Item> items;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        items = new ArrayList<>();
    }

    public void adicionarAoPedido(Item i) {
        this.items.add(i);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void showItems() {
        for (Item i: items) {
            System.out.println(i.getNome() + " - " + i.getPreco());
        }
    }

    public double taxService() {
        double valorTotal = 0;
        for (Item i: items) {
            valorTotal += i.getPreco();
        }
        return (valorTotal * 0.1);
    }

    public double valorTotal() {
        double valorTotal = 0;
        for (Item i: items) {
            valorTotal += i.getPreco();
        }
        return valorTotal * 1.1;
    }

}
