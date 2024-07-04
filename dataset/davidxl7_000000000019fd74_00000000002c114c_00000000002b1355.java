import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.print("Case #"+(i+1)+": ");
            solve(in);
        }
    }
    public static void solve(Scanner in){
        int R = in.nextInt();
        int C = in.nextInt();
        int Totalinterest = 0;
        int tempinterest = 0;
        int[][]map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j]=in.nextInt();
                tempinterest+=map[i][j];
            }
        }
        boolean[][]removed = new boolean[R][C];
        //Totalinterest = tempinterest;
        while(true){
            Totalinterest+=tempinterest;
            ArrayList<point>remove = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(removed[i][j]){
                        continue;
                    }
                    int amount = 0;
                    double avg = 0;
                    for(int x = i+1;x<R;x++){
                        if(!removed[x][j]){
                            avg+=map[x][j];
                            amount++;
                            break;
                        }
                    }
                    for(int x = i-1;x>=0;x--){
                        if(!removed[x][j]){
                            avg+=map[x][j];
                            amount++;
                            break;
                        }
                    }
                    for(int y = j+1;y<C;y++){
                        if(!removed[i][y]){
                            avg+=map[i][y];
                            amount++;
                            break;
                        }
                    }
                    for(int y = j-1;y>=0;y--){
                        if(!removed[i][y]){
                            avg+=map[i][y];
                            amount++;
                            break;
                        }
                    }
                    avg/=amount;
                    if((double)map[i][j]<avg){
                        remove.add(new point(i,j));
                    }
                }
            }
            if(remove.size()==0){
                //Totalinterest+=tempinterest;
                break;
            }
            for (point point : remove) {
                tempinterest -= map[point.x][point.y];
                //map[point.x][point.y] = -1;
                removed[point.x][point.y]=true;
            }
            //Totalinterest+=tempinterest;
        }
        System.out.println(Totalinterest);
    }
    static class point{
        int x,y;
        public point(int x1, int y1){
            x = x1;
            y = y1;
        }
    }
}
