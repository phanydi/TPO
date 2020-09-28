package test;

import main.LeftistHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LHTest {
    LeftistHeap heap = new LeftistHeap();

    void initHeap1(){
        heap.insert(0);
        heap.insert(1);
        heap.insert(6);
        heap.insert(10);
        heap.insert(4);
        heap.insert(9);
        heap.insert(5);
    }

    void initHeap2(){
        heap.insert(1);
        heap.insert(9);
        heap.insert(8);
        heap.insert(2);
        heap.insert(5);
        heap.insert(4);
        heap.insert(6);
        heap.insert(3);
        heap.insert(7);
        heap.insert(10);
        heap.insert(0);
    }

    @Test
    void insertNode1(){
        initHeap1();
        Assertions.assertEquals("10 6 4 9 0 5 1 ", heap.printHeap(), "Error while creating heap 1");
    }

    @Test
    void insertNode2(){
        initHeap2();
        Assertions.assertEquals("8 2 5 1 9 4 6 3 10 7 0 ", heap.printHeap(), "Error while creating heap 2");
    }

    @Test
    void deleteMin1(){
        initHeap1();
        heap.deleteMin();
        Assertions.assertEquals("10 6 4 9 1 5 ", heap.printHeap(), "Error delete min from heap 1");
    }

    @Test
    void deleteMin2(){
        initHeap2();
        heap.deleteMin();
        Assertions.assertEquals("8 2 5 1 9 4 6 3 10 7 ", heap.printHeap(), "Error delete min from heap 2");
    }

    @Test
    void clearHeap(){
        initHeap1();
        heap.clear();
        Assertions.assertEquals("", heap.printHeap(), "Error clear heap)");
    }
}

