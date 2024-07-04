import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        System.out.print(System.lineSeparator());
        a:
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int n = in.nextInt();
            List<Interval> intervalList = new ArrayList<>();
            int tmp1,tmp2;
            for (int itr = 0; itr < n; itr++) {
                tmp1 = in.nextInt();
                tmp2 = in.nextInt();
                intervalList.add(new Interval(tmp1,tmp2));
            }
            Collections.sort(intervalList);
            String result = "J";
            String[] worker = {"J", "C"};
            int index = 0;
            int jprefinish = intervalList.get(0).end;
            int cprefinish = 0;
            boolean imp = false;
            for (int j= 1; j< n; j++) {
                if(intervalList.get(j-1).end > intervalList.get(j).start) {
                    if (index == 0) {
                        if (cprefinish > intervalList.get(j).start) {
                            System.out.println("IMPOSSIBLE");
                            continue a;
                        }
                        index = 1;
                        cprefinish = intervalList.get(j).end;
                    } else {
                        if (jprefinish > intervalList.get(j).start) {
                            System.out.println("IMPOSSIBLE");
                            continue a;
                        }
                        index = 0;
                        jprefinish = intervalList.get(j).end;
                    }
                }
                result += worker[index];
            }
            System.out.println(result);
        }
	}
	
	static class Interval implements Comparable<Interval> {
        int start;
        int end;
        public Interval(int start, int end)
        {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }
    }
}
