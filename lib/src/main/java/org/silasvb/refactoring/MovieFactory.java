package org.silasvb.refactoring;

public class MovieFactory {

    public static Movie createNewRelease(String title) {
        return new NewRelease(title);
    }

    public static Movie createChildrensMovie(String title) {
        return new ChildrensMovie(title);
    }

    public static Movie createRegularMovie(String title) {
        return new RegularMovie(title);
    }

}
