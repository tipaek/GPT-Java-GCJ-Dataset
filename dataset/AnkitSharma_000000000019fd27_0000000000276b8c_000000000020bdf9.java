
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int x = 1; x<=t; x++){
            int n = s.nextInt();
            StringBuffer ans = new StringBuffer("");
            boolean[] c = new boolean[1441];
            boolean[] j = new boolean[1441];
            for(int i=0; i<n; i++){
                int a = s.nextInt();
                int b = s.nextInt();
                boolean cGood = true;
                boolean jGood = true;
                for(int k = a; k<b; k++){
                    if(c[k]){
                        cGood = false;
                        break;
                    }
                }
                if(cGood){
                    for(int k = a; k<b; k++){
                        c[k] = true; 
                    }
                    ans.append("C");
                } else {
                    for(int k = a; k<b; k++){
                        if(j[k]){
                            jGood = false;
                            break;
                        }
                    }
                    if(jGood){
                       for(int k = a; k<b; k++){
                            j[k] = true; 
                        } 
                        ans.append("J");
                    }
                }
                if(!cGood && !jGood)
                    ans = new StringBuffer("IMPOSSIBLE");
                
            }
            System.out.println("Case #"+x+":"+ans);
        }
    }
}