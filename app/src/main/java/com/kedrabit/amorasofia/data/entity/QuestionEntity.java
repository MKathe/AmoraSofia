package com.kedrabit.amorasofia.data.entity;

import java.io.Serializable;

/**
 * Created by katherine on 20/05/17.
 */

public class QuestionEntity implements Serializable {
    private int id;
    private String usuario;
    private String curso;
    private String pgta_texto;
    private String pgta_img;
    private RespuestaEntity respuesta;
    private boolean estado;

    public QuestionEntity(int id, String usuario, String curso,
                          String pgta_texto, String pgta_img,
                          RespuestaEntity respuesta, boolean estado) {
        this.id = id;
        this.usuario = usuario;
        this.curso = curso;
        this.pgta_texto = pgta_texto;
        this.pgta_img = pgta_img;
        this.respuesta = respuesta;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPgta_texto() {
        return pgta_texto;
    }

    public void setPgta_texto(String pgta_texto) {
        this.pgta_texto = pgta_texto;
    }

    public String getPgta_img() {
        return pgta_img;
    }

    public void setPgta_img(String pgta_img) {
        this.pgta_img = pgta_img;
    }

    public RespuestaEntity getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaEntity respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
