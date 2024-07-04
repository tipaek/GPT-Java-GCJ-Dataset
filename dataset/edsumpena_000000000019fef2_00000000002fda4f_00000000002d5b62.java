import java.util.*;
import java.io.*;
public class Solution {
    private static ArrayList<Integer> indexes = new ArrayList<>();
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
      int xx = in.nextInt();
      int y = in.nextInt();
      solve(xx, y);
      
      //System.out.println("Case #" + x + ": " + getNestedStr(str));
    }
  }
  
  private static int[] solve(int x, int y){
      boolean xNeg = x < 0;
      boolean yNeg = y < 0;
      int[] moveX = oneMove(Math.abs(x));
      int[] moveY = oneMove(Math.abs(y));
      
      System.out.println("One MoveX: " + Arrays.toString(moveX));
      System.out.println("One MoveY: " + Arrays.toString(moveY));
      
      if(moveX[0] == -1){
          if(moveY[0] == -1)
            moveX = multiMoves(new ArrayList<>(), x);
            else{
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(moveY[1]);
                moveX = multiMoves(tmp, x);
            }
      }
      
      if(moveX[0] == -1)
        return new int[]{-1};
        
    ArrayList<Integer> indexesX = new ArrayList<>();
    for(int i : indexes)
        indexesX.add(i);
      
      if(moveY[0] == -1){
        moveX = multiMoves(indexes, y);
      }
      
      if(moveY[0] == -1)
        return new int[]{-1};
        
    ArrayList<Integer> indexesY = new ArrayList<>();
    for(int i : indexes)
        indexesX.add(i);
        
    System.out.println(indexesX + ", " + indexesY);
    System.out.println(Arrays.toString(moveX) + ", " + Arrays.toString(moveY));
    return new int[]{-1};
  }
  
  private static int[] multiMoves(ArrayList<Integer> exclude, int target){
      int mult = 1;
      int counter = 1;
      ArrayList<Integer> multiples = new ArrayList<>();
      while(addAll(multiples) < target){
          if(!exclude.contains(counter))
            multiples.add(mult);
          mult *= 2;
          counter += 1;
      }
      
      int total = 0;
      ArrayList<Integer> moves = new ArrayList<>();
      boolean startNeg = false;
      
      for(int j = 0; j < 2; j++){
          if(j == 1){
              multiples.set(0, -multiples.get(0));
            startNeg = true;
          }
          moves.clear();
          indexes.clear();
          total = multiples.get(0);
          moves.add(multiples.get(0));
        for(int i = 1; i < multiples.size(); i++){
            if(total <= target){
                total += multiples.get(i);
                moves.add(multiples.get(i));
                indexes.add(i);
           } else {
                total -= multiples.get(i);
                moves.add(-multiples.get(i));
                indexes.add(i);
           }
        }
        if(total != target && j == 1){
            return new int[]{-1};
        } else if(total == target){
            int[] move = new int[moves.size()];
            for(int i = 0; i < moves.size(); i++)
                move[i] = moves.get(i);
            return move;
        }
        
      }
      return new int[]{-1};
  }
  
  private static int addAll(ArrayList<Integer> list){
      int sum = 0;
      for(int i : list)
        sum += i;
    return sum;
  }
  
  private static int[] oneMove(int val){
      int mult = 1;
      int counter = 1;
      while(mult < val){
          mult *= 2;
          counter += 1;
      }
      return new int[]{(mult == val ? 1 : 0), counter};
  }
}