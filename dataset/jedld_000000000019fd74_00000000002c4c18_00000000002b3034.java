import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
  public static class TrieSolution {
    public String getMatchString() {
      ArrayList<Node> evalLines = new ArrayList<Node>();
      Iterator<Node> itr = leafSet.iterator();

      ArrayList<Character> result = null;
      char currentChar = '*';
      while (itr.hasNext()) {
        Node n = itr.next();
        if (n.name != '*' && result == null) {
          result = new ArrayList<Character>();
          result.add(n.name);
          currentChar = n.name;
        }
        evalLines.add(n);
      }

      if (result == null) {
        result = new ArrayList<Character>();
        result.add('*');
      }

      ArrayList<Character> answer = subEval(evalLines, result, currentChar);
      if (answer == null) return "*";
      StringBuilder builder = new StringBuilder();
      for (int i = answer.size() - 1; i >= 0; i--) {
        char c = answer.get(i);
        if (c != '!') {
          builder.append(answer.get(i));
        }
      }
      return builder.toString();
    }

    private ArrayList<Character> subEval(
        ArrayList<Node> evalLines, ArrayList<Character> result, char currentChar) {

      while (!isDone(evalLines)) {
        char candidateChar = '#';
//        System.out.println(
//            "----------" + evalLines.stream().map(v -> v.name).collect(Collectors.toList()));
        for (int i = 0; i < evalLines.size(); i++) {
          Node leaf = evalLines.get(i);
          //                    System.out.println(leaf.name);
          if (leaf.name == '*') {
            // we can stay or match to parent
            ArrayList<Node> newTimelIne = (ArrayList<Node>) evalLines.clone();
            ArrayList<Character> testString = (ArrayList<Character>) result.clone();
            if (leaf.parent.name == currentChar) {
                newTimelIne.set(i, leaf.parent);
                ArrayList<Character> subAnswer = subEval(newTimelIne, testString, currentChar);
                if (subAnswer != null) {
                    return subAnswer;
                }
            }

          } else if (leaf.name == currentChar) {
            if (leaf.parent == null) {
              return null;
            }
            if (leaf.parent.name != '*') {
              candidateChar = leaf.parent.name;
            }
            evalLines.set(i, leaf.parent);
          } else {
            //                        System.out.println("x " + leaf.name);
            return null;
          }
        }
        if (candidateChar == '#') return result;
        result.add(candidateChar);
        currentChar = candidateChar;
      }

      //            System.out.println();
      return result;
    }

    private boolean isDone(ArrayList<Node> evalLines) {
      for (Node lines : evalLines) {
        if (lines != rootNode) {
          return false;
        }
      }
      return true;
    }

    public class Node {
      char name;
      Node parent;
      HashMap<Character, Node> children;

      public Node(Character c) {
        this.name = c;
        this.parent = null;
        this.children = new HashMap<>();
      }

      public Node addNode(HashSet<Node> leafSet, Node node) {
        if (children.containsKey(node.name)) {
          return children.get(node.name);
        }
        node.parent = this;
        if (leafSet.contains(this)) {
          leafSet.remove(this);
        }
        leafSet.add(node);
        children.put(node.name, node);
        return node;
      }

      public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\"" + name + ":" + hashCode() + "\" : { ");
        ArrayList<String> arrayList = new ArrayList<>();
        for (Node c : children.values()) {
          arrayList.add(c.toString());
        }
        builder.append(String.join(",", arrayList));
        builder.append("}");
        return builder.toString();
      }
    }

    Node rootNode = null;
    HashSet<Node> leafSet = new HashSet<>();

    public TrieSolution() {
      rootNode = new Node('!');
    }

    public void processString(String pattern) {
      Node currentNode = rootNode;
      for (int i = 0; i < pattern.length(); i++) {
        char c = pattern.charAt(i);
        currentNode = currentNode.addNode(leafSet, new Node(c));
      }
    }

    public String toString() {
      return "{ "
          + rootNode.toString()
          + ", \"leaves\" : \""
          + leafSet.stream().map(v -> v.hashCode()).collect(Collectors.toSet())
          + "\"}";
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      TrieSolution solver = new TrieSolution();
      for (int j = 0; j <= n; j++) {
        String pattern = in.nextLine();
        solver.processString(pattern);
      }
//      System.out.println(solver.toString());
      System.out.println("Case # " + i + ": " + solver.getMatchString());
    }
  }
}
