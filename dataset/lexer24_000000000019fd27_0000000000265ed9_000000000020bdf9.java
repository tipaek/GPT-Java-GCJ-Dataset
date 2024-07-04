import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    static final String[] users = { "C", "J" };

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Map<Integer, Node> map = new TreeMap<>();

            for (int j = 0; j < n; j++) {
                int start = in.nextInt()*10 + 1;
                int end = in.nextInt()*10;
                Node startNode = new Node(j);
                map.put(start, startNode);
                map.put(end, new Node(false, startNode));
            }
            String[] res = new String[n];
            String result = "";
            int[] arr = new int[2];
            for (Map.Entry<Integer, Node> entry : map.entrySet()) {
                Node node = entry.getValue();
                if (node.isStart) {
                    int user = getUser(arr);
                    if (user > 1) {
                        result = "IMPOSSIBLE";
                        break;
                    }
                    res[node.order] = users[user];
                    node.who = user;
                    arr[user] = 1;
                }
                else {
                    int endedUser = node.endOf.who;
                    arr[endedUser] = 0;
                }
            }
            if(result.length() == 0) result = String.join("", res);
            System.out.println("Case #" + i + ": " + result);
        }
        in.close();
    }

    public static int getUser(int[] arr) {
        if (arr[0] == 0) return 0;
        if (arr[1] == 0) return 1;
        return 2;
    }

    public static class Node {
        boolean isStart;
        int who;
        Node endOf;
        int order;

        public Node(boolean isStart, Node endOf) {
            this.isStart = isStart;
            this.endOf = endOf;
        }

        public Node(int order) {
            this.isStart = true;
            this.order = order;
        }
    }
}