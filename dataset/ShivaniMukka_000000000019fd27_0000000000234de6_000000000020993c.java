import java.util.*;
import java.io.*;

class sol{
 public static void main(String[] args){
    Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int num=0,num1=0;
    int t=in.nextInt();
    for(int i=1;i<=t;i++){
        int n=in.nextInt();
        int[][] arr=new int[n][n];
        int[][] row=new int[n][10];
        int[][] col=new int[n][10];
        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                arr[j][k]=in.nextInt();
                
            }
        }
        int r1=0,r2=0,r3=0;
        
        for(int m=0;m<n;m++){
            r1+=arr[m][m];
            }
        
        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                num=arr[j][k];
                num1=arr[k][j];
                row[j][num]++;
                col[k][num]++;
            }
        }
        r2=0;r3=0;
        for(int j=0;j<n;j++){
            for(int k=0;k<10;k++){
               // System.out.println(row[j][k]);
                
                if(row[j][k]>r2){
                    r2=row[j][k];
                    //System.out.println(row[j][k]+"inloop");
                    }
                
                if(col[j][k]>r3){
                    r3=col[j][k];
                }
            }
        }
        
        if(r2==1){
            r2=0;
        }
        if(r3==1){
            r3=0;
        }
        System.out.println("Case #"+i+": "+r1+" "+r2+" "+r3);
    }
    }
    }