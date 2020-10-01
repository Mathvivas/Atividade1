package br.maua.model;

/**
 * Classe responsável por representar o Anime.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */
public class Anime {
    private String nome;
    private String url;
    private String sinopse;
    private int episodios;
    private double nota;

    /**
     *
     * @param nome Nome do Anime.
     * @param url Url da imagem do Anime.
     * @param sinopse Sinópse do Anime.
     * @param episodios Quantidade de episódios do Anime.
     * @param nota Nota do Anime.
     */
    public Anime(String nome, String url, String sinopse, int episodios, double nota) {
        this.nome = nome;
        this.url = url;
        this.sinopse = sinopse;
        this.episodios = episodios;
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

    public int getEpisodios() {
        return episodios;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Anime {" +
                "nome = '" + nome + '\'' +
                ", url = '" + url + '\'' +
                ", sinopse = '" + sinopse + '\'' +
                ", episodios = " + episodios +
                ", nota = " + nota +
                '}';
    }
}
