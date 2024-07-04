
import java.io.*;
import java.util.*;
class Solution {
    public static void main (String[] args) {
        //System.out.println("GfG!");
        int t;
        Scanner sc = new Scanner(System.in);
        t =sc.nextInt();
        int cse = 0;
        while(t--!=0){
            cse++;
            String s = sc.next();
            String ans = "";
            int rem=0;
            int prev=0;
            for(int i=0;i<s.length();i++){
                String tmp = "";
                char c = s.charAt(i);
                tmp+=c;
                int k = Integer.parseInt(tmp);
                if(i==0){
                for(int j=1;j<=k;j++)
                    ans+='(';
                ans+=c;
                }
                else{
                    if(prev<k){
                        int x = k-prev;
                        for(int j=1;j<=x;j++)
                            ans+='(';
                        ans+=c;
                    }
                    if(prev>k){
                        int x = prev-k;
                        for(int j=1;j<=x;j++)
                            ans+=')';
                        ans+=c;
                    }
                    if(prev==k)
                        ans+=c;

                }
                if(i==s.length()-1){
                    for(int j=1;j<=k;j++)
                        ans+=')';
                }
                prev=k;

            }


            System.out.println("Case #"+cse+": "+ans);
            //while
        }


    }}
