package lk.ACPT.dsa;

public class Stack {
    Node top;

    public void push(int data) {
        Node node = new Node(data);
        node.data = data;
        top = node;

    }
    public  void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
