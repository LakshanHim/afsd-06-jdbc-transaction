package lk.ACPT.dsa;

public class Queue {
    Node top;

    public void push(int data){
        Node newNode = new Node(data);

        if(top == null){
            top = newNode;
        }
        else{
            Node temp = top;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

}
