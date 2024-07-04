

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for(int b=1; b<=t; b++){
            int n=s.nextInt();
            int[][] a=new int[n][n];
            int trace=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    a[i][j]=s.nextInt();
                }
            }
            for(int i=0; i<n; i++)
                trace+=a[i][i];
            int row=0, column=0;
            boolean flag=true;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    for(int k=j+1; k<n; k++){
                        if(a[i][j]==a[i][k]){
                            row++;
                            flag=false;
                            break;
                        }
                    }
                    if(!flag)
                        break;
                }
            }
            flag=true;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    for(int k=j+1; k<n; k++){
                        if(a[j][i]==a[k][i]){
                            column++;
                            flag=false;
                            break;
                        }
                    }
                    if(!flag)
                        break;
                }
            }
            System.out.println("Case #"+b+": "+trace+" "+row+" "+column);
        }
    }
}
