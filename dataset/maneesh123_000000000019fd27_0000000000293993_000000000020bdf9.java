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
                inputList.add(new int[]{Reader.nextInt(), Reader.nextInt(), i});
            }
            Collections.sort(inputList, (a, b) -> {
                int x = Integer.compare(a[0], b[0]);
                if (x == 0) {
                    return Integer.compare(a[1], b[1]);
                }
                return x;
            });
            boolean isImpossible = false;
            int cEndTime = inputList.get(0)[1];
            char[] result = new char[N];
            result[inputList.get(0)[2]] = 'C';
            int jEndTime = inputList.get(1)[1];
            result[inputList.get(1)[2]] = 'J';
            for (int i=2; i< inputList.size(); i++) {
                int[] arr = inputList.get(i);
                int index = arr[2];
                int startTime = arr[0];
                if (cEndTime > startTime && jEndTime > startTime) {
                    isImpossible = true;
                    break;
                }
                if (startTime >= jEndTime) {
                    result[index] = 'J';
                    jEndTime = arr[1];
                } else {
                    result[index] = 'C';
                    cEndTime = arr[1];
                }
            }
            sb.append("Case #"+ k+ ": "+ (isImpossible? "IMPOSSIBLE": new String(result)) + (k != T? "\n": ""));
        }
        System.out.println(sb.toString());
    }
}