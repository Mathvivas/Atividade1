package br.maua.model;

import br.maua.api.API;
import br.maua.classes_dao.AnimeDAO;
import br.maua.classes_dao.MangaDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelo sistema principal do programa. Ela é quem interage com o usuário.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */
public class Sistema {
    private List<Anime> animes;
    private List<Manga> mangas;
    private AnimeDAO animeDAO;
    private MangaDAO mangaDAO;
    private Scanner scanner;
    private API api;

    /**
     * Construtor da Classe.
     */
    public Sistema() {
        animes = new ArrayList<>();
        mangas = new ArrayList<>();
        animeDAO = new AnimeDAO();
        mangaDAO = new MangaDAO();
        api = new API();
        scanner = new Scanner(System.in);
    }

    /**
     * Método responsável por rodar o programa.
     */
    public void run() {
        boolean on = true;

        do {
            menu();
            System.out.println("\nO que deseja?: ");
            int op = Integer.parseInt(scanner.next());

            switch (op) {
                case 1:
                    procurarAnime();
                    break;
                case 2:
                    cadastrarAnime();
                    break;
                case 3:
                    procurarManga();
                    break;
                case 4:
                    cadastrarManga();
                    break;
                case 0:
                    on = false;
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        } while (on);
    }


    /**
     * Método responsável pelo menu de opções do usuário.
     */
    public void menu() {
        System.out.println("\n|_________| MENU |_________|");
        System.out.println("| 1 - Procurar um Anime");
        System.out.println("| 2 - Cadastrar um Anime");
        System.out.println("| 3 - Procurar um Mangá");
        System.out.println("| 3 - Cadastrar um Mangá");
        System.out.println("| 0 - Sair");
        System.out.println("|__________________________|");
    }

    /**
     * Método responsável por exibir as características do Anime.
     */
    public void exibirAnime() {
        animes = animeDAO.getAll();
        System.out.println("Anime: ");
        animes.forEach(anime -> System.out.println(anime));
    }

    /**
     * Método responsável por exibir as características do Mangá.
     */
    public void exibirManga() {
        mangas = mangaDAO.getAll();
        System.out.println("Manga: ");
        mangas.forEach(manga -> System.out.println(manga));
    }

    /**
     * Método responsável por procurar o Anime desejado no Banco de Dados.
     */
    public void procurarAnime() {
        exibirAnime();
    }

    public void cadastrarAnime() {
        System.out.println("\nDigite o nome do Anime desejado: ");
        String nome = scanner.next();
        try {
            api.leituraAPIAnime(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método responsável por procurar o Mangá desejado no Banco de Dados.
     */
    public void procurarManga() {

    }

    public void cadastrarManga() {
        System.out.println("\nDigite o nome do Mangá desejado: ");
        String nome = scanner.next();
        try {
            api.leituraAPIManga(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

