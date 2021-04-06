package com.pierredev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pierredev.data.vo.VendaVO;
import com.pierredev.entities.ProdutoVenda;
import com.pierredev.entities.Venda;
import com.pierredev.exception.ResourceNotFoundException;
import com.pierredev.repositories.ProdutoRepository;
import com.pierredev.repositories.ProdutoVendaRepository;
import com.pierredev.repositories.VendaRepository;

@Service
public class VendaService {
	

	private final VendaRepository vendaRepository;
	private final ProdutoVendaRepository produtoVendaRepository;
	//private final ProdutoSendMessage produtoSendMessage;

	@Autowired
	public VendaService(VendaRepository produtoRepository, ProdutoVendaRepository produtoVendaRepository) {
		this.vendaRepository = produtoRepository;
		this.produtoVendaRepository = produtoVendaRepository;
		
	}
	
	public VendaVO create(VendaVO vendaVO) {
		Venda venda = vendaRepository.save(Venda.create(vendaVO));
		
		List<ProdutoVenda> produtoSalvos = new ArrayList<>();
		vendaVO.getProdutos().forEach(p -> {
			ProdutoVenda pv = ProdutoVenda.create(p);
			pv.setVenda(venda);
			produtoSalvos.add(produtoVendaRepository.save(pv));
		});
		venda.setProdutos(produtoSalvos);
		
	 	return VendaVO.create(venda);
	 	
	}
	
	public Page<VendaVO> findAll(Pageable pageable) {
		var page = vendaRepository.findAll(pageable);
		return page.map(this::convertToVendaVO);
	}

	private VendaVO convertToVendaVO(Venda venda) {
		return VendaVO.create(venda);
	}
	
	public VendaVO findById(Long id) {
		var entity = vendaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return VendaVO.create(entity);
	}
	

	public VendaVO update(VendaVO vendaVO) {
		final Optional<Venda> optionalProduto = vendaRepository.findById(vendaVO.getId());
		
		if(!optionalProduto.isPresent()) {
			new ResourceNotFoundException("No records found for this ID");
		}
		
		return VendaVO.create(vendaRepository.save(Venda.create(vendaVO)));
	}
	
	public void delete(Long id) {
		var entity = vendaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		vendaRepository.delete(entity);
	}


}
