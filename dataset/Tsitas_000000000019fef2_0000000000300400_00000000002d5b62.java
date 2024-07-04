
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author Eleftherios Chrysochoidis
 * Date 19/4/2020
 */
public class Solution {

   public static void main(String[] args) {

      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.


      for (int c = 1; c <= t; ++c) { // testCases
         int goalX = in.nextInt();
         int goalY = in.nextInt();

         String result = solve(c, goalX, goalY);
         System.out.println(String.format("Case #%d: %s", c, result));

      }
   }

   private static String solve(int c, int goalX, int goalY) {
      ExecutorService executor = Executors.newFixedThreadPool(1);
      Future<String> future = executor.submit(() -> {
         int x = 0, y = 0;
         Node node = new Node(x, y, 0, "");
         return node.solve(new Node(goalX, goalY, ""));
      });

      executor.shutdown();
      try {
         return future.get(20, TimeUnit.SECONDS);
      } catch (InterruptedException | ExecutionException e) {
         throw new RuntimeException(e.getMessage());
      } catch (TimeoutException e) {
         future.cancel(true);
         throw new RuntimeException("Timeout! " + e.getMessage());
      }
   }


   static class Node {

      private int x;
      private int y;
      private int step = 0;
      private String direction = "";

      public Node() {
      }

      public Node(int x, int y, String direction) {
         this.x = x;
         this.y = y;
         this.direction = direction;
      }

      public Node(int x, int y, int step, String direction) {
         this.x = x;
         this.y = y;
         this.step = step;
         this.direction = direction;
      }

      public List<Node> getChildren(Node goalNode) {
         List<Node> children = new ArrayList<>();
         int units = ((Double) Math.pow(2, step)).intValue();

         Node north = getNorth(units);
         if (goalNode.isValid(north))
            children.add(north);

         Node south = getSouth(units);
         if (goalNode.isValid(south))
            children.add(south);

         Node east = getEast(units);
         if (goalNode.isValid(east))
            children.add(east);

         Node west = getWest(units);
         if (goalNode.isValid(west))
            children.add(west);

         return children;
      }

      public Node getNorth(int units) {
         return new Node(x, y + units, step + 1, direction + "N");
      }

      public Node getSouth(int units) {
         return new Node(x, y - units, step + 1, direction + "S");
      }

      public Node getEast(int units) {
         return new Node(x + units, y, step + 1, direction + "E");
      }

      public Node getWest(int units) {
         return new Node(x - units, y, step + 1, direction + "W");
      }

      public boolean isValid(Node node) {
         int dist = Math.abs(x - node.x + y - node.y);
         int goalDist = Math.abs(x + y);
         return goalDist >= Math.abs(dist - goalDist);
      }

      public String solve(Node goalNode) {

         Queue<Node> nodeQueue = new LinkedList<>();

         nodeQueue.add(this);
         while (!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.remove();
            if (currentNode.isGoalNode(goalNode)) {
               String result = currentNode.direction;
//               System.out.println("Goal Node " + currentNode + " found. Visited: " + result);
               return result;
            } else
               nodeQueue.addAll(currentNode.getChildren(goalNode));
         }

         return "IMPOSSIBLE";
      }

      public boolean isGoalNode(Node goalNode) {
         return x == goalNode.x && y == goalNode.y;
      }

      @Override
      public String toString() {
         return x + "," + y;
      }
   }
}
