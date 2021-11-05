package br.org.serratec.backend.dto;

import br.org.serratec.backend.model.Usuario;

public class UsuarioDTO {
	
	private Long id;
	private String nome;
	private String email;
		
	public UsuarioDTO() {
		super();
	}
	public UsuarioDTO(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.id = usuario.getId();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
