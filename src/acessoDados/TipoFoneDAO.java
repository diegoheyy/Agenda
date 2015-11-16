/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acessoDados;

import classes.Conexao;
import classes.TipoFone;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DIEGOHEYY
 */
public class TipoFoneDAO {

    public static List<TipoFone> listaTipoFone() throws Exception {
        List<TipoFone> lista = new ArrayList<TipoFone>(0);
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * ");
        sb.append(" FROM tipofone ");

        try {
            ResultSet listaAux = Conexao.obterStatement().executeQuery(sb.toString());

            while (listaAux.next()) {
                TipoFone tipo = new TipoFone();
                tipo.setCod(listaAux.getInt("codtipofone"));
                tipo.setDescricao(listaAux.getString("descricao"));

                lista.add(tipo);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
}
