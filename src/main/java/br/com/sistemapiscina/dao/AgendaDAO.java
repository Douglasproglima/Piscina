package br.com.sistemapiscina.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistemapiscina.domain.AgendaXDias;
import br.com.sistemapiscina.domain.Agenda;
import br.com.sistemapiscina.util.HibernateUtil;

public class AgendaDAO extends GenericDAO<Agenda>{

	public void salvar(Agenda agenda, List<AgendaXDias> agendasXDias){
		Session sessao =  HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			
			//Salva o cabeçalho
			sessao.save(agenda);
			
			//Após obter o save do cabeçalho é possível retornar o código do pai
			for (int posicao = 0; posicao < agendasXDias.size(); posicao++) {
				//Pega o item da linha corrente, onde neste momento se tem o 
				//a agenda, valor e dias, faltando apenas o código.
				AgendaXDias agendaXDias = agendasXDias.get(posicao);
				
				//Salva agenda na tabela de itens da agenda
				agendaXDias.setAgenda(agenda);
				
				//Salva os itens da agenda
				sessao.save(agendaXDias);
			}
			
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				//Se der erro no Agendamento ou nos itens do agendamentos, cancela toda a transação realizada
				transacao.rollback();
			}
			throw erro;
		}finally {
			sessao.close();
		}
	}
}
