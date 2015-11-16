package classes;

public class Email {

    private String email;
    private TipoEmail tipo;

    public Email(String email, TipoEmail tipo) {
        this.email = email;
        this.tipo = tipo;
    }

    public Email() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoEmail getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmail tipo) {
        this.tipo = tipo;
    }

    public String[] infoBasico() {

        return (new String[]{this.email, this.tipo.getDescricao(), Integer.toString(this.tipo.getCod())});

    }

}
