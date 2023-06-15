package com.example.model;

import java.time.LocalDate;

public interface IEmploye {
    int Age();
    int Anciennte();
    LocalDate DateRetraite(int ageRetraite);
}
