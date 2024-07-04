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
            int start = Integer.parseInt(arr[0]) + 1;
            int end = Integer.parseInt(arr[1]) - 1;
            
            boolean[] currentParent;
            
            if(!c[start] && !c[start + 1] && !c[end] && !c[end - 1]) {
                currentParent = c;
                sb.append('C');
            } else if (!j[start] && !j[start + 1] && !j[end] && !j[end -1]) {
                currentParent = j;
                sb.append('J');
            } else {
                while (++i < lines) {
                    br.readLine();
                }
                return IMPOSSIBLE;
            }
            
            while(start <= end) {
                currentParent[start] = true;
                ++start;
            }
        }
        return sb.toString();
    }

}