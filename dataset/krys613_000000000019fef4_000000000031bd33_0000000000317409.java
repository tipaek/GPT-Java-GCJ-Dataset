import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int tc = 1; tc <= TC; tc++){
            //init for this test case
            String ans = "IMPOSSIBLE";
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String path = sc.next();
            char[] move = path.toCharArray();
            //start is origin
            if(X == 0 && Y == 0) ans = "0";
            //go through the points if i >= |x| + |y| return i 
            //return impossible after no valid i 
            for(int i = 1; i <= path.length(); i++){
                char m = move[i - 1];
                if(m == 'S') Y -= 1;
                if(m == 'N') Y += 1;
                if(m == 'E') X += 1;
                if(m == 'W') X -= 1;
                if(i >= Math.abs(X) + Math.abs(Y)){
                    ans = i + "";
                    break;
                }
             }
            //output
            System.out.println("Case #" + tc + ": " + ans);
        }
    }
}