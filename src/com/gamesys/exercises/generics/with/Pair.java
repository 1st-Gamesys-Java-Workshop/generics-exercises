package com.gamesys.exercises.generics.with;

public class Pair<T, S> {

    private T left;
    private S right;

    public Pair(T left, S right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public S getRight() {
        return right;
    }
}
