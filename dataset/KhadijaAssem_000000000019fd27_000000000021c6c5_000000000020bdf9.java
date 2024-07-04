
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int k = 0; k < t; k++) {
            int n = input.nextInt();
            ArrayList<task> ts = new ArrayList<>();
            person j = new person();
            j.busy = false;
            person c = new person();
            c.busy = false;
            for(int i=0;i<n;i++){
                ts.add(i,new task());
                ts.get(i).st = input.nextInt();
                ts.get(i).en = input.nextInt();
                ts.get(i).num = i;
            }
            Collections.sort(ts, new Comparator<task>() {
                @Override
                public int compare(task p1, task p2) {
                    return p1.st - p2.st;
                }
            });
//            for (int i =0;i<n;i++)
//                System.out.println(ts.get(i).st+ " " + ts.get(i).en+" "+ts.get(i).num);
            char[] output = new char[n];
            for(int i=0;i<n;i++){
//                System.out.println(ts.get(i).st+ " " + ts.get(i).en+" "+ts.get(i).num);
                if (j.busy&&j.tDone(ts.get(i).st)) j.busy = false;
                if (c.busy&&c.tDone(ts.get(i).st)) c.busy = false;
                if(j.busy){
                    if(c.busy){
                        String str = "IMPOSSIBLE";
                        output = str.toCharArray();
                        break;
                    }
                    c.st = ts.get(i).st;
                    c.en = ts.get(i).en;
                    c.busy = true;
                    output[ts.get(i).num] = 'J';
//                    System.out.println("Assigned to C");
                }
                else {
                    j.st = ts.get(i).st;
                    j.en = ts.get(i).en;
                    j.busy = true;
                    output[ts.get(i).num] = 'C';
//                    System.out.println("Assigned to J");
                }
            }

            System.out.println("Case #" + (k+1) + ": "+new String(output));
        }
    }
    private static class person{
        int st,en,task;
        boolean busy;
        public boolean tDone(int now){
//            System.out.print(now);
//            System.out.println("Will end "+this.en);
            if(now>=this.en) return true;
            return false;
        }
    }
    private static class task implements Comparable{
        int st,en,num;

        public int compareTo(Object o) {
            return 0;
        }
    }
}
