/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {

        // Write code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer("");
        for (int ii = 1; ii <= t; ++ii) {
            sb.append("Case #"+ii+": ");
            int ans = 0, row = 0, col = 0;
            String str = br.readLine();
            int n=str.length();
            int counter = 0;
            for (int i = 0; i < n; ++i) {
                char ch = str.charAt(i);
                int digit = Integer.parseInt(""+ch);
                if(digit>counter){
                    for(int j=counter;j<digit;++j)
                    sb.append('(');
                    sb.append(ch);
                    counter=digit;
                }else if(digit<counter){
                    for(int j=digit;j<counter;++j)
                    sb.append(')');
                    sb.append(ch);
                    counter=digit;
                }else{
                    sb.append(ch);
                }
            }
            //sb.append("|"+counter+"|");
                    for(int j=0;j<counter;++j)
                    sb.append(')');
                    sb.append("\n");
            
            }
            System.out.print(sb.toString());
    }
}
