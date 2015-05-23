package com.mcms.study.spring.batch.job.exception;

public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -8891586863405512406L;
    public static final String EXCEPTION_DEF_ITEMS = "3";
    public static final String EXCEPTION_ITEMS_KEY = "errot.item";

    public static String initErrorItem() {
        return System.setProperty(EXCEPTION_ITEMS_KEY, EXCEPTION_DEF_ITEMS);
    }

    public static String setErrorItem(String errorItems) {
        return System.setProperty(EXCEPTION_ITEMS_KEY, errorItems);
    }

    public static String getErrorItem() {
        return System.getProperty(EXCEPTION_ITEMS_KEY, EXCEPTION_DEF_ITEMS);
    }

}
