import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int c = 1; c <= t; c++) {
            int n = Integer.parseInt(br.readLine());
            char[] Cday = new char[1441];
            char[] Jday = new char[1441];
            for (int i = 0; i <= 1440; i++) {
                Cday[i] = '0';
                Jday[i] = '0';
            }
            
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().trim().split("\\s+");
                start[i] = Integer.parseInt(str[0]);
                end[i] = Integer.parseInt(str[1]);
            }
            
            StringBuilder res = new StringBuilder();
            boolean isPossible = true;
            
            for (int i = 0; i < n; i++) {
                int s = start[i];
                int e = end[i];
                
                boolean canAssignC = true;
                boolean canAssignJ = true;
                
                for (int j = s + 1; j <= e; j++) {
                    if (Cday[j] == '1') {
                        canAssignC = false;
                    }
                    if (Jday[j] == '2') {
                        canAssignJ = false;
                    }
                }
                
                if (canAssignC) {
                    for (int j = s; j <= e; j++) {
                        Cday[j] = '1';
                    }
                    res.append('C');
                } else if (canAssignJ) {
                    for (int j = s; j <= e; j++) {
                        Jday[j] = '2';
                    }
                    res.append('J');
                } else {
                    System.out.println("Case #" + c + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + c + ": " + res.toString());
            }
        }
    }
}