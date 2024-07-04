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
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int testCases = Integer.parseInt(input.readLine());

        for (int t = 1; t <= testCases; t++) {
            output.print("Case #" + t + ": ");
            int U = Integer.parseInt(input.readLine());
            int[] frequency = new int[26];
            boolean[] isFirstLetter = new boolean[26];

            for (int i = 0; i < 10000; i++) {
                StringTokenizer tokenizer = new StringTokenizer(input.readLine());
                long Q = Long.parseLong(tokenizer.nextToken());
                String R = tokenizer.nextToken();
                isFirstLetter[R.charAt(0) - 'A'] = true;

                for (int j = 0; j < R.length(); j++) {
                    frequency[R.charAt(j) - 'A']++;
                }
            }

            PriorityQueue<Letter> priorityQueue = new PriorityQueue<>();
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                if (frequency[i] != 0) {
                    if (!isFirstLetter[i]) {
                        answer.append((char) ('A' + i));
                    } else {
                        priorityQueue.add(new Letter((char) ('A' + i), frequency[i]));
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                answer.append(priorityQueue.poll().character);
            }

            output.println(answer.toString());
        }

        output.flush();
        output.close();
    }
}