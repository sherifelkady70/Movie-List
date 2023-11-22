package com.example.movie;

import java.util.List;

/*data class Movies(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)*/
public class Movies {
    private int page;
    private List<Result> results;
    private int total_pages;
    private int total_results;

    public int getPage() {
        return page;
    }

    public List<Result> getResults() {
        return results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
