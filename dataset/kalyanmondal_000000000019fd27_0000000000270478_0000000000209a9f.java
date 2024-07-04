import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))).useDelimiter("\n");
        String test = in.next();
        int t = Integer.parseInt(test);
        for (int i=0; i<t; i++) {
            String num = in.next();
            LinkedList linkedList = new LinkedList();
            for(int j=0; j<num.length(); j++) {
                linkedList.addNode(num.charAt(j));
            }
            int count = 0;
            Node headLL = linkedList.head;
            while (headLL != null) {
                int data = Integer.parseInt(String.valueOf(headLL.data));
                Node temp = headLL;
                //Insert paranthesis before
                int cl = count;
                for(int k=0; k<data-cl; k++) {
                    Node node = new Node('(');
                    count++;
                    node.next = temp;
                    node.prev = temp.prev;
                    if(temp.prev != null)
                        temp.prev.next = node;
                    temp.prev = node;
                    temp = node;
                }
                Node tempL = headLL;
                while(tempL!=null) {
                    linkedList.head = tempL;
                    tempL = tempL.prev;
                }
                //Insert paranthesis after difference
                // if equal - skip
                while (headLL.next != null && data == Integer.parseInt(String.valueOf(headLL.next.data))) {
                    headLL = headLL.next;
                }
                // if less - closing braces
                if (headLL.next != null && (data > Integer.parseInt(String.valueOf(headLL.next.data)))) {
                    Node present = headLL;
                    int nextData = Integer.parseInt(String.valueOf(headLL.next.data));
                    for(int k=0; k<(data - nextData); k++) {
                        Node node = new Node(')');
                        count--;
                        node.next = present.next;
                        present.next.prev = node;
                        present.next = node;
                        node.prev = present;
                        present = node;
                    }
                    headLL = present;
                }
                // if greater - don't skip
                headLL = headLL.next;
            }
            while (count > 0){
               linkedList.addNode(')');
               count--;
            }

            System.out.print("Case #"+(i+1)+": ");
            linkedList.printList();
            System.out.println();
        }
    }
    static class LinkedList {
        Node head;
        LinkedList() {
            this.head = null;
        }

        public void addNode(char data) {
            Node node = new Node(data);
            Node last = head;
            node.next = null;
            if (head == null) {
                node.prev = null;
                head = node;
                return;
            }
            while (last.next != null)
                last = last.next;

            last.next = node;

            node.prev = last;
        }

        public void printList() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data);
                temp = temp.next;
            }
        }
    }
    static class Node {
        char data;
        Node next;
        Node prev;
        Node(char data) {
            this.data = data;
        }
    }
}
