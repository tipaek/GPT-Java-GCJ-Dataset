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

            for (int j = 0; j < y; j++) {
                int min = start.get(j);
                int minIdx = j;
                for (int z = i + 1; z < y; z++)
                    if (start.get(z) < start.get(minIdx)) {
                        minIdx = z;
                        min = start.get(z);
                    }
                start.set(minIdx, start.get(i));
                start.set(j, min);
                min = end.get(minIdx);
                end.set(minIdx, end.get(j));
                end.set(j, min);
                min = pos[minIdx];
                pos[minIdx] = pos[j];
                pos[j] = min;
            }

            char[] ans = new char[y];
            boolean notAvail = false;
            for (int j = 0; j < y; j++) {

                if (activities.get(i).get(1) < endTimeC && activities.get(i).get(1) < endTimeJ) {
                    notAvail = true;
                    break;
                } else {
                    if (activities.get(i).get(1) >= endTimeC) {
                        ans[activities.get(i).get(0)] = 'C';
                        endTimeC = activities.get(i).get(2);
                    } else {
                        ans[activities.get(i).get(0)] = 'J';
                        endTimeJ = activities.get(i).get(2);
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