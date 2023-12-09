import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

public class main {
    static ArrayList<Produto> produtos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            System.out.println("Selecione a operação:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Atualizar produto");
            System.out.println("4. Deletar produto");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    deletarProduto();
                    break;
                case 5:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static void adicionarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.next();
        System.out.println("Digite o preço do produto:");
        double preco;
        while (true) {
            try {
                preco = Double.parseDouble(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido. Digite o preço do produto novamente:");
            }
        }
        Produto produto = new Produto(nome, preco);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso");
    }

    public static void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.nome + " | Preço: " + produto.preco);
        }
    }

    public static void atualizarProduto() {
        System.out.println("Digite o nome do produto que deseja atualizar:");
        String nome = scanner.next();
        boolean produtoEncontrado = false;
        for (Produto produto : produtos) {
            if (produto.nome.equalsIgnoreCase(nome)) {
                System.out.println("Digite o novo nome do produto:");
                String novoNome = scanner.next();
                System.out.println("Digite o novo preço do produto:");
                double novoPreco = scanner.nextDouble();
                produto.nome = novoNome;
                produto.preco = novoPreco;
                produtoEncontrado = true;
                System.out.println("Produto atualizado com sucesso");
                break;
            }
        }
        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado");
        }
    }

    public static void deletarProduto() {
        System.out.println("Digite o nome do produto que deseja excluir:");
        String nome = scanner.next();
        boolean produtoEncontrado = false;
        for (Produto produto : produtos) {
            if (produto.nome.equalsIgnoreCase(nome)) {
                produtos.remove(produto);
                produtoEncontrado = true;
                System.out.println("Produto excluído com sucesso");
                break;
            }
        }
        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado");
        }
    }
}
