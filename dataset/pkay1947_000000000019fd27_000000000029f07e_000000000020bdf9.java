import java.util.*;
import java.io.*;

class Task {
    int s;
    int e;
    int ix; char val;
}
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=in.nextInt();
        for (int z=1; z<=T; z++) {
            int n=in.nextInt();
            List<Task> list = new ArrayList<>();
            for (int i=0; i<n; i++) {
                Task tsk=new Task();
                tsk.s=in.nextInt(); tsk.e=in.nextInt(); tsk.ix=i;
                list.add(tsk);
            }
            Comparator<Task> sSort = (Task t1, Task t2) -> Integer.compare(t1.s, t2.s);            
            Collections.sort(list, sSort);
            TreeMap<Integer, Integer> cMap = new TreeMap<>();
            TreeMap<Integer, Integer> jMap = new TreeMap<>();
            boolean done=false;
            for (Task t : list) {
                if (done) break;
                boolean checkJ=false;
                Map.Entry<Integer, Integer>	kvc = cMap.floorEntry(t.s);
                Map.Entry<Integer, Integer>	kvj = jMap.floorEntry(t.s);
                if (kvc == null && cMap.size()==0) { cMap.put(t.s, t.e); t.val='C'; }
                else if (kvj == null && jMap.size()==0) { jMap.put(t.s, t.e); t.val='J'; }
                else if (kvc.getKey().intValue()==t.s && kvj.getKey().intValue()==t.s) {done=true; break;}
                else if (kvc.getKey().intValue()==t.s) { 
                    checkJ=true;
                } else {
                    Map.Entry<Integer, Integer>	ceilc = cMap.ceilingEntry(t.s);
                    if ((kvc==null || kvc.getValue().intValue()<=t.s) && (ceilc==null || ceilc.getKey().intValue()>=t.e)) { cMap.put(t.s, t.e); t.val='C'; }
                    else checkJ=true;
                }
                if (checkJ) {
                    if (kvj==null || kvj.getValue().intValue()<=t.s) {
                        Map.Entry<Integer, Integer>	ceil = jMap.ceilingEntry(t.s);
                        if (ceil==null || ceil.getKey().intValue()>=t.e) { jMap.put(t.s, t.e); t.val='J'; }
                        else {done=true;}
                    } else {done=true;}
                }
            }
            String ans="";
            if (done) ans="IMPOSSIBLE";
            else {
                Comparator<Task> ixSort = (Task t1, Task t2) -> Integer.compare(t1.ix, t2.ix);
                Collections.sort(list, ixSort);
                for (Task t:list) ans+=t.val;
            }
            System.out.println("Case #" + z + ": " + ans);
        }
    }
}