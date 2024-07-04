

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{

    


    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int t =sc.nextInt();


        for(int i=0;i<t;i++){

            int n = sc.nextInt();

            int arr [][] = new int [n][n];

            for(int j=0;j<n;j++)
                for(int k=0;k<n;k++)
                    arr[j][k] = sc.nextInt();

            int row =0;
            //check row
            for(int j=0;j<n;j++){
                if(!checkRow(arr,j))row++;
            }

            int col =0;
            //check col
            for(int j=0;j<n;j++){
                if(!checkCol(arr,j))col++;
            }

            System.out.println("Case #" +(i+1) +": "+trace(arr) +" "+ row+" " + col);
        }


        
        

        
    }

    public static boolean checkRow(int [][] arr, int row){
        
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        int n= arr.length;
        for(int i=0;i<n;i++){
            if(arr[row][i]>n || arr[row][i]<0)return false;
            
            if(map.containsKey(arr[row][i]))return false;
            else map.put(arr[row][i],true);
        }
        return true;
    }


    public static boolean checkCol(int [][] arr, int col){
        
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        int n =arr.length;
        for(int i=0;i<n;i++){

            if(arr[i][col]>n || arr[i][col]<0)return false;
            // sum+=;
            if(map.containsKey(arr[i][col]))return false;
            else map.put(arr[i][col],true);
        }
        return true;
    }

    public static int trace(int [][] arr){
        int sum =0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
        }
        return sum;
    }

}