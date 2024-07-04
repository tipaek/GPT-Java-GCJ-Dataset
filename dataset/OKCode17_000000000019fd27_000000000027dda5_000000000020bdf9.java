import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;

    private void solve() {
        int num = sc.nextInt();
        Map<String, List<Integer>> map = new HashMap<>();
        int[][] intervals = new int[num][2];
        for(int i=0;i<num;i++){
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            if(!map.containsKey(intervals[i][0]+","+intervals[i][1]))
                map.put(intervals[i][0]+","+intervals[i][1], new ArrayList<>());
            map.get(intervals[i][0]+","+intervals[i][1]).add(i);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        int j = 0;
        int c = 0;
        boolean impossible = false;
        char[] ans = new char[num];
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            if(start<j && start<c) {
                impossible = true;
                break;
            }
            List<Integer> list = map.get(start+","+end);
            if(start<c){
                j = end;
                ans[list.get(0)] = 'J';
            }else{
                c = end;
                ans[list.get(0)] = 'C';
            }
            list.remove(0);
        }
        out.println(impossible?"IMPOSSIBLE":new String(ans));
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
