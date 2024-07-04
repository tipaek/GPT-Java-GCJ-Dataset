import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {

  private static Scanner sc;

  public static void main(String[] args){
    Solution solution = new Solution();
    sc = new Scanner(System.in);
    solution.initTestCase(solution.getInput());
  }

  private List<Map<Integer, Integer>> getInput() {

    int T = getValue();

    List<Map<Integer, Integer>> testCases = new ArrayList();
    for (int i = 0; i < T; i++) {
      int N = getValue();
      Map<Integer, Integer> test = new HashMap<>(N);
      for (int j = 0; j < N; j++) {
        test.put(sc.nextInt(),  sc.nextInt());
      }
      testCases.add(test);
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
      Map<String, Integer> sch = new HashMap();
      for (Map.Entry<Integer, Integer> hours : testCase.entrySet()) {
        sb = solve(hours, sch, sb);
      }
      System.out.println("Case #" + (caseN++) +": " + sb);
    }
  }

  public String solve(Map.Entry<Integer, Integer> hours,  Map<String, Integer> sch, String sb){

    if(!sch.containsKey("C") ||  sch.get("C") <= hours.getKey()){
      sch.put("C", hours.getValue());
      sb = sb.concat("C");
    } else if(!sch.containsKey("J") ||  sch.get("J") <= hours.getKey()){
      sch.put("J", hours.getValue());
      sb = sb.concat("J");
    } else {
      sb = "IMPOSSIBLE";
    }
    return sb;
  }

}