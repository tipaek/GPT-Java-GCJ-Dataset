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
        l=2*1000+1;
        ans=new String[l][l];
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                ans[i][j]="";
            }
        }
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
//        for(int j=5;j>=-5;j--){
//            for(int i=-5;i<=5;i++){
//                System.out.print(String.format("%4s",new StringBuilder(ans[get(i)][get(j)]).toString()));
//            }
//            System.out.println();
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tt=1;tt<=t;tt++){
            String []s = br.readLine().split(" ");
            int g = get(Integer.parseInt(s[0]));
            int h = get(Integer.parseInt(s[1]));
            long distance=Math.abs(g)+Math.abs(h);
            int k = (int) (Math.log(distance)/Math.log(2));
            String anss = solve(g, h, distance,k);
            if(anss.length()==0){

                System.out.println("Case #"+tt+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+tt+": "+anss);
            }
        }
    }

    static boolean flag = true;
    static String solve(int g, int h, long distance, int k){
        int add = (int) Math.pow(2,k);
        if(k==0){
            if(g==0 && h==1){
                return "N";
            }else if(g==0 && h==-1){
                return "S";
            }else if(g==1 && h==0){
                return "E";
            }else if(g==-1 && h==0){
                return "W";
            }
            return "";
        }
        if(distance<Math.abs(g) || distance<Math.abs(h)){
            return "";
        }
        String temp="";
        if(g<0){
            String v = solve(g+add, h, distance, k-1);
            if(v.length()!=0){
                temp=v+"W";
            }
        }
        if(g>0 && temp.length()==0){
            String v = solve(g-add, h, distance, k-1);
            if(v.length()!=0){
                temp=v+"E";
            }
        }
        if(h<0 && temp.length()==0){
            String v = solve(g, h+add, distance, k-1);
            if(v.length()!=0){
                temp=v+"S";
            }
        }
        if(h>0 && temp.length()==0){
            String v = solve(g, h-add, distance, k-1);
            if(v.length()!=0){
                temp=v+"N";
            }
        }
        return temp;
    }
}
