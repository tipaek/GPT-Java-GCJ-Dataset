
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static long[][] map = new long[60][60];
    static boolean[][] visited = new boolean[60][60];
    static ArrayList<String> list = new ArrayList<>();
    static int mvs = 0;
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       PrintWriter pw = new PrintWriter(System.out);
       int T = sc.nextInt();
        int k= 1;
        while (T-->0)
        {
            mvs = 0 ;
            dfs(1,1,sc.nextInt());
            pw.printf("Case #%d:\n",k++);
            for(int i = list.size() -1 ;i>=0;i--)
                pw.print(list.get(i));
            list.clear();
        }
        pw.flush();
    }
    static boolean dfs(int x , int y , long n)
    {

        if(mvs>=500)
            return false;

        if(x>=60 || y>=60)
            return false;
        if(visited[x][y])
            return false;
        if(n<0)
            return false;
        if(n==0)
            return true;
        visited[x][y] = true;
        mvs++;
        if(dfs(x+1,y+1,n-get(x,y)))
        {
            list.add(x+" "+y+"\n");
            visited[x][y] = false;
            mvs--;
            return true;
        }else if(dfs(x+1,y,n-get(x,y)) ){
            list.add(x+" "+y+"\n");
            visited[x][y] = false;
            mvs--;
            return true;
        }
        visited[x][y] = false;
        mvs--;
        return false;
    }
    static long get(int x , int y)
    {
        if(map[x][y]!=0)
            return map[x][y];
        if(x == 1 || y == 1 || y == x)
            return 1;
        map[x][y] = get(x-1 , y-1)+get(x-1 , y);
        return map[x][y];
    }
}
