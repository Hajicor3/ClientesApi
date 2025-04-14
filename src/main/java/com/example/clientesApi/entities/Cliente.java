package com.example.clientesApi.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_clientes")
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String telefone;
	
	public Cliente(String nome, String cpf, String email, String senha, String telefone) {
		setNome(nome);
		setCpf(cpf);
		setEmail(email);
		setSenha(senha);
		setTelefone(telefone);
	}

	public void setNome(String nome) {
		if(nome == null || nome.trim().length() < 3) {
			throw new IllegalArgumentException("O nome não pode ser nulo e deve ter pelo menos 3 caracteres!");
		}
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		if (cpf == null || !cpf.trim().matches("\\d{11}")){
			throw new IllegalArgumentException("Cpf inválido !");
		}
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		if(email == null || !email.trim().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException("Email inválido");
		}
		this.email =  email;
	}

	public void setSenha(String senha) {
		if(senha == null || senha.trim().isEmpty()){
			throw new IllegalArgumentException("Senha inválida! A senha não pode ser vazia.");
		}
		this.senha = senha;
	}

	public void setTelefone(String telefone) {
		if(telefone == null || telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("Telefone inválido!");
		}
		this.telefone = telefone;
	}
}
