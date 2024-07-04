import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution {
    
    private static void printArr(int arr[][]){
        
        for(int i[] : arr){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println("");
        }
        
    }
    
    public static void main(String[] args) throws Exception{
        try {
            
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            int test = Integer.parseInt(br.readLine());
            
            for(int t=1; t<= test; t++){
                
                int n = Integer.parseInt(br.readLine());
                
                int arr[][] = new int[n][n];
                String str[] =null;
                int i,j;
                
                for(i=0; i<n ;i++){
                    str = br.readLine().split(" ");
                    for(j=0; j<n; j++){
                        arr[i][j] = Integer.parseInt(str[j]);
                    }
                }
               
                int k=0;
                for(i=0,j=0;i<n;i++,j++){
                    k += arr[i][j];
                }
                TreeSet<Integer> set;
                int c=0,r=0;
                //row
                for(i=0; i<n;i++){
                    set = new TreeSet<>();
                    for( j=0;j<n;j++){
                        if(set.contains(arr[i][j])){
                            r++;    
                            break;
                        }
                        else{
                            set.add(arr[i][j]);
                        }
                    }
                }
                for(i=0; i<n;i++){
                    set = new TreeSet<>();
                    for( j=0;j<n;j++){
                        if(set.contains(arr[j][i])){
                            c++;    
                            break;
                        }
                        else{
                            set.add(arr[j][i]);
                        }
                    }
                }
                
                System.out.println("Case #" + t + ": " + k +" " + r + " " + c);
                
                
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
