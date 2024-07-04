import java.util.*;
class Solution {
    public static void main(String[] args){ 
        Scanner scn= new Scanner(System.in);
        int t= scn.nextInt();
        int x=1;
        while(t>0){
            int n= scn.nextInt();
            int [][]arr= new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=scn.nextInt();
                    if(i==j){
                        trace+=arr[i][j];
                    }
                }
            }
            int row=0;
            int col=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(j==0){
                    for(int k=j+1;k<n;k++){
                        if(arr[i][j]==arr[i][k]){
                            row++;
                            break;}}
                    }
                }
            }
            for(int j=0;j<n;j++){
                 for(int i=0;i<n;i++){
                    if(i==0){
                    for(int k=i+1;k<n;k++){
                        if(arr[i][j]==arr[k][j]){
                            col++;
                            break;}}
                    }
                }
            }
            
            
            System.out.println("Case #"+x+": "+trace+" "+row+" "+col);
            t--;
            x++;
        }
        scn.close();
    }
}