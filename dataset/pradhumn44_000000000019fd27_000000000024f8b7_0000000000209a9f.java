import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.next());
        for(int i = 1 ; i <= t ; i++){
            String str = s.next();
            String arr[] = str.split("");

            int n = arr.length;
            int ar[] = new int[n];

            for(int j = 0 ; j < n ; j++)
            ar[j] = Integer.parseInt(arr[j]);
            
            String ans = "";
            
            for(int j = 0 ; j < ar[0] ; j++)
            ans += "(";
            int flag = 0;
            // int nop[] = new int[n+1];
            // nop[0] = ar[0];
            // nop[n] = 0 - ar[n-1];

            // for(int j = 0 ; j < n-1 ; j++)
            // nop[j+1] = ar[j+1] - ar[j];

            //code for mid
            for(int j = 0 ; j < n-1 ; j++){
                ans += arr[j];
                if(flag == 1 && ar[j+1] > ar[j]){
                    for(int k = 0 ; k < ar[j] ; k++)
                    ans += ")";
                    for(int k = 0 ; k < ar[j+1] ; k++)
                    ans += "(";
                    flag = 0;
                }else if(flag == 0 && ar[j] > ar[j+1]){
                    flag = 1;
                    int x = Math.abs(ar[j] - ar[j+1]);
                    for(int k = 0 ; k < x ; k++)
                    ans += ")";
                }else{
                    int x = Math.abs(ar[j] - ar[j+1]);
                    if(flag == 0){
                        for(int k = 0 ; k < x ; k++)
                        ans += "(";
                    }
                    if(flag == 1){
                        for(int k = 0 ; k < x ; k++)
                        ans += ")";
                    }
                }
            }

            //code of end
            ans += arr[n-1];
            for(int j = 0 ; j < ar[n-1] ; j++)
            ans += ")";

            // for(int j = 0 ; j <= n ; j++)
            // System.out.print(nop[j]+" ");
            System.out.println(ans);
        }
    }
}