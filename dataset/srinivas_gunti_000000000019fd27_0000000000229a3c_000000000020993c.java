import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        int k=1;
        
        while(t-- >0){
            int n = sc.nextInt();
            
            int arr[][] = new int[n][n];
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            
            vestigium(arr, n,k);
            
            k++;
        }
    }
    
    static void vestigium(int arr[][], int n, int m){
        int k =0;
        
        for(int i=0;i<n;i++){
            k=k+arr[i][i];
        }
        
        int r=0;
        
        for(int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<Integer>();
            
            for(int j=0;j<n;j++){
                if(set.contains(arr[i][j])){
                    r++;
                    break;
                }
                else
                    set.add(arr[i][j]);
            }
            
        }
        
         int c=0;
        
        for(int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<Integer>();
            
            for(int j=0;j<n;j++){
                if(set.contains(arr[j][i])){
                    c++;
                    break;
                }
                else
                    set.add(arr[j][i]);
            }
            
        }
        
        System.out.println("Case #"+m+": "+k+ " "+ r+ " "+c);

    }
}



