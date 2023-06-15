package com.example.model.myExceptions;

public class Under16AgeException extends IllegalAgeException {
    public Under16AgeException() {
        super("L'âge de l'employé à la date de recrutement ne doit pas être inférieur à 16ans");
    }
}
