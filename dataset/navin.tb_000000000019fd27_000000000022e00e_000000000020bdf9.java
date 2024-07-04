import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    for(int t=1;t<=testCases;t++) {
      int n = in.nextInt();
      List<Pair> activities = new ArrayList<>();
      for(int i=0;i<n;i++) {
        activities.add(new Pair(in.nextInt(), in.nextInt()));
      }
      List<Pair> sortedActivities = activities
        .stream()
        .sorted(Comparator.comparingInt(Pair::getKey))
        .collect(Collectors.toList());
      int jamieEnd = 0;
      int cameronEnd = 0;
      Map<Pair, String> map = new HashMap<>();
      boolean isSuccess = true;
      StringBuilder result = new StringBuilder();
      for(Pair activity : sortedActivities) {
        if(activity.getKey() >= jamieEnd) {
          map.put(activity, "C");
          jamieEnd = activity.getValue();
        } else if(activity.getKey() >= cameronEnd) {
          map.put(activity, "J");
          cameronEnd = activity.getValue();
        } else {
          isSuccess = false;
          result.append("IMPOSSIBLE");
          break;
        }
      }
      if(isSuccess) {
        for(Pair pair : activities) {
          result.append(map.get(pair));
        }
      }
      System.out.println("Case #" + t +": "+result.toString());
    }
  }
}

class Pair {
  Integer key;
  Integer value;
  
  Pair(Integer key, Integer value) {
    this.key = key;
    this.value = value;
  }
  
  Pair(){
  
  }
  Integer getKey(){
    return this.key;
  }
  
  Integer getValue() {
    return this.value;
  }
}

