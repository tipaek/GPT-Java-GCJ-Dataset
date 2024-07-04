import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
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

            int U = stoi(br.readLine());

            HashMap<Long, ArrayList<String>> hashMap = new HashMap<>();

            for(long j = 0; j< 10; ++j){
                hashMap.put(j,new ArrayList<>());
            }


            for(int j = 0 ;j < 10000;++j){
                st = new StringTokenizer(br.readLine());
                long Q = stoi(st.nextToken());
                String[] R = st.nextToken().split("");
                boolean flag = false;
                if (Q >= 10) {
                    flag = true;
                }
                if(flag){
                    if (!hashMap.get(0L).contains(R[R.length - 1])) {
                        hashMap.get(0L).add(R[R.length - 1]);
                    }

                    int lg = (int)Math.log10(Q);

                    if(lg+1 == R.length) {
                        while (Q >= 10) {
                            Q /= 10;
                        }
                        if (!hashMap.get(Q).contains(R[0])) {
                            hashMap.get(Q).add(R[0]);
                        }
                    }
                } else {
                    Q%=10;
                    if (!hashMap.get(Q).contains(R[R.length - 1])) {
                        hashMap.get(Q).add(R[R.length - 1]);
                    }

                }
            }
            StringBuilder out = new StringBuilder();
            for(long j = 1; j < 10; ++j){
                String x = hashMap.get(j).get(0);
                /*
                for(String y : hashMap.get(1L)){
                    System.out.println(y);
                }
                 */
                out.append(x);
                hashMap.get(0L).remove(x);
                for(long k = j+1; k < 10; k++){
                    hashMap.get(k).remove(x);
                }
            }
            out.insert(0,hashMap.get(0L).get(0));
            sb.append(out.toString());
            sb.append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
