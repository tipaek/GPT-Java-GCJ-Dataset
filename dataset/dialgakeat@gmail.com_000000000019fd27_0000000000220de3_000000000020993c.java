import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        
        for(int i=1 ; i<=t; i++){
            int n = scan.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            int arr[][] = new int[n][n];
            
            for (int a = 0 ; a < n; a++){
                for (int b = 0 ; b < n; b++){
                    arr[a][b] = scan.nextInt();
                    if(a == b){
                        k+=arr[a][b];
                    }
                }
                HashSet set = new HashSet();
                for (int x : arr[a]) {
                    if (set.add(x) == false) {
                        r++;
                        break;
                    }
                }
            }
            
            for (int a = 0 ; a < n; a++){
                HashSet set = new HashSet();
                for (int b = 0 ; b < n; b++){
                    if (set.add(arr[b][a]) == false) {
                        c++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + k + " " + r + " " +c);
            
        }
    }
}