import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args)throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int z=1;
        while(z<=t){
            int n = s.nextInt();
            
            int arr[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = s.nextInt();
            }
            }
            
            int sum = 0;
            HashSet<Integer> set = new HashSet<>();
            
            for(int i = 0;i<n;i++){
                sum +=arr[i][i];
            }
            
            int r = 0,c = 0;
            for(int i = 0;i<n;i++){
                set.clear();
                set.add(arr[i][0]);
                
                for(int j = 1;j<n;j++){
                    if(set.contains(arr[i][j])){
                     r++;
                     break;
                    }
                  set.add(arr[i][j]);
                }
            }
            
            for(int j = 0;j<n;j++){
                set.clear();
                set.add(arr[0][j]);
                
                for(int i = 1;i<n;i++){
                    if(set.contains(arr[i][j])){
                     c++;
                     break;
                    }
                  set.add(arr[i][j]);
                }
            }
            // if(r!=0) r++;
            // if(c!=0) c++;
            System.out.println("Case #"+z+": "+sum+" "+(r)+" "+(c));
            z++;
        }
    }
}