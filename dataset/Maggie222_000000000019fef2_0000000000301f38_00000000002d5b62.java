import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
  static int[] xSteps = {1, 0, -1, 0};
  static int[] ySteps = {0, 1, 0, -1};
  static Character[] directions = {'E', 'N', 'W', 'S'};

  public static void main(String[] args) {
    // Scanner has functions to read ints, longs, strings, chars, etc.
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int caseNum = input.nextInt();
    input.nextLine();

    for (int i = 1; i <= caseNum; i++) {
      int targetX = input.nextInt();
      int targetY = input.nextInt();
      Node targetNode = new Node(targetX, targetY);
      String result = solve(targetNode);
      out.println("Case #" + i + ": " + result);
    }
  }

  private static String solve(Node targetNode) {
    if((targetNode.x + targetNode.y) % 2 == 0) {
      return "IMPOSSIBLE";
    }
    Queue<Node> currentQueue = new LinkedList<>();
    Node startNode = new Node(0, 0);
    currentQueue.add(startNode);
    Set<Node> visited = new HashSet<>();
    int numStep = 1;
    while(!currentQueue.isEmpty()) {
      Queue<Node> nextQueue = new LinkedList<>();
      for(Node current : currentQueue) {
        visited.add(current);
        if(current.equals(targetNode)) {
          return extractPath(current);
        }
        if(!isPossible(current, targetNode, numStep)) {
          continue;
        }
        for(int j = 0; j < 4; j ++) {
          Node nextNode = new Node(current.x + numStep * xSteps[j],  current.y + numStep * ySteps[j]);
          nextNode.pre = current;
          nextNode.pathDirection = directions[j];
          if(!visited.contains(nextNode)) {
            nextQueue.add(nextNode);
          }
        }
      }
      currentQueue = nextQueue;
      numStep *= 2;
    }
    return "IMPOSSIBLE";
  }

  private static String extractPath(Node current) {
    StringBuilder sb = new StringBuilder();
    while(current.pre != null) {
      sb.insert(0, current.pathDirection);
      current = current.pre;
    }
    return sb.toString();
  }

  private static boolean isPossible(Node node1, Node node2, int stepNum) {
    if(Math.abs(node1.x - node2.x) != 0 && Math.abs(node1.x - node2.x) < stepNum || Math.abs(node1.y - node2.y) != 0 && Math.abs(node1.y - node2.y) < stepNum) {
      return false;
    }
    return true;
  }

  public static class Node {
    int x;
    int y;
    Node pre = null;
    Character pathDirection = null;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return x == node.x &&
          y == node.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}


