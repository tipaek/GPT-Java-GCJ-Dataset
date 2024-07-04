import java.util.*;
class Line {
    public int s,e;
    public char p;
    public Line(int a,int b) {
        s=a;
        e=b;
        p='N';
    }
    public boolean intersect(Line l) {
        if(l.s>s&&l.s<e)
            return true;
        else if(l.e>s&&l.e<e)
            return true;
        return false;
    }
}
public class Solution {
    public static void main(String rpn[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++) {
            int n=sc.nextInt();
            Line l[]=new Line[n];
            for(int j=0;j<n;j++) {
                l[j]=new Line(sc.nextInt(),sc.nextInt());
            }
            char p='C';
            String res="";
            
            /*for(int j=1;j<n;j++) {
                if(l[j].intersect(l[j-1])) {
                    if(p=='C')
                        p='J';
                    else
                        p='C';
                    res+=p;
                }
                else
                    res+=p; 
            }*/
            ArrayList<Line> c=new ArrayList<>();
            ArrayList<Line> j=new ArrayList<>();
            //if(c.isEmpty())
             //   c.add(l[0]);
            A:for(int u=0;u<n;u++) {
                if(p=='C') {
                    boolean khali=true;
                    B:for(Line te:c) {
                        if(te.intersect(l[u])) {
                            khali=false;
                            break B;
                        }
                    }
                    if(khali) {
                        c.add(l[u]);
                        res+=p; 
                    }
                    else {
                        p='J';
                        khali=true;
                        C:for(Line te:j) {
                            if(te.intersect(l[u])) {
                                khali=false;
                                break C;
                            }
                        }
                        if(khali) {
                            j.add(l[u]);
                            res+=p; 
                        }
                        else {
                            res="IMPOSSIBLE";
                            break A;
                        }
                    }
                }
                else {
                    boolean khali=true;
                    B:for(Line te:j) {
                        if(te.intersect(l[u])) {
                            khali=false;
                            break B;
                        }
                    }
                    if(khali) {
                        j.add(l[u]);
                        res+=p; 
                    }
                    else {
                        p='C';
                        khali=true;
                        C:for(Line te:c) {
                            if(te.intersect(l[u])) {
                                khali=false;
                                break C;
                            }
                        }
                        if(khali) {
                            c.add(l[u]);
                            res+=p; 
                        }
                        else {
                            res="IMPOSSIBLE";
                            break A;
                        }
                    }
                }
            }

            System.out.println("Case #"+(i)+": "+res);
        }
    }
}