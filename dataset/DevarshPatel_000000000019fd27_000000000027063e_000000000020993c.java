package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<String> string = new ArrayList<>();
        for(int temp=0;temp<k;temp++){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int l=0;l<n;l++){
                for(int m=0;m<n;m++){
                    arr[l][m] = sc.nextInt();
                }
            }
            string.add(solve(arr,n));
        }
        int  temp = 0;
        for (String s: string
             ) {
            temp += 1;
            System.out.println("Case #"+temp+": " +s);
        }
    }
    public static String solve(int arr[][],int n) {
        int trace = 0;
        for(int i=0;i<n;i++){
            trace += arr[i][i];
        }
        return (trace + " " + rowsSame(arr,n) + " " + colsSame(arr,n));
    }

    public static int rowsSame(int arr[][], int n){
        int same = 0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> map = new HashMap<>();
            aa : for(int j=0;j<n;j++){
                if(map.containsKey(arr[i][j])){
                    same +=1;
                    break aa;
                }
                else{
                    map.put(arr[i][j],0);
                }
            }
        }
        return same;
    }

    public static int colsSame(int arr[][], int n){
        int same = 0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> map = new HashMap<>();
            aa : for(int j=0;j<n;j++){
                if(map.containsKey(arr[j][i])){
                    same +=1;
                    break aa;
                }
                else{
                    map.put(arr[j][i],0);
                }
            }
        }
        return same;
    }
}

class Solver {


}