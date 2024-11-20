package ru.netology.hw_mockito;

public class MovieManager {
    private MovieList[] items = new MovieList[0];
    private int limit;

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void add(MovieList item) {
        MovieList[] tmp = new MovieList[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public MovieList[] findAll() {
        return items;
    }

    public MovieList[] findLast() {
        int resultLength = Math.min(items.length, limit);
        MovieList[] result = new MovieList[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = items[items.length - 1 - i];
        }
        return result;
    }
}