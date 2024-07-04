/* @author Stephen
 * @date 2020-01-27
 * @time 14:32
 */

import static java.lang.Math.*;
import static java.util.Arrays.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Solution {
    private Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    void solve(){
        int T=in.nextInt();
        for(int t=1;t<=T;t++){
            int op=0,cp=0;
            String str=in.next();
            StringBuilder builder=new StringBuilder();
            for(int i=0;i<str.length();i++){
                if(i==0){
                    for(int j=0;j<str.charAt(i)-'0';j++) builder.append('(');
                    builder.append(str.charAt(i));
//                    pre= str.charAt(i)-'0';
                    op=str.charAt(i)-'0';
                }
                else {
                    int var1=0;
                    if((var1=str.charAt(i)-'0')>=op){
                        for(int j=0;j<var1-op;j++) builder.append('(');
                        builder.append(str.charAt(i));
                        op=var1;
                    }
                    else {
                        for(int j=0;j<op-var1;j++) {
                            builder.append(')');
                        }
                        builder.append(str.charAt(i));
                        op=var1;

                    }
                }

            }
            for(int i=1;i<=op;i++) builder.append(')');
            System.out.println("Case #"+t+": "+builder.toString());
        }
    }
    public static void main(String[] args){
        new Solution().solve();

    }
}