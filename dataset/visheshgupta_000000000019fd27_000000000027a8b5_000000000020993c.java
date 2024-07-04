import java.util.*;
import java.io.*;
public class Solution {
 public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        int count=1;
        while(count<=t){
            int n=scn.nextInt();
            Integer[][] arr=new Integer[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=scn.nextInt();
                }
            }
            int row=0;
            int col=0;
            int value=0;
            HashSet<Integer> map=new HashSet<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map.contains(arr[i][j])){
                        row++;

                        break;
                    }
                    else map.add(arr[i][j]);
                }
                map.clear();
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map.contains(arr[j][i])){
                        col++;

                        break;
                    }
                    else map.add(arr[j][i]);
                }
                map.clear();
            }

            for(int i=0;i<n;i++){
                value+=arr[i][i];
            }
            System.out.println("Case #"+count+": "+value+" "+row+" "+col);
            count++;
        }
    }
}