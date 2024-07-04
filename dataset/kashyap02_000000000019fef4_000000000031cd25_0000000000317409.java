import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String s = sc.next();

            int ans = X;
            int curY = Y;
            int curX = 0;

            if(X <= s.length()) {
                for (int i = 0; i < X; i++) {
                    if (s.charAt(i) == 'N')
                        curY++;
                    else
                        curY--;
                }

                if(curX == curY) {
                    System.out.println("Case #" + t + ": " + ans);
                    continue;
                }

                s = s.substring(X);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }
//            System.out.println(curX + " " + curY + " " + s);
            int flag = 0;

            if(s.length() > 0 && flag == 0){
                for(int i = 0; i < s.length(); i++){
                    if(curX == curY){
                        flag = 1;
                        break;
                    }
                    if(curY >= 0){
                        if(s.charAt(i) == 'N'){
                            curY++;
                            ans++;
                            if(curX == curY) {
                                flag = 1;
                                break;
                            }
                            curX++;
                        }else {
                            curY--;
                            ans++;
                            if(curX == curY) {
                                flag = 1;
                                break;
                            }
                            curX++;
                        }
                    } else {
                        if(s.charAt(i) == 'S'){
                            curY--;
                            ans++;
                            if(curX == curY) {
                                flag = 1;
                                break;
                            }
                            curX--;
                        } else {
                            curY++;
                            ans++;
                            if(curX == curY) {
                                flag = 1;
                                break;
                            }
                            curX--;
                        }
                    }
                }
            }
            if(flag == 1)
                System.out.println("Case #" + t + ": " + ans);
            else
                System.out.println("Case #" + t + ": IMPOSSIBLE");
        }
    }
}
