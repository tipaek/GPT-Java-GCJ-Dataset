import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        a:
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int n = in.nextInt();
            List<Interval> intervalList = new ArrayList<>();
            int tmp1,tmp2;
            for (int itr = 0; itr < n; itr++) {
                tmp1 = in.nextInt();
                tmp2 = in.nextInt();
                intervalList.add(new Interval(tmp1,tmp2,itr));
            }
            Collections.sort(intervalList);
            String[] worker = {"J", "C"};
            int index = 0;
            int jprefinish = intervalList.get(0).end;
            intervalList.get(0).worker = "J";
            int cprefinish = 0;
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
                intervalList.get(j).worker = worker[index];
            }
            Collections.sort(intervalList, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.originalRef - o2.originalRef;
                }
            });
            for (int j=0;j<n;j++) {
                System.out.print(intervalList.get(j).worker);
            }
            System.out.print(System.lineSeparator());
        }
	}
	
	static class Interval implements Comparable<Interval> {
        int start;
        int end;
        int originalRef;
        String worker;

        public Interval(int start, int end, int originalRef) {
            super();
            this.start = start;
            this.end = end;
            this.originalRef = originalRef;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }

    }
}
