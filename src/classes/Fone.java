package classes;

public class Fone {

    private String numero;
    private TipoFone tipo;

    public Fone(String numero, TipoFone tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Fone() {

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoFone getTipo() {
        return tipo;
    }

    public void setTipo(TipoFone tipo) {
        this.tipo = tipo;
    }

    public String[] infoBasico() {

        return (new String[]{this.numero, this.tipo.getDescricao(), Integer.toString(this.tipo.getCod())});

    }

}
