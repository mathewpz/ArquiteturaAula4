package br.usjt.usjt_clima_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.usjt_clima_jpa_hibernate.model.Clima;
import br.usjt.usjt_clima_jpa_hibernate.model.DiaDaSemana;

public class TesteInsereClimaComDiaDaSemana {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		DiaDaSemana d = new DiaDaSemana();
		d.setDia("Segunda");
		manager.persist(d);
		Clima c = new Clima();
		c.setTempMinima(16.9);
		c.setTempMaxima(26.2);
		c.setUmidaRelativa(4.68);
		c.setDescricao("céu claro");
		c.setDataHora("23/03/2020");
		c.setDiaDaSemana(d);
		manager.persist(c);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}
