/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acessoDados;

import classes.Conexao;
import classes.Contato;
import classes.Email;
import classes.Fone;
import classes.TipoEmail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DIEGOHEYY
 */
public class EmailDAO {

    public static List<Email> listarEmails(int contato) throws Exception {
        List<Email> lista = new ArrayList<Email>(0);
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT e.email as [email],e.codtipoemail as [tipo],  t.descricao as [descricao] ");
        sb.append(" FROM emailscontato e ");
        sb.append("    INNER JOIN tipoemail t ON e.codtipoemail = t.codtipoemail");
        sb.append(" where e.codcontato  = ").append(contato);

        try {
            ResultSet listaAux = Conexao.obterStatement().executeQuery(sb.toString());

            while (listaAux.next()) {
                Email email = new Email();
                email.setEmail(listaAux.getString("email"));
                email.setTipo(new TipoEmail(listaAux.getInt("tipo"), listaAux.getString("descricao")));

                lista.add(email);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public static void inserirEmails(Contato c) throws SQLException {
        String SQLcontato = " insert into emailscontato(codcontato, codtipoemail, email)  values (?,?,?); ";
        PreparedStatement ps = Conexao.obterConexao().prepareStatement(SQLcontato);

        for (Email ee : c.getEmails()) {
            ps.setInt(1, c.getCodcontato());
            ps.setInt(2, ee.getTipo().getCod());
            ps.setString(3, ee.getEmail());
            ps.executeUpdate();
        }

    }

    public static void delEmails(Contato c) throws SQLException {
        String SQLcontato = " delete from emailscontato where codcontato = ?";
        PreparedStatement ps = Conexao.obterConexao().prepareStatement(SQLcontato);
        ps.setInt(1, c.getCodcontato());
        ps.executeUpdate();

    }

}
