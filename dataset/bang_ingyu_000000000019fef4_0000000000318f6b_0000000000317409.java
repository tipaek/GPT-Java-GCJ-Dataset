import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = stoi(br.readLine());

        for(int i = 1; i <= T; ++i){
            sb.append(String.format("Case #%d: ",i));
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            char[] m = st.nextToken().toCharArray();
            int t = -1;

            if(x==0 && y == 0){
                t = 0;
            }

            for(int j = 0; t < 0 && j < m.length; j++){
                char d = m[j];
                if(d == 'N'){
                    y++;
                } else if(d == 'S'){
                    y--;
                } else if(d == 'E'){
                    x++;
                } else {
                    x--;
                }
                if(Math.abs(x)+Math.abs(y) <= j+1){
                    t = j+1;
                }
            }

            if(t < 0){
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(t);
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
