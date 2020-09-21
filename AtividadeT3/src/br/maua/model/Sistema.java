package br.maua.model;

import br.maua.classes_dao.AnimeDAO;
import br.maua.classes_dao.MangaDAO;

import java.util.List;
import java.util.Scanner;

public class Sistema {
    private List<Anime> animes;
    private List<Manga> mangas;
    private AnimeDAO animeDAO;
    private MangaDAO mangaDAO;
    private Scanner scanner;

    public void run() {
        boolean on = true;

        do {
            menu();
            System.out.println("\nO que deseja?: ");
            int op = scanner.nextInt();

            switch (op) {
                case 1:

                case 0:
                    on = false;
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        } while (on);
    }


    public void menu() {
        System.out.println("\n|_________| MENU |_________");
        System.out.println("| 1 - Procurar um Anime");
        System.out.println("| 2 - Procurar um Mangá");
        System.out.println("| 0 - Sair");
        System.out.println("|__________________________");
    }

    public void exibirAnime() {
        animes = animeDAO.getAll();
        System.out.println("Anime: ");
        animes.forEach(anime -> System.out.println(anime));
    }

    public void exibirManga() {
        mangas = mangaDAO.getAll();
        System.out.println("Manga: ");
        mangas.forEach(manga -> System.out.println(manga));
    }
}
