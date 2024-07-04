import java.util.*;
import java.io.*;
class Solution {
    static class Reader {
        static BufferedReader br;
        static StringTokenizer tokenizer;
        static void init(InputStream input) throws IOException{
            br = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }
        static String next() throws IOException{
            while(!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(br.readLine());
            }
            return tokenizer.nextToken();
        }
        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        StringBuilder sb = new StringBuilder("");
        int T = Reader.nextInt();
        for (int k=1; k <= T; k++) {
            List<int[]> inputList = new ArrayList<>();
            int N = Reader.nextInt();
            for (int i=0; i<N; i++) {
                inputList.add(new int[]{Reader.nextInt(), Reader.nextInt()});
            }
            Collections.sort(inputList, (a, b) -> {
                int x = Integer.compare(a[0], b[0]);
                return x;
            });
            int cEndTime = inputList.get(0)[1];
            int jEndTime = inputList.get(1)[1];
            StringBuilder temp = new StringBuilder("CJ");
            for (int i=2; i< inputList.size(); i++) {
                int[] arr = inputList.get(i);
                int startTime = arr[0];
                if (cEndTime > startTime && jEndTime > startTime) {
                    temp = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                if (startTime >= jEndTime) {
                    temp.append("J");
                    jEndTime = arr[1];
                } else {
                    temp.append("C");
                    cEndTime = arr[1];
                }
            }
            sb.append("Case #"+ k+ ": "+ temp.toString() + ((k != T)? "\n": ""));
        }
        System.out.println(sb.toString());
    }
}