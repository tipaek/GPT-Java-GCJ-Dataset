// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Solver s = new Solver();
        s.solve();
    }
}

class Solver{
    void solve(){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int tc = 1; tc <= t; tc++) {
        int x = in.nextInt();
        int y = in.nextInt();
        String path = in.nextLine();
        int ans = 0;
        int diff = x+y;
        for(char move: path.toCharArray()){
            if(move=='N'){
               if(y<0){
                    y++;
                   if(x!=0){
                        x+= (x<0) ? 1:-1;
                    }
                    else if(y!=0){
                        y++;
                    }
                   else break;
                }
            }
            else if(move=='S'){
               if(y>0){
                    y--;
                    if(x!=0){
                        x+= (x<0) ? 1:-1;
                    }
                    else if(y!=0){
                        y--;
                    }
                   else break;
               }
            }
            if(move=='E'){
               if(x<0){
                    x++;
                   if(y!=0){
                        y+= (y<0) ? 1:-1;
                    }
                    else if(x!=0){
                        x++;
                    }
                   else break;
                }
            }
            else if(move=='W'){
               if(x>0){
                    x--;
                    if(y!=0){
                        y+= (y<0) ? 1:-1;
                    }
                    else if(x!=0){
                        x--;
                    }
                   else break;
               }
            }
            if(x==0&&y==0) break;
            ans++;
        }
        if(x==0&&y==0) System.out.println("Case #" + tc + ": " + ans);
        else System.out.println("Case #" + tc + ": IMPOSSIBLE");
    }
    }
}