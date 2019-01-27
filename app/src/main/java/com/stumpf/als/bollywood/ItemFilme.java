package com.stumpf.als.bollywood;
import android.net.Uri;

import java.io.Serializable;

public class ItemFilme implements Serializable {
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Uri getImagem() {
        return imagem;
    }
    public void setImagem(Uri imagem) {
        this.imagem = imagem;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public float getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }
    public ItemFilme(String titulo, String descricao, String data, float avaliacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.avaliacao = avaliacao;
    }
    private String id;
    private Uri imagem;
    private String titulo;
    private String descricao;
    private String data;
    private float avaliacao;
}