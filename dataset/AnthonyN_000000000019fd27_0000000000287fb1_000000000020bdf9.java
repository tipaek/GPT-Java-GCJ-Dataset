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
    List<Integer> ambigIndexes = new ArrayList<Integer>();
    List<String> sortedOut = new ArrayList<String>();
    String[] out = new String[sorted.length];
    
    sortedOut.add("C");
    
    for(int i = 1; i < sorted.length; i++){
      boolean canC = endTimeOfLast("C", sorted, sortedOut) <= sorted[i][0];
      boolean canJ = endTimeOfLast("J", sorted, sortedOut) <= sorted[i][0];
      
      if(canC && canJ){
        ambigIndexes.add(i);
        sortedOut.add("C");
      }
      else if(canC)
        sortedOut.add("C");
      else if(canJ)
        sortedOut.add("J");
      else if(ambigIndexes.size() != 0)
        i = revert(ambigIndexes, sortedOut);
      else
        return "IMPOSSIBLE";
    }
    
    for(int i = 0; i < out.length; i++)
      out[findIndex(sorted[i], arr)] = sortedOut.get(i);
    
    
    return String.join("", out);
  }
  
  private static int revert(List<Integer> indexes, List<String> letters){
    int index = indexes.get(indexes.size() - 1);
    indexes.remove(indexes.size() - 1);
    
    int i = letters.size() - 1;
    while(i > index)
      letters.remove(i);
    
    if(letters.get(index).equals("C"))
      letters.set(index, "J");
    else
      letters.set(index, "C");
    
    return index;
  }
  
  private static int[][] sort(int[][] arr){
    int[][] sorted = new int[arr.length][2];
    for(int r = 0; r < arr.length; r++)
      for(int c = 0; c < 2; c++)
        sorted[r][c] = arr[r][c];
    
    Arrays.sort(sorted, new Comparator<int[]>(){
      public int compare(int[] a1, int[] a2){
        return a1[0] != a2[0] ? a1[0] - a2[0] : a1[1] - a2[1];
      }
    });
    
    return sorted;
  }
  
  private static int endTimeOfLast(String lett, int[][] arr, List<String> letters){
    for(int i = letters.size() - 1; i >= 0; i--)
        if(letters.get(i).equals(lett))
          return arr[i][1];
    
    return -1;
  }
  
  private static int findIndex(int[] arr, int[][] bigArr){
    for(int r = 0; r < bigArr.length; r++)
      if(bigArr[r][0] == arr[0] && bigArr[r][1] == arr[1])
        return r;
    
    return -1;
  }
}