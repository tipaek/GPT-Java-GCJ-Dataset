import java.io.*;
import java.util.*;

class StringMatch {
  Node headNode;

  public StringMatch (String line) {
    headNode = new Node(line.charAt(0), null);
    Node tempNode = headNode;
    for (int i = 1; i < line.length(); i++) {
      tempNode.nextNode = new Node(line.charAt(i), null);
      tempNode = tempNode.nextNode;
    }
    tempNode.nextNode = new Node('0', null);
  }

  public void addParenthesis () {
    Node tempNode = headNode;
    int currentCount = 0;
    while (tempNode != null) {
      int digit = (tempNode.character - '0');
      if (digit >= currentCount) {
        tempNode.leftParenthesis += (digit - currentCount);
        currentCount += (digit - currentCount);
      }
      else {
        tempNode.rightParenthesis += (currentCount - digit);
        currentCount -= (currentCount - digit);
      }
      tempNode = tempNode.nextNode;
    }
  }

  static class Node {
    char character;
    Node nextNode;
    int leftParenthesis;
    int rightParenthesis;

    Node (char c, Node n) {
      character = c;
      nextNode = n;
      leftParenthesis = 0;
      rightParenthesis = 0;
    }
  }

  public String toString() {
    Node tempNode = headNode;
    StringBuilder out = new StringBuilder("");
    while (tempNode != null) {
      if (tempNode.leftParenthesis != 0) {
        for (int i = 0; i < tempNode.leftParenthesis; i++) {
          out.append("(");
        }
      }
      else {
        for (int i = 0; i < tempNode.rightParenthesis; i++) {
          out.append(")");
        }
      }
      if (tempNode.nextNode != null) {
        out.append("" + tempNode.character);
      }
      tempNode = tempNode.nextNode;
    }
    return out.toString();
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);

    int N = in.nextInt();
    in.nextLine();

    for (int n = 1; n <= N; n++) {
      String line = in.nextLine();
      StringMatch stringMatch = new StringMatch(line);
      stringMatch.addParenthesis();
      System.out.printf("Case #%d: %s\n", n, stringMatch);
    }
  }
}
