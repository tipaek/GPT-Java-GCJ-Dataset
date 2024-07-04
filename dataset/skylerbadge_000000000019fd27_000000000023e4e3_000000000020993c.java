import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, tr, cc, cr,i,j,ind;
        sc.nextLine();
        for(int z = 1; z<=t;z++){
            n = sc.nextInt();
            tr=0;
            cr=0;
            cc=0;
            int m[][] = new int[n][n];
            for(i=0; i<n; i++){
                for(j=0;j<n;j++){
                    m[i][j] = sc.nextInt();
                    if(i==j) tr+= m[i][j];
                }
            }
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    ind = Math.abs(m[i][j])-1;
                    if(m[i][ind]<0){
                        cr++;
                        break;
                    }
                    m[i][ind] = -m[i][ind];
                }
            }
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    m[i][j] = Math.abs(m[i][j]);
                }
            }
            for(j=0;j<n;j++){
                for(i=0;i<n;i++){
                    ind = Math.abs(m[i][j])-1;
                    if(m[ind][j]<0){
                        cc++;
                        break;
                    }
                    m[ind][j] = -m[ind][j];
                }
            }
            System.out.println("Case #"+z+": "+tr+" "+cr+" "+cc);
        }
    }
}
