package com.pierredev.data.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pierredev.entities.ProdutoVenda;
import com.pierredev.entities.Venda;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id","data","produtos","preco"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VendaVO extends RepresentationModel<VendaVO> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("data")
	private Date data;
	
	@JsonProperty("produtos")
	private List<ProdutoVendaVO> produtos;
	
	@JsonProperty("valortotal")
	private Double valorTotal;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public List<ProdutoVendaVO> getProdutos() {
		return produtos;
	}



	public void setProdutos(List<ProdutoVendaVO> produtos) {
		this.produtos = produtos;
	}



	public Double getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}



	public static VendaVO create(Venda venda) {
		return new ModelMapper().map(venda, VendaVO.class);
		
	}
}
