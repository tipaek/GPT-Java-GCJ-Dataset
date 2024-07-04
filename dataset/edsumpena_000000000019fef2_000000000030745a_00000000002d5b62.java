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
      String[] arr = solve(xx, y);
      String o = "";
      if(arr[0] != null){
      for(String str : arr)
        o += str;
    } else {
        o = "IMPOSSIBLE";
    }
      
      System.out.println("Case #" + x + ": " + o);
    }
  }
  
  private static String[] solve(int x, int y){
      boolean xNeg = x < 0;
      boolean yNeg = y < 0;
      x = Math.abs(x);
      y = Math.abs(y);
      int[] moveX = oneMove(Math.abs(x));
      int[] moveY = oneMove(Math.abs(y));
      
    if(Arrays.equals(moveX, moveY) && moveX[0] != -1)
        return new String[]{null};
      
      indexes.clear();
      
      System.out.println("One MoveX: " + Arrays.toString(moveX));
      System.out.println("One MoveY: " + Arrays.toString(moveY));
      
      if(moveX[0] == 0){
          if(moveY[0] == 0)
            moveX = multiMoves(new ArrayList<>(), x);
            else{
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(moveY[1]);
                moveX = multiMoves(tmp, x);
            }
      } else {
          moveX = new int[]{moveX[2]};
      }
      
      if(moveX[0] == 0)
        return new String[]{null};
        
    ArrayList<Integer> indexesX = new ArrayList<>();
    for(int i : indexes)
        indexesX.add(i);
      
      if(moveY[0] == 0){
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(moveY[1]);
        
        if(indexes.isEmpty()){
            indexes = tmp;
        } 
        moveY = multiMoves(indexes, y);
      } else {
          moveY = new int[]{moveY[2]};
      }
    
    if(xNeg)
        for(int i = 0; i < moveX.length; i++)
            moveX[i] = -moveX[i];
    if(yNeg)
        for(int i = 0; i < moveY.length; i++)
            moveY[i] = -moveY[i];
            
    System.out.println(Arrays.toString(moveX) + ", " + Arrays.toString(moveY));
      
      if(moveY[0] == 0)
        return new String[]{null};
        
    ArrayList<Integer> xxx = new ArrayList<>();
    ArrayList<Integer> yyy = new ArrayList<>();
        
    for(int i : moveX)
        xxx.add(i);
        
    for(int i : moveY)
        yyy.add(i);
        
    int[] output = new int[moveX.length + moveY.length];
    int minX = Integer.MAX_VALUE;
    int xVal = 0;
    int minY = Integer.MAX_VALUE;
    int yVal = 0;
    int c = 0;
    
    while(xxx.isEmpty() && yyy.isEmpty()){
    for(int i = 0; i < xxx.size(); i++){
        if(minX > Math.abs(xxx.get(i)) && xxx.get(i) != 0){
            minX = Math.abs(xxx.get(i));
            xVal = xxx.get(i);
        } else if(xxx.get(i) == 0){
            xxx.remove(i);
            i--;
        }
    }
    
    for(int i = 0; i < yyy.size(); i++){
        if(minY > Math.abs(yyy.get(i)) && yyy.get(i) != 0){
            minY = Math.abs(yyy.get(i));
            yVal = yyy.get(i);
        } else if(yyy.get(i) == 0){
            yyy.remove(i);
            i--;
        }
    }
    
    if(minX < minY){
        if(xVal < 0)
            output[c] = "W";
        else
            output[c] = "E";
        c += 1;
        xxx.remove(xVal);
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
    }else{
        if(yVal < 0)
            output[c] = "S";
        else
            output[c] = "N";
        c += 1;
        yyy.remove(yVal);
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
    }
    
    }
        
    ArrayList<Integer> indexesY = new ArrayList<>();
    for(int i : indexes)
        indexesX.add(i);
        
    System.out.println(indexesX + ", " + indexesY);
    System.out.println(Arrays.toString(output));
   // System.out.println(Arrays.toString(moveX) + ", " + Arrays.toString(moveY));
    return output;
  }
  
  private static int[] multiMoves(ArrayList<Integer> exclude, int target){
      int mult = 1;
      int counter = 1;
      
      if(target == 0)
        return new int[]{0};
      
      ArrayList<Integer> multiples = new ArrayList<>();
      while(addAll(multiples) < target){
          if(!exclude.contains(counter))
            multiples.add(mult);
          mult *= 2;
          counter += 1;
      }
      
      System.out.println("Multiples: " + multiples + ", " + exclude);
      
      int total = 0;
      ArrayList<Integer> moves = new ArrayList<>();
      boolean startNeg = false;
      //if(!startNeg)
      //return new int[]{-1};
      
      if(multiples.isEmpty())
        return new int[]{0};
      
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
            return new int[]{0};
        } else if(total == target){
            int[] move = new int[moves.size()];
            for(int i = 0; i < moves.size(); i++)
                move[i] = moves.get(i);
            return move;
        }
        
      }
      return new int[]{0};
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
      return new int[]{(mult == val ? 1 : 0), counter - 1, mult};
  }
}