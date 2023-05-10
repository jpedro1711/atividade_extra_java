import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Item cocaCola = new Item("Coca-cola", 5.99);
        Item macarrao = new Item("Macarrão", 30.99);

        Cardapio cardapio = new Cardapio();
        cardapio.addItem(cocaCola);
        cardapio.addItem(macarrao);

        int opcao = 0;
        while (opcao != 2) {
            if (opcao == 0) {
                System.out.println("MENU - SELECIONE UMA OPÇÃO \n1 - Fazer Pedido \n2 - Sair");
            }
            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Você deve digitar o número correspondente a opção desejada");
                opcao = sc.nextInt();
            }

            if (opcao == 2) {
                System.out.println("Encerrado...");
            }
            if (opcao == 1) {
                sc.nextLine();
                System.out.print("Digite o seu nome: ");
                String nomeCliente = sc.nextLine();
                Cliente c = new Cliente(nomeCliente);
                System.out.println("Cardápio: ");
                cardapio.exibirCardapio();
                Pedido p = new Pedido(c);
                boolean finished = false;
                while (finished == false) {
                    System.out.println("Digite o número do item para adicionar ao pedido: (Caso deseje encerrar digite 0)");
                    int item = sc.nextInt();
                    if (item == 0) {
                        finished = true;
                    } else {
                        try {
                            p.adicionarAoPedido(cardapio.getItem(item - 1));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Opção inválida!");
                        }
                        System.out.println("Item adicionado ao pedido: " + cardapio.getItem(item - 1).getNome());
                    }
                }

                System.out.println("Nota fiscal");
                System.out.println("Cliente: " + p.getCliente().getNome());
                System.out.println("Resumo do pedido: ");
                p.showItems();
                System.out.println("Taxa de serviço (10%): " + String.format("%.2f", p.taxService()));
                System.out.println("Valor total do pedido: " + String.format("%.2f", p.valorTotal()));

                System.out.println("Digite um valor para pagamento: ");
                double valorPago = sc.nextDouble();
                System.out.println("Troco: " + (String.format("%.2f", valorPago - p.valorTotal())));
                opcao = 0;
            }
        }

        sc.close();
    }
}