package main.Simulation;

public class Rodent {
    int id;
    Human victim;
    int x,y;
    boolean alive;

    public Rodent(int id, boolean alive, Human victim, int x, int y){
        this.id = id;
        this.alive = alive;
        if (victim == null) this.victim = null;
        else
            if (victim.rodent == null){
                this.victim = victim;
                startHypnotize(victim);
            } else{
                System.out.print("#" + this.id + " if failed."
                        + victim.name + " has already been hypnotized by #" + victim.rodent.id + "\n");
            }
        this.x = x;
        this.y = y;
    }

    void setId(int id){
        this.id = id;
    }

    void setAlive(boolean alive){
        this.alive = alive;
    }

    public boolean getAlive(){
        return this.alive;
    }

    void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    void setVictim(Human h){
        this.victim = h;
    }

    public void printToString(){
        System.out.print("Rodent #" + this.id + " is at (" + this.x + ";" + this.y + ")");
        if (victim != null) System.out.print(" and hypnotized " + victim.name + ".");
        System.out.print("\n");
    }

    void startHypnotize(Human h){
        this.victim = h;
        this.victim.isHypnotized(this);
    }

    public void stopHypnotize(){
        this.victim.doneHypnotized();
        this.victim = null;
    }

    void move(int delX, int delY){
        this.x += delX;
        this.y += delY;
        System.out.print(this.id + " is now at (" + x + ", " + y + ")\n");
    }

    void kill(){
        this.alive = false;
        System.out.print("Rodent #" + this.id + " is died\n");
        stopHypnotize();
    }
}
