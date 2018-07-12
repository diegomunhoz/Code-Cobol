package dao;

import java.util.ArrayList;
import model.Arquivocip;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class ArquivocipDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Arquivocip> buscarTodos() throws Exception {
        ArrayList<Arquivocip> listaRetorno = new ArrayList<Arquivocip>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Arquivocip.class);
        criteria.addOrder(Order.asc("idArquivocip"));
        listaRetorno = (ArrayList<Arquivocip>) criteria.list();
        return listaRetorno;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Arquivocip> buscarPorNome(String nome) throws Exception {
        ArrayList<Arquivocip> listaRetorno = new ArrayList<Arquivocip>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Arquivocip.class);
        criteria.add(Restrictions.ilike("nome", "%" + nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Arquivocip>) criteria.list();
        return listaRetorno;
    }
}