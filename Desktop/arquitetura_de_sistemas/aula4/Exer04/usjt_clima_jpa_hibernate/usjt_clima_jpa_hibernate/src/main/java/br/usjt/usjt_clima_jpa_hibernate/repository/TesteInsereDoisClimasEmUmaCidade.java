package br.usjt.usjt_clima_jpa_hibernate.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.usjt_clima_jpa_hibernate.model.Cidade;
import br.usjt.usjt_clima_jpa_hibernate.model.Clima;
import br.usjt.usjt_clima_jpa_hibernate.model.DiaDaSemana;

public class TesteInsereDoisClimasEmUmaCidade {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Cidade c= new Cidade();
		c.setNome("São Paulo");
		c.setLatitude(-23.63);
		c.setLongitude(-46.79);
		DiaDaSemana d1 = new DiaDaSemana();
		DiaDaSemana d2 = new DiaDaSemana();
		d1.setDia("Segunda");
		d2.setDia("Terça");
		manager.persist(d1);
		manager.persist(d2);
		List<Clima>climas = new ArrayList<>();
		Clima c1 = new Clima();
		c1.setTempMinima(16.9);
		c1.setTempMaxima(26.2);
		c1.setUmidaRelativa(4.68);
		c1.setDescricao("céu claro");
		c1.setDataHora("23/03/2020");
		c1.setDiaDaSemana(d1);
		c1.setCidade(c);
		Clima c2 = new Clima();
		c2.setTempMinima(16.4);
		c2.setTempMaxima(24.6);
		c2.setUmidaRelativa(3.19);
		c2.setDescricao("céu claro");
		c2.setDataHora("24/03/2020");
		c2.setDiaDaSemana(d2);
		c2.setCidade(c);
		climas.add(c1);
		climas.add(c2);
		c.setClimas(climas);
		manager.persist(c);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}
