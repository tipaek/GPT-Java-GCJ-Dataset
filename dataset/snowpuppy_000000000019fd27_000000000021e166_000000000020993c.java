import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.Math;
class Solution{
    public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    for(int i=1;i<=t;i++){
    	int n=sc.nextInt();
    	int trace=0;
    	int arr[][]=new int[n][n];
        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                arr[j][k]=sc.nextInt();
                if(j==k){trace+=arr[j][k];}
            }
        }
        int r=0,c=0;
        for(int j=0;j<n;j++){
            HashSet<Integer> set=new HashSet();
            for(int k=0;k<n;k++){
                if(set.contains(arr[j][k])){r++;break;}
                set.add(arr[j][k]);
            }
        }
        for(int j=0;j<n;j++){
            HashSet<Integer> set=new HashSet();
            for(int k=0;k<n;k++){
                if(set.contains(arr[k][j])){c++;break;}
                set.add(arr[k][j]);
            }
        }
        System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
    }
    }
}