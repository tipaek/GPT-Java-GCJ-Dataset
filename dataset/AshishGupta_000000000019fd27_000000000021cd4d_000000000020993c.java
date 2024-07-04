import java.lang.*;
import java.util.Scanner;
public class Solution{
    public static void main(String args[]){
        int ar[][],t=0,r=0,c=0,temp=0,temp2=0;
        boolean flag1,flag2;
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();

        for(int test=1;test<=T;test++){
            t=0; r=0; c=0; temp=0;
            int n=sc.nextInt();
            ar=new int[n][n];

            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    ar[i][j]=sc.nextInt();
            
            
            while(r!=n && c!=n && n!=0){
                t+=ar[r][c];
                r++; c++;
            }

            r=0;c=0;
/*
            bl1:for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){    
                    temp=ar[i][j];
                    for(int k=j+1;k<n;k++){
                        if(temp==ar[i][k]){
                            r++;
                            continue bl1;
                        }
                    }
                }
            }

            bl2:for(int j=0;j<n;j++){
                for(int i=0;i<n;i++){
                    temp=ar[i][j];
                    for(int k=i+1;k<n;k++){
                        if(temp==ar[k][j]){
                            c++;
                            continue bl2;
                        }
                    }
                }
            }
*/

            bl1:for (int i = 0; i < n; i++) {
                flag1=false;flag2=false;
                for (int j = 0; j < n; j++) {
                    temp = ar[i][j];
                    temp2= ar[j][i];
                    for (int k = j + 1; k < n; k++) {
                        if (temp == ar[i][k] && flag1==false) {
                            r++;
                            flag1=true;
                        }
                        if (temp2 == ar[k][i] && flag2 == false){
                            c++;
                            flag2=true;
                        }
                        if(flag1==true && flag2==true)
                            continue bl1;
                    }
                }
            }

            System.out.println("case #"+test+": "+t+" "+r+" "+c+" ");

        }        
    }
}