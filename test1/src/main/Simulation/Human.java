package main.Simulation;

public class Human {
    String name, action;
    boolean alive;
    Rodent rodent;
    int x,y;
    public Human(String name, boolean alive, Rodent rodent, String action, int x, int y){
        this.name = name;
        this.action = action;
        this.alive = alive;
        this.rodent = rodent; // if == null means this human is normal, else he is hypnotized
        this.x = x;
        this.y = y;
    }

    void setName(String name){
        this.name = name;
    }

    void setAlive(boolean alive){
        this.alive = alive;
    }

    void setAction(String action){
        this.action = action;
    }

    void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    void setRodent(Rodent r){
        this.rodent = r;
    }

    public Rodent getRodent(){
        return this.rodent;
    }

    void isHypnotized(Rodent rodent){
        this.rodent = rodent;
        //System.out.print("!!! " + this.name + " is hypnotized by rodent #"+ rodent.id +
          //      ". Attack the rodent to get him back to normal.\n");
    }

    public boolean attack(Rodent r){
        System.out.print(this.name + " is trying to attack #" + r.id + "\n");
        if (distance(r)<=10){
            if (rodent == null) {
                r.kill();
                return true;
            }
            else System.out.print("!!! "+ this.name + " is hypnotized. Can not attack the rodent\n");
        }
        else System.out.print("!!! "+ this.name + " is too far (distance > 10). Failed to attack the rodent\n");

        return false;
    }

    void doneHypnotized(){
        this.rodent = null;
        System.out.print(this.name + " is no longer hypnotized. He is normal now.\n");
    }

    public void move(int delX, int delY){
        this.x += delX;
        this.y += delY;
        System.out.print(this.name + " is now at (" + x + ", " + y + ")\n");
    }

    double distance(Human h){
        int x = this.x - h.x;
        int y = this.x - h.y;
        return Math.sqrt(x*x+y*y);
    }

    double distance(Rodent r){
        int x = this.x - r.x;
        int y = this.x - r.y;
        return Math.sqrt(x*x+y*y);
    }

    void kill(){
        this.alive = false;
        System.out.print( this.name +" is died\n");
    }

    public void printToString(){
        if (alive == false) System.out.print(this.name + " is died\n"); else{
            if (rodent == null) {
                if (action == null) System.out.print(this.name + " is doing nothing at (" + x + ", " + y + ")\n");
                    else System.out.print(this.name + " is " + action + " at (" + x + ", " + y + ")\n");
            } else System.out.print(this.name + " is hypnotized by #" + this.rodent.id +" at (" + x + ", " + y + ")\n");

        }

    }
}
