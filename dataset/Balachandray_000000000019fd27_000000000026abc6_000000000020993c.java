import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        for(int c=0;c<t;c++){
            int n = ip.nextInt();
            int trace = 0;
            int row = 0;
            int col = 0;
            int[][] a= new int[n][n];
            for(int i=0;i<n;i++){
                HashSet<Integer> set = new HashSet<>();
                boolean row_flag = false;
                for(int j=0;j<n;j++){
                    int temp = ip.nextInt();
                    a[i][j]=temp;
                    if(i==j){
                        trace+= temp;
                    }
                    if(set.contains(temp))
                        row_flag = true;
                    else
                        set.add(temp);
                }
                row = (row_flag == true)?row+1:row;
            }
            int column=0;
            while(column<n){
                HashSet<Integer> set = new HashSet<>();
                boolean col_flag = false;
                for(int i=0;i<n;i++){
                    if(set.contains(a[i][column])){
                        col_flag = true;
                        break;
                    }else{
                        set.add(a[i][column]);
                    }
                }
                col = (col_flag == true)?col+1:col;
                column++;
            }
            
            System.out.println("Case #"+(c+1)+": "+trace+" "+row+" "+col);
        }
    }
}