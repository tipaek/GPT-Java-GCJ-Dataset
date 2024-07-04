import java.util.*;
public class Solution {
    public static void main(String... args){
        
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int i = 1;i<=testcase;i++){
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            int rsum = 0;
            for(int j =0 ; j<n;j++){
               // arr[j][] = new int[n];
                for(int k =0 ; k<n;k++){
                    arr[j][k] = sc.nextInt();
                    rsum+= j==k? arr[j][k]:0;
                }            
            }
            System.out.print("Case #"+i+": "+rsum);
            int r =0,c=0;
            for(int j =0 ; j<n;j++){
            Set<Integer> hash_set = new HashSet<Integer>();
              for(int k =0 ; k<n;k++){
                    if(hash_set.contains(arr[j][k])){
                    r++;
                    break;
                    }
                    hash_set.add(arr[j][k]);
                }            
            }
            
            for(int j =0 ; j<n;j++){
            Set<Integer> hash_set = new HashSet<Integer>();
                for(int k =0 ; k<n;k++){
                    if(hash_set.contains(arr[k][j])){
                    c++;
                    break;
                    }
                    hash_set.add(arr[k][j]);
                }            
            }
            System.out.println(r+" "+c);
        }
    }
}