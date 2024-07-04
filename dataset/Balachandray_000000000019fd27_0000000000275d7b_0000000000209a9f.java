import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        for(int c=0;c<t;c++){
            String s = ip.next();
            String sol = "";
            int[] a = new int[s.length()];
            for(int i=0;i<s.length();i++){
                a[i] = s.charAt(i)-'0';
            }
            int j = 0;
            System.out.print("Case #"+(c+1)+": ");
            while(j<a.length){
                if(a[j] == 0){
                    sol += "0";
                }else{
                    if(j-1>=0){
                        if(a[j-1] < a[j])
                        {
                            sol += left(a[j]-a[j-1])+""+a[j];
                        }else{
                            sol += ""+a[j];
                        }
                    }else{
                        sol += left(a[j])+""+a[j];    
                    }
                    
                    
                    if(j+1< a.length){
                        if(a[j+1] < a[j]){
                            sol += right(a[j]-a[j+1]);    
                        }
                    }else{
                        sol += right(a[j]);
                    }
                }
                j++;
            }
            System.out.println(sol);
        }
    }
    public static String left(int l){
        String sol = "";
        for(int i=0;i<l;i++){
            sol += "(";
        }
        return sol;
    }
    public static String right(int r){
        String sol = "";
        for(int i=0;i<r;i++){
            sol += ")";
        }
        return sol;
    }
}