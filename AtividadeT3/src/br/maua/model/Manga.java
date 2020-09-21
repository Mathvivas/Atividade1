package br.maua.model;

public class Manga {
    private String nome;
    private String url;
    private String sinopse;
    private int capitulos;
    private int volumes;
    private String tipo;
    private double nota;

    public Manga(String nome, String url, String sinopse, int capitulos, int volumes, String tipo, double nota) {
        this.nome = nome;
        this.url = url;
        this.sinopse = sinopse;
        this.capitulos = capitulos;
        this.volumes = volumes;
        this.tipo = tipo;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public int getVolumes() {
        return volumes;
    }

    public String getTipo() {
        return tipo;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Manga {" +
                "nome = '" + nome + '\'' +
                ", url = '" + url + '\'' +
                ", sinopse = '" + sinopse + '\'' +
                ", capitulos = " + capitulos +
                ", volumes = " + volumes +
                ", tipo = '" + tipo + '\'' +
                ", nota = " + nota +
                '}';
    }
}
