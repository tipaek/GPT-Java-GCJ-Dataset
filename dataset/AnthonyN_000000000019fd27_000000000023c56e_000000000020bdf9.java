import java.util.*;

public class Solution{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int numOfTestCases = Integer.valueOf(in.nextLine());
    
    for(int i = 0; i < numOfTestCases; i++){
      int numOfActivities = Integer.valueOf(in.nextLine());
      int[][] activities = new int[numOfActivities][2];
      
      for(int j = 0; j < numOfActivities; j++){
        String[] timeStrs = in.nextLine().split(" ");
        activities[j][0] = Integer.valueOf(timeStrs[0]);
        activities[j][1] = Integer.valueOf(timeStrs[1]);
      }
      
      System.out.println("Case #" + (i + 1) + ": " + solve(activities));
    }
  }
  
  private static String solve(int[][] arr){
    int[][] sorted = sort(arr);
    String[] sortedOut = new String[sorted.length];
    String[] out = new String[sorted.length];
    
    sortedOut[0] = "C";
    
    for(int i = 1; i < sorted.length; i++){
      if(endTimeOfLast("C", sorted, sortedOut) <= sorted[i][0])
        sortedOut[i] = "C";
      else if(endTimeOfLast("J", sorted, sortedOut) <= sorted[i][0])
        sortedOut[i] = "J";
      else
        return "IMPOSSIBLE";
    }
    
    for(int i = 0; i < sortedOut.length; i++)
      out[findIndex(sorted[i], arr)] = sortedOut[i];
    
    
    return String.join("", out);
  }
  
  private static int[][] sort(int[][] arr){
    int[][] sorted = new int[arr.length][2];
    for(int r = 0; r < arr.length; r++)
      for(int c = 0; c < 2; c++)
        sorted[r][c] = arr[r][c];
    
    Arrays.sort(sorted, new Comparator<int[]>(){
      public int compare(int[] a1, int[] a2){
        return a1[0] - a2[0];
      }
    });
    
    return sorted;
  }
  
  private static int findIndex(int[] arr, int[][] bigArr){
    for(int r = 0; r < bigArr.length; r++)
      if(Arrays.equals(arr, bigArr[r]))
        return r;
    
    return -1;
  }
  
  private static int endTimeOfLast(String lett, int[][] arr, String[] letters){
    for(int i = letters.length - 1; i >= 0; i--)
      if(letters[i] != null)
        if(letters[i].equals(lett))
          return arr[i][1];
    
    return -1;
  }
}