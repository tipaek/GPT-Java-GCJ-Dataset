import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            String[] input = scanner.nextLine().split("\\s+");
            int ranks = Integer.parseInt(input[0]);
            int suits = Integer.parseInt(input[1]);

            Node head = new Node(1);
            Node current = head;
            Node watchNode = head;
            int nodeId = 2;

            for (int suit = 0; suit < suits; suit++) {
                for (int rank = 1; rank <= ranks; rank++) {
                    if (!(rank == 1 && suit == 0)) {
                        current.next = new Node(rank);
                        current.next.previous = current;
                        current = current.next;
                        current.id = nodeId;
                        if (nodeId == 5) {
                            watchNode = current;
                        }
                        nodeId++;
                    }
                }
            }

            int solvedCount = 0;
            List<String> result = new ArrayList<>();

            while (solvedCount < ranks * suits - 1) {
                int targetRank = ranks - (solvedCount / suits);
                if (current.rank == targetRank) {
                    solvedCount++;
                    current = current.previous;
                } else {
                    Node correctNode = current.previous;
                    int offset = 1;
                    while (correctNode.rank != targetRank) {
                        correctNode = correctNode.previous;
                        offset++;
                    }
                    int bDepth = ranks * suits - solvedCount;
                    int aDepth = bDepth - offset;
                    result.add(aDepth + " " + (bDepth - aDepth));

                    Node tempNode = correctNode.next;
                    correctNode.next.previous = null;
                    correctNode.next = current.next;
                    head.previous = current;
                    head = tempNode;
                    current = correctNode;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result.size());
            for (String res : result) {
                System.out.println(res);
            }
        }

        scanner.close();
    }

    static class Node {
        Node previous;
        Node next;
        int rank;
        int id;

        Node(int rank) {
            this.rank = rank;
        }
    }
}