import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t=Integer.parseInt(in.readLine());
        for(int a=0;a<t;a++){
            String str=in.readLine();
            int len=str.length();
            String ans="";
            int open=0;
            for(int b=0;b<len;b++){
                char ch=str.charAt(b);
                int digit=Integer.parseInt(ch+"");
                if(open<digit){
                    for(int c=open+1;c<=digit;c++){
                        ans+="(";
                        open++;
                    }
                }
                else if(open>digit){
                    for(int c=open-1;c>=digit;c--){
                        ans+=")";
                        open--;
                    }
                }
                ans+=ch;
            }
            for(int b=open-1;b>=0;b--)
                ans+=")";
            System.out.println("Case #"+(a+1)+": "+ans);
        }
    }
}

