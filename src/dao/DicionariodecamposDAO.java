package dao;

import java.util.ArrayList;
import model.Dicionariodecampos;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DicionariodecamposDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Dicionariodecampos> buscarTodos() throws Exception {
        ArrayList<Dicionariodecampos> listaRetorno = new ArrayList<Dicionariodecampos>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Dicionariodecampos.class);
        criteria.addOrder(Order.asc("idDicionariodecampos"));
        listaRetorno = (ArrayList<Dicionariodecampos>) criteria.list();
        return listaRetorno;
    }

    public Dicionariodecampos buscarPorCodigo(Long codigo) throws Exception {
        Session sessao = null;
        Dicionariodecampos cliente = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        cliente = (Dicionariodecampos) sessao.get(Dicionariodecampos.class, codigo);
        return cliente;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Dicionariodecampos> buscarPorNome(String nome) throws Exception {
        ArrayList<Dicionariodecampos> listaRetorno = new ArrayList<Dicionariodecampos>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Dicionariodecampos.class);
        criteria.add(Restrictions.ilike("nome", "%" + nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Dicionariodecampos>) criteria.list();
        return listaRetorno;
    }
}