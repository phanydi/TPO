package test;

import main.Simulation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationTest {


    @Test
    void createRoom(){
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        Room r = new Room();
        Human Arthur = new Human("Athur", true, null, null, 10,10);
        Human Trillian = new Human("Trillian", true, null, "pulling Arthur", 9,8);
        Human Ford = new Human("Ford", true, null, "trying to open the door", 0,1);
        Human Zaphod = new Human("Zaphod ", true, null, "trying to open the door", 1,0);
        Rodent rod1 = new Rodent(1, true, Arthur, 12, 13);
        r.addHuman(Trillian);
        r.addHuman(Arthur);
        r.addHuman(Ford);
        r.addHuman(Zaphod);
        r.addRodent(rod1);
        //r.printAll();
        Assertions.assertEquals("The room is created.\n"
                , out.toString(), "Error while creating room");
        Assertions.assertEquals(4, r.human.size(), "Error while adding human into room");
        Assertions.assertEquals(1, r.rodent.size(), "Error while adding rodent into room");
    }

    @Test
    void createHuman(){
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        Human Trillian = new Human("Trillian", true, null, "pulling Arthur", 9,8);
        Trillian.printToString();
        Assertions.assertEquals("Trillian is pulling Arthur at (9, 8)\n"
                ,out.toString(), "Error while creating human");
    }

    @Test
    void createRodentWithoutVictim(){
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        Rodent rod1 = new Rodent(1, true, null, 12, 13);
        rod1.printToString();
        Assertions.assertEquals("Rodent #1 is at (12;13)\n"
                ,out.toString(), "Error while creating rodent");
    }

    @Test
    void createRodentWithVictim(){
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        Human Arthur = new Human("Athur", true, null, null, 10,10);
        Rodent rod1 = new Rodent(1, true, Arthur, 12, 13);
        rod1.printToString();
        Assertions.assertEquals("Rodent #1 is at (12;13) and hypnotized Athur.\n"
                ,out.toString(), "Error while creating rodent");
    }

    @Test
    void moveHuman(){
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        Human Trillian = new Human("Trillian", true, null, "pulling Arthur", 9,8);
        Trillian.move(-2,-3);
        Assertions.assertEquals("Trillian is now at (7, 5)\n"
                ,out.toString(), "Error while moving Trillian");
    }

    @Test
    void hypnotizing(){
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        Human Arthur = new Human("Athur", true, null, null, 10,10);
        Rodent rod1 = new Rodent(1, true, Arthur, 12, 13);
        Assertions.assertEquals(Arthur.getRodent(), rod1, "Error while creating rodent and hypnotize");
    }

    @Test
    void doneHypnotizing(){
        Human Arthur = new Human("Athur", true, null, null, 10,10);
        Rodent rod1 = new Rodent(1, true, Arthur, 12, 13);

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        rod1.stopHypnotize();

        Assertions.assertEquals("Athur is no longer hypnotized. He is normal now.\n"
                ,out.toString(), "Error while rodent stop hypnotizing");
    }

    @Test
    void attackDorentinRange(){
        Human Arthur = new Human("Athur", true, null, null, 10,10);
        Rodent rod1 = new Rodent(1, true, Arthur, 12, 13);
        Human Trillian = new Human("Trillian", true, null, "pulling Arthur", 9,8);

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        Assertions.assertTrue(Trillian.attack(rod1));
        Assertions.assertFalse(rod1.getAlive());
        Assertions.assertEquals(null, Arthur.getRodent(),
                "Error stopping Arthur from being hypnotized when rodent is died.\n");
    }

    @Test
    void attackDorentOutRange(){
        Human Arthur = new Human("Athur", true, null, null, 10,10);
        Rodent rod1 = new Rodent(1, true, Arthur, 12, 13);
        Human Zaphod = new Human("Zaphod ", true, null, "trying to open the door", 1,0);

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        Assertions.assertFalse(Zaphod.attack(rod1));
        Assertions.assertTrue(rod1.getAlive());
    }
}
