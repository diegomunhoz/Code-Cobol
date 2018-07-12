package dao;

import java.util.ArrayList;
import model.Dicionariodetipos;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DicionariodetiposDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Dicionariodetipos> buscarTodos() throws Exception {
        ArrayList<Dicionariodetipos> listaRetorno = new ArrayList<Dicionariodetipos>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Dicionariodetipos.class);
        criteria.addOrder(Order.asc("tipoCampo"));
        listaRetorno = (ArrayList<Dicionariodetipos>) criteria.list();
        return listaRetorno;
    }

    public Dicionariodetipos buscarPorCodigo(Long codigo) throws Exception {
        Session sessao = null;
        Dicionariodetipos cliente = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        cliente = (Dicionariodetipos) sessao.get(Dicionariodetipos.class, codigo);
        return cliente;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Dicionariodetipos> buscarPorNome(String nome) throws Exception {
        ArrayList<Dicionariodetipos> listaRetorno = new ArrayList<Dicionariodetipos>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Dicionariodetipos.class);
        criteria.add(Restrictions.ilike("tipoCampo", "%" + nome + "%"));
        criteria.addOrder(Order.asc("tipoCampo"));
        listaRetorno = (ArrayList<Dicionariodetipos>) criteria.list();
        return listaRetorno;
    }
}