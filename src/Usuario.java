public class Usuario {
    private static int contadorId = 1; 
    private String nome;
    private int id;
    
    public Usuario(String nome) {
        this.nome = nome;
        this.id = contadorId++;
    }
    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "nome='" + nome + '\'' +
               ", id=" + id +
               '}';
    }
}
