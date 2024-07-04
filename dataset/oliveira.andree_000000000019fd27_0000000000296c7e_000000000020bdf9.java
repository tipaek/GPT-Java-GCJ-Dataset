import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {

  private static Scanner sc;

  public static void main(String[] args){
    Solution solution = new Solution();
    sc = new Scanner(System.in);
    solution.initTestCase(solution.getInput());
  }

  private List<Map<Integer, Integer>> getInput() {

    int T = getValue();
    List<Map<Integer, Integer>> testCases = new ArrayList(T);
    for (int i = 0; i < T; i++) {
      int N = getValue();
      Map<Integer, Integer> testCase = new LinkedHashMap<>(N);
      for (int j = 0; j < N; j++) {
        testCase.put(sc.nextInt(), sc.nextInt());
      }
      testCases.add(testCase);
    }
    return testCases;
  }

  private static int getValue() {
    return sc.nextInt();
  }

  public void initTestCase(List<Map<Integer, Integer>> testCases){
    int caseN = 1;
    for (Map<Integer, Integer> testCase : testCases) {
      String sb = "";
      Map<String, Map<Integer, Integer>> sch = new HashMap();
      for (Map.Entry<Integer, Integer> activity : testCase.entrySet()) {
        sb = solve(activity, sch, sb);
      }
      System.out.println("Case #" + (caseN++) +": " + sb);
    }
  }

  public String solve(Map.Entry<Integer, Integer> activity,  Map<String, Map<Integer, Integer>> sch, String sb){

    if(!sch.containsKey("J") || nonOverlap(sch.get("J"), activity)){
      if (!sch.containsKey("J")) sch.put("J", new LinkedHashMap<>());
      sch.get("J").put(activity.getKey(), activity.getValue()); return sb.concat("J");
    } else if(!sch.containsKey("C") || nonOverlap(sch.get("C"), activity)){
      if (!sch.containsKey("C")) sch.put("C", new LinkedHashMap<>());
      sch.get("C").put(activity.getKey(), activity.getValue()); return sb + "C";
    }
    return "IMPOSSIBLE";
  }

  private boolean nonOverlap(Map<Integer, Integer> actMap, Map.Entry<Integer, Integer> nextAct) {
    for(Map.Entry<Integer, Integer> ac : actMap.entrySet()){
      if (overlap(ac, nextAct)){
        return false;
      }
    }
    return true;
  }

  boolean overlap(Map.Entry<Integer, Integer> activity,  Map.Entry<Integer, Integer> nextAct){
    return (nextAct.getKey() >= activity.getKey() && nextAct.getKey() < activity.getValue())
        || (nextAct.getValue() > activity.getKey() && nextAct.getValue() <= activity.getValue());
  }

}