import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
      int cases = in.nextInt();
      
      ArrayList<String> schedules = new ArrayList<>();
      
      for(int i = 0; i < cases; i++){
          schedules.add(String.valueOf(in.nextInt()));
          schedules.add(String.valueOf(in.nextInt()));
      }
      
      //System.out.println("SCHEDULE: " + schedules);
      
      System.out.println("Case #" + x + ": " + getPossibleCombo(schedules));
    }
  }
  
  private static String getPossibleCombo(ArrayList<String> schedule){
    int[] occupiedUntil = new int[]{0, 0};  //[0] = C, [1] = J
    String output = "";
    
    ArrayList<String> order = new ArrayList<>();
    ArrayList<String> original = new ArrayList<>();
    
    for(String str : schedule)
        order.add(null);
        
    for(String str : schedule)
        original.add(str);
    
    while(!schedule.isEmpty()){
        int[][] next = getNextSchedule(schedule);
        
        //System.out.println("NEXT_SCHEDULE: " + Arrays.toString(next[0]) + ", " + Arrays.toString(next[1]));
        
        if(next[0][0] >= occupiedUntil[0]){
            occupiedUntil[0] = next[0][1];
            order.set(getOrderIndex(next[0], original), "C");
        } else if(next[0][0] >= occupiedUntil[1]){
            occupiedUntil[1] = next[0][1];
            order.set(getOrderIndex(next[0], original), "J");
        } else
            return "IMPOSSIBLE";
            
        schedule.remove(next[1][0]);
        schedule.remove(next[1][1] - 1);
    }
    
    //System.out.println(order);
    
    for(String str : order)
        if(str != null)
            output += str;
    
    return output;
  }
  
  private static int getOrderIndex(int[] schedule, ArrayList<String> original){
      for(int i = 0; i < original.size(); i += 2)
        if(Integer.valueOf(original.get(i)) == schedule[0] && 
            Integer.valueOf(original.get(i + 1)) == schedule[1])
            return i;
    return -1;
  }
  
  private static int[][] getNextSchedule(ArrayList<String> schedulesLeft){
    int earliest = Integer.MAX_VALUE;
    int[][] output = new int[2][2];
    for(int i = 0; i < schedulesLeft.size(); i += 2){
        if(Integer.valueOf(schedulesLeft.get(i)) < earliest){
            output[0][0] = Integer.valueOf(schedulesLeft.get(i));
            output[0][1] = Integer.valueOf(schedulesLeft.get(i + 1));
            output[1][0] = i;
            output[1][1] = i + 1;
            earliest = Integer.valueOf(schedulesLeft.get(i));
        }
    }
    return output;
  }
}