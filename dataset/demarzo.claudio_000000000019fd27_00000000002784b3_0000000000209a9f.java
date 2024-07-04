import java.util.*;
import java.io.*;
    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
            String data=in.next();
            String ris="";
            int d=0;
            for(int j=0; j<data.length(); j++){
                int x = Integer.parseInt(data.charAt(j)+"");
                if(x>d){        //add
                    for(int z=0; z<x-d; z++){
                        ris+="(";
                    }
                    d=x;
                }else if(x<d){      //rem
                    for(int z=0; z<d-x; z++){
                        ris+=")";
                    }
                    d=x;
                }else{} //dn
                ris+=""+x;
                
            }
            while(d!=0){
                d--;
                ris+=")";
            }
            System.out.println("Case #" + i + ": " + ris);
        }
    }
}