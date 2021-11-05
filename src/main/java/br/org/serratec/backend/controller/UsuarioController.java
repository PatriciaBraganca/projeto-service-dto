package br.org.serratec.backend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.backend.dto.UsuarioDTO;
import br.org.serratec.backend.dto.UsuarioInserirDTO;
import br.org.serratec.backend.exception.EmailException;
import br.org.serratec.backend.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	/*
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listar(){
		List<UsuarioDTO> usuariosDTO = usuarioService.listar();
		return ResponseEntity.ok(usuariosDTO);
	}
	*/
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listar(){
		return ResponseEntity.ok(usuarioService.listar());
	}
	
	@PostMapping
	public ResponseEntity<Object> inserir(@RequestBody UsuarioInserirDTO usuarioInserirDTO) {
		try {
			UsuarioDTO usuarioDTO = usuarioService.inserir(usuarioInserirDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(usuarioDTO.getId())
					.toUri();
			return ResponseEntity.created(uri).body(usuarioDTO);
		} catch (EmailException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}
	}
