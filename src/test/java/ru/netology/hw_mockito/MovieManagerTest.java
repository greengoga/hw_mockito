package ru.netology.hw_mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void shouldAddMovie() {
        MovieManager manager = new MovieManager();
        Movie movie = new Movie(1 ,101, "Бладшот", "Боевик");

        manager.add(movie);

        Movie[] expected = {movie};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMultipleMovies() {
        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie(1 ,101, "Бладшот", "боевик");
        Movie movie2 = new Movie(2 ,102, "Вперёд", "мультфильм");
        Movie movie3 = new Movie(3 ,103, "Отель \"Белград\"", "комедия");
        Movie movie4 = new Movie(4 ,104, "Джентельмены", "боевик");
        Movie movie5 = new Movie(5 ,105, "Человек-невидимка", "ужасы");
        Movie movie6 = new Movie(6 ,106, "Тролли. Мировой тур", "мультфильм");
        Movie movie7 = new Movie(7 ,107, "Номер один", "комедия");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindLastWithLimit() {
        MovieManager manager = new MovieManager(2);
        Movie movie1 = new Movie(1 ,101, "Бладшот", "боевик");
        Movie movie2 = new Movie(2 ,102, "Вперёд", "мультфильм");
        Movie movie3 = new Movie(3 ,103, "Отель \"Белград\"", "комедия");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] expected = {movie3, movie2};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyIfNoMovies() {
        MovieManager manager = new MovieManager();
        Movie[] expected = {};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindLastWithLessThanLimit() {
        MovieManager manager = new MovieManager(3);
        Movie movie2 = new Movie(2 ,102, "Вперёд", "мультфильм");
        Movie movie3 = new Movie(3 ,103, "Отель \"Белград\"", "комедия");

        //manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] expected = {movie3, movie2};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindLastWithOverLimit() {
        MovieManager manager = new MovieManager(2);
        Movie movie1 = new Movie(1 ,101, "Бладшот", "боевик");
        Movie movie2 = new Movie(2 ,102, "Вперёд", "мультфильм");
        Movie movie3 = new Movie(3 ,103, "Отель \"Белград\"", "комедия");
        Movie movie4 = new Movie(4 ,104, "Джентельмены", "боевик");
        Movie movie5 = new Movie(5 ,105, "Человек-невидимка", "ужасы");
        Movie movie6 = new Movie(6 ,106, "Тролли. Мировой тур", "мультфильм");
        Movie movie7 = new Movie(7 ,107, "Номер один", "комедия");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        Movie[] expected = {movie7, movie6};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindLastWithExactLimit() {
        MovieManager manager = new MovieManager(7);
        Movie movie1 = new Movie(1 ,101, "Бладшот", "боевик");
        Movie movie2 = new Movie(2 ,102, "Вперёд", "мультфильм");
        Movie movie3 = new Movie(3 ,103, "Отель \"Белград\"", "комедия");
        Movie movie4 = new Movie(4 ,104, "Джентельмены", "боевик");
        Movie movie5 = new Movie(5 ,105, "Человек-невидимка", "ужасы");
        Movie movie6 = new Movie(6 ,106, "Тролли. Мировой тур", "мультфильм");
        Movie movie7 = new Movie(7 ,107, "Номер один", "комедия");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        Movie[] expected = {movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyForFindAll() {
        MovieManager manager = new MovieManager();
        Movie[] expected = {};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldReturnLastWithLimit1() {
        MovieManager manager = new MovieManager(1);
        Movie movie1 = new Movie(1 ,101, "Бладшот", "боевик");
        Movie movie2 = new Movie(2 ,102, "Вперёд", "мультфильм");
        Movie movie3 = new Movie(3 ,103, "Отель \"Белград\"", "комедия");
        Movie movie4 = new Movie(4 ,104, "Джентельмены", "боевик");
        Movie movie5 = new Movie(5 ,105, "Человек-невидимка", "ужасы");
        Movie movie6 = new Movie(6 ,106, "Тролли. Мировой тур", "мультфильм");
        Movie movie7 = new Movie(7 ,107, "Номер один", "комедия");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        Movie[] expected = {movie7};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldReturnEmptyWithRandomLimit() {
        MovieManager manager = new MovieManager(42);

        Movie[] expected = {};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldHandleDuplicateMovies() {
        MovieManager manager = new MovieManager(3);
        Movie movie1 = new Movie(1, 101, "Бладшот", "боевик");
        Movie movie2 = new Movie(2, 102, "Бладшот", "боевик");

        manager.add(movie1);
        manager.add(movie2);

        Movie[] expected = {movie2, movie1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldHandleMovieWithEmptyName() {
        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie(1, 101, "", "боевик");

        manager.add(movie1);

        Movie[] expected = {movie1};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldHandleMovieWithNullGenre() {
        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie(1, 101, "Бладшот", null);

        manager.add(movie1);

        Movie[] expected = {movie1};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}