import java.io.*;
import java.util.*;
public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    BufferedReader rd;
    PrintWriter wr;
    StringTokenizer tok = null;
    String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(rd.readLine());
        }
        return tok.nextToken();
    }
    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);
        int cases = Integer.parseInt(nextToken());
        for (int i = 1; i <= cases; i++) {
            int N = Integer.parseInt(nextToken());
            int[][] intervals = new int[N][2];
            Map<int[], Integer> map = new HashMap<>();
            int idx = 0;
            for (int j = 0; j < N; j++) {
                intervals[j][0] = Integer.parseInt(nextToken());
                intervals[j][1] = Integer.parseInt(nextToken());
                int[] mapKey = intervals[j];
                map.put(mapKey, idx);
                idx++;
            }
            Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[0]));
            wr.println(String.format("Case #%d: %s", i, subSolve(intervals, map))); 
        }
        rd.close();
        wr.close();
    }
    
    private String subSolve(int[][] intervals, Map<int[], Integer> map) {
        Map<Integer, String> outputMap = new HashMap<>();
        int CEnd = 0;
        int JEnd = 0;
        for (int[] interval : intervals) {
            int idx = map.get(interval);
            int start = interval[0];
            int end = interval[1];
            if (CEnd == 0) {
                CEnd = end;
                outputMap.put(idx, "C");
            } else {
                if (CEnd <= start) {
                    CEnd = end;
                    outputMap.put(idx, "C"); 
                } else if (JEnd <= start){
                    JEnd = end;
                    outputMap.put(idx, "J"); 
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < outputMap.size(); i++) {
            sb.append(outputMap.get(i));
        }
        return sb.toString();
    }
    
}