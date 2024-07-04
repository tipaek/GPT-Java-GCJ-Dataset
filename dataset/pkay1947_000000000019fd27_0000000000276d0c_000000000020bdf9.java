import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=in.nextInt();
        for (int t=1; t<=T; t++) {
            int n=in.nextInt();
            String ans=""; boolean done=false;
            boolean[] cr=new boolean[1441]; boolean[] jr=new boolean[1441];
            for (int i=0; i<n; i++) {
                int a=in.nextInt(); int b=in.nextInt();
                if (done) continue;
                boolean flag=false;
                for (int j=a+1; j<b && !flag; j++) flag=cr[j]; 
                if (flag) {
                    flag=false;
                    for (int j=a+1; j<b && !flag; j++) flag=jr[j];
                    if (!flag) {
                        for (int j=a; j<=b; j++) jr[j]=true;
                        ans+='J';
                    } else {
                        done=true;
                    } 
                } else {
                    for (int j=a; j<=b; j++) cr[j]=true;
                    ans+='C';
                }
            }
            System.out.println("Case #" + t + ": " + (done?"IMPOSSIBLE":ans));
        }
    }
}