import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        List<int[][]> list = new ArrayList<>();
        for(int t=0; t<T; t++) {
            int N = in.nextInt();
            int[][] time = new int[N][2];
            for(int i=0; i<N; i++) {
                time[i][0] = in.nextInt();
                time[i][1] = in.nextInt();
            }
            list.add(time);
        }

        for(int i=0; i<T; i++) {
            output(list.get(i), i);
        }
    }

    private static void output(int[][] times, int testCaseNo) {
        int[] cTime = new int[] {0, 0};
        int[] jTime = new int[] {0, 0};
        StringBuilder sb = new StringBuilder();
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int[] time: times) {
            int startTime = time[0];
            int endTime = time[1];

            if(startTime >= cTime[1]) {
                sb.append("C");
                if(cTime[0] == 0) cTime[0] = startTime;
                cTime[1] = endTime;
            } else if (startTime >= jTime[1]) {
                sb.append("J");
                if(jTime[0] == 0) jTime[0] = startTime;
                jTime[1] = endTime;
            } else {
                System.out.println("Case #" + (testCaseNo+1) + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + (testCaseNo+1) + ": " + sb.toString());
    }
}
