
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder str = new StringBuilder("");
        for(int h=1;h<=t;h++)
        {
            str.append("Case #"+h+":\n");
            int n = Integer.parseInt(br.readLine());
            int k = (int)(Math.log(n)/Math.log(2))+1;
            boolean startFromLeft = true;
            while(n>0) {
                int sum = (int)Math.pow(2, k-1);
                addRowElem(str, k, startFromLeft, true, 0);
                startFromLeft = !startFromLeft;
                n = n-sum;
                k--;
                if(n<Math.pow(2, k-1)){
                    break;
                }
            }
            if(n>0){
                addRowElem(str, k, startFromLeft, false, n);
                n-=k;
                startFromLeft = !startFromLeft;
            }
            if(n>0){
                addRowElem(str, k, startFromLeft, false, n);
                n-=k;
            }

        }
        out.print(str);
        out.flush();
        br.close();
    }

    private static void addRowElem(StringBuilder str, int k, boolean startFromleft, boolean include, int n ) {
        if(include) {
            if(startFromleft) {
                for (int i = 1; i <= k; i++) {
                    str.append(k+" "+i + "\n");
                }
            }else{
                for (int i = k; i >= 1; i--) {
                    str.append(k+" "+i + "\n");
                }
            }
        } else {
            if(startFromleft) {
                for (int i = k; i >= 1; i--) {
                    str.append(1+" "+i+ "\n");
                    n--;
                    if(n==0){
                        break;
                    }
                }
            }else{
                for (int i = k; i >= 1; i--) {
                    str.append(i+" "+i + "\n");
                    n--;
                    if(n==0){
                        break;
                    }
                }
            }

        }
    }


}
