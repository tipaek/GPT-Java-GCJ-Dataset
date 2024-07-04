import java.util.*;
import java.io.*;
import java.math.*;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int trace=0;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    a[j][k]=sc.nextInt();
                    if(j==k){
                        trace+=a[j][k];
                    }
                }
            }
            int rows=0;
            int cols=0;
            for(int j=0;j<n;j++){
                HashSet<Integer> hs=new HashSet<Integer>();
                for(int k=0;k<n;k++){
                    if(hs.contains(a[j][k])){
                        rows++;
                        break;
                    }
                    hs.add(a[j][k]);
                }
            }
            for(int j=0;j<n;j++){
                HashSet<Integer> hset=new HashSet<Integer>();
                for(int k=0;k<n;k++){
                    if(hset.contains(a[k][j])){
                        cols++;
                        break;
                    }
                    hset.add(a[k][j]);
                }
            }
            System.out.println("Case #"+(i+1)+":"+" "+trace+" "+rows+" "+cols);
        }
    }
}