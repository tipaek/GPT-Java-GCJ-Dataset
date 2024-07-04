
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution{
    static class Node implements Comparable<Node> {
        int start;
        int end;
        int num;
        public Node(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.start - o.start;
        }
    }
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int not = Integer.parseInt(br.readLine());

        int ii = 1;
        while (not-- != 0) {
            int n = Integer.parseInt(br.readLine());
            Node[] arr = new Node[n];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                arr[i] = new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1]), i);
            }
            Arrays.sort(arr);
            int end = 0;
            int res[] = new int[n];
            Node[] temp = new Node[n];
            int x = 0;
            for (int i = 0 ; i < n; i++) {
                if (arr[i].start >= end) {
                    res[arr[i].num] = 1;
                    end = arr[i].end;
                }
                else {
                    temp[x++] = arr[i];
                }
            }

            boolean flag = true;
            end = 0;
            for (int i  = 0; i < x; i++) {
                if (temp[i].start >= end) {
                    res[temp[i].num] = 2;
                    end = temp[i].end;
                }
                else {
                    flag = false;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (flag) {
                for (int i = 0; i < n; i++) {
                    if (res[i] == 1) {
                        sb.append('C');
                    }
                    else {
                        sb.append('J');
                    }
                }
            }
            else sb.append("IMPOSSIBLE");
            System.out.println("Case #"+ii+": "+sb);
            ii++;
        }
    }
}