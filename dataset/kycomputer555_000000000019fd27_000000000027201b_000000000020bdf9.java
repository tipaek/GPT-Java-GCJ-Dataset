import java.util.*;
import java.io.*;
public class Solution {

  public static class Node {
    int start = 0;
    int end = 0;
    char name = 0;
    public Node(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int iTest = 1; iTest <= t; ++iTest) {
      List<Node> originalList = new ArrayList<Node>();
      int n = in.nextInt();
      for (int i=0; i<n; i++) {
        originalList.add(new Node(in.nextInt(), in.nextInt()));
      }

      List<Node> sortedList = new ArrayList<Node>(originalList); 
      Collections.sort(sortedList, new Comparator<Node>() {
        @Override
        public int compare(Node a, Node b) {
            return a.start-b.start;
        }
      });

      String result = "";
      List<Node> cList = new ArrayList<Node>();
      List<Node> jList = new ArrayList<Node>();
      for (int i=0; i<sortedList.size(); i++) {
        Node node = sortedList.get(i);
        if (!add(cList, node, 'C') && !add(jList, node, 'J')) {
          result = "IMPOSSIBLE";
          break;
        }
      }
      if (!result.equalsIgnoreCase("IMPOSSIBLE")) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<originalList.size(); i++) {
          str.append(originalList.get(i).name);
        }
        result = str.toString();
      }
      System.out.println("Case #" + iTest + ": " + result);
    }
  }

  public static boolean add(List<Node> list, Node node, char c) {
    node.name = c;
    if (list.isEmpty()) {
      list.add(node);
      return true;
    } else {
      Node last = list.get(list.size()-1);
      if (node.start >= last.end) {
        list.add(node);
        return true;
      }
    }
    return false;
  }
}