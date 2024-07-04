
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder str = new StringBuilder("");
        for(int h=1;h<=t;h++)
        {
            str.append("Case #"+h+": ");
            int n = Integer.parseInt(br.readLine());
            Integer arr[][] = new Integer[n][2];
            for(int i=0;i<n;i++){
                String[] in = br.readLine().split(" ");
                arr[i][0]= Integer.parseInt(in[0]);
                arr[i][1]= Integer.parseInt(in[1]);
            }
            Arrays.sort(arr, (a,b)->a[0]-b[0]);
            int c =0 ;
            int j =0;
            boolean found = false;
            StringBuilder kp = new StringBuilder();
            for(int i=0;i<n;i++){
                if(arr[i][0]>=c){
                    c = arr[i][1];
                    kp.append("C");
                } else if(arr[i][0]>=j){
                    j = arr[i][1];
                    kp.append("J");
                }else{
                    found = true;
                    break;
                }
            }
            if(found){
                str.append("IMPOSSIBLE");
            } else {
                str.append(kp);
            }
            str.append("\n");
        }
        out.print(str);
        out.flush();
        br.close();
    }
}




