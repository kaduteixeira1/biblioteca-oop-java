import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario, LocalDateTime dataEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
        livro.setDisponivel(false);
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void devolver(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        livro.setDisponivel(true);
    }

    public void mostrarPrazoDevolucao() {
        LocalDateTime prazo = dataEmprestimo.plusDays(usuario.getPrazoEmprestimoDias());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Prazo de devolução para " + usuario.getNome() + " (" + usuario.getTipo() + "): " + prazo.format(formatter));
    }

    @Override
    public String toString() {
        return "\nEmprestimo{" +
               "livro=" + livro.getTitulo() +
               ", usuario=" + usuario.getNome() +
               ", dataEmprestimo=" + dataEmprestimo +
               ", dataDevolucao=" + (dataDevolucao == null ? "Não devolvido" : dataDevolucao) +
               '}';
    }
}
