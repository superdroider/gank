package com.superdroid.data.entity;

/**
 * Created by Administrator on 2016/5/11.
 */
public class CommonResponseEntity<T> {

    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
