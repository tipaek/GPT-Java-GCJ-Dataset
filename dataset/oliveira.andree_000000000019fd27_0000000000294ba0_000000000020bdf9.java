import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * NestingDepth
 */
class Solution {

  private static Scanner sc;

  public static void main(String[] args){
    Solution solution = new Solution();
    sc = new Scanner(System.in);
    solution.initTestCase(solution.getInput());
  }

  private List<List<Activity>> getInput() {

    int T = getValue();
    List<List<Activity>> testCases = new ArrayList(T);
    for (int i = 0; i < T; i++) {
      int N = getValue();
      List<Activity> testCase = new ArrayList<>(N);
      for (int j = 0; j < N; j++) {
        testCase.add(new Activity(sc.nextInt(), sc.nextInt()));
      }
      testCases.add(testCase);
    }
    return testCases;
  }

  private static int getValue() {
    return sc.nextInt();
  }

  public void initTestCase(List<List<Activity>> testCases){
    int caseN = 1;
    for (List<Activity> testCase : testCases) {
      String sb = "";
      Map<String, List<Activity>> sch = new HashMap();
      for (Activity activity : testCase) {
        sb = solve(activity, sch, sb);
      }
      System.out.println("Case #" + (caseN++) +": " + sb);
    }
  }

  public String solve(Activity activity,  Map<String, List<Activity>> sch, String sb){

    if(!sch.containsKey("C") || nonOverlap(sch.get("C"), activity)){
      if (!sch.containsKey("C")) sch.put("C", new ArrayList<>());
      sch.get("C").add(activity); return sb + "C";
    } else if(!sch.containsKey("J") || nonOverlap(sch.get("J"), activity)){
      if (!sch.containsKey("J")) sch.put("J", new ArrayList<>());
      sch.get("J").add(activity); return sb.concat("J");
    }
    return "IMPOSSIBLE";
  }

  private boolean nonOverlap(List<Activity> c, Activity nextA) {
    for(Activity ac : c){
      if (ac.overlap(nextA)){
        return false;
      }
    }
    return true;
  }

  class Activity{
    public int start;
    public int end;

    Activity(int pStart, int pEnd){
      this.start = pStart;
      this.end = pEnd;
    }

    boolean overlap(Activity activity){
      return (activity.start >= start && activity.start < end)
          || (activity.end > start && activity.end <= end);
    }


  }

}