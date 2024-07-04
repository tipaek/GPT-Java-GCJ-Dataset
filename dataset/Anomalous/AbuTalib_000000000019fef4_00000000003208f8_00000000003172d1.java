import java.util.*;
import java.io.*;

class Solution {
  static class Node implements Comparable<Node> {
    long key;
    int frequency;

    Node(long key, int frequency) {
      this.key = key;
      this.frequency = frequency;
    }

    @Override
    public int compareTo(Node other) {
      if (this.frequency != other.frequency) {
        return Integer.compare(other.frequency, this.frequency);
      }
      return Long.compare(this.key, other.key);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = scanner.nextInt();
    scanner.nextLine();

    for (int t = 1; t <= testCases; t++) {
      int n = scanner.nextInt();
      int d = scanner.nextInt();
      Map<Long, Integer> frequencyMap = new HashMap<>();

      for (int i = 0; i < n; i++) {
        long num = scanner.nextLong();
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
      }

      PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
      for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
        priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
      }

      if (priorityQueue.peek().frequency >= d) {
        System.out.println("Case #" + t + ": 0");
      } else {
        long[] uniqueNumbers = new long[priorityQueue.size()];
        for (int i = 0; i < uniqueNumbers.length; i++) {
          uniqueNumbers[i] = priorityQueue.poll().key;
        }

        boolean found = false;
        outerLoop:
        for (int i = 0; i < uniqueNumbers.length; i++) {
          for (int j = i + 1; j < uniqueNumbers.length; j++) {
            if (uniqueNumbers[i] % uniqueNumbers[j] == 0) {
              System.out.println("Case #" + t + ": 1");
              found = true;
              break outerLoop;
            }
          }
        }

        if (!found) {
          System.out.println("Case #" + t + ": 2");
        }
      }
    }
  }
}