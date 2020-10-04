package br.maua.json;

import br.maua.classes_dao.AnimeDAO;
import br.maua.classes_dao.MangaDAO;
import br.maua.model.Anime;
import br.maua.model.Manga;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por transformar o conteúdo retornado pela API em um formato JSON.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */
public class ArrayParser {

    /**
     *
     * @param json Conteúdo no formato JSON.
     * @return Retorna uma lista de Animes.
     */
    public List<Anime> parseJsonAnime(String json) {
        JSONObject retorno = new JSONObject(json);
        JSONArray animesJson = retorno.getJSONArray("results");
        List<Anime> animes = new ArrayList<>();
        AnimeDAO animeDAO = new AnimeDAO();

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

    /**
     *
     * @param json Conteúdo no formato JSON.
     * @return Retorna uma lista de Mangás.
     */
    public List<Manga> parseJsonManga(String json) {
        JSONObject retorno = new JSONObject(json);
        JSONArray mangasJson = retorno.getJSONArray("results");
        List<Manga> mangas = new ArrayList<>();
        MangaDAO mangaDAO = new MangaDAO();

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

        for (int i = 0; i < mangas.size(); i++)
            mangaDAO.create(mangas.get(i));

        return mangas;
    }
}
