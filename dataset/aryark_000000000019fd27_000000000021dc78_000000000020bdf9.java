import java.util.*;

public class Solution
{
    public static void main (String [] args) {
        Solution s = new Solution();
        s.run();
    }
    
    public void run()
    {
      Scanner scan = new Scanner(System.in);
      int T = scan.nextInt();
      for (int a = 0; a < T; a++) {
        int N = scan.nextInt();
        String ans = "";
        boolean possible = true;
        ArrayList<Activity> listC = new ArrayList<Activity>();
        ArrayList<Activity> listJ = new ArrayList<Activity>();
        ArrayList<Activity> wholeList = new ArrayList<Activity>();
        for (int i = 0; i < N; i++) {
          //System.out.println(listC+" "+ans);
          int start = scan.nextInt();
          int end = scan.nextInt();
          wholeList.add(new Activity(start, end));
        }
        //System.out.println(wholeList);
        for (int i = 0; i < wholeList.size(); i++) {
          if (!possible) continue;
          Activity act = wholeList.get(i);
          //System.out.println("activity created");
          int cSize = listC.size();
          int jSize = listJ.size();
          if (i == 0) {
            listC.add(act);
            ans += "C";
            //System.out.println("i = 0 done");
          } else {
            //System.out.println("i > 0 loop entered");
            if (activityOverlaps(cSize, act, listC)) {
              if (jSize == 0) {
                listJ.add(act);
                ans += "J";
              } else {
                if (activityOverlaps(jSize, act, listJ)) {
                  possible = false;
                } else {
                  listJ.add(act);
                  ans += "J";
                }
              }
            } else {
              listC.add(act);
              ans += "C";
            }
          }
          //System.out.println("iteration done");
        }
        System.out.print("Case #"+(a+1)+": ");
        if (possible) System.out.println(ans);
        else System.out.println("IMPOSSIBLE");
      }
    }

    public boolean activityOverlaps(int size, Activity a, ArrayList<Activity> list) {
      for (int i = 0; i < size; i++) {
        if (a.overlap(list.get(i))) return true;
      }
      return false;
    }

    class Activity {
      private int start, end;
      public Activity(int s, int e) {start = s; end = e;}

      public boolean overlap(Activity act)
      {
        if (act.start >= start && act.start < end) return true;
        if (start >= act.start && start < act.end) return true;
        return false;
      }

      public String toString() {
        return "("+start+", "+end+")";
      }
    }
}

