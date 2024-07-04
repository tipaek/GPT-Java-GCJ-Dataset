import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[]Args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int x=1; x<=t; x++){
            int n = in.nextInt();
            Interval[]act=new Interval[n];
            for(int i=0; i<n; i++){
                act[i]=new Interval(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(act, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.ini-o2.ini;
                }
            });
            char[]sol=new char[n];
            boolean imp=false;
            int lC=0;
            int lJ=0;
            for(int i=0; i<n; i++){
                if(lC<=act[i].ini){
                    sol[act[i].pos]='C';
                    lC=act[i].fin;
                }
                else if(lJ<=act[i].ini){
                    sol[act[i].pos]='J';
                    lJ=act[i].fin;
                }
                else{
                    imp=true;
                    break;
                }
            }
            String solucion="";
            if(imp){
                solucion="IMPOSSIBLE";
            }
            else{
                for(int i=0; i<n; i++){
                    solucion+=sol[i];
                }
            }
            System.out.println("Case #"+x+": "+solucion);
        }
    }
}
class Interval{
    int ini;
    int fin;
    int pos;
    Interval(int x, int y, int p){
        ini=x;
        fin=y;
        pos=p;
    }
}
