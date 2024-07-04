import java.util.*;
import java.io.*;
class Solution{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int kk=1;
        while(t-->0){
            int n=sc.nextInt();
            int[][] arr=new int[n][n];
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
            }
            int trace=0;
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                if(i==j) trace+=arr[i][j];
                }
            }
            Set<Integer> hs=new HashSet<>();
            int row=0,col=0;
            int i=0,j=0;
            for(i=0;i<n;i++){
                
                for(j=0;j<n;j++){
                   
                   hs.add(arr[i][j]);
                   
                    
                }
                if(hs.size()!=n){
                    
                    row++;
                }
                hs.clear();
                
                
                
            }
            
            for(i=0;i<n;i++){
                
                for(j=0;j<n;j++){
                   
                   hs.add(arr[j][i]);
                   
                    
                }
                if(hs.size()!=n){
                    
                    col++;
                }
                hs.clear();
                
                
                
            }
            
            
            
            
            
            
            
            
            System.out.println("Case #"+kk+": "+trace+" "+row+" "+col);
            kk+=1;
        }
        
    }
    
}