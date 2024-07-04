import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        for(int i=1;i<=t;i++){
            String s=scn.next();
            StringBuilder ans=new StringBuilder();
            char ch=s.charAt(0);
            int val=(int)ch-48;
            int v=0;
            for(int j=0;j<val;j++){
                ans.append("(");

            }
            ans.append(ch);
            for(int j=1;j<s.length();j++){
                ch=s.charAt(j);
                v=(int)ch-48;
                if(v==val){
                    ans.append(v);
                }
                else if(v>val){
                    for(int k=0;k<v-val;k++){
                        ans.append("(");
                    }
                    ans.append(v);
                    val=v;
                }
                else{
                    for(int k=0;k<val-v;k++){
                        ans.append(")");
                    }
                    ans.append(v);
                    val=v;
                }
            }
            for(int k=0;k<val;k++){
                ans.append(")");
            }
            System.out.println("Case #" + i + ": " +ans);
        }
    }
}