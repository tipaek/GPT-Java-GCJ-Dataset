import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = Integer.parseInt(sc.nextLine());
            for (int i=0; i<num; i++) {
                int n = Integer.parseInt(sc.nextLine());
                int[][] arr = new int[n][2];
                for (int j=0; j<n; j++) {
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    sc.nextLine();
                    arr[j][0] = start;
                    arr[j][1] = end;
                }
                Arrays.sort(arr, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
                String ans = "";
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                String[] opt = new String[] {"C", "J"};
                int cur = 0;
                for (int j=0; j<n; j++) {
                    if (ans.equals("IMPOSSIBLE")) {
                        sc.nextLine();
                        continue;
                    }
                    if (pq.isEmpty()) {
                        pq.add(arr[j][1]);
                        ans += opt[cur];
                    } else {
                        if (arr[j][0] < pq.peek()) {
                            if (pq.size() == 2) {
                                ans = "IMPOSSIBLE";
                                continue;
                            }
                            pq.add(arr[j][1]);
                            cur = (cur + 1) % 2;
                            ans += opt[cur];
                        } else  {
                            while (!pq.isEmpty() && arr[j][0] >= pq.peek()) {
                                pq.poll();
                            }
                            pq.add(arr[j][1]);
                            ans += opt[cur];
                        }
                    }
                }

                System.out.println("Case #" + (i+1) + ": " + ans+"\n");
            }
        }
    }
}
