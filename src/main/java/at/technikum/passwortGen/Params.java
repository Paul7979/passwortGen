package at.technikum.passwortGen;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Params {

    private int amount;

    private char[] alphabet;

    private int length;

    public Params(int amount, char[] alphabet, int length) {
        this.amount = amount;
        this.alphabet = alphabet;
        this.length = length;
    }

    public Params() {
    }



    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
