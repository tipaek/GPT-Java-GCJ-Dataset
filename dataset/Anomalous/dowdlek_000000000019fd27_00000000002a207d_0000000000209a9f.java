import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestingDepth {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        for (int cases = 0; cases < n; cases++) {
            sb.append("Case #").append(cases + 1).append(": ");
            char[] input = reader.readLine().toCharArray();
            Node[] nodes = new Node[input.length];

            for (int i = 0; i < input.length; i++) {
                nodes[i] = new Node(Character.getNumericValue(input[i]));
            }

            NDLinked linked = new NDLinked(nodes);
            linked.processNodes();
            sb.append(linked.head.rep).append('\n');
        }

        System.out.println(sb.toString());
    }

    static class NDLinked {
        Node head;
        int size;

        NDLinked(Node[] nodes) {
            this.head = nodes[0];
            this.size = nodes.length;

            if (size > 1) {
                nodes[0].next = nodes[1];
                nodes[size - 1].prev = nodes[size - 2];

                for (int i = 1; i < size - 1; i++) {
                    nodes[i].next = nodes[i + 1];
                    nodes[i].prev = nodes[i - 1];
                }
            }
        }

        void processNodes() {
            Node current = head;
            current.isHead = true;

            while (size > 1) {
                if (current.prev == null) {
                    processHead(current);
                } else if (current.next == null) {
                    processTail(current);
                } else {
                    processMiddle(current);
                }
            }

            while (head.val > 0) {
                head.reduce();
            }
        }

        void processHead(Node current) {
            while (current.next.val < current.val) {
                current.reduce();
            }
            if (current.next.val == current.val) {
                combineAfter(current);
            } else {
                current = current.next;
            }
        }

        void processTail(Node current) {
            while (current.prev.val < current.val) {
                current.reduce();
            }
            if (current.prev.val == current.val) {
                combineBefore(current);
            } else {
                current = current.prev;
            }
        }

        void processMiddle(Node current) {
            if (current.val == current.prev.val) {
                while (current.val == current.prev.val) {
                    combineBefore(current);
                }
            }

            if (current.val == current.next.val) {
                while (current.val == current.next.val) {
                    combineAfter(current);
                }
            }

            if (current.val > current.next.val && current.val > current.prev.val) {
                if (current.prev.val == current.next.val) {
                    while (current.prev.val < current.val) {
                        current.reduce();
                    }
                    combineAfter(current);
                    combineBefore(current);
                } else if (current.prev.val > current.next.val) {
                    while (current.prev.val < current.val) {
                        current.reduce();
                    }
                    combineBefore(current);
                } else {
                    while (current.next.val < current.val) {
                        current.reduce();
                    }
                    combineAfter(current);
                }
            } else if (current.val > current.prev.val) {
                while (current.prev.val < current.val) {
                    current.reduce();
                }
                combineBefore(current);
            } else if (current.val > current.next.val) {
                while (current.next.val < current.val) {
                    current.reduce();
                }
                combineAfter(current);
            } else {
                current = current.next;
            }
        }

        void combineAfter(Node current) {
            size--;
            String tempRep = current.next.rep;
            Node tempNode = current.next;
            current.next = tempNode.next;
            if (tempNode.next != null) {
                tempNode.next.prev = current;
            }
            current.rep += tempRep;
        }

        void combineBefore(Node current) {
            size--;
            String tempRep = current.prev.rep;
            Node tempNode = current.prev;
            current.isHead = tempNode.isHead;
            current.prev = tempNode.prev;
            if (tempNode.prev != null) {
                tempNode.prev.next = current;
            }
            current.rep = tempRep + current.rep;
            if (current.isHead) {
                this.head = current;
            }
        }
    }

    static class Node {
        Node prev;
        Node next;
        int val;
        String rep;
        boolean isHead = false;

        Node(int val) {
            this.val = val;
            this.rep = Integer.toString(val);
        }

        void reduce() {
            val--;
            rep = "(" + rep + ")";
        }
    }
}