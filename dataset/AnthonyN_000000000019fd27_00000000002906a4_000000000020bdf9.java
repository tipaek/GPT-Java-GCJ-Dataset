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
    List<List<Object>> values = sort(arr);
    List<Integer> ambigIndexes = new ArrayList<Integer>();
    String[] out = new String[values.size()];
    
    values.get(0).set(2, "C");
    
    for(int i = 1; i < values.size(); i++){
      int startTime = ((List<Integer>)(values.get(i).get(1))).get(0);
      boolean canC = endTimeOfLast("C", values) <= startTime;
      boolean canJ = endTimeOfLast("J", values) <= startTime;
      
      if(canC && canJ){
        ambigIndexes.add(i);
        values.get(i).set(2, "C");
      }
      else if(canC)
        values.get(i).set(2, "C");
      else if(canJ)
        values.get(i).set(2, "J");
      else if(ambigIndexes.size() != 0)
        i = revert(ambigIndexes, values);
      else
        return "IMPOSSIBLE";
    }
    
    for(int i = 0; i < out.length; i++){
      int index = (Integer)(values.get(i).get(0));
      out[index] = (String)(values.get(i).get(2));
    }
    
    return String.join("", out);
  }
  
  private static int revert(List<Integer> indexes, List<List<Object>> values){
    int index = indexes.get(indexes.size() - 1);
    indexes.remove(indexes.size() - 1);
    
    for(int i = values.size() - 1; i > index; i--)
      values.get(i).set(2, "");
    
    String changeLetter = ((String)(values.get(index).get(2))).equals("C") ? "J" : "C";
    values.get(index).set(2, changeLetter);
    
    return index;
  }
  
  private static int endTimeOfLast(String lett, List<List<Object>> values){
    for(int i = values.size() - 1; i >= 0; i--)
        if(((String)(values.get(i).get(2))).equals(lett))
          return ((List<Integer>)(values.get(i).get(1))).get(1);
    
    return -1;
  }
  
  private static List<List<Object>> sort(int[][] arr){
    List<List<Object>> values = new ArrayList<List<Object>>();
    
    while(values.size() != arr.length){
      int minIndex = 0;
      
      for(int j = 1; j < arr.length; j++)
        if(
           arr[j][0] < arr[minIndex][0] || 
           (arr[j][0] == arr[minIndex][0] && arr[j][1] < arr[minIndex][1])
        )
          minIndex = j;
      
      List<Object> subValues = new ArrayList<Object>();
      
      subValues.add(minIndex);
      
      List<Integer> times = new ArrayList<Integer>();
      times.add(arr[minIndex][0]);
      times.add(arr[minIndex][1]);
      subValues.add(times);
      
      subValues.add("");
      
      values.add(subValues);
      
      arr[minIndex][0] = Integer.MAX_VALUE;
    }
    
    return values;
  }
}