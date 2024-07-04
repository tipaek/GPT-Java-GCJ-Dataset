import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class PascalGraph{
    int n;
    int xMoves[] = {-1, -1 , 0, 0, 1, 1};
    int yMoves[] = {-1, 0, -1, 1,0, 1};
    boolean visited[][];
    int parent[][][];
    int triangle[][];
    int caseNumber;
    PascalGraph(int n, int triangle[][], int caseNumber){
        this.n = n;
        visited = new boolean[n][n];
        this.triangle = triangle;
        this.parent = new int[n][n][2];
        parent[0][0][0] = 0;
        parent[0][0][1] = 0;
        this.caseNumber = caseNumber;
    }

    public void bfs(int startX, int startY){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        queue.add(1);
        queue.add(1);
        visited[startX][startY] = true;
        while(queue.size() > 0){
            int parentX = queue.poll();
            int parentY = queue.poll();
            int sum = queue.poll();
            int moveNumber= queue.poll();
            if(sum == n && moveNumber <= 500){
                ArrayList<Integer[]> list = new ArrayList<>();
                while(true){
                    list.add(new Integer[]{parentX + 1, parentY + 1});
                    if(parentX == 0 && parentY == 0)
                        break;
                    parentX = parent[parentX][parentY][0];
                    parentY = parent[parentX][parentY][1];
                }
               // list.add(new Integer[]{parentX, parentY});
                System.out.println("Case #" + caseNumber + ": ");
                for(int i = list.size() - 1; i >=0; i--){
                    System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
                }
                return;
            }
            for(int i = 0; i < 6; i++){
                int childX = parentX + xMoves[i];
                int childY = parentY + yMoves[i];
                if(isChildValid(childX, childY) && triangle[childX][childY] != 0 && !visited[childX][childY]){
                    parent[childX][childY][0] = parentX;
                    parent[childX][childY][1] = parentY;
                    visited[childX][childY] = true;
                    queue.add(childX);
                    queue.add(childY);
                    queue.add(sum + triangle[childX][childY]);
                    queue.add(moveNumber + 1);
                }

            }
        }

    }
    public boolean isChildValid(int x, int y){
        return x >= 0 && x < n && y >=0 && y < n;
    }

}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int triangle[][] = new int[n][n];
            triangle[0][0] = 1;

            for(int i = 1; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(j - 1 >= 0)
                        triangle[i][j] += triangle[i - 1][j - 1];
                    triangle[i][j] += triangle[i - 1][j];
                }
            }
            PascalGraph pg = new PascalGraph(n, triangle, caseNumber);
            pg.bfs(0, 0);
            //System.out.println("Case #" + caseNumber + ": " + output);
            caseNumber++;
        }
    }
}
