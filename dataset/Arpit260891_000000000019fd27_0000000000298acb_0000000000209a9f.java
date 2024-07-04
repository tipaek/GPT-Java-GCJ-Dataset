import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int count = 1;
        while (count <= t) {

            String Snew = "";

            String[] S = br.readLine().split("");
            for(int i = 0;i<S.length;i++) {

                int k = Integer.parseInt(S[i]);
                if(i == 0 && k == 0) Snew+= S[i];
                else if(i == 0){
                    
                    Snew+=new Solution().addOpen(k) + S[i];
                    if(i == S.length - 1) Snew+=new Solution().addClose(k);
                    
                } 
                else if(k == 0) Snew+=new Solution().addClose(Integer.parseInt(S[i-1])) + S[i];
                else if(k == Integer.parseInt(S[i-1])) Snew+=S[i];
                else if(k < Integer.parseInt(S[i-1])) {

                    Snew+= new Solution().addClose(Integer.parseInt(S[i-1]) - k) + S[i];
                    if(i == S.length - 1) Snew+=new Solution().addClose(k);
                }
                else if(k > Integer.parseInt(S[i-1])) {

                    Snew+=new Solution().addClose(Integer.parseInt(S[i-1])) + new Solution().addOpen(k) + S[i];
                    if(i == S.length - 1) Snew+=new Solution().addClose(k);
                }

            }

            System.out.println("Case #" + count + ": " + Snew);
            count++;
        }
    }

    public String addOpen(int n) {

        String s = "";
        for(int i = 0;i<n;i++) {
            s+='(';
        }

        return s;

    }

    public String addClose(int n) {

        String s = "";
        for(int i = 0;i<n;i++) {
            s+=')';
        }

        return s;

    }
}
