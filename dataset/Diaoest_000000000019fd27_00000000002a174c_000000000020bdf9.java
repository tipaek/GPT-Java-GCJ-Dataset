import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = Integer.parseInt(sc.nextLine());
            for (int i=0; i<num; i++) {
                int n = Integer.parseInt(sc.nextLine());
                int[][] arr = new int[n][3];
                for (int j=0; j<n; j++) {
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    sc.nextLine();
                    arr[j][0] = start;
                    arr[j][1] = end;
                    arr[j][2] = j;
                }
                Arrays.sort(arr, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//                for (int j=0; j<n; j++) {
//                    System.out.println(Arrays.toString(arr[j]));
//                }
                char[] a = new char[n];
                String ans = "";
                PriorityQueue<int[]> pq = new PriorityQueue<>((c,b) -> c[0] - b [0]);
                char[] opt = new char[] {'C', 'J'};
                int cur = 0;
                for (int j=0; j<n; j++) {
                    if (pq.isEmpty()) {
                        pq.add(new int[] {arr[j][1], cur, arr[j][2]});
//                        ans += opt[cur];
                    } else {
                        if (arr[j][0] < pq.peek()[0]) {
                            if (pq.size() == 2) {
                                ans = "IMPOSSIBLE";
                                continue;
                            }
                            cur = (pq.peek()[1] + 1) % 2;
//                            ans += opt[cur];
                            pq.add(new int[] {arr[j][1], cur, arr[j][2]});
                        } else  {
                            while (!pq.isEmpty() && arr[j][0] >= pq.peek()[0]) {
                                int[] tmp = pq.poll();
                                cur = tmp[1];
                                a[tmp[2]] = opt[cur];
                            }
                            pq.add(new int[] {arr[j][1], cur, arr[j][2]});
                        }
                    }
                }
                if (!ans.equals("IMPOSSIBLE")) {
                    while (!pq.isEmpty()) {
                        int[] tmp = pq.poll();
                        cur = tmp[1];
                        a[tmp[2]] = opt[cur];
                    }
                    ans = String.valueOf(a);
                }

                System.out.println("Case #" + (i+1) + ": " + ans +"\n");
            }
        }
    }
}
