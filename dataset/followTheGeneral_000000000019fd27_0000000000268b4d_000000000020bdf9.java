import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        int currentCase = 1;
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            
            while (testCases-- > 0) {
                System.out.println("Case #" + currentCase++ + ": " + findResult(br));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    String findResult (BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean[] c = new boolean[2400];
        boolean[] j = new boolean[2400];
        
        int lines = Integer.parseInt(br.readLine());
        for (int i = 0; i < lines; ++i) {
            String[] arr = br.readLine().split("\\s+");
            int start = Integer.parseInt(arr[0]);
            int end = Integer.parseInt(arr[1]);
            
            boolean[] currentParent;
            
            if(!c[start] && !c[end]) {
                currentParent = c;
                sb.append('C');
            } else if (!j[start] && !j[end]) {
                currentParent = j;
                sb.append('J');
            } else {
                while (++i < lines) {
                    br.readLine();
                }
                return IMPOSSIBLE;
            }
            
            int endTime = end -1;
            while(start++ < endTime) {
                currentParent[start] = true;
            }
        }
        return sb.toString();
    }

}