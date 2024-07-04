import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mbharti
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
                events.add(new Event(Integer.parseInt(v2[0]), Integer.parseInt(v2[1]), i));
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
        char[] rs = new char[events.size()];
        rs[events.get(0).c]= 'C';
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
                rs[events.get(i).c]= 'J';
                mlist.add(events.get(i).end);
            }else {
                mlist.remove(idx);
                mlist.add(idx, events.get(i).end);
                rs[events.get(i).c]= (idx%2==0)?'C':'J';
            }
        }
        if(mlist.size()>2){
            return String.format("Case #%d: IMPOSSIBLE",tc);
        }
        return String.format("Case #%d: %s",tc, String.valueOf(rs));
    }

    static class Event implements Comparable{
        int start;
        int end;
        int c;

        Event(int st, int ed, int c){
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
