import java.util.Scanner;
public class Solution{
static int findTrace(int mat[][], int n) 
{ 
    int sum = 0; 
    for (int i=0; i<n; i++) 
        sum += mat[i][i]; 
    return sum; 
} 
public static void main(String args[]){
   int t,n,j,k,l,m;
   Scanner sc=new Scanner(System.in);
   t=sc.nextInt();
   int[] resr=new int[t];
   int[] resc=new int[t];
   int trace=0;
   int[] res=new int[t];
   for(int i=0;i<t;i++){
       n=sc.nextInt();
       int[][] arr=new int[n][n];
       for(j=0;j<n;j++){
          for(k=0;k<n;k++){
             arr[j][k]=sc.nextInt();
          }
       }
       res[i]=findTrace(arr,n);
       resr[i]=0;
       resc[i]=0;
       for(j=0;j<n;j++){
         for(k=0;k<n;k++){
            for(l=k+1;l<n;l++){
               if(arr[j][l]==arr[j][k])
                 break;
            }
            if(l!=n){
              resr[i]++;
              break;
            }
         }
       }
       
       for(k=0;k<n;k++){
        for(j=0;j<n;j++){
            for(m=j+1;m<n;m++){
               if(arr[m][k]==arr[j][k])
                 break;
            }
            if(m!=n){
              resc[i]++;
              break;
            }
         }
       }
       
   }
   for(int i=0;i<t;i++){
      System.out.println("Case #"+(i+1)+": "+res[i]+" "+resr[i]+" "+resc[i]);
   }
 }
}