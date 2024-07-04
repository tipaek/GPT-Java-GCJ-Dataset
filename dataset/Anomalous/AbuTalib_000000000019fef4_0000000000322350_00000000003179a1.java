import java.util.*;
import java.io.*;

public class Solution {
  static class Node implements Comparable<Node> {
    char ch;
    int frequency;

    Node(char ch, int frequency) {
      this.ch = ch;
      this.frequency = frequency;
    }

    @Override
    public int compareTo(Node other) {
      return Integer.compare(this.frequency, other.frequency);
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = scanner.nextInt();
    for (int t = 1; t <= testCases; t++) {
      int U = scanner.nextInt();
      int[] frequency = new int[26];
      for (int i = 0; i < 10000; i++) {
        long num = scanner.nextLong();
        char[] response = scanner.next().toCharArray();
        scanner.nextLine();
        for (char ch : response) {
          frequency[ch - 'A']++;
        }
      }
      PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
      for (int i = 0; i < 26; i++) {
        if (frequency[i] > 0) {
          priorityQueue.add(new Node((char) ('A' + i), frequency[i]));
        }
      }
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < 9; i++) {
        result.append(priorityQueue.poll().ch);
      }
      System.out.println("Case #" + t + ": " + priorityQueue.poll().ch + result.toString());
    }
  }
}