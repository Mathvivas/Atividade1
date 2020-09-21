package br.maua.json;

import br.maua.model.Anime;
import br.maua.model.Manga;
import org.json.JSONObject;

public class ObjectParser {

    public static JSONObject toJson(Anime anime) {
        JSONObject json = new JSONObject();

        json.put("Nome", anime.getNome());
        json.put("url", anime.getUrl());
        json.put("Sinópse", anime.getSinopse());
        json.put("Episódios", anime.getEpisodios());
        json.put("Nota", anime.getNota());
        return json;
    }

    public static JSONObject toJson(Manga manga) {
        JSONObject json = new JSONObject();

        json.put("Nome", manga.getNome());
        json.put("url", manga.getUrl());
        json.put("Sinópse", manga.getSinopse());
        json.put("Capítulos", manga.getCapitulos());
        json.put("Volumes", manga.getVolumes());
        json.put("Tipo", manga.getTipo());
        json.put("Nota", manga.getNota());
        return json;
    }
}
