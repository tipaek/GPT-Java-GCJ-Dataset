import java.io.*;
import java.util.*;

public class Solution {
    static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(in.nextLine());

        ArrayList<String> answers = new ArrayList<>();
        for(int q=1; q<=cases; q++) {
            String data = in.nextLine();
            int A = Integer.parseInt(data.split(" ")[0]);
            int B = Integer.parseInt(data.split(" ")[1]);
            boolean found = false;
            int hitx = 0;
            int hity = 0;
            for(int i=-1; i<=1; i++) {
                for(int j=-1; j<=1; j++) {
                    String ans = query(i*500000000 + " " + j*500000000);
                    if(ans.equals("CORRECT")) continue;
                    if(ans.equals("HIT")) {
                        found = true;
                        hitx = i*500000000;
                        hity = j*500000000;
                        break;
                    }
                }
                if(found) break;
            }
            if(!found) continue;
            int delta;
            int cx; int cy;
            
            int rx = hitx;
            int lx = hitx;
            delta = B;
            while(Math.abs(delta) > 1) {
                rx += delta;
                String ans = query(rx + " " + hity);
                if(ans.equals("CORRECT")) break;
                if(ans.equals("HIT")) delta /= 2;
                else delta /= -2;
            }
            delta = (-1) * B;
            while(Math.abs(delta) > 1) {
                rx += delta;
                String ans = query(rx + " " + hity);
                if(ans.equals("CORRECT")) break;
                if(ans.equals("HIT")) delta /= 2;
                else delta /= -2;
            }
            cx = (rx + lx) / 2;

            int uy = hity;
            int dy = hity;
            delta = B;
            while(Math.abs(delta) > 1) {
                uy += delta;
                String ans = query(hitx + " " + uy);
                if(ans.equals("CORRECT")) break;
                if(ans.equals("HIT")) delta /= 2;
                else delta /= -2;
            }
            delta = (-1) * B;
            while(Math.abs(delta) > 1) {
                dy += delta;
                String ans = query(hitx + " " + dy);
                if(ans.equals("CORRECT")) break;
                if(ans.equals("HIT")) delta /= 2;
                else delta /= -2;
            }
            cy = (uy + dy) / 2;
            String answer = "";
            found = false;
            for(int i=-1; i<=1; i++) {
                for(int j=-1; j<=1; j++) {
                    answer = query((cx + i) + " " + (cy + j));
                    if(answer.equals("HIT")) {
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }
        }

        for(String s : answers) System.out.println(s);
    }

    public static String query(String guess) {
        System.out.println(guess);
        return in.nextLine();
    }

}
