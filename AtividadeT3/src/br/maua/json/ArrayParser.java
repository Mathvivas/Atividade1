package br.maua.json;

import br.maua.model.Anime;
import br.maua.model.Manga;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArrayParser {

    public List<Anime> parseJsonAnime(String json) {
        JSONObject retorno = new JSONObject(json);
        JSONArray animesJson = retorno.getJSONArray("results");
        List<Anime> animes = new ArrayList<>();

        for (Object anime: animesJson) {
            animes.add(new Anime(
                    ((JSONObject)anime).getString("title"),
                    ((JSONObject)anime).getString("image_url"),
                    ((JSONObject)anime).getString("synopsis"),
                    ((JSONObject)anime).getInt("episodes"),
                    ((JSONObject)anime).getInt("score")));
        }
        return animes;
    }

    public List<Manga> parseJsonManga(String json) {
        JSONObject retorno = new JSONObject(json);
        JSONArray mangasJson = retorno.getJSONArray("results");
        List<Manga> mangas = new ArrayList<>();

        for (Object manga: mangasJson) {
            mangas.add(new Manga(
                    ((JSONObject)manga).getString("title"),
                    ((JSONObject)manga).getString("image_url"),
                    ((JSONObject)manga).getString("synopsis"),
                    ((JSONObject)manga).getInt("chapters"),
                    ((JSONObject)manga).getInt("volumes"),
                    ((JSONObject)manga).getString("type"),
                    ((JSONObject)manga).getInt("score")));
        }
        return mangas;
    }
}
