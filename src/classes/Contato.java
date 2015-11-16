package classes;

import java.util.ArrayList;
import java.util.List;

public class Contato {

    private int codcontato;
    private String nome;
    private String sobrenome;
    private String foto;
    private String data;

    private List<Email> emails = new ArrayList<Email>(0);
    private List<Fone> fones = new ArrayList<Fone>(0);

    public Contato() {
    }

    public Contato(int codcontato, String nome, String sobrenome, String foto, String data) {
        this.codcontato = codcontato;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.foto = foto;
        this.data = data;
    }

    public int getCodcontato() {
        return codcontato;
    }

    public void setCodcontato(int codcontato) {
        this.codcontato = codcontato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public String getUmEmail() {
        if (this.emails.isEmpty()) {
            return "";
        }
        return emails.get(0).getEmail();
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Fone> getFones() {
        return fones;
    }

    public String getUmFone() {
        if (this.fones.isEmpty()) {
            return "";
        }
        return fones.get(0).getNumero();
    }

    public void setFones(List<Fone> fones) {
        this.fones = fones;
    }

    public String[] infoBasico() {

        return (new String[]{this.nome, this.sobrenome, this.getUmFone(), this.getUmEmail(), Integer.toString(this.getCodcontato())});

    }

}
