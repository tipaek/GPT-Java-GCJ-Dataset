import java.util.*;
public class Solution{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int t = 1;
        while(t<=T){
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            int length = s.length();
            int arr[] = new int[length+1];
            arr[0] = x+y;
            for(int i=0;i<length;i++){
                int dx=0;
                int dy=0;
                if(s.charAt(i)=='N'){
                    dx = 0;
                    dy = 1;
                }
                if(s.charAt(i)=='E'){
                    dx = 1;
                    dy = 0;
                }
                if(s.charAt(i)=='S'){
                    dx = 0;
                    dy = -1;
                }
                if(s.charAt(i)=='W'){
                    dx = -1;
                    dy = 0;
                }
                x += dx;
                y += dy;
                arr[i+1] = Math.abs(x)+Math.abs(y);
            }
            
            
            int ans = -1;
            for(int i=0;i<arr.length;i++){
                if(arr[i]<=i){
                    ans = i;
                    break;
                }
            }
            
            System.out.print("Case #"+t+": ");
            if(ans==-1){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(ans);
            }
            t++;
        }
    }
}