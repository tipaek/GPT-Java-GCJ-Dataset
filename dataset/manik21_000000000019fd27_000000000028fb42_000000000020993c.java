import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner scan= new Scanner (System.in);
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            int mat=scan.nextInt();
            int arr[][]=new int[mat][mat];
            for(int j=0;j<mat;j++){
                for(int k=0;k<mat;k++){
                    arr[j][k]=scan.nextInt();
                }
            }
            
            int sum=0;
            for(int j=0;j<mat;j++){
                for(int k=0;k<mat;k++){
                    
                   if(k==j) sum+=arr[j][k];
                }
            }
            System.out.print("Case #"+i+": "+sum+" ");
            int row=0,col=0;
            boolean bre ,bre1;
        for(int c=0;c<mat;c++){
            bre=false;bre1=false;
           for(int a=0;a<mat;a++){
               for(int b=a+1;b<mat;b++){
                   if(arr[c][a]==arr[c][b]){
                      row++; bre=true;
                       break;}
               }
                      if(bre)
                       break;
           }
           
           
           
           for(int a=0;a<mat;a++){
               for(int b=a+1;b<mat;b++){
                   if(arr[a][c]==arr[b][c]){
                      col++; bre1=true;
                       break;}
               }
                      if(bre1)
                       break;
           }
         
        }
        System.out.println(row+" "+col); 
      }
        
    }
}