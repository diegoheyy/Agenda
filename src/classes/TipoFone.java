/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author DIEGOHEYY
 */
public class TipoFone {

    private int cod;
    private String descricao;

    public TipoFone(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public TipoFone() {

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
