public class UsuarioVip extends Usuario {
    public UsuarioVip(String nome) {
        super(nome);
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 14;
    }

    @Override
    public String getTipo() {
        return "VIP";
    }
}
