package modelos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vinic
 */
public class Usuario {

    private int idUsuario;
    private String nome, senha, cpf, funcao;

    public Usuario() {

    }
    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(int idUsuario, String nome, String senha, String cpf, String funcao) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.funcao = funcao;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nome=" + nome + ", senha=" + senha + ", cpf=" + cpf + ", funcao=" + funcao + '}';
    }
    
}
