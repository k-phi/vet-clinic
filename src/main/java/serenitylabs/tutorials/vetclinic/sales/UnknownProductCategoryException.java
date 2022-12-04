package serenitylabs.tutorials.vetclinic.sales;

public class UnknownProductCategoryException extends RuntimeException {
    public UnknownProductCategoryException(String message) {
        super(message);
    }
}
