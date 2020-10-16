package edu.mccneb;
import java.util.Random;
public class Die {
    private int value;
    public Die(){
        value=0;
    }
    public void Roll()
    {
        Random r = new Random();
        value = r.nextInt(6)+1;
    }
    public int getValue(){return value;}
}
