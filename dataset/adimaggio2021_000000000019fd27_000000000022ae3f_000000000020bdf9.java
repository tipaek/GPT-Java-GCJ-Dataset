import java.util.*;
import java.io.*;
import java.lang.*; 

public class Solution{
    public static void main(String[] args){
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
        for(int m = 0; m<n;m++){
            int x = in.nextInt();
            boolean flag = true;
            int [][]f = new int[x][2];
            for(int i = 0; i<x;i++){
                f[i][0] = in.nextInt();
                f[i][1] = in.nextInt();
            }
            int [] tm = new int [24*60];
            for(int i = 0; i<x;i++){
                tm[f[i][0]] += 1;
                tm[f[i][1]] += -1;
            }
            
            int count = 0;
            for(int i = 0; i<24*60;i++){
                count += tm[i];
                if(count>2){
                    flag = false;
                    break;
                }
            }
            if(flag){
                int c = f[0][1]; 
                int j = -1;
                String res = "C";
                for(int i = 1; i<x;i++){
                    if(f[i][0] >= c){
                        c  = -1;
                    }
                    if(f[i][0] >= j){
                        j  = -1;
                    }
                    if(c == -1){
                        c = f[i][1];
                        res += "C";
                    }
                    if(j == -1){
                        j = f[i][1];
                        res += "J";
                    }
                    System.out.println("Case #" + (m+1) + ": "  +res); 
                }
            }else{
                System.out.println("Case #" + (m+1) + ": "  +"IMPOSSIBLE"); 
            }
        }
    }
}