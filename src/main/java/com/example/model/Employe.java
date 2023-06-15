package com.example.model;

import com.example.model.myExceptions.IllegalAgeException;
import com.example.model.myExceptions.Under16AgeException;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Employe implements IEmploye,Comparable<Employe>{
    private static int ctr;
    protected SimpleIntegerProperty _mtle;
    protected SimpleStringProperty _nom;
    protected ObjectProperty<LocalDate> _dateNaisance;
    protected ObjectProperty<LocalDate> _dateEmbauche;
    protected SimpleDoubleProperty _salaireBase;
    protected final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //Constructor

    public Employe() {
        ctr++;
        _mtle=new SimpleIntegerProperty(ctr);
        _nom=new SimpleStringProperty();
        _dateNaisance=new SimpleObjectProperty<>();
        _dateEmbauche=new SimpleObjectProperty<>();
        _salaireBase=new SimpleDoubleProperty(0);
    }

    public Employe(String _nom, LocalDate _dateNaisance, LocalDate _dateEmbauche, double _salaireBase) throws IllegalAgeException {
        this();
        this._nom.set(_nom);
        this.set_dateNaisance(_dateNaisance);
        this.set_dateEmbauche(_dateEmbauche);
        this._salaireBase.set(_salaireBase);
    }

    //Getter & Setter
    public int get_mtle() {
        return _mtle.get();
    }

    public SimpleIntegerProperty _mtleProperty() {
        return _mtle;
    }

    public void set_mtle(int _mtle) {
        this._mtle.set(_mtle);
    }

    public String get_nom() {
        return _nom.get();
    }

    public SimpleStringProperty _nomProperty() {
        return _nom;
    }

    public void set_nom(String _nom) {
        this._nom.set(_nom);
    }

    public LocalDate get_dateNaisance() {
        return _dateNaisance.get();
    }

    public ObjectProperty<LocalDate> _dateNaisanceProperty() {
        return _dateNaisance;
    }

    public void set_dateNaisance(LocalDate _dateNaisance) throws IllegalAgeException {
        if(_dateNaisance.isAfter(LocalDate.now()))
            throw new IllegalAgeException("La date de naissance ne doit pas depasser la date d'aujourdhui");
        if(this._dateEmbauche.get()!=null)
            verifyAgeUnder16y(_dateNaisance,this._dateEmbauche.get());
        this._dateNaisance.set(_dateNaisance);
    }

    public LocalDate get_dateEmbauche() {

        return _dateEmbauche.get();
    }

    public ObjectProperty<LocalDate> _dateEmbaucheProperty() {
        return _dateEmbauche;
    }

    public void set_dateEmbauche(LocalDate _dateEmbauche) throws Under16AgeException {
        if(this._dateNaisance.get()!=null)
            verifyAgeUnder16y(this._dateNaisance.get(),_dateEmbauche);
        this._dateEmbauche.set(_dateEmbauche);
    }

    public double get_salaireBase() {
        return _salaireBase.get();
    }

    public SimpleDoubleProperty _salaireBaseProperty() {
        return _salaireBase;
    }

    public void set_salaireBase(double _salaireBase) {
        this._salaireBase.set(_salaireBase);
    }
    //Methodes
    private void verifyAgeUnder16y(LocalDate dateNaissance,LocalDate dateEmbauche) throws Under16AgeException {
        Period period = Period.between(dateNaissance,dateEmbauche);
        if(period.getYears()<16)
           throw new Under16AgeException();
    }

    public abstract double SalaireAPayer();

    @Override
    public int compareTo(Employe employe) {
        return this.get_nom().compareTo(employe.get_nom());
    }

    @Override
    public int Age() {
        Period period = Period.between(this.get_dateNaisance(),LocalDate.now());
        return period.getYears();
    }

    @Override
    public int Anciennte() {
        Period period = Period.between(this.get_dateEmbauche(),LocalDate.now());
        return period.getYears();
    }

    @Override
    public LocalDate DateRetraite(int ageRetraite) {
        return this.get_dateEmbauche().plusYears(ageRetraite);
    }

    @Override
    public String toString() {
        return String.format("%s Age:%s ans\t %s %s [Anciennte : %s ,Retraite : %s]  %.2f DH Annuel : %.2f"
                ,this.get_nom()
                ,this.Age()
                ,FORMATTER.format(this.get_dateNaisance())
                ,FORMATTER.format(this.get_dateEmbauche())
                ,this.Anciennte()
                ,FORMATTER.format(this.DateRetraite(65))
                ,_salaireBase.get()
                ,_salaireBase.get()*12
        );
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employe){
            Employe emp = (Employe) obj;
            return emp.get_mtle()==this.get_mtle();
        }
        return false;
    }
}
