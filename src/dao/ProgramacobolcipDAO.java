package dao;

import java.util.ArrayList;
import model.Programacobolcip;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class ProgramacobolcipDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Programacobolcip> buscarTodos() throws Exception {
        ArrayList<Programacobolcip> listaRetorno = new ArrayList<Programacobolcip>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Programacobolcip.class);
        criteria.addOrder(Order.asc("idProgramacobolcip"));
        listaRetorno = (ArrayList<Programacobolcip>) criteria.list();
        return listaRetorno;
    }

    public Programacobolcip buscarPorCodigo(Long codigo) throws Exception {
        Session sessao = null;
        Programacobolcip cliente = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        cliente = (Programacobolcip) sessao.get(Programacobolcip.class, codigo);
        return cliente;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Programacobolcip> buscarPorNome(String nome) throws Exception {
        ArrayList<Programacobolcip> listaRetorno = new ArrayList<Programacobolcip>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Programacobolcip.class);
        criteria.add(Restrictions.ilike("nome", "%" + nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Programacobolcip>) criteria.list();
        return listaRetorno;
    }
}