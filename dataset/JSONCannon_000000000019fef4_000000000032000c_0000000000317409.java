import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int numTests = scanner.nextInt();
    for(int t = 1; t <= numTests; ++t) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      String m = scanner.next();
      char[] catMoves = m.toCharArray();
      int totalDist = x + y;
      if(totalDist > catMoves.length * 2){
        System.out.println("Case #" + t + ": IMPOSSIBLE");
        continue;
      }
      List<Integer> xPositions = new ArrayList<>();
      xPositions.add(x);
      List<Integer> yPositions = new ArrayList<>();
      yPositions.add(y);
      for(int i = 0; i < catMoves.length; i++){
        int previousX = xPositions.get(i);
        int previousY = yPositions.get(i);
        if(catMoves[i] == 'E'){
          xPositions.add(previousX + 1);
          yPositions.add(previousY);
        }else if(catMoves[i] == 'W'){
          xPositions.add(previousX - 1);
          yPositions.add(previousY);
        }else if(catMoves[i] == 'N'){
          xPositions.add(previousX);
          yPositions.add(previousY + 1);
        }else if(catMoves[i] == 'S'){
          xPositions.add(previousX);
          yPositions.add(previousY - 1);
        }
      }
      int endDistAway = Math.abs(xPositions.get(catMoves.length)) + Math.abs(yPositions.get(catMoves.length));
      if(endDistAway > catMoves.length){  // Can't get there
        System.out.println("Case #" + t + ": IMPOSSIBLE");
        continue;
      }
      for(int i = 1; i < xPositions.size(); i++){
        int catX = xPositions.get(i);
        int catY = yPositions.get(i);
        int totalDistance = Math.abs(catX) + Math.abs(catY);
        if(totalDistance <= i){  // If I can get there in this many minutes
          System.out.println("Case #" + t + ": " + i);
          break;
        }
      }
    }
  }
}
