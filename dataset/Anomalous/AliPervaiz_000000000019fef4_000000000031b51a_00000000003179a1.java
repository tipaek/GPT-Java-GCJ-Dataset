import java.util.*;
import java.io.*;

public class Solution {

    public static class Letter implements Comparable<Letter> {
        char character;
        int frequency;

        public Letter(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Letter other) {
            return Integer.compare(other.frequency, this.frequency);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCaseCount; t++) {
            writer.print("Case #" + t + ": ");
            int U = Integer.parseInt(reader.readLine());
            int[] frequency = new int[26];

            for (int i = 0; i < 10000; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int Q = Integer.parseInt(tokenizer.nextToken());
                String R = tokenizer.nextToken();

                for (int j = 0; j < R.length(); j++) {
                    frequency[R.charAt(j) - 'A']++;
                }
            }

            PriorityQueue<Letter> priorityQueue = new PriorityQueue<>();
            for (int i = 0; i < 26; i++) {
                if (frequency[i] != 0) {
                    priorityQueue.add(new Letter((char) ('A' + i), frequency[i]));
                }
            }

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                answer.append(priorityQueue.poll().character);
            }
            answer.insert(0, priorityQueue.poll().character);
            writer.println(answer);
        }

        writer.flush();
        writer.close();
    }
}