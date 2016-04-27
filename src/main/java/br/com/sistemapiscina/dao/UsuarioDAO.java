package br.com.sistemapiscina.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.sistemapiscina.domain.Usuario;
import br.com.sistemapiscina.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario>{
	//Criptografia da senha através do SimpleHash
		public Usuario autenticar(String nome, String senha){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			
			try {
				Criteria consulta = sessao.createCriteria(Usuario.class);
				consulta.createAlias("usuario", "user");
				
				consulta.add(Restrictions.eq("user.nome", nome));
//				consulta.add(Restrictions.eq("p.cpf", nome));
				
				//Pega a senha normal e passa para o simpleHash criptografar com  md5
				SimpleHash hash =  new SimpleHash("md5", senha);
				//passa a senha criptografada
				consulta.add(Restrictions.eq("senha", hash.toHex()));
				
				Usuario resultado = (Usuario) consulta.uniqueResult();
				
				return resultado;
			} catch (RuntimeException erro) {
				throw erro;
			}finally {
				sessao.close();
			}
		}
}
