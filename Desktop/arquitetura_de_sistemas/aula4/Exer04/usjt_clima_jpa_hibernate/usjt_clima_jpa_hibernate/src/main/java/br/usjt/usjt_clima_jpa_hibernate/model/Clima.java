package br.usjt.usjt_clima_jpa_hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_clima")
public class Clima {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false,length=200)
	private Double tempMinima;
	@Column(nullable=false,length=200)
	private Double tempMaxima;
	@Column(nullable=false,length=200)
	private Double umidaRelativa;
	@Column(nullable=false,length=200)
	private String descricao;
	@Column(nullable=false,length=200)
	private String dataHora;
	
	@OneToOne(optional=false)
	@JoinColumn(name="id_do_dia_da_semana")
	private DiaDaSemana diaDaSemana;
	
	@ManyToOne(optional=false,cascade = CascadeType.ALL)
	private Cidade cidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getTempMinima() {
		return tempMinima;
	}
	public void setTempMinima(Double tempMinima) {
		this.tempMinima = tempMinima;
	}
	public Double getTempMaxima() {
		return tempMaxima;
	}
	public void setTempMaxima(Double tempMaxima) {
		this.tempMaxima = tempMaxima;
	}
	public Double getUmidaRelativa() {
		return umidaRelativa;
	}
	public void setUmidaRelativa(Double umidaRelativa) {
		this.umidaRelativa = umidaRelativa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tempMaxima == null) ? 0 : tempMaxima.hashCode());
		result = prime * result + ((tempMinima == null) ? 0 : tempMinima.hashCode());
		result = prime * result + ((umidaRelativa == null) ? 0 : umidaRelativa.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clima other = (Clima) obj;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tempMaxima == null) {
			if (other.tempMaxima != null)
				return false;
		} else if (!tempMaxima.equals(other.tempMaxima))
			return false;
		if (tempMinima == null) {
			if (other.tempMinima != null)
				return false;
		} else if (!tempMinima.equals(other.tempMinima))
			return false;
		if (umidaRelativa == null) {
			if (other.umidaRelativa != null)
				return false;
		} else if (!umidaRelativa.equals(other.umidaRelativa))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Clima [id=" + id + ", tempMinima=" + tempMinima + ", tempMaxima=" + tempMaxima + ", umidaRelativa="
				+ umidaRelativa + ", descricao=" + descricao + ", dataHora=" + dataHora + ", diaDaSemana=" + diaDaSemana
				+ ", cidade=" + cidade + "]";
	}
}
