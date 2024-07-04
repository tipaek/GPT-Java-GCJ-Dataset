import java.awt.*;
import java.util.*;
import java.io.*;

public class Solution {
    static LinkedList<Integer>[] ll;
    static boolean col[];
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sBuilder;
        int t = sc.nextInt();
        for (int tst = 1; tst <= t; tst++) {
            sBuilder=new StringBuilder();
            int n=sc.nextInt();
            sBuilder.append("Case #"+tst+": ");
            Point point[]=new Point[n];
            ll=new LinkedList[n];
            visited =new boolean[n];
            col =new boolean[n];
            for (int i=0;i<n;i++)ll[i]=new LinkedList<>();
            for (int i=0;i<n;i++){
                point[i]=new Point(sc.nextInt(),sc.nextInt());
            }
            for (int i=0;i<n;i++){
                for (int j=i+1;j<n;j++){
                    if (check(point[i],point[j])){
                        ll[i].add(j);
                        ll[j].add(i);
                    }
                }
            }
            boolean z=true;
            for (int i=0;i<n;i++){
                if (visited[i])continue;
                if (!Dfs(i)){
                    z=false;
                }
            }
            if (!z)sBuilder.append("IMPOSSIBLE");
            else {
                for (int i=0;i<n;i++){
                    if (col[i])sBuilder.append('C');
                    else sBuilder.append('J');
                }
            }
            sBuilder.append("\n");
            System.out.print(sBuilder);
        }
    }
    static boolean Dfs(int v){
        visited[v]=true;
        for (int u:ll[v]){
            if (visited[u]){
                if (col[u]!=!col[v])return false;
            }else {
                col[u] = !col[v];
                if (!Dfs(u)) return false;
            }
        }
        return true;
    }
    static boolean check(Point p1, Point p2){
        return (p1.x>p2.x && p1.x<p2.y) || (p1.y>p2.x && p1.y<p2.y) || (p2.x>p1.x && p2.x<p1.y) || p2.y>p1.x && p2.y<p1.y || (p1.x==p2.x && p2.y==p1.y);
    }
}