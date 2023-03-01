package cdc.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private String nameOrig;
    private double oldbalanceOrig;
    private double newbalanceOrig;
    private String nameDest;
    private double oldbalanceDest;
    private double newbalanceDest;

    public Transaction() {
    }

    public Transaction( double amount, String nameOrig, double oldbalanceOrig, double newbalanceOrig, String nameDest, double oldbalanceDest, double newbalanceDest) {
        this.amount = amount;
        this.nameOrig = nameOrig;
        this.oldbalanceOrig = oldbalanceOrig;
        this.newbalanceOrig = newbalanceOrig;
        this.nameDest = nameDest;
        this.oldbalanceDest = oldbalanceDest;
        this.newbalanceDest = newbalanceDest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNameOrig() {
        return nameOrig;
    }

    public void setNameOrig(String nameOrig) {
        this.nameOrig = nameOrig;
    }

    public double getOldbalanceOrig() {
        return oldbalanceOrig;
    }

    public void setOldbalanceOrig(double oldbalanceOrig) {
        this.oldbalanceOrig = oldbalanceOrig;
    }

    public double getNewbalanceOrig() {
        return newbalanceOrig;
    }

    public void setNewbalanceOrig(double newbalanceOrig) {
        this.newbalanceOrig = newbalanceOrig;
    }

    public String getNameDest() {
        return nameDest;
    }

    public void setNameDest(String nameDest) {
        this.nameDest = nameDest;
    }

    public double getOldbalanceDest() {
        return oldbalanceDest;
    }

    public void setOldbalanceDest(double oldbalanceDest) {
        this.oldbalanceDest = oldbalanceDest;
    }

    public double getNewbalanceDest() {
        return newbalanceDest;
    }

    public void setNewbalanceDest(double newbalanceDest) {
        this.newbalanceDest = newbalanceDest;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", nameOrig='" + nameOrig + '\'' +
                ", oldbalanceOrig=" + oldbalanceOrig +
                ", newbalanceOrig=" + newbalanceOrig +
                ", nameDest='" + nameDest + '\'' +
                ", oldbalanceDest=" + oldbalanceDest +
                ", newbalanceDest=" + newbalanceDest +
                '}';
    }
}