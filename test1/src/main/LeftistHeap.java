package main;

class Node{
    int node, value;
    Node left, right;

    public Node(int node){
        this(node, null, null);
    }
    public Node(int node, Node left, Node right){
        this.node = node;
        this.left = left;
        this.right = right;
        this.value = 0;
    }
}

public class LeftistHeap{

    private Node root;

    public LeftistHeap(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void clear(){
        root = null;
    }

    public void insert(int x){
        root = merge(new Node(x), root);
    }

    private Node merge(Node x, Node y){
        if (x == null) return y;
        if (y == null) return x;
        if (x.node > y.node){
            Node temp = x;
            x = y;
            y = temp;
        }

        x.right = merge(x.right, y);

        if(x.left == null){
            x.left = x.right;
            x.right = null;
        }
        else{
            if(x.left.value < x.right.value) {
                Node temp = x.left;
                x.left = x.right;
                x.right = temp;
            }
            x.value = x.right.value + 1;
        }
        return x;
    }

    public int deleteMin(){
        if (isEmpty()) return -1;
        int minNode = root.node;
        root = merge(root.left, root.right);
        return minNode;
    }

    public String printHeap(){
        System.out.println();
        return printHeap(root);
    }
    private String printHeap(Node r){
        String res = "";
        if (r != null){
            res = printHeap(r.left) + r.node +" " + printHeap(r.right);
        }
        return res;
    }
}
