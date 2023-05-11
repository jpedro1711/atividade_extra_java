import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Alimento coca = new Bebida("Coca-cola", 5.99, 1);
        Alimento agua = new Bebida("Água sem gás", 3.00, 0.5);
        Alimento ravioli = new Prato("Ravioli", 55.99, 2);
        Alimento macarrao = new Prato("Macarrão", 30.99, 1);

        Cardapio cardapio = new Cardapio();
        cardapio.addItem(coca);
        cardapio.addItem(ravioli);
        cardapio.addItem(agua);
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
                sc.next();
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
                while (!finished) {
                    System.out.println("Digite o número do item para adicionar ao pedido: (Caso deseje encerrar digite 0)");
                    try {
                        int item = sc.nextInt();
                        if (item == 0) {
                            finished = true;
                        } else {
                            try {
                                p.adicionarAoPedido((Alimento) cardapio.getItem(item - 1));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Opção inválida!");
                            }
                            System.out.println("Item adicionado ao pedido: " + cardapio.getItem(item - 1).getNome());
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Você deve digitar o número correspondente a opção desejada");
                        sc.next();
                    }
                }

                System.out.println("Nota fiscal");
                System.out.println("Cliente: " + p.getCliente().getNome());
                System.out.println("Resumo do pedido: ");
                p.showItems();
                System.out.println("Taxa de serviço (10%): " + String.format("%.2f", p.taxService()));
                System.out.println("Valor total do pedido: " + String.format("%.2f", p.valorTotal()));

                System.out.println("Digite um valor para pagamento: ");
                double valorPago;
                try {
                    valorPago = sc.nextDouble();
                    System.out.println("Troco: " + (String.format("%.2f", valorPago - p.valorTotal())));
                    opcao = 0;
                } catch (InputMismatchException e) {
                    System.out.println("Valor para pagamento inválido");
                    sc.next();
                }
            }
        }

        sc.close();
    }
}