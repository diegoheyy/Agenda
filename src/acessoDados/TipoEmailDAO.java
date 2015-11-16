/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acessoDados;

import classes.Conexao;
import classes.TipoEmail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DIEGOHEYY
 */
public class TipoEmailDAO {

    public static List<TipoEmail> listaTipoEmail() throws Exception {
        List<TipoEmail> lista = new ArrayList<TipoEmail>(0);
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * ");
        sb.append(" FROM tipoemail ");

        try {
            ResultSet listaAux = Conexao.obterStatement().executeQuery(sb.toString());

            while (listaAux.next()) {
                TipoEmail tipo = new TipoEmail();
                tipo.setCod(listaAux.getInt("codtipoemail"));
                tipo.setDescricao(listaAux.getString("descricao"));

                lista.add(tipo);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

}
