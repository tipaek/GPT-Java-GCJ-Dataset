package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.pow;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        int x = 0;
        while (x < t) {
            boolean fg=false;
            String ans = "";
            int a,b;
            t t1  = new t();
            t t2 = new t();

            String[] input = reader.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);

            Queue<t> q = new LinkedList<>();
            q.add(t1);

            for(int j=0;j<4;j++) {
                for(int i = 0; i< pow(4,j); i++) {
                    t1=q.peek();
                    if(t1.x==a && t1.y==b) {
                        fg=true; ans=t1.s;
                        break;
                    }
                    else {
                        q.remove();
                        t2 = new t((int) (t1.x+ pow(2,j)), t1.y, t1.s+"E");
                        q.add(t2);
                        t2 = new t((int) (t1.x- pow(2,j)), t1.y, t1.s+"W");
                        q.add(t2);
                        t2 = new t(t1.x, (int) (t1.y+pow(2,j)), t1.s+"N");
                        q.add(t2);
                        t2 = new t(t1.x, (int) (t1.y-pow(2,j)), t1.s+"S");
                        q.add(t2);
                    }
                }
                if(fg) break;
            }
            if(!fg) ans="IMPOSSIBLE";
            System.out.println("Case #"+(x+1)+": "+ ans);
            x++;
        }
    }
}

class t {
        int x,y;
        String s;

        t(){
            x = 0;
            y = 0;
            s = "";
        }

        t(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
}
