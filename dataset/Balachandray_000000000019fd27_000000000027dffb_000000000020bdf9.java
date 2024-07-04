import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        for(int c=0;c<t;c++){
            int n = ip.nextInt();
            int[][] a = new int[n][2];
            for(int i=0;i<n;i++){
                a[i][0] = ip.nextInt();
                a[i][1] = ip.nextInt();
            }
            
            System.out.print("Case #"+(c+1)+": ");
            boolean flag = true;
            String sol = "";
            int C[][] = new int[1][2];
            int J[][] = new int[1][2];
            for(int i=0;i<n;i++){
                if(i == 0){
                    sol += "C";
                    C[0][0] = a[i][0];
                    C[0][1] = a[i][1];
                }else{
                    if(C[0][1] <= a[i][0]){
                        sol += "C";
                        C[0][0] = a[i][0];
                        C[0][1] = a[i][1];
                    }else if(J[0][1] <= a[i][0]){
                        sol += "J";
                        J[0][0] = a[i][0];
                        J[0][1] = a[i][1];
                    }else{
                        if(C[0][0] >= a[i][0] && C[0][1] >= a[i][1] ){
                            sol += "C";
                        }else if(J[0][0] >= a[i][0] && J[0][1] >= a[i][1] ){
                            sol += "J";
                        }else{
                            sol = "IMPOSSIBLE";
                            break;    
                        }
                        
                    }
                }
            }
            System.out.println(sol);
        }
    }
}