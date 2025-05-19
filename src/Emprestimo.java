import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
    }
    public Livro getLivro() {
        return livro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public void devolver(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        livro.setDisponivel(true);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
               "livro=" + livro.getTitulo() +
               ", usuario=" + usuario.getNome() +
               ", dataEmprestimo=" + dataEmprestimo +
               ", dataDevolucao=" + (dataDevolucao == null ? "Não devolvido" : dataDevolucao) +
               '}';
    }
}
