import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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
            int N = stoi(st.nextToken());
            int D = stoi(st.nextToken());
            ArrayList<Long> a = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j){
                a.add(Long.parseLong(st.nextToken()));
            }
            Collections.sort(a);
            long prev = -1;
            int j = 1;
            int max = 0;
            long size = -1;
            for(int k = 0; k < N; k++){
                if(a.get(k) == prev){
                    j++;
                    continue;
                }
                prev = a.get(k);
                if(j > max) {
                    max = j;
                    size = prev;
                }
                j = 1;
            }

            boolean flag = false;

            for(long x : a){
                for (long y : a){
                    if (x == (D-1) * y) {
                        flag = true;
                        break;
                    }
                }
            }

            if(max >= D){
                sb.append(0);
            }else if(flag){
                sb.append(D-2);
            } else {
                sb.append(D-1);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
