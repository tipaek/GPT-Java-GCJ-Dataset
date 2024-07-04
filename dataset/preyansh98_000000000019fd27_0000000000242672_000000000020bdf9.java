import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i<=T; ++i){
            long start = System.nanoTime();
            int N = Integer.parseInt(br.readLine());

            int[][] times = new int[N][2];
            Map<String, Integer> map = new HashMap<>();

            for(int x = 0; x<N; x++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                times[x][0] = Integer.parseInt(st.nextToken());
                times[x][1] = Integer.parseInt(st.nextToken());

                map.put(times[x][0]+";"+times[x][1], x);
            }

            Arrays.sort(times, (a,b) -> {
                if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
                else return Integer.compare(a[0],b[0]);
            });

            //assign first to C and find soln.
            String soln = findSchedule(times, 1, "C",times[0][1], 0);

            char[] res = !soln.equals("IMPOSSIBLE") ? new char[soln.length()] : "IMPOSSIBLE".toCharArray();

            for(int j = 0; j<soln.length() && !soln.equals("IMPOSSIBLE"); j++){
                String hash = times[j][0] + ";" + times[j][1];
                res[map.get(hash)] = soln.charAt(j);
            }

            System.out.println("Case #" + i + ": " + new String(res));
        }
    }

    private static String findSchedule(int[][] times, int idx, String curr, int cFreeFrom, int jFreeFrom){
        if(curr.length() == times.length)
            return curr;

        boolean isCFree = cFreeFrom <= times[idx][0];
        boolean isJFree = jFreeFrom <= times[idx][0];

        String soln1 = null;
        String soln2 = null;

        if(isCFree)
            soln1 = findSchedule(times, idx+1, curr+"C", times[idx][1], jFreeFrom);

        if(isJFree)
            soln2 = findSchedule(times, idx+1, curr+"J", cFreeFrom, times[idx][1]);

        if(soln1 != null)
            return soln1;

        if(soln2!=null)
            return soln2;

        return "IMPOSSIBLE";
    }
}