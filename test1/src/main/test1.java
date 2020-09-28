package main;

import main.Simulation.Room;

public class test1 {

    public static void main(String[] args) {
        Function func = new Function();
        System.out.println((func.sec(Math.PI/2)));
        System.out.println("LeftistHeap Test");
        LeftistHeap heap = new LeftistHeap();

        heap.insert(0);
        heap.insert(1);
        heap.insert(6);
        heap.insert(10);
        heap.insert(4);
        heap.insert(9);
        heap.insert(5);

        System.out.println(heap.printHeap());
        heap.deleteMin();
        System.out.println(heap.printHeap());
        System.out.println("Empty status = "+ heap.isEmpty());

        heap.clear();
        System.out.println("Empty status = "+ heap.isEmpty());

        System.out.println(heap.printHeap());

        Room s = new Room();
    }

}
