import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++) {
            String[] line = br.readLine().trim().split(" ");
            int X = Integer.parseInt(line[0]);
            int Y = Integer.parseInt(line[1]);
            String path = line[2];
            int time = 1;
            while(time <= path.length()) {
                char c = path.charAt(time - 1);
                if(c == 'N') {
                    Y++;
                } else if(c == 'S') {
                    Y--;
                } else if(c == 'E') {
                    X++;
                } else {
                    X--;
                }
                int sum = X > 0 ? X : -1 * X;
                sum += Y > 0 ? Y : -1 * Y;
                if(sum <= time) {
                    sb.append("Case #").append(t).append(": ").append(time).append("\n");
                    break;
                }
                time++;
            }
            if(time > path.length()) {
                sb.append("Case #").append(t).append(": IMPOSSIBLE").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}