import java.util.*;
import java.io.*;

class Path {
    int r;
    int c;
    String path;    
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; k++) {
            int x = in.nextInt();
            int y = in.nextInt();

            String res = "IMPOSSIBLE";
            boolean impossible = false;
            if ((x+y)>=1 && ((x+y)%2==0)) {
                impossible = true;
            }


            if (!impossible) {
                Queue<Path> q = new LinkedList<>();
                

                Path p = new Path();
                p.r = 0;
                p.c = 0;
                p.path = "";
                q.add(p);
                int level = 0;

                while (q.size()>0){
                    if (level > 32) {
                        break;
                    }

                    int step = (int) Math.pow(2,level);
                    //System.out.println("Level: "+level+", Step: "+step);

                    ArrayList<Path> list = new ArrayList<>(); 
                    while (q.size()>0){
                        Path item = q.remove();
                        list.add(item);
                    }

                    boolean found = false;
                    for (Path item: list){
                        //System.out.println("processing r:" + item.r + ", c: " + item.c + ", path: " + item.path + ", level: " + level );


                        if (x==item.c && y==item.r) {
                            found = true;
                            // System.out.println(item.path);
                            res = item.path;
                            break;
                        }

                        if (!((item.c - (2 * (step+1))) < x)){
                            Path pe = new Path();
                            pe.r = item.r;
                            pe.c = item.c+step;
                            pe.path = item.path+"E";
                            q.add(pe);
                        }

                        if (((item.c + (2 * (step+1))) > x)){
                            Path pw = new Path();
                            pw.r = item.r;
                            pw.c = item.c-step;
                            pw.path = item.path+"W";
                            q.add(pw);
                        }


                        if (((item.r + (2 * (step+1))) > y)){
                            Path ps = new Path();
                            ps.r = item.r-step;
                            ps.c = item.c;
                            ps.path = item.path+"S";
                            q.add(ps);
                        }

                        if (((item.r - (2 * (step+1))) < y)){
                            Path pn = new Path();
                            pn.r = item.r+step;
                            pn.c = item.c;
                            pn.path = item.path+"N";
                            q.add(pn);
                        }

                        // q.remove();
                        // q.remove();
                        // q.remove();
                        // q.remove();
                        // System.out.println(item); 
                    }
                    if (found) {
                        break;
                    }

                    level = level + 1;
                }
            }

            System.out.println("Case #" + k + ": " + res);
        }
    }
}