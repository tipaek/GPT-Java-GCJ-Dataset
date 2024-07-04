import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestingDepth {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        int size;

        for (int cases = 0; cases < n; cases++) {
            sb.append("Case #").append(cases+1).append(": ");
            char[] input = reader.readLine().toCharArray();
            Node[] nodes = new Node[input.length];

            for (int i = 0; i < input.length; i++) {
                nodes[i] = new Node(Character.getNumericValue(input[i]));
            }

            nodes[0].prev = null;
            nodes[nodes.length - 1].next = null;
            NDLinked linked = new NDLinked(nodes[0]);



            if (nodes.length > 1) {
                nodes[0].next = nodes[1];
                nodes[nodes.length - 1].prev = nodes[nodes.length - 2];
                size = 2;


                for (int i = 1; i < nodes.length - 1; i++) {
                    size++;
                    nodes[i].next = nodes[i+1];
                    nodes[i].prev = nodes[i-1];
                }
                linked.size = size;

            }

            Node current = nodes[0];
            current.isHead = true;

            while (linked.size > 1) {

                if (current.prev == null) { //check if at head

                    //if we are larger than the next node
                    while (current.next.val < current.val) {
                        current.reduce();
                    }

                    if (current.next.val == current.val) {
                        linked.combineAfter(current);
                    } else {
                        current = current.next;
                    }

                } else if (current.next == null) { //check if at tail

                    //if we are larger than the prev node
                    while (current.prev.val < current.val) {
                        current.reduce();
                    }

                    if (current.prev.val == current.val) {
                        linked.combineBefore(current);
                    } else {
                        current = current.prev;
                    }
                } else { //not head or tail

                    if (current.val == current.prev.val) { //if current equals prev
                        while (current.val == current.prev.val) {
                            linked.combineBefore(current);
                        }
                    }

                    if (current.val == current.next.val) { //if current equals next
                        while (current.val == current.next.val) {
                            linked.combineAfter(current);
                        }
                    }

                    if (current.val > current.next.val && current.val > current.prev.val) { //if current is greater than next and prev

                        if (current.prev.val == current.next.val) { //if prev equals next

                            while (current.prev.val < current.val) {
                                current.reduce();
                            }

                            linked.combineAfter(current);
                            linked.combineBefore(current);

                        } else if (current.prev.val > current.next.val) { //if prev is greater than next

                            while (current.prev.val < current.val) {
                                current.reduce();
                            }
                            linked.combineBefore(current);

                        } else { //if next is greater than prev

                            while (current.next.val < current.val) {
                                current.reduce();
                            }
                            linked.combineAfter(current);
                        }
                    } else if (current.val > current.prev.val){ //current greater than only prev

                        while (current.prev.val < current.val) {
                            current.reduce();
                        }
                        linked.combineBefore(current);


                    } else if (current.val > current.next.val) { //current greater than only next

                        while (current.next.val < current.val) {
                            current.reduce();
                        }
                        linked.combineAfter(current);

                    } else {

                        current = current.next;

                    }
                }



            }

            while (linked.head.val > 0) {
                linked.head.reduce();
            }

            sb.append(linked.head.rep).append('\n');








        }

        System.out.println(sb.toString());
    }

    public static class NDLinked {

        Node head;
        int size;


        NDLinked(Node head) {
            this.head = head;
        }

        void combineAfter(Node current) {
            size--;
            String tempRep = current.next.rep;
            Node tempNode = current.next;
            current.next = tempNode.next;
            if (tempNode.next != null) {
                tempNode.next.prev = current;
            }
            current.rep = current.rep + tempRep;
        }

        void combineBefore(Node current) {
            size--;
            String tempRep = current.prev.rep;
            Node tempNode = current.prev;
            current.isHead = tempNode.isHead;

            current.prev = tempNode.prev;

            if (tempNode.prev != null){
                tempNode.prev.next = current;
            }

            current.rep = tempRep + current.rep;
            if (current.isHead) {
                this.head = current;
            }

        }



    }


    public static class Node {

        Node prev;
        Node next;
        int val;
        String rep;
        boolean isHead = false;

        Node(int val) {
            this.val = val;
            this.rep = Integer.toString(val);
        }

        public void reduce() {
            val--;
            rep = "(" + rep + ")";
        }


    }
}
