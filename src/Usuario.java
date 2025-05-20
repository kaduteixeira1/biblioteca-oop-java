public class Usuario {
    protected static int contadorId = 1;
    protected String nome;
    protected int id;

    public Usuario(String nome) {
        this.nome = nome;
        this.id = contadorId++;
    }
    public String getNome() {return nome;}
    public int getId() {return id;}
    public int getPrazoEmprestimoDias() {return 7;}
    public String getTipo() {return "Comum";}

    @Override
    public String toString() {
        return "Usuario{" +
               "nome='" + nome + '\'' +
               ", id=" + id +
               ", tipo=" + getTipo() +
               '}';
    }
}
