package controle;

import java.util.List;
import acessoDados.ContatoDAO;
import acessoDados.EmailDAO;
import static acessoDados.EmailDAO.listarEmails;
import acessoDados.FoneDao;
import static acessoDados.FoneDao.listarFones;
import acessoDados.TipoEmailDAO;
import acessoDados.TipoFoneDAO;
import classes.Contato;
import classes.TipoEmail;
import classes.TipoFone;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultas {

    public static List<Contato> listarContato() throws Exception {
        List<Contato> c = ContatoDAO.listarContatos();
        for (Contato com : c) {
            com.setEmails(listarEmails(com.getCodcontato()));
            com.setFones(listarFones(com.getCodcontato()));
        }
        return c;
    }

    public static List<Contato> pesquisaContato(String nome) throws Exception {
        List<Contato> c = ContatoDAO.pesquisaContatos(nome);
        for (Contato com : c) {
            com.setEmails(listarEmails(com.getCodcontato()));
            com.setFones(listarFones(com.getCodcontato()));
        }
        return c;
    }

    public static Contato pesquisaContato(int cod) throws Exception {
        Contato com = ContatoDAO.pesquisaContato(cod);

        com.setEmails(listarEmails(cod));
        com.setFones(listarFones(cod));

        return com;
    }

    public static List<TipoEmail> listaTipoEmail() throws Exception {
        return TipoEmailDAO.listaTipoEmail();
    }

    public static List<TipoFone> listaTipoFone() throws Exception {
        return TipoFoneDAO.listaTipoFone();
    }

    public static String[] vetTipoFone() {
        List<TipoFone> f = null;
        String[] vet = null;
        try {
            f = TipoFoneDAO.listaTipoFone();

            vet = new String[f.size()];

            int cont = 0;
            for (TipoFone fone : f) {
                vet[cont] = fone.getDescricao();
                cont++;
            }

        } catch (Exception ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vet;
    }

    public static String[] vetTipoEmail() {
        List<TipoEmail> f = null;
        String[] vet = null;
        try {
            f = TipoEmailDAO.listaTipoEmail();

            vet = new String[f.size()];

            int cont = 0;
            for (TipoEmail email : f) {
                vet[cont] = email.getDescricao();
                cont++;
            }

        } catch (Exception ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vet;
    }

    public static void insereContato(Contato contato) throws SQLException, Exception {
        int qq = ContatoDAO.qtdadeContato();
        ContatoDAO.insereContato(contato);
        contato.setCodcontato(qq + 1);
        if(contato.getEmails().size()>0){
            EmailDAO.inserirEmails(contato);
        }
        if(contato.getFones().size()>0){
            FoneDao.inserirFones(contato);
        }

    }

    public static void alteraContato(Contato contato) throws SQLException {
        FoneDao.delFones(contato);
        EmailDAO.delEmails(contato);
        FoneDao.inserirFones(contato);
        EmailDAO.inserirEmails(contato);
        ContatoDAO.updateContato(contato);

    }
    
    public static void deletaContato(Contato contato) throws SQLException{
        FoneDao.delFones(contato);
        EmailDAO.delEmails(contato);
        ContatoDAO.delContato(contato);
        
    }
}
