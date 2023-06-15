package com.example.model;

import com.example.model.myExceptions.IllegalAgeException;
import javafx.beans.property.SimpleDoubleProperty;

import java.time.LocalDate;

public class Agent extends Employe{
    private SimpleDoubleProperty _primeResponsabilite;
    //Constructor

    public Agent() {
        this._primeResponsabilite = new SimpleDoubleProperty(0);
    }

    public Agent(String _nom, LocalDate _dateNaisance, LocalDate _dateEmbauche, double _salaireBase, double _primeResponsabilite) throws IllegalAgeException {
        super(_nom, _dateNaisance, _dateEmbauche, _salaireBase);

        this._primeResponsabilite = new SimpleDoubleProperty(_primeResponsabilite);
    }
    //Getter & Setter

    public double get_primeResponsabilite() {
        return _primeResponsabilite.get();
    }

    public SimpleDoubleProperty _primeResponsabiliteProperty() {
        return _primeResponsabilite;
    }

    public void set_primeResponsabilite(double _primeResponsabilite) {
        this._primeResponsabilite.set(_primeResponsabilite);
    }

    @Override
    public double SalaireAPayer() {
        double TauxIR= 1.0-(double)IR.getIR(this.get_salaireBase()*12);
        return (this.get_salaireBase()+this.get_primeResponsabilite())*TauxIR;
    }

    @Override
    public String toString() {
        return String.format("Agent => %s \n\t\tSalaire Net:%.2f",super.toString(),this.SalaireAPayer());
    }
}
