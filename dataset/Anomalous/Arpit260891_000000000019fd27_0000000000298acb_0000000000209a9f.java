import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int count = 1; count <= t; count++) {
            StringBuilder Snew = new StringBuilder();
            String[] S = br.readLine().split("");
            
            for (int i = 0; i < S.length; i++) {
                int k = Integer.parseInt(S[i]);
                
                if (i == 0) {
                    if (k != 0) {
                        Snew.append(addOpen(k));
                    }
                    Snew.append(S[i]);
                    
                    if (i == S.length - 1) {
                        Snew.append(addClose(k));
                    }
                } else {
                    int prev = Integer.parseInt(S[i - 1]);
                    
                    if (k == 0) {
                        Snew.append(addClose(prev)).append(S[i]);
                    } else if (k == prev) {
                        Snew.append(S[i]);
                    } else if (k < prev) {
                        Snew.append(addClose(prev - k)).append(S[i]);
                        
                        if (i == S.length - 1) {
                            Snew.append(addClose(k));
                        }
                    } else {
                        Snew.append(addClose(prev)).append(addOpen(k)).append(S[i]);
                        
                        if (i == S.length - 1) {
                            Snew.append(addClose(k));
                        }
                    }
                }
            }
            
            System.out.println("Case #" + count + ": " + Snew.toString());
        }
    }

    private static String addOpen(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append('(');
        }
        return s.toString();
    }

    private static String addClose(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(')');
        }
        return s.toString();
    }
}