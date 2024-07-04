// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9
// TIME - O(n^2) cuz of Selection Sort
package random;
import java.io.*;
import java.util.*;

public class cj2020_parentingpartneringreturns {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int test = 1; test <= t; test++ ) {

            int endTimeC = 0, endTimeJ = 0;
            int n = Integer.parseInt(buf.readLine());
            // ACTIVITY -> (#position, START time, END time)
            ArrayList<ArrayList<Integer>> activities = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < n; i++) { 
                StringTokenizer st = new StringTokenizer(buf.readLine());
                ArrayList<Integer> list = new ArrayList<Integer>(); // Not init with inner class {{}}
                // error: local variables referenced from an inner class must be final or effectively final (cause: var i)
                list.add(i);
                list.add(Integer.parseInt(st.nextToken()));
                list.add(Integer.parseInt(st.nextToken()));
                activities.add(list);
            }

            // Sort based on START time
            Collections.sort(activities, new Comparator<ArrayList<Integer>>() {
                public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                    return a.get(1) - b.get(1);
                }
            });

            char[] ans = new char[n];
            boolean busy = false;
            for(int i = 0; i < n; i++) {

                if(activities.get(i).get(1) < endTimeC && activities.get(i).get(1) < endTimeJ) { // BOTH BUSY
                    busy = true;
                    break;
                }
                else {
                    if(activities.get(i).get(1) >= endTimeC) {
                        ans[activities.get(i).get(0)] = 'C';
                        endTimeC = activities.get(i).get(2);
                    }
                    else {
                        ans[activities.get(i).get(0)] = 'J';
                        endTimeJ = activities.get(i).get(2);
                    }
                }
            }
            if(busy)
                System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
            else
                System.out.println("Case #" + test + ": " + new String(ans));
        }
    } 
}
