package dao;

import java.util.ArrayList;
import model.Camposarquivocip;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class CamposarquivocipDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Camposarquivocip> buscarTodos() throws Exception {
        ArrayList<Camposarquivocip> listaRetorno = new ArrayList<Camposarquivocip>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Camposarquivocip.class);
        criteria.addOrder(Order.asc("idCamposarquivocip"));
        listaRetorno = (ArrayList<Camposarquivocip>) criteria.list();
        return listaRetorno;
    }

    public Camposarquivocip buscarPorCodigo(Long codigo) throws Exception {
        Session sessao = null;
        Camposarquivocip cliente = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        cliente = (Camposarquivocip) sessao.get(Camposarquivocip.class, codigo);
        return cliente;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Camposarquivocip> buscarPorNome(String nome) throws Exception {
        ArrayList<Camposarquivocip> listaRetorno = new ArrayList<Camposarquivocip>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Camposarquivocip.class);
        criteria.add(Restrictions.ilike("nome", "%" + nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Camposarquivocip>) criteria.list();
        return listaRetorno;
    }
}