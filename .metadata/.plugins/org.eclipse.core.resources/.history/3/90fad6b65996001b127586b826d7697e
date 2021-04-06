package com.pierredev.msvenda.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pierredev.msvenda.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private final ProdutoService produtoService;
	
	private PagedResourcesAssembler<ProdutoVO> assembler;

}
