/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acessoDados;

import classes.Conexao;
import classes.Contato;
import classes.Fone;
import classes.TipoFone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DIEGOHEYY
 */
public class FoneDao {

    public static List<Fone> listarFones(int contato) throws Exception {
        List<Fone> lista = new ArrayList<Fone>(0);
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT e.numero as [fone], e.codtipofone as [tipo],t.descricao as [descricao] ");
        sb.append(" FROM fonescontato e  ");
        sb.append("    INNER JOIN tipofone t ON e.codtipofone = t.codtipofone");
        sb.append(" where e.codcontato  = ").append(contato);

        try {
            ResultSet listaAux = Conexao.obterStatement().executeQuery(sb.toString());

            while (listaAux.next()) {
                Fone fone = new Fone();
                fone.setNumero(listaAux.getString("fone"));
                fone.setTipo(new TipoFone(listaAux.getInt("tipo"), listaAux.getString("descricao")));

                lista.add(fone);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public static void inserirFones(Contato c) throws SQLException {
        String SQLcontato = " insert into fonescontato(codcontato, codtipofone, numero)  values (?,?,?); ";
        PreparedStatement ps = Conexao.obterConexao().prepareStatement(SQLcontato);

        for (Fone ee : c.getFones()) {
            ps.setInt(1, c.getCodcontato());
            ps.setInt(2, ee.getTipo().getCod());
            ps.setString(3, ee.getNumero());
            ps.executeUpdate();
        }

    }

    public static void delFones(Contato c) throws SQLException {
        String SQLcontato = " delete from fonescontato where codcontato = ?";
        PreparedStatement ps = Conexao.obterConexao().prepareStatement(SQLcontato);
        ps.setInt(1, c.getCodcontato());
        ps.executeUpdate();

    }
}
