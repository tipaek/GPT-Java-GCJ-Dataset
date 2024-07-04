import java.io.File;
import java.io.PrintStream;
import java.util.*;

public class Solution {
    static String   FILENAME;
    static Scanner sc;
    static String   IN;
    static String   OUT;
    static PrintStream out;

    static{
        try{
            /*
            FILENAME = "Solution-large";
            IN = FILENAME + ".in";
            OUT = FILENAME + ".out";
            sc = new Scanner(new File(IN));
            out      = new PrintStream(
                    new FileOutputStream(OUT, false));
                    */

            //IN = "C:\\GitProjects\\algorithm_practice\\src\\main\\java\\GoogleCodeJam\\Y2020\\Quali\\C\\C-test.in";
            IN = null;
            if(IN == null)
                sc = new Scanner(System.in);
            else
                sc = new Scanner(new File(IN));
            out = new PrintStream(System.out);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private String solve(List<Activity> input){
        String result;
        Collections.sort(input, (a, b) -> a.start - b.start);

        int jend = -1;
        int cend = -1;

        for(int i=0; i<input.size(); ++i){
            Activity act = input.get(i);
            if(jend <= act.start){
                act.assigned ='J';
                jend = act.end;
            }
            else if(cend <= act.start){
                act.assigned ='C';
                cend = act.end;
            }
            else
                return "IMPOSSIBLE";
        }

        Collections.sort(input, (a, b) -> a.index - b.index);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.size(); ++i)
            sb.append(input.get(i).assigned);
        return sb.toString();
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");

            int n = sc.nextInt();
            List<Activity> acts = new ArrayList<>();
            for(int j=0; j<n; ++j){
                int s = sc.nextInt();
                int e = sc.nextInt();
                acts.add(new Activity(j, s, e));
            }
            String result = solve(acts);
            out.println(result);
        }
        sc.close();
        out.close();
    }

    static class Activity{
        public int index;
        public int start;
        public int end;
        public char assigned;

        public Activity(int i, int s, int e){
            index = i; start=s; end=e;
        }
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
