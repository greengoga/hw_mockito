package ru.netology.hw_mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void shouldAddMovie() {
        MovieManager manager = new MovieManager();
        MovieList movie = new MovieList(1 ,101, "Бладшот", "Боевик");

        manager.add(movie);

        MovieList[] expected = {movie};
        MovieList[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMultipleMovies() {
        MovieManager manager = new MovieManager();
        MovieList movie1 = new MovieList(1 ,101, "Бладшот", "боевик");
        MovieList movie2 = new MovieList(2 ,102, "Вперёд", "мультфильм");
        MovieList movie3 = new MovieList(3 ,103, "Отель \"Белград", "комедия");
        MovieList movie4 = new MovieList(4 ,104, "Джентельмены", "боевик");
        MovieList movie5 = new MovieList(5 ,105, "Человек-невидимка", "ужасы");
        MovieList movie6 = new MovieList(6 ,106, "Тролли. Мировой тур", "мультфильм");
        MovieList movie7 = new MovieList(7 ,107, "Номер один", "комедия");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);



        MovieList[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        MovieList[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ShouldFindLastWithLimit() {
        MovieManager manager = new MovieManager(2);
        MovieList movie1 = new MovieList(1 ,101, "Бладшот", "боевик");
        MovieList movie2 = new MovieList(2 ,102, "Вперёд", "мультфильм");
        MovieList movie3 = new MovieList(3 ,103, "Отель \"Белград\"", "комедия");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        MovieList[] expected = {movie3, movie2};
        MovieList[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyIfNoMovies() {
        MovieManager manager = new MovieManager();
        MovieList[] expected = {};
        MovieList[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
