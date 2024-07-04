import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            ArrayList<Integer> arrList = new ArrayList<>();
            int trace = 0;
            int rowflag = 0;
            int colflag = 0;
            int[][] arr = new int[n][n];
            for(int j=0;j<n;j++){
                arrList.clear();
                for(int k=0;k<n;k++){
                    arr[j][k] = sc.nextInt();
                    if(!arrList.contains(arr[j][k]))
                        arrList.add(arr[j][k]);
                    if(j == k)
                        trace += arr[j][k];
                }
                if(arrList.size() != n)
                    rowflag++;
            }
            arrList.clear();
            for(int j=0;j<n;j++){
                arrList.clear();
                for(int k=0;k<n;k++){
                    if(!arrList.contains(arr[k][j]))
                        arrList.add(arr[k][j]);
                }
                if(arrList.size() != n)
                    colflag++;
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+rowflag+" "+colflag);
        }
    }
}