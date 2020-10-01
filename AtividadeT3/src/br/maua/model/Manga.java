package br.maua.model;

/**
 * Classe responsável pro representar o Mangá.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */
public class Manga {
    private String nome;
    private String url;
    private String sinopse;
    private int capitulos;
    private int volumes;
    private String tipo;
    private double nota;


    /**
     *
     * @param nome Nome do Mangá.
     * @param url Url da imagem do Mangá.
     * @param sinopse Sinópse do Mangá.
     * @param capitulos Número de capítulos do Mangá.
     * @param volumes Número de volumes do Mangá.
     * @param tipo Tipo do Mangá.
     * @param nota Nota do Mangá.
     */
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
