package dao;

import java.util.ArrayList;
import model.Linhacodigoprogramacobol;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class LinhacodigoprogramacobolDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Linhacodigoprogramacobol> buscarTodos() throws Exception {
        ArrayList<Linhacodigoprogramacobol> listaRetorno = new ArrayList<Linhacodigoprogramacobol>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Linhacodigoprogramacobol.class);
        criteria.addOrder(Order.asc("idLinhacodigoprogramacobol"));
        listaRetorno = (ArrayList<Linhacodigoprogramacobol>) criteria.list();
        return listaRetorno;
    }

    public Linhacodigoprogramacobol buscarPorCodigo(Long codigo) throws Exception {
        Session sessao = null;
        Linhacodigoprogramacobol cliente = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        cliente = (Linhacodigoprogramacobol) sessao.get(Linhacodigoprogramacobol.class, codigo);
        return cliente;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Linhacodigoprogramacobol> buscarPorNome(String nome) throws Exception {
        ArrayList<Linhacodigoprogramacobol> listaRetorno = new ArrayList<Linhacodigoprogramacobol>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Linhacodigoprogramacobol.class);
        criteria.add(Restrictions.ilike("nome", "%" + nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Linhacodigoprogramacobol>) criteria.list();
        return listaRetorno;
    }
}