package main.Simulation;

import java.util.*;

public class Room {
    Door door = new Door(0,0, false);
    public List<Human> human = new ArrayList<>();
    public List<Rodent> rodent = new ArrayList<>();

    public Room(){
        System.out.print("The room is created.\n");
    }

    public void addHuman(Human h){
        human.add(h);
    }

    public int getNumHuman(){
        return human.size();
    }

    public int getNumRodent(){
        return rodent.size();
    }

    public void removeHuman(Human h){
        human.remove(h);
    }

    public void addRodent(Rodent r){
        rodent.add(r);
    }

    public boolean checkDoorOpen(){
        return door.isOpen;
    }

    public void removeRodent(Rodent r){
        rodent.remove(r);
    }

    public void printHuman(){
        human.forEach(h -> h.printToString());
    }

    public void printRodent(){
        rodent.forEach(r -> r.printToString());
    }

    public void printAll(){
        System.out.print("There are "+ human.size() + " human and " + rodent.size() + "rodents in this room");
        printHuman();
        printRodent();
    }
}
