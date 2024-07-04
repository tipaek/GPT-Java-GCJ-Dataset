import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int m = 0; m<t; m++){
            System.out.println("Case #" + m + "");
            int n = in.nextInt();
            int x = (int) (-0.5 + Math.sqrt(1+8*n)/2);
            int left = n-(x*x+x)/2 -1;
            if(left<0){
                x-=1;
            }
            left = n-(x*x+x)/2 -1;
            System.out.println(1+ " " + 1);
            int r = 2;
            int f=0;
            for(int i = 0; i<x; i++){
                System.out.println((r+i) + " " + 2);
                f = i;
            }
            r = r + f +1;
            for(int i = 0; i<left; i++){
                System.out.println((r+i) + " " + 1);
            }
            
        }
    }
}