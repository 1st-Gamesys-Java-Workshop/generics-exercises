package com.gamesys.exercises.generics.with;

public class PairUtils {

    public static <T, S> boolean equals(Pair<T, S> pair1, Pair<T, S> pair2) {
        if (pair1 == null || pair2 == null ||
                pair1.getLeft() == null || pair1.getRight() == null ||
                pair2.getLeft() == null || pair2.getRight() == null) {
            return false;
        }
        return pair1.getLeft().equals(pair2.getLeft()) && pair1.getRight().equals(pair2.getRight());
    }

}
