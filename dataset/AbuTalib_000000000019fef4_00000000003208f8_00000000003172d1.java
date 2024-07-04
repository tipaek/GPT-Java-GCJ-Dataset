import java.util.*;
import java.io.*;

class Solution {
  public static class Node implements Comparable<Node> {
    long key;
    int mode;

    public Node(long k, int m) {
      key = k;
      mode = m;
    }

    public int compareTo(Node other) {
      if (mode > other.mode) {
        return -1;
      } else if (mode == other.mode) {
        if (key > other.key) {
          return -1;
        } else if (key == other.key) {
          return 0;
        }
      }
      return 1;
    }
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int rr = in.nextInt();
    in.nextLine();
    for (int t = 1; t <= rr; t++) {
      int n = in.nextInt();
      int d = in.nextInt();
      HashMap<Long, Integer> hm = new HashMap<>();
      for (int i = 0; i < n; i++) {
        long num = in.nextLong();
        if (hm.containsKey(num)) {
          hm.put(num, hm.get(num) + 1);
        } else {
          hm.put(num, 1);
        }
      }
      PriorityQueue<Node> pq = new PriorityQueue<>();
      for (Map.Entry<Long, Integer> entry : hm.entrySet()) {
        Node nn = new Node(entry.getKey(), entry.getValue());
        pq.add(nn);
      }
      if (pq.peek().mode >= d) {
        System.out.println("Case #" + t + ": 0");
      } else {
        long[] arr = new long[pq.size()];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = pq.poll().key;
        }
        boolean twoPasses = false;
        a: for(int i=0; i<arr.length; i++){
          for(int j=i+1; j<arr.length; j++){
            if(arr[i] % arr[j] == 0){
              System.out.println("Case #"+t+": 1");
              twoPasses = true;
              break a;
            }
          }
        }
        if(!twoPasses){
          System.out.println("Case #"+t+": 2");
        }
      }

    }
  }

}