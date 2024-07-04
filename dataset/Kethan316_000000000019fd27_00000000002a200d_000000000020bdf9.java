import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= x; i++) {
            int endC = 0;
            int endJ = 0;
            int y = Integer.parseInt(bf.readLine());
            ArrayList<ArrayList<Integer>> activities = new ArrayList<ArrayList<Integer>>();
            for (int j = 0; j < y; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                list.add(Integer.parseInt(st.nextToken()));
                list.add(Integer.parseInt(st.nextToken()));
                activities.add(list);
            }

            Collections.sort(activities, new Comparator<ArrayList<Integer>>() {
                public int compare(ArrayList<Integer> x, ArrayList<Integer> y) {
                    return x.get(1) - y.get(1);
                }
            });
            char[] ans = new char[y];
            boolean notAvail = false;
            for (int j = 0; j < y; j++) {

                if (activities.get(j).get(1) < endC && activities.get(j).get(1) < endJ) {
                    notAvail = true;
                    break;
                } else {
                    if (activities.get(j).get(1) >= endC) {
                        ans[activities.get(j).get(0)] = 'C';
                        endC = activities.get(j).get(2);
                    } else {
                        ans[activities.get(j).get(0)] = 'J';
                        endJ = activities.get(j).get(2);
                    }
                }
            }
            if (notAvail)
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            else
                System.out.println("Case #" + i + ": " + new String(ans));
        }
    }
}