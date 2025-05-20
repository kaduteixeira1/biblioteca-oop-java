import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Dados iniciais para testes
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell", "123"));
        biblioteca.adicionarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "456"));
        biblioteca.adicionarUsuario(new UsuarioVip("Carlos Eduardo"));
        biblioteca.adicionarUsuario(new Usuario("Maria Silva"));

        int opcaoPrincipal = -1;
        while (opcaoPrincipal != 0) {
            try {
                System.out.println("\n===== Sistema de Gerenciamento de Biblioteca =====");
                System.out.println("1 - Gerenciar Usuários");
                System.out.println("2 - Gerenciar Livros");
                System.out.println("3 - Gerenciar Empréstimos");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                opcaoPrincipal = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoPrincipal) {
                    case 1:
                        gerenciarUsuarios(biblioteca, scanner);
                        break;
                    case 2:
                        gerenciarLivros(biblioteca, scanner);
                        break;
                    case 3:
                        gerenciarEmprestimos(biblioteca, scanner);
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void gerenciarUsuarios(Biblioteca biblioteca, Scanner scanner) {
        int opcao = -1;
        while (opcao != 0) {
            try {
                System.out.println("\n--- Gerenciar Usuários ---");
                System.out.println("1 - Listar usuários");
                System.out.println("2 - Cadastrar usuário");
                System.out.println("3 - Remover usuário");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        biblioteca.listarUsuarios();
                        break;
                    case 2:
                        System.out.print("Digite o nome do usuário: ");
                        String nome = scanner.nextLine();
                        int tipo;
                        do {
                            System.out.print("Digite o tipo de usuário (1 - Comum, 2 - VIP): ");
                            while (!scanner.hasNextInt()) {
                                System.out.print("Entrada inválida. Digite 1 ou 2: ");
                                scanner.next();
                            }
                            tipo = scanner.nextInt();
                            scanner.nextLine();
                        } while (tipo != 1 && tipo != 2);

                        Usuario novoUsuario = (tipo == 2) ? new UsuarioVip(nome) : new Usuario(nome);
                        biblioteca.adicionarUsuario(novoUsuario);
                        System.out.println("Usuário cadastrado com sucesso.");
                        break;
                    case 3:
                        System.out.print("Digite o ID do usuário para remover: ");
                        int idRemover = scanner.nextInt();
                        scanner.nextLine();
                        if (biblioteca.removerUsuario(idRemover)) {
                            System.out.println("Usuário removido.");
                        } else {
                            System.out.println("Usuário não encontrado.");
                        }
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            }
        }
    }

    private static void gerenciarLivros(Biblioteca biblioteca, Scanner scanner) {
        int opcao = -1;
        while (opcao != 0) {
            try {
                System.out.println("\n--- Gerenciar Livros ---");
                System.out.println("1 - Listar livros");
                System.out.println("2 - Cadastrar livro");
                System.out.println("3 - Remover livro");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        biblioteca.listarLivros();
                        break;
                    case 2:
                        System.out.print("Digite o título do livro: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Digite o autor do livro: ");
                        String autor = scanner.nextLine();
                        System.out.print("Digite o ISBN do livro: ");
                        String isbn = scanner.nextLine();
                        if (biblioteca.buscarLivroPorIsbn(isbn) != null) {
                            System.out.println("ISBN já cadastrado! Tente outro.");
                        } else {
                            biblioteca.adicionarLivro(new Livro(titulo, autor, isbn));
                            System.out.println("Livro cadastrado com sucesso.");
                        }
                        break;
                    case 3:
                        System.out.print("Digite o ISBN do livro para remover: ");
                        String isbnRemover = scanner.nextLine();
                        if (biblioteca.removerLivro(isbnRemover)) {
                            System.out.println("Livro removido.");
                        } else {
                            System.out.println("Livro não encontrado.");
                        }
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            }
        }
    }

    private static void gerenciarEmprestimos(Biblioteca biblioteca, Scanner scanner) {
        int opcao = -1;
        while (opcao != 0) {
            try {
                System.out.println("\n--- Gerenciar Empréstimos ---");
                System.out.println("1 - Realizar empréstimo");
                System.out.println("2 - Devolver livro");
                System.out.println("3 - Listar empréstimos");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o ISBN do livro: ");
                        String isbnEmprestimo = scanner.nextLine();
                        System.out.print("Digite o ID do usuário: ");
                        int idUsuarioEmprestimo = scanner.nextInt();
                        scanner.nextLine();
                        biblioteca.emprestarLivro(isbnEmprestimo, idUsuarioEmprestimo);
                        break;
                    case 2:
                        System.out.print("Digite o ISBN do livro: ");
                        String isbnDevolucao = scanner.nextLine();
                        System.out.print("Digite o ID do usuário: ");
                        int idUsuarioDevolucao = scanner.nextInt();
                        scanner.nextLine();
                        biblioteca.devolverLivro(isbnDevolucao, idUsuarioDevolucao);
                        break;
                    case 3:
                        biblioteca.listarEmprestimos();
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            }
        }
    }
}
