import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Alimento> items;

    public Cardapio() {
        this.items = new ArrayList<>();
    }

    public void addItem(Alimento alimento) {
        this.items.add(alimento);
    }

    public Item getItem(int i) {
        return this.items.get(i);
    }

    public void exibirCardapio(){
        for (Item i: items) {
            System.out.println((items.indexOf(i) + 1) + " - " +i.getNome() + " - " + i.getPreco());
        }
    }
}
