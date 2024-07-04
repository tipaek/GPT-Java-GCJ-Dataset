import java.util.*;

public class Solution {
    public static class Pair{
        int row;
        int col;
        String path;
        long sum;

        public Pair (int a, int b, String c, long d){
            this.row = a;
            this.col = b;
            this.path = c;
            this.sum = d;
        }
    }

    public static class twoD{
        int row;
        int col;

        public twoD(int a, int b){
            this.row = a;
            this.col = b;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dx = {-1, -1, 0, 1, 0, 1};
        int[] dy = {-1, 0, -1, 0, 1, 1};

        long[][] choose = new long[21][21];

        for (int i = 1; i < 21; i++){
            choose[i][0] = 1L;
            for (int j = 1; j <= i; j++){
                choose[i][j] = choose[i][j-1] * (i-j+1)/j;
            }
        }

        for (int a = 1; a <= T; a++){
            long N = sc.nextLong();
            Pair start = new Pair(1, 1, "", 1L);
            boolean[][] visited = new boolean[21][21];
            Queue<Pair>q = new LinkedList<Pair>();
            q.add(start);
            String p = "B";

            while(!q.isEmpty()){
                Pair next = q.remove();
                if (visited[next.row][next.col]) {
                    continue;
                }
                visited[next.row][next.col] = true;

                if (next.sum == N){
                    p = next.path;
                    break;
                }

                for (int i = 0; i < 6; i++){
                    int x2 = next.row + dx[i];
                    int y2 = next.col + dy[i];
                    if (x2 > 0 && y2 > 0 && x2 < 21 && y2 < 21 && x2 >= y2){
                        Pair f =  new Pair (x2, y2, next.path + i, next.sum + choose[x2][y2]);
                        q.add(f);
                    }
                }
            }

            System.out.println("Case #" + a + ": ");

            System.out.println(1 + " " + 1);
            int currx = 1;
            int curry = 1;
            for (int i = 0; i < p.length(); i++){
                if (p.charAt(i) == '0'){
                    currx -= 1;
                    curry -= 1;
                }
                else if (p.charAt(i) == '1'){
                    currx -= 1;
                    curry -= 0;
                }
                else if (p.charAt(i) == '2'){
                    currx -= 0;
                    curry -= 1;
                }
                else if (p.charAt(i) == '3'){
                    currx += 1;
                    curry -= 0;
                }
                else if (p.charAt(i) == '4'){
                    currx += 0;
                    curry += 1;
                }
                else if (p.charAt(i) == '5'){
                    currx += 1;
                    curry += 1;
                }
                System.out.println(currx + " " + curry);
            }

        }
    }
}
