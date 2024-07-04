import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author adarshbhattarai on 2020-04-19
 * @project untitled
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = sc.nextInt();
        for(int i=1;i<=testcases;i++) {
            int first = sc.nextInt();
            int last = sc.nextInt();
            System.out.println("Case #"+i+": "+ solve(first,last));
        }
    }

    static String solve(int a, int b){
        int[][] DIRS = {{0,1},{1,0},{-1,0},{0,-1}};
        String[] eve = {"N","E","W","S"};
        if((Math.abs(a)%2==0 && Math.abs(b)%2==0)||(Math.abs(a)%2==1 && Math.abs(b)%2==1) )
             return "IMPOSSIBLE";
        Node n=new Node(new int[]{0,0,0}, "");
        int t=0;
        Queue<Node> qu = new LinkedList();
        qu.add(n);
        long currime= System.currentTimeMillis();
        while(!qu.isEmpty()){
            Node val = qu.poll();
            int[] values=val.values;
            String path=val.path;

            if(values[0]==a && values[1]==b){
                return path;
            }
            int nextPath=1<<values[2];
            int i=0;
            for(int[] dir: DIRS){
                int nf=values[0]+dir[0]*nextPath;
                int nl=values[1]+dir[1]*nextPath;
                qu.add(new Node(new int[]{nf,nl,values[2]+1},path+eve[i]));
                i++;
            }
        }
        return "IMPOSSIBLE";
    }

    static boolean isIncircle(int x, int y, int [] valurs){
        int centerX=valurs[0];
        int centerY=valurs[1];
        int radious=1<<valurs[2];

        return ((centerX-x)*(centerX-x) + (centerY -y)* (centerY-y))<= radious*radious;

    }

}

class Node{
    int[] values;
    String path;

    Node(int[] values, String path){
        this.path=path;
        this.values=values;

    }
}
