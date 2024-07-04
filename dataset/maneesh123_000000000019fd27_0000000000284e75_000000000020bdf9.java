import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        int T = Integer.parseInt(br.readLine());
        for (int k=1; k <= T; k++) {
           int N = Integer.parseInt(br.readLine());
           List<int[]> list = new ArrayList<>();
           for (int i=0; i<N; i++) {
               String[] input = br.readLine().split(" ");
               list.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
           }
           Collections.sort(list, (a, b) -> {
               int x = Integer.compare(a[0], b[0]);
               if (x == 0) {
                   return Integer.compare(a[1], b[1]);
               }
               return x;
           });
           StringBuilder temp = new StringBuilder("CJ");
           int carieEndTime = list.get(0)[1];
           int jamieEndTime = list.get(1)[1];
           for (int i=2; i<list.size(); i++) {
               int[] arr = list.get(i);
               int currentStartTime = arr[0];
               if (currentStartTime < carieEndTime && currentStartTime < jamieEndTime) {
                   temp = new StringBuilder("IMPOSSIBLE");
                   break;
               }
               if (currentStartTime >= carieEndTime) {
                   carieEndTime = arr[1];
                   temp.append("C");
               } else {
                   jamieEndTime = arr[1];
                   temp.append("J");
               }
           }
           sb.append("Case #"+k+": ");
           sb.append(temp.toString());
           sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}