import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <=t; ++i) {
            int n = in.nextInt();
            ArrayList<Activity> initialList = new ArrayList<>(n);
            for (int j=0;j<n;j++){
                initialList.add(new Activity(in.nextInt(), in.nextInt(), j));
            }
            System.out.println("Case #" + i + ": " + getOutput(initialList));
        }
    }

    private static String getOutput(List<Activity> intialList) {
        List<Activity> activityList = new ArrayList<>(intialList);
        int cLast = -1;
        int jlast= -1;
        String[] output = new String[activityList.size()];
        Collections.sort(activityList, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                if(a1.start<a2.start){
                    return -1;
                } else if (a1.start == a2.start) {
                    if(a1.end < a2.end) {
                        return -1;
                    }
                }
                return 1;
            }
        });

        //System.out.println(activityList);
        boolean impossible = false;
        for(Activity a: activityList) {
            if(cLast == -1 || (cLast <= a.start)){
                output[a.pos]= "C";
                cLast = a.end;
            }else if (jlast == -1 || (jlast <= a.start)){
                output[a.pos] = "J";
                jlast = a.end;
            }else{
                output[a.pos] = "U";
                impossible = true;
                break;
            }
        }

        if(impossible){
            cLast = -1;
            jlast = -1;
            impossible = false;
            output = new String[activityList.size()];
            for(Activity a: activityList) {
                if(jlast == -1 || (jlast <= a.start)){
                    output[a.pos]= "J";
                    jlast = a.end;
                }else if (cLast == -1 || (cLast <= a.start)){
                    output[a.pos] = "C";
                    cLast = a.end;
                }else{
                    output[a.pos] = "U";
                    impossible = true;
                    break;
                }
            }
        }

        if(impossible) {
            return "IMPOSSIBLE";
        }

        StringBuilder res = new StringBuilder();

        for(int i=0;i<output.length;i++){
            res.append(output[i]);
        }
        return res.toString();
    }


    private static class Activity {
        private int start;
        private int end;
        private int pos;

        public Activity(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }

        @Override
        public String toString(){
            return "Activity[" + start +","+ end + ","+ pos +"]";
        }
    }
}
