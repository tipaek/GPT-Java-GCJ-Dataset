import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            System.out.print("Case #"+i+": ");
            solve(br);
        }
    }
    public static void solve(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        LinkedList<state>Q = new LinkedList<>();
        Q.add(new state(0,0,0,""));
        int max = 1;
        while(Math.pow(2,max)<Math.max(Math.abs(X),Math.abs(Y))){
            max++;
        }
        max+=2;
        while(Q.size()!=0){
            state temp = Q.poll();
            if(temp.x==X&&temp.y==Y){
                System.out.println(temp.path.toString());
                return;
            }
            if(temp.moves==max){
                System.out.println("IMPOSSIBLE");
                return;
            }
            Q.add(new state(temp.x-(int)Math.pow(2,temp.moves),temp.y,temp.moves+1,temp.path.toString()+"W"));
            Q.add(new state(temp.x,temp.y-(int)Math.pow(2,temp.moves),temp.moves+1,temp.path.toString()+"S"));
            Q.add(new state(temp.x+(int)Math.pow(2,temp.moves),temp.y,temp.moves+1,temp.path.toString()+"E"));
            Q.add(new state(temp.x,temp.y+(int)Math.pow(2,temp.moves),temp.moves+1,temp.path.toString()+"N"));
        }






    }
    static class state{
        int x,y,moves;
        StringBuilder path;
        public state(int X, int Y, int M, String Path){
            x = X;
            y = Y;
            moves = M;
            path = new StringBuilder(Path);
        }
    }
}

