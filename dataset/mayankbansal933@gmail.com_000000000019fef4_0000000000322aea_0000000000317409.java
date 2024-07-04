import java.io.*;
import java.util.*;
class Triple{
    int x;
    int y;
    int d;
    Triple(int x,int y,int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
class Solution{
    public static void main(String []arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            String []s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            String m = s[2];
            int ans = Integer.MAX_VALUE;
            for(int i=0;i<m.length();i++){
                if(m.charAt(i) == 'S'){
                    y --;
                }else if(m.charAt(i) == 'N'){
                    y ++;
                }else if(m.charAt(i) == 'W'){
                    x --;
                }else{
                    x ++;
                }
                if(Math.abs(x) + Math.abs(y) <= (i+1)){
                    ans = Math.min(ans , (i+1));
                }
            }
            
            if(ans == Integer.MAX_VALUE){
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }else{
                System.out.println("Case #" + t + ": " + ans);
            }
        }
    }
}