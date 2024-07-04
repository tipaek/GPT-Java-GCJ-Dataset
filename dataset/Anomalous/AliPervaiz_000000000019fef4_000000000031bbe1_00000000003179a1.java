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
            int[] frequencies = new int[26];

            for (int i = 0; i < 10000; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                long Q = Long.parseLong(tokenizer.nextToken());
                String R = tokenizer.nextToken();
                for (char c : R.toCharArray()) {
                    frequencies[c - 'A']++;
                }
            }

            PriorityQueue<Letter> priorityQueue = new PriorityQueue<>();
            for (int i = 0; i < 26; i++) {
                if (frequencies[i] > 0) {
                    priorityQueue.add(new Letter((char) ('A' + i), frequencies[i]));
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                result.append(priorityQueue.poll().character);
            }
            result.insert(0, priorityQueue.poll().character);
            
            writer.println(result);
        }
        
        writer.flush();
        writer.close();
    }
}