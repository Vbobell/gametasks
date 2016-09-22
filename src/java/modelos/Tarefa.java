/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.time.LocalDate;

/**
 *
 * @author vinic
 */
public class Tarefa {

    private int idTarefa;
    private String titulo, descricao, status;
    private int valor;
    private LocalDate dataInicio, dataLimite;

    public Tarefa() {

    }

    public Tarefa(int idTarefa, String titulo, String descricao,LocalDate dataInicio, LocalDate dataLimite) {
        this.idTarefa = idTarefa;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataLimite = dataLimite;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public int getValor() {
        return valor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

}
