package com.equipe7.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.equipe7.dao.PessoaDAO;

@ManagedBean
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = -9200881845896475718L;

	private String nome;
	private String sexo;
	private int tipoDocumento;
	private String numDocumento;
	private String email;
	private String telefone;
	private String endereco;
	private long idade;
	private String dataCadastro;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public long getIdade() {
		return idade;
	}

	public void setIdade(long idade) {
		this.idade = idade;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String insert() {
		boolean valid = PessoaDAO.insert(nome, sexo, tipoDocumento, numDocumento, email, telefone, endereco, idade,
				dataCadastro);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("nome", nome);
			session.setAttribute("sexo", sexo);
			session.setAttribute("tipoDocumento", tipoDocumento);
			session.setAttribute("numDocumento", numDocumento);
			session.setAttribute("email", email);
			session.setAttribute("telefone", telefone);
			session.setAttribute("endereco", endereco);
			session.setAttribute("idade", idade);

			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro ao cadastrar pessoa.", "Por favor repita o processo"));
			return "insert";
		}

	}

	public ArrayList<PessoaBean> getMessages() {
		return PessoaDAO.getPessoas();
	}

	public void clearFormPessoa() {
		setNome(null);
		setSexo(null);
		setTipoDocumento(0);
		setNumDocumento(null);
		setEmail(null);
		setTelefone(null);
		setEndereco(null);
		setIdade(0);

	}

}
