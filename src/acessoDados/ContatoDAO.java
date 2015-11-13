package acessoDados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Conexao;
import classes.Contato;
import classes.Fone;
import java.sql.PreparedStatement;

public class ContatoDAO {

    public static List<Contato> listarContatos() throws Exception {

        List<Contato> lista = new ArrayList<>(0);
        String sb = "select * from contato";

        try {
            ResultSet listaAux = Conexao.obterStatement().executeQuery(sb);

            while (listaAux.next()) {
                lista.add(new Contato(listaAux.getInt("codcontato"), listaAux.getString("nome"), listaAux.getString("sobrenome"), listaAux.getString("foto"), listaAux.getString("datacadastro")));
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public static List<Contato> pesquisaContatos(String nome) throws Exception {

        List<Contato> lista = new ArrayList<>(0);
        StringBuilder sb;
        sb = new StringBuilder("select * from contato "
                + "where nome like '%" + nome + "%' or "
                + "sobrenome like '%" + nome + "%'");

        try {
            ResultSet listaAux = Conexao.obterStatement().executeQuery(sb.toString());

            while (listaAux.next()) {
                lista.add(new Contato(listaAux.getInt("codcontato"), listaAux.getString("nome"), listaAux.getString("sobrenome"), listaAux.getString("foto"), listaAux.getString("datacadastro")));
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public static Contato pesquisaContato(int nome) throws Exception {

        StringBuilder sb;
        sb = new StringBuilder("select * from contato "
                + "where codcontato = " + nome);

        try {

            ResultSet listaAux = Conexao.obterStatement().executeQuery(sb.toString());
            while (listaAux.next()) {

                return (new Contato(listaAux.getInt("codcontato"), listaAux.getString("nome"), listaAux.getString("sobrenome"), listaAux.getString("foto"), listaAux.getString("datacadastro")));

            }
        } catch (SQLException e) {

            throw e;
        }
        return null;
    }

    public static int qtdadeContato() throws Exception {

        StringBuilder sb;
        //sb = new StringBuilder("select count(*) as [qtdade] from contato ");
        sb = new StringBuilder("select max(codcontato) as [qtdade] from contato ");

        try {

            ResultSet listaAux = Conexao.obterStatement().executeQuery(sb.toString());
            while (listaAux.next()) {
                return listaAux.getInt("qtdade");
            }

        } catch (SQLException e) {

            throw e;
        }
        return 0;
    }

    public static void insereContato(Contato c) throws SQLException {

        String SQLcontato = " insert into contato(nome, sobrenome, foto) values (?,?,?)";

        PreparedStatement ps = Conexao.obterConexao().prepareStatement(SQLcontato);

        ps.setString(1, c.getNome());
        ps.setString(2, c.getSobrenome());
        ps.setString(3, c.getFoto());
        ps.executeUpdate();

    }

    public static void updateContato(Contato c) throws SQLException {

        String SQLcontato = " update contato set nome = ?, sobrenome = ?, foto = ? where codcontato = ?";

        PreparedStatement ps = Conexao.obterConexao().prepareStatement(SQLcontato);

        ps.setString(1, c.getNome());
        ps.setString(2, c.getSobrenome());
        ps.setString(3, c.getFoto());
        ps.setInt(4, c.getCodcontato());
        ps.executeUpdate();

    }

    public static void delContato(Contato c) throws SQLException{
        String SQLcontato = " delete from contato where codcontato = ?";

        PreparedStatement ps = Conexao.obterConexao().prepareStatement(SQLcontato);

        ps.setInt(1, c.getCodcontato());
      
        ps.executeUpdate();
        
    }
}
