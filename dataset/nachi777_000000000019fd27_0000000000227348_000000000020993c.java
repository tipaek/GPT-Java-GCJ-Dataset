/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution{
    public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int k=1;k<=t;k++){
                int n=Integer.parseInt(br.readLine());
                int[][] arr=new int[n][n];
                for(int i=0;i<n;i++){
                    String[] s=br.readLine().split(" ");
                    for(int j=0;j<n;j++)
                    arr[i][j]=Integer.parseInt(s[j]);
                }
                HashSet<Integer> set=new HashSet<>();
                int r=0;
                for(int i=0;i<n;i++){
                    set.clear();
                    for(int j=0;j<n;j++){
                        if(set.contains(arr[i][j])){
                            r++;
                            break;
                        }
                        set.add(arr[i][j]);
                    }
                }
                
                int c=0;
                for(int i=0;i<n;i++){
                    set.clear();
                    for(int j=0;j<n;j++){
                        if(set.contains(arr[j][i])){
                            c++;
                            break;
                        }
                        set.add(arr[j][i]);
                    }
                }
                int sum=0;
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(i==j)
                          sum+=arr[i][j];
                    }
                }
                System.out.println("Case #"+k+": "+sum+" "+r+" "+c);
            }
    }
}