import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Solution {
             static int x;
          static int y;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int tc = getInt(br.readLine());

         int i = 0;
         while (tc-->0){

             i = i+1;

             String[] xy=  br.readLine().split(" ");
             x = getInt(xy[0]);
              y = getInt(xy[1]);
             int l  = Math.abs(x)+Math.abs(y);
             boolean express=  check(l);
             if(express){
                 System.out.println("Case #"+i+": IMPOSSIBLE");
                 continue;
             }
             Cordinate node= new Cordinate(0,0,"",0);
             BfsCall(node,i);
         }
    }
    public static void BfsCall(Cordinate node,int test){

        //Queue<Cordinate> bfs  = new ArrayDeque<>();
        ArrayList<Cordinate> bfs  = new ArrayList<>();
        (bfs).add(node);

        while (!bfs.isEmpty()){
            Cordinate parent=  bfs.remove(0);


            if(parent.x==x && parent.y==y){
                System.out.println("Case #"+test+": "+parent.ans);
                break;
            }
            int jump =(int) Math.pow(2,parent.i);
            StringBuilder Nans = new StringBuilder(parent.ans);

                   Nans.append("N");
                   Cordinate N = new Cordinate(parent.x, parent.y + jump, Nans.toString(), parent.i + 1);
                   (bfs).add(N);

                 Nans = new StringBuilder(parent.ans);
                 Nans.append("S");
                 Cordinate S = new Cordinate(parent.x, parent.y - jump, Nans.toString(), parent.i + 1);
            (bfs).add(S);


              Nans = new StringBuilder(parent.ans);
              Nans.append("E");
              Cordinate E = new Cordinate(parent.x + jump, parent.y, Nans.toString(), parent.i + 1);
            (bfs).add(E);

              Nans = new StringBuilder(parent.ans);
              Nans.append("W");
              Cordinate W = new Cordinate(parent.x - jump, parent.y, Nans.toString(), parent.i + 1);
            (bfs).add(W);

        }

    }
    public static  int getInt(String s){
        return Integer.parseInt(s);
    }

    public  static boolean check(int l){

        int n = (int)(Math.log(l)/Math.log(2)+1e-10);
        if(1<<n==l){
            return true;
        }
        return false;
    }


}
class Cordinate{

    int x ;
    int y ;
    String ans;
    int i ;

    public Cordinate(int x,int y,String  ans,int i){
        this.x= x;
        this.i = i;
        this.y= y;
        this.ans  =ans;
    }
}
