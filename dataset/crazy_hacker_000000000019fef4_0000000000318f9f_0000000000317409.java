
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder str = new StringBuilder("");
        for(int h=1;h<=t;h++) {
            str.append("Case #" + h + ": ");
            String in[] = br.readLine().split(" ");
            long x = Long.parseLong(in[0]);
            long y = Long.parseLong(in[1]);
            char moves[]  = in[2].toCharArray();
            long s = 0L;
            boolean found = false;
            for(int i=0;i<moves.length;i++){
                if( moves[i]=='S'){
                    y--;
                } else if(moves[i]=='N'){
                    y++;
                } else if(moves[i]=='E'){
                    x++;
                } else {
                    x--;
                }
                s++;
                if((Math.abs(x)+Math.abs(y))<=s){
                    found = true;
                    break;
                }
            }
            if(found){
                str.append(s+"\n");
            } else {
                str.append("IMPOSSIBLE\n");
            }
        }
        out.print(str);
        out.flush();
        br.close();
    }
}
