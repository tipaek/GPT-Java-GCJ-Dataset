import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String S = br.readLine(), modS = "";
            // add parenthesis to the beginning
            for (int k = 0; k < Integer.parseInt(S.charAt(0)+""); k++, modS += "(");
            modS += S.charAt(0);

            for (int j = 1; j < S.length() ; j++) {
                if(S.charAt(j) > S.charAt(j-1)){
                    int diff = S.charAt(j) - S.charAt(j-1);
                    char[] temp = new char[diff];
                    Arrays.fill(temp, '(');
                    modS += new String(temp);
                }
                else if(S.charAt(j) < S.charAt(j-1)){
                    int diff = S.charAt(j - 1) - S.charAt(j);
                    char[] temp = new char[diff];
                    Arrays.fill(temp, ')');
                    modS += new String(temp);
                }
                modS += S.charAt(j);
            }

            // add a parenthesis to the end
            for (int k = 0; k < Integer.parseInt(S.charAt(S.length() - 1)+""); k++, modS += ")");

            bw.write("Case #" + (i+1) + ": " + modS + "\n");
        }
        bw.flush();
    }
}
