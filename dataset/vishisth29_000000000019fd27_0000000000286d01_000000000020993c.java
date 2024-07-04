import java.io.*;
import java.util.*;
public class Solution {

    public static void main(String args[]) {

        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        for(int a=1;a<=t;a++){
            int n=scn.nextInt();
            int [][] arr=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=scn.nextInt();
                }
            }
            int k=0;
            for(int i=0;i<n;i++){
                k=k+arr[i][i];
            }


            int r=0,c=0;

            int res=0;
            for(int i=0;i<n;i++){
                Set<Integer> set=new HashSet<>();

                for(int j=0;j<n;j++){
                    if(set.contains(arr[i][j])){
                        res++;
                        break;
                    }
                    set.add(arr[i][j]);
                }
            }

            r=res;
            res=0;

            for(int i=0;i<n;i++){
                Set<Integer> set=new HashSet<>();

                for(int j=0;j<n;j++){
                    if(set.contains(arr[j][i])){
                        res++;
                        break;
                    }
                    set.add(arr[j][i]);
                }
            }
            c=res;
            System.out.print("Case #"+a+": "+k+" "+r+" "+c);

        }
    }





    }
