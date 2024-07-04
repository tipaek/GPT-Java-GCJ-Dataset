import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class node{
    int i;
    int j;
    node(int x,int y){
        i=x;
        j=y;
    }
}
public class Solution {
    static String [][]ans;
    static int l;
    static long []pow;
    static boolean check(int x, int y){
        int m = l/2;
        if(-m<=x && x<=m){
            if(-m<=y && y<=m){
                return true;
            }
        }
        return false;
    }
    static int get(int i){
        return i+l/2;
    }
    static void bfs(){
        l=2*4+1;
        ans=new String[l][l];
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                ans[i][j]="";
            }
        }
//        for(int i=0;i<l;i++){
//            for(int j=0;j<l;j++){
//                ans[i][j]=-1;
//            }
//        }
//        ans[get(0)][get(0)]=0;
        Queue<node> queue = new LinkedList<>();
        ((LinkedList<node>) queue).add(new node(0,0));
        while(!queue.isEmpty()){
            node t = queue.poll();
            int add = (int) Math.pow(2,ans[get(t.i)][get(t.j)].length());
            if(check(t.i+add, t.j)){
                if(ans[get(t.i+add)][get(t.j)].length()==0){
                    ans[get(t.i+add)][get(t.j)]=ans[get(t.i)][get(t.j)]+"E";
                    ((LinkedList<node>) queue).add(new node(t.i+add, t.j));
                }
            }
            if(check(t.i-add, t.j)){
                if(ans[get(t.i-add)][get(t.j)].length()==0){
                    ans[get(t.i-add)][get(t.j)]=ans[get(t.i)][get(t.j)]+"W";
                    ((LinkedList<node>) queue).add(new node(t.i-add, t.j));
                }
            }
            if(check(t.i, t.j+add)){
                if(ans[get(t.i)][get(t.j+add)].length()==0){
                    ans[get(t.i)][get(t.j+add)]=ans[get(t.i)][get(t.j)]+"N";
                    ((LinkedList<node>) queue).add(new node(t.i, t.j+add));
                }
            }
            if(check(t.i, t.j-add)){
                if(ans[get(t.i)][get(t.j-add)].length()==0){
                    ans[get(t.i)][get(t.j-add)]=ans[get(t.i)][get(t.j)]+"S";
                    ((LinkedList<node>) queue).add(new node(t.i, t.j-add));
                }
            }
        }
    }
    public static void main(String []args) throws IOException {
        bfs();
//        for(int i=-l/2;i<=l/2;i++){
//            for(int j=-l/2;j<=l/2;j++){
//                System.out.print(String.format("%4s",ans[get(i)][get(j)]));
//            }
//            System.out.println();
//        }
//        System.out.println(new StringBuilder(ans[get(2)][get(3)]).reverse().toString());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tt=1;tt<=t;tt++){
            String []s = br.readLine().split(" ");
            int g = get(Integer.parseInt(s[0]));
            int h = get(Integer.parseInt(s[1]));
            String e = ans[g][h];
            if(ans[g][h].length()==0){
                e="IMPOSSIBLE";
            }
            System.out.println("Case #"+tt+": "+e);
        }
//        for(int j=l/2;j>=-l/2;j--){
//            for(int i=-l/2;i<=l/2;i++){
//                System.out.print(String.format("%4s",new StringBuilder(ans[get(i)][get(j)]).toString()));
//            }
//            System.out.println();
//        }
    }
}
