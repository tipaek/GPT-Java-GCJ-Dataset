import java.io.*;
import java.util.*;
import java.awt.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        int z=1;
        while(t-->0){
            int n=sc.nextInt();
            char[] c=new char[n];
            Point[] p=new Point[n];
            for(int i=0;i<n;i++){
                p[i]=new Point(sc.nextInt(),sc.nextInt());
            }
            LinkedList<Point> cam=new LinkedList<>();
            LinkedList<Point> jam=new LinkedList<>();
            boolean f=false;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(!(p[i].y<=p[j].x || p[j].y<=p[i].x)){
                        cam.add(p[i]);
                        c[i]='C';
                        jam.add(p[j]);
                        c[j]='J';
                        p[i]=null;p[j]=null;
                        f=true;
                        break;
                    }
                }
                if(f)break;
            }
            if(f){
                boolean g=false;
                for(int i=0;i<n;i++){
                    if(p[i]==null)continue;
                    f=false;
                    for(Point P:cam){
                        if(!(P.y<=p[i].x || p[i].y<=P.x)){
                            f=true;
                            break;
                        }
                    }
                    if(f){
                        for(Point P:jam){
                            if(!(P.y<=p[i].x || p[i].y<=P.x)){
                                g=true;
                                break;
                            }
                        }
                        if(!g){
                            jam.add(p[i]);
                            p[i]=null;
                            c[i]='J';
                        }
                        else break;
                    }
                    else{
                        for(Point P:jam){
                            if(!(P.y<=p[i].x || p[i].y<=P.x)){
                                f=true;
                                break;
                            }
                        }
                        if(f){
                            cam.add(p[i]);
                            p[i]=null;
                            c[i]='C';
                        }
                    }
                }
                if(g){
                    sb.append("Case #"+(z++)+": IMPOSSIBLE\n");
                    continue;
                }
                for(int i=0;i<n;i++){
                    if(p[i]!=null){
                        boolean cameron=true,jamie=true;
                        for(Point P:cam){
                            if(!(P.y<=p[i].x || p[i].y<=P.x)){
                                cameron=false;
                                break;
                            }
                        }
                        for(Point P:jam){
                            if(!(P.y<=p[i].x || p[i].y<=P.x)){
                                jamie=false;
                                break;
                            }
                        }
                        if(cameron && !jamie)c[i]='C';
                        else if(!cameron && jamie)c[i]='J';
                        else if(cameron && jamie)c[i]='C';
                        else{
                            sb.append("Case #"+(z++)+": IMPOSSIBLE");
                            break;
                        }
                    }
                    if(i==n-1){
                        sb.append("Case #"+(z++)+": ");
                        for(int j=0;j<n;j++)sb.append(c[j]);
                    }
                }
            }
            else{
                for(int i=0;i<n;i++)c[i]='C';
                sb.append("Case #"+(z++)+": ");
                for(int j=0;j<n;j++)sb.append(c[j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
//Case #x: k r c
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}