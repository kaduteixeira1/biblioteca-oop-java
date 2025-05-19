import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean emprestarLivro(String isbn, int usuarioId) {
        Livro livro = buscarLivroPorIsbn(isbn);
        Usuario usuario = buscarUsuarioPorId(usuarioId);

        if (livro == null) {
            System.out.println("\nLivro não encontrado.");
            return false;
        }
        if (usuario == null) {
            System.out.println("\nUsuário não encontrado.");
            return false;
        }
        if (!livro.isDisponivel()) {
            System.out.println("\nLivro não disponível para empréstimo.");
            return false;
        }

        livro.setDisponivel(false);
        Emprestimo emprestimo = new Emprestimo(livro, usuario, LocalDate.now());
        emprestimos.add(emprestimo);
        System.out.println("\nEmpréstimo realizado com sucesso!");
        return true;
    }

    public boolean devolverLivro(String isbn, int usuarioId) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getIsbn().equals(isbn) &&
                emprestimo.getUsuario().getId() == usuarioId &&
                emprestimo.getDataDevolucao() == null) {
                emprestimo.devolver(LocalDate.now());
                System.out.println("\nLivro devolvido com sucesso!");
                return true;
            }
        }
        System.out.println("\nEmpréstimo não encontrado ou livro já devolvido.");
        return false;
    }

    public Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public void listarLivros() {
        System.out.println("\nLista de livros:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void listarUsuarios() {
        System.out.println("\nLista de usuários:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void listarEmprestimos() {
        System.out.println("\nLista de empréstimos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    public boolean removerUsuario(int id) {
        return usuarios.removeIf(u -> u.getId() == id);
    }
    
    public boolean removerLivro(String isbn) {
        return livros.removeIf(l -> l.getIsbn().equals(isbn));
    }
    
}
