/**
 * Created by oana on 4/5/20.
 */

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int[] s =new int[n];
            int[] e =new int[n];

            for(int j=0;j<n;j++){
                s[j]=in.nextInt();
                e[j]=in.nextInt();
            }

            String[] sch =new String[n];
            String r="";

            for(int j=0;j<n;j++){

                int overlap=0;
                String so="C";
                for(int k=j-1;k>=0;k--) {

                    if(s[j]>=s[k] && s[j]<e[k]){
                        overlap++;
                        so=sch[k];
                    } else {
                        if (e[j] > s[k] && e[j] <= e[k]) {
                            overlap++;
                            so=sch[k];
                        }
                    }

                }

                if (overlap==0){
                    r+="C";
                    sch[j]="C";
                }
                if (overlap==1){
                    if(so=="C") {
                        r += "J";
                        sch[j]="J";
                    }else{
                        r += "C";
                        sch[j]="C";
                    }
                }
                if (overlap>=2){
                    r="IMPOSSIBLE";
                }

            }

            System.out.println("Case #" + i + ": " + r);
        }
    }
}
