

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {


    public static void main(String[] args){

        Transpose tr = Transpose.get();
        //tr.println(""+getMinDepthAbove("0586142",0));
        tr.start(new Transpose.Test(){
            @Override
            void onTest(int i,int T) {
                int N = tr.nextInt();

                ArrayList<Activity> activities = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    Activity a = new Activity();
                    int[] ix = tr.nextIntArray();
                    a.start = ix[0];
                    a.end = ix[1];
                    activities.add(a);
                }
                Solver s = new Solver();
                s.activities = activities;
                s.sort();
                if(s.isImpossible()){
                    tr.addCase(i,"IMPOSSIBLE");
                }else{
                    tr.addCase(i,s.solve());
                }

            }
        });
        tr.flush();
    }
}

class Schedule{
    ArrayList<Activity> activities = new ArrayList<>();
    String id;
    public Schedule(String i){
        id = i;
    }
}

class Solver{
    ArrayList<Activity> activities;
    ArrayList<Activity> sorted = new ArrayList<>();
    Schedule cS = new Schedule("C");
    Schedule jS = new Schedule("J");

    ArrayList<Activity> overlaps = new ArrayList<>();

    public void sort(){
        sorted.clear();
        sorted.addAll(activities);
        sorted.sort(new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.sortValue()-o2.sortValue();
            }
        });
    }

    public boolean isImpossible(){
        if(sorted.size()<3) return false;
        for (int i = 0; i < sorted.size() - 2; i++) {
            if(sorted.get(i).overlaps(sorted.get(i+1)) && sorted.get(i).overlaps(sorted.get(i+2))){
                if(!sorted.get(i+1).overlaps(sorted.get(i+2))) return false;
                return true;
            }
            //if(sorted.get(i).overlaps(sorted.get(i+1)) && sorted.get(i+1).overlaps(sorted.get(i+2))) return true;
        }
        return false;
    }

    public String solve(){
        ArrayList<ArrayList<Activity>> pairs = getOverlappingPairs();
        for (int i = 0; i < pairs.size(); i++) {
            pairs.get(i).get(0).to = "C";
            pairs.get(i).get(1).to = "J";
        }

        int c = 0;
        for (int i = 0; i < sorted.size(); i++) {
            if(sorted.get(i).to==null) {
                sorted.get(i).to = c%2==0 ? "C" : "J";
                c++;
            }
        }
        String out = "";
        for (int i = 0; i < activities.size(); i++) {
            out+=activities.get(i).to;
        }
        return out;
    }

    public ArrayList<ArrayList<Activity>> getOverlappingPairs(){
        if(sorted.size()<2) return new ArrayList<>();
        ArrayList<ArrayList<Activity>> pairs = new ArrayList<>();
        for (int i = 0; i < sorted.size() - 1; i++) {
            if(sorted.get(i).overlaps(sorted.get(i+1))){
                ArrayList<Activity> p = new ArrayList<>();
                p.add(sorted.get(i));
                p.add(sorted.get(i+1));
                pairs.add(p);
                overlaps.add(sorted.get(i));
                overlaps.add(sorted.get(i+1));
            }
        }
        return pairs;
    }
}

class Activity{
    int start = 0;
    int end = 0;

    String to;

    public int sortValue(){
        return start+end;
    }

    public boolean overlaps(Activity e){
        if(e.start > start && e.start <end) return true;
        if(start > e.start && start <e.end) return true;
        return false;
    }
}


//s2.complete.Transpose code here
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

    /*complete.Insert custom functions here*/

    static abstract class Test{
        abstract void onTest(int i,int T);
    }
}
