import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class Solution {

  private static int max = Integer.MAX_VALUE;
  private static Map<Character, int[]> directionMap = new HashMap();

  public static void main(String[] args) {
    directionMap.put('N', new int[]{0, 1});
    directionMap.put('E', new int[]{1, 0});
    directionMap.put('W', new int[]{-1, 0});
    directionMap.put('S', new int[]{0, -1});

    Scanner sc = new Scanner(System.in);
    int testcases = sc.nextInt();
    int cases = 1;

    while (cases <= testcases) {
      max = Integer.MAX_VALUE;
      int X = sc.nextInt();
      int Y = sc.nextInt();

      String direction = sc.next();

      LinkedList<int[]> path = new LinkedList();
      path.add(new int[]{X, Y});
      int M = direction.length();
      Map<String, Integer> pathMap = new HashMap();
      for (int i = 0; i < direction.length(); i++) {

        int[] currentPoints = path.getLast();
        int[] inc = directionMap.get(direction.charAt(i));
        int newPathX = currentPoints[0] + inc[0];
        int newPathY = currentPoints[1] + inc[1];
        path.add(new int[]{newPathX, newPathY});
        pathMap.put("row" + newPathX + "col" + newPathY, (i + 1));

      }

      //System.out.println(pathMap);

      findAllPaths(M, 1, pathMap, 0, 0);
      String result = max == Integer.MAX_VALUE ? "IMPOSSIBLE" : String.valueOf(max);

      System.out.println("Case #" + cases + ": " + result);

      cases++;

    }

  }

  private static void findAllPaths(int M, int currentStep, Map<String, Integer> pathMap, int x,
      int y) {

    if (currentStep > M) {
      return;
    }

    Iterator<Character> itr = directionMap.keySet().iterator();

    while (itr.hasNext()) {
      if (currentStep == 1) {
        String search = "row" + x + "col" + y;
        if (pathMap.containsKey(search) && pathMap.get(search) >= currentStep) {
          //System.out.println("search found "+search);
          max = Math.min(max, pathMap.get(search));
        }
      }
      char key = itr.next();
      int[] points = directionMap.get(key);
      int newPathX = x + points[0];
      int newPathY = y + points[1];
      String search = "row" + newPathX + "col" + newPathY;

      if (pathMap.containsKey(search) && pathMap.get(search) >= currentStep) {
        // System.out.println("search found "+search);
        max = Math.min(max, pathMap.get(search));
      }
      findAllPaths(M, currentStep + 1, pathMap, newPathX, newPathY);


    }

  }


}













