package com.exercise.aucta_exercise.model.exceptions;

public class InvalidMovieIdException extends  RuntimeException{
    public InvalidMovieIdException() {
       super("Invalid Movie ID Exception");
    }
}
