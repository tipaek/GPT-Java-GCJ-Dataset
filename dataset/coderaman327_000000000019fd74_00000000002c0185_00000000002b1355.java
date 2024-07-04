import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node {
    int r1;
    int c1;

    Node(int r, int c) {
        r1 = r;
        c1 = c;
    }
}

public class Solution {
    public static void main(String[] args) throws java.io.IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][][] matrix = new int[r + 2][c + 2][5];
            ArrayList<Node> queue = new ArrayList<>(r * c);
            long total_sum = 0;
            for (int i = 1; i <= r; ++i)
                for (int j = 1; j <= c; j++) {
                    matrix[i][j][0] = sc.nextInt();
                    matrix[i][j][1] = j - 1;
                    matrix[i][j][2] = i - 1;
                    matrix[i][j][3] = j + 1;
                    matrix[i][j][4] = i + 1;
                    queue.add(new Node(i, j));
                    total_sum += matrix[i][j][0];
                }
            long ans = 0;
            boolean cond = true;
            while (cond) {
                cond=false;
                ArrayList<Node> q1 = new ArrayList<>();
                ArrayList<Node> q2= new ArrayList<>();
                int len = queue.size();
                ans += total_sum;
                //System.out.println(total_sum);
                for (int i = 0; i < len; ++i) {
                    Node cur_node = queue.get(i);
                    int i1 = cur_node.r1;
                    int j1 = cur_node.c1;
                     if (matrix[i1][j1][0] != 0) {
                        double sum = 0;
                        int count = 0;
                         //System.out.println(i1+" "+j1);
                         int left = matrix[i1][j1][1];
                        int above = matrix[i1][j1][2];
                        int right = matrix[i1][j1][3];
                        int below = matrix[i1][j1][4];
                        if (left != 0) {
                            count++;
                            sum += matrix[i1][left][0];
                        }
                        if (above != 0) {
                            count++;
                            sum += matrix[above][j1][0];
                        }
                        if (right != c + 1) {
                            count++;
                            sum += matrix[i1][right][0];
                        }
                        if (below != r + 1) {
                            count++;
                            sum += matrix[below][j1][0];
                        }
                        //System.out.println(sum+" "+count);
                        if (matrix[i1][j1][0] < (sum / count)) {
                            total_sum -= matrix[i1][j1][0];
                            cond = true;
                            //System.out.println("eliminated");
                            matrix[i1][j1][0] = 0;
                            q1.add(new Node(i1, left));
                            q1.add(new Node(above, j1));
                            q1.add(new Node(i1, right));
                            q1.add(new Node(below, j1));
                            q2.add(new Node(i1,j1));

                        }
                    }
                }
                queue=q1;
                int new_len=q2.size();
                for(int i=0;i<new_len;i++)
                {
                    Node cur=q2.get(i);
                    int i1=cur.r1;
                    int j1=cur.c1;
                    int left = matrix[i1][j1][1];
                    int above = matrix[i1][j1][2];
                    int right = matrix[i1][j1][3];
                    int below = matrix[i1][j1][4];
                    matrix[i1][left][3] = right;
                    matrix[above][j1][4] = below;
                    matrix[i1][right][1] = left;
                    matrix[below][j1][2] = above;
                }
                //System.out.println(queue);
            }
            System.out.println("Case #" + k + ": " + ans);
        }
    }
}
