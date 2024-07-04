import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 
 * @date 04/04/20
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        int t = Integer.valueOf(br.readLine());
        String res="";
        int tc=1;
        while(t>0){
            if(res.length()>0){
                res+="\n";
            }
            String v = br.readLine();
            int n = Integer.parseInt(v);
            List<Event> events = new ArrayList<>(n);
            for(int i=0;i<n;i++) {
                String v2[] = br.readLine().split(" ");
                events.add(new Event(Integer.parseInt(v2[0]), Integer.parseInt(v2[1]), (i%2==0)?'C':'J'));
            }
            res += canManagedBooking(events, tc);
            tc++;
            t--;
        }
        System.out.println(res);
    }

    public static String canManagedBooking(List<Event> events, int tc){
        Collections.sort(events);
        List<Integer> mlist = new ArrayList<>();
        mlist.add(events.get(0).end);
        String r= ""+events.get(0).c;
        for(int i=1;i<events.size();i++){
            boolean f = false;
            int idx = -1;
            for(int k=0;k<mlist.size();k++){
                if(mlist.get(k) <=events.get(i).start){
                    f=true;
                    idx=k;
                    break;
                }
            }
            if(!f){
                r += events.get(i).c;
                mlist.add(events.get(i).end);
            }else {
                mlist.remove(idx);
                mlist.add(idx, events.get(i).end);
                r += events.get(i).c;
            }
        }
        if(mlist.size()>2){
            r = "IMPOSSIBLE";
        }
        return String.format("Case #%d: %s",tc, r);
    }

    static class Event implements Comparable{
        int start;
        int end;
        char c;

        Event(int st, int ed, char c){
            this.start = st;
            this.end = ed;
            this.c = c;
        }

        @Override
        public int compareTo(Object o) {
            Event e = (Event) o;
            return this.end - e.end;
        }
    }
}
