package com.stumpf.als.bollywood;
import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
public class ItemFilme implements Serializable {
    private long id;
    private String titulo;
    private String descricao;
    private String data;
    private String posterPath;
    private String capaPath;
    private float avaliacao;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public String getPosterPath() {
        return buildPath("w500", posterPath);
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
    public String getCapaPath() {
        return buildPath("w780", capaPath);
    }
    public void setCapaPath(String capaPath) {
        this.capaPath = capaPath;
    }
    public float getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }
    public ItemFilme(long id, String titulo, String descricao, String data, String posterPath, String capaPath, float avaliacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.posterPath = posterPath;
        this.capaPath = capaPath;
        this.avaliacao = avaliacao;
    }
    public ItemFilme(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getLong("id");
        this.titulo = jsonObject.getString("title");
        this.descricao = jsonObject.getString("overview");
        this.data = jsonObject.getString("release_date");
        this.posterPath = jsonObject.getString("poster_path");
        this.capaPath = jsonObject.getString("backdrop_path");
        this.avaliacao = (float) jsonObject.getDouble("vote_average");
    }
    private String buildPath(String width, String path){
        StringBuilder builder = new StringBuilder();
        builder.append("http://image.tmdb.org/t/p/")
                .append(width)
                .append(path);
        return builder.toString();
    }
    /*metodo para implementar uma API*/
    /*public String getId() {
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
    }*/
}