package com.example.model;

import com.example.model.myExceptions.IllegalAgeException;
import javafx.beans.property.SimpleIntegerProperty;

import java.time.LocalDate;

public class Formateur extends Employe {
    private SimpleIntegerProperty _heureSup;
    private static int _remunerationHSup=70;

    //Constructors
    public Formateur() {
        super();
        this._heureSup = new SimpleIntegerProperty();
    }

    public Formateur(String _nom, LocalDate _dateNaisance, LocalDate _dateEmbauche, double _salaireBase, int _heureSup) throws IllegalAgeException {
        super(_nom, _dateNaisance, _dateEmbauche, _salaireBase);
        this._heureSup = new SimpleIntegerProperty(_heureSup);
    }
    //Getter & Setter


    public int get_heureSup() {
        return _heureSup.get();
    }

    public SimpleIntegerProperty _heureSupProperty() {
        return _heureSup;
    }

    public void set_heureSup(int _heureSup) {
        this._heureSup.set(_heureSup);
    }

    @Override
    public double SalaireAPayer() {
        int NBrHS = this.get_heureSup()<=30?this.get_heureSup():30;
        double TauxIR= 1.0- IR.getIR(this.get_salaireBase()*12);
        return (this.get_salaireBase()+this.get_heureSup()*_remunerationHSup)*TauxIR;
    }
    @Override
    public String toString() {
        return String.format("Formatteur => %s \n\t\tSalaire Net:%.2f",super.toString(),this.SalaireAPayer());
    }
}
