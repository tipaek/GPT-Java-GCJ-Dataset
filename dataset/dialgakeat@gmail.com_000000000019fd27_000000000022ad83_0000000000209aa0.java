import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        
        for(int i = 1; i<=t ; i++){
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[3*n];
            for(int a = 0; a<n ; a++){
                arr[a] = a+1;
            }
            for(int a = 0; a<n ; a++){
                arr[n+a] = a+1;
            }
            for(int a = 0; a<n ; a++){
                arr[2*n+a] = a+1;
            }
            if(k%n != 0){
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+i+": POSSIBLE");
                int s = k/n+n-1;
                for(int a = 0; a<n ; a++){
                    for(int b = 0; b<n ; b++){
                        System.out.print(arr[s+b] + " ");
                    }
                    System.out.println();
                    s--;
                }
                
            }
            
        }
    }
}
