package main.Simulation;

public class Door {
    int x,y;
    boolean isOpen;
    public Door(int x, int y, boolean isOpen){
        this.x = x;
        this.y = y;
        this.isOpen = isOpen;
    }

    void open(){
        this.isOpen = true;
    }

    void close(){
        this.isOpen = false;
    }
}
