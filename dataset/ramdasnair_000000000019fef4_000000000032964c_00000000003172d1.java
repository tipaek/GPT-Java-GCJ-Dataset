import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        for(int u=0; u < t; u++) {

            int n = input.nextInt();
            long d = input.nextLong();

            Long[] a = new Long[n];

            long total = 0;

            HashMap<Long, Integer> countMap = new HashMap<Long, Integer>();

            int maxCount = 0;
            int maxIndex = -1;

            for(int i=0; i < n; i++) {
                a[i] = input.nextLong();
                total += a[i];

                Integer cnt = countMap.get(a[i]);
                if (cnt == null) cnt = 0;
                cnt++;
                if (cnt > maxCount) {
                    maxCount = cnt;
                    maxIndex = i;
                }
                countMap.put(a[i], cnt);
            }

            int count = 0;

            if (maxCount >= d) {
                count = 0;
            } else {

                double avg = ((double)total)/d;
                boolean found = false;
                int cuts = 0;
                double slices = 0;

                Arrays.sort(a);

                avg = Math.min(avg, a[0]);
                for (int i = 0; i < n; i++) {

                    double curSlices = (a[i] / avg);

                    if (slices + curSlices >= d) {
                        curSlices = d - slices;
                        slices += curSlices;
                        cuts += Math.max(1, curSlices - 1);
                        break;
                    }

                    if (a[i] > avg) {
                        cuts += curSlices - 1;
                    }

                    slices += curSlices;
                }

                if (slices >= d) {
                    count = cuts;
                    found = true;
                }
            }

            String out = count + "";

            println("Case #" + (u+1) + ": " + out);
        }
    }

    private static void print(Object s) {
        System.out.print(s);
    }

    private static void println(Object s) {
        System.out.println(s);
    }

}