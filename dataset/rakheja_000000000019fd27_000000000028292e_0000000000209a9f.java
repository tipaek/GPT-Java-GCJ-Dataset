import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static int[] convertArr(int[] arr){
        int[] ret = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            ret[i+1] = arr[i];
        }
        return ret;
    }

    public static int getStringDepth(String s){
        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            int k = Integer.parseInt(s.charAt(i)+"");
            if(k>d) d = k;
        }
        return d;
    }

    public static int getMinDepth(String s){
        int d = 10;
        for (int i = 0; i < s.length(); i++) {
            int k = intAt(s,i);
            if(d>k) d = k;
        }
        return d;
    }

    public static int getMinDepthAbove(String s,int c){
        int d = 10;
        for (int i = 0; i < s.length(); i++) {
            int k = intAt(s,i);
            if(d>k && k>c) d = k;
        }
        return d;
    }

    public static int intAt(String s, int i){
        return Integer.parseInt(s.charAt(i)+"");
    }

    public void solveForDepth(String s,int d){
        int start = 0,end = s.length();
        boolean foundStart = false;
        ArrayList<Depth> depths = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

        }
    }

    public static void main(String[] args){

        Transpose tr = Transpose.get();
        //tr.println(""+getMinDepthAbove("0586142",0));
        tr.start(new Transpose.Test(){
            @Override
            void onTest(int i,int T) {
                String S = tr.nextLine();
                Depth main = new Depth();
                main.s = S;
                main.finalString = new StringBuilder(S);
                main.start = 0;
                main.end = main.end;
                main.solve();
                Inserter in = new Inserter();
                main.generateInserts(in);
                String s = in.build(S);
                tr.addCase(i,s);

            }
        });
        tr.flush();
    }
}


class Insert{
    int pos = 0;
    String c = "";

    @Override
    public String toString() {
        return pos + " - "+c;
    }
}

class Inserter{
    ArrayList<Insert> inserts = new ArrayList<>();
    public void insert(Insert i){
        inserts.add(i);
    }

    public String build(String s){
        StringBuilder b = new StringBuilder(s);
        int off = 0;
        for (int i = 0; i < inserts.size(); i++) {
            b.insert(off+inserts.get(i).pos,inserts.get(i).c);
            off+=inserts.get(i).c.length();
        }
        return b.toString();
    }

    @Override
    public String toString() {
        return inserts.toString();
    }
}

class Depth{
    String s;
    int start;
    int end;
    int ac = 0;
    Depth parent = null;

    StringBuilder finalString;
    int depth = 0;
    Depth root = null;
    ArrayList<Depth> subs = new ArrayList<>();


    public Depth getRoot() {
        if(root==null) return this;
        return root;
    }


    public String repeat(String c,int i){
        String r = "";
        for (int j = 0; j < i; j++) {
            r+=c;
        }
        return r;
    }

    public void generateInserts(Inserter in){
        for (int i = 0; i < subs.size(); i++) {
            int x = (subs.get(i).depth-depth);
            Insert j = new Insert();
            j.pos = subs.get(i).start;
            j.c = repeat("(",x);
            in.insert(j);
            subs.get(i).generateInserts(in);
            j = new Insert();
            j.pos = subs.get(i).end;
            j.c = repeat(")",x);
            in.insert(j);
        }
    }


    public void solve(){
        int cstart = 0;
        int last = 0;

        if(s.length()==1 ){

            Solution.intAt(s, 0);
            Depth d = new Depth();
            d.depth = Solution.intAt(s, 0);
            d.start = start+0;
            d.end =start+ 1;
            d.s = s;
            d.root = getRoot();
            d.parent = this;
            subs.add(d);
        }
        else

        while (last!=s.length()-1){
            int sd = Solution.getMinDepthAbove(s.substring(cstart),depth);

            if(sd==10) return;
            //System.out.println("New min depth: "+sd);
            int ms = -1;
            int me = s.length();
            for (int i = cstart; i < s.length(); i++) {
                if(Solution.intAt(s, i) >= sd){
                    if(ms==-1) {
                        ms = i;
                        //System.out.println("New start: "+ms);
                    }
                    if(i==s.length()-1){
                        me = i+1;
                        Depth d = new Depth();
                        d.depth = sd;
                        d.start = start+ms;
                        d.end = start+me;
                        d.s = s.substring(ms,me);
                        d.root = getRoot();
                        d.parent = this;
                        //System.out.println("New SUB: "+d.start+","+d.end+", "+d.s+", DEPTH: "+sd);
                        d.solve();
                        subs.add(d);
                        last = i;
                        cstart = me;
                        break;
                    }
                }else if(ms!=-1){
                        me = i;
                        Depth d = new Depth();
                        d.depth = sd;
                        d.start = start+ms;
                        d.end = start+me;
                        d.s = s.substring(ms,me);
                        d.parent = this;
                        d.root = getRoot();
                        //System.out.println("New SUB: "+d.start+","+d.end+", "+d.s+", DEPTH: "+sd);
                        d.solve();
                        subs.add(d);
                        last = i;
                        cstart = me;
                        break;

                    }

                last = i;
            }
        }
    }

}

//s2.Transpose code here
class Transpose {
    BufferedReader br;

    String queue = "";

    int T = -1;
    int TE = -1;
    public static Transpose get(){
        return new Transpose();
    }

    private Transpose(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String nextLine(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int nextInt(){
        return Integer.parseInt(nextLine());
    }

    public double nextDouble(){
        return Double.parseDouble(nextLine());
    }
    public String[] nextStringArray(){
        try {
            return br.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{};
    }
    public int[] nextIntArray(){
        String[] ss = nextStringArray();
        int[] sx = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            sx[i] = Integer.parseInt(ss[i]);
        }
        return sx;
    }

    public void start(Test t){
        int[] ts = nextIntArray();
        T = ts[0];
        if(ts.length>1){
            TE = ts[1];
        }
        for (int i = 1; i <= T; i++) {
            t.onTest(i,T);
        }
    }

    public Transpose add(String s){
        queue+=s;
        return this;
    }

    public Transpose addCase(int i, String s){
        addLine("Case #"+i+": "+s);
        return this;
    }

    public Transpose addLine(String s){
        return add(s+"\n");
    }

    public void print(String s){
        System.out.print(s);
    }

    public void println(String s){
        System.out.println(s);
    }
    public void printCase(int i,String s){
        println("Case #"+i+": "+s);
    }

    public void flush(){
        if(!queue.isEmpty())
            System.out.print(queue);
        queue = "";
    }
    static abstract class Test{
        abstract void onTest(int i,int T);
    }
}