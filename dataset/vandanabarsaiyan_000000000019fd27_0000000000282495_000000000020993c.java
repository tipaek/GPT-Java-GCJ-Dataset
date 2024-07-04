
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int n=in.nextInt(),s=0,f1=0,f2=0;
            int a[][]=new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                   a[j][k]=in.nextInt();
                   if(j==k) 
                   s+=a[j][k];
                  
                }
            }
            for(int j=0;j<n;j++){
                l:
                for(int k=0;k<n-1;k++){
                   for(int h=k+1;h<n;h++){
                       if(a[j][k]==a[j][h]){
                       f1++;
                       break l;}
                   }
                   
                }
            }
            for(int j=0;j<n;j++){
                le:
                for(int k=0;k<n-1;k++){
                    for(int h=k+1;h<n;h++){
                        if(a[k][j]==a[h][j]){
                            f2++;
                            break le;
                        }
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+s+" "+f1+" "+f2);
        }
    }
}