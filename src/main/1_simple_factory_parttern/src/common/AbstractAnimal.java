package common;

import com.sun.org.apache.bcel.internal.generic.NEW;

public abstract class AbstractAnimal{
    private String voice;

   public AbstractAnimal(){}

   public AbstractAnimal(String voice){
       this.voice = voice;
   }

    public void call(){
        System.out.println(voice);
    }
}
