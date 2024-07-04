import java.util.*;
import java.io.*;

class Solution {
    public static class Node implements Comparable<Node> {
        char ch;
        long frequency;

        public Node(char ch, long frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(other.frequency, this.frequency);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            scanner.nextInt();  // Skipping the integer input as it is not used
            long[] frequencies = new long[26];
            boolean[] isLeadingChar = new boolean[26];

            for (int i = 0; i < 10000; i++) {
                scanner.nextLong();  // Skipping the long input as it is not used
                char[] chars = scanner.next().toCharArray();
                isLeadingChar[chars[0] - 'A'] = true;

                for (int j = 0; j < chars.length; j++) {
                    frequencies[chars[j] - 'A'] += Math.pow(10, chars.length - j - 1);
                }
            }

            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                if (frequencies[i] != 0) {
                    if (!isLeadingChar[i]) {
                        result.append((char) ('A' + i));
                    } else {
                        priorityQueue.add(new Node((char) ('A' + i), frequencies[i]));
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                result.append(priorityQueue.poll().ch);
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}