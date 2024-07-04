import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = scanner.nextLine().split("\\s+");
            int rankCount = Integer.parseInt(input[0]);
            int suitCount = Integer.parseInt(input[1]);

            Node head = new Node(1);
            Node currentNode = head;
            Node targetNode = head;
            int id = 2;

            for (int suit = 0; suit < suitCount; suit++) {
                for (int rank = 1; rank <= rankCount; rank++) {
                    if (suit != 0 || rank != 1) {
                        currentNode.next = new Node(rank);
                        currentNode.next.prev = currentNode;
                        currentNode = currentNode.next;
                        currentNode.id = id;
                        if (id == 5) {
                            targetNode = currentNode;
                        }
                        id++;
                    }
                }
            }

            int solved = 0;
            List<String> solutionSteps = new ArrayList<>();

            while (solved < rankCount * suitCount - 1) {
                int requiredRank = rankCount - (solved / suitCount);
                if (currentNode.rank == requiredRank) {
                    solved++;
                    currentNode = currentNode.prev;
                } else {
                    Node correctNode = head;
                    int distance = 1;
                    while (correctNode.rank != requiredRank) {
                        correctNode = correctNode.next;
                        distance++;
                    }
                    int aDepth = distance;
                    int bDepth = rankCount * suitCount - solved;
                    solutionSteps.add(aDepth + " " + (bDepth - aDepth));

                    if (correctNode.next != null) {
                        correctNode.next.prev = null;
                    }
                    correctNode.next = currentNode.next;
                    if (currentNode.next != null) {
                        currentNode.next.prev = correctNode;
                    }
                    currentNode.next = head;
                    head.prev = currentNode;
                    head = correctNode.next;
                    currentNode = correctNode;
                }
            }

            System.out.println("Case #" + testCase + ": " + solutionSteps.size());
            for (String step : solutionSteps) {
                System.out.println(step);
            }
        }
        scanner.close();
    }

    static class Node {
        Node prev = null;
        Node next = null;
        int rank;
        int id;

        public Node(int rank) {
            this.rank = rank;
        }
    }
}