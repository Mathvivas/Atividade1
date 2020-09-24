package br.maua.json;

import br.maua.model.Anime;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArrayParser {

    public List<Anime> parseJson(String json) {
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
}
