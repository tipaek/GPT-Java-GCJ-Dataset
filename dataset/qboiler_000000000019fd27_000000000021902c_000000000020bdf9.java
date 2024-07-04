import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author qboiler
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            gg.set(0);
            processCase(reader, i);
        }
    }
    public static void main2(String s) throws IOException {

        StringReader ir = new StringReader(s);
        BufferedReader reader = new BufferedReader(ir);
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            gg.set(0);
            processCase(reader, i);
        }
    }

    public static void processCase(BufferedReader reader, int caseN) throws IOException {

        int events = Integer.parseInt(reader.readLine());

        Event[] aEvents = new Event[events];
        for(int i=0;i<events;++i){
            String[] n = reader.readLine().split(" ");
            Event e = new Event(Integer.parseInt(n[0]), Integer.parseInt(n[1]));
            aEvents[i] = e;
        }

        Arrays.sort(aEvents);
        char[] resulta = new char[events];

        int cammeron  = -1;
        int j = -1;
        String result = "";
        for(int i=0;i<events;++i){
            Event e = aEvents[i];
            if(e.start>= cammeron){
                cammeron = e.end;
                if(e.intOrder>resulta.length){
                    result = "Error-> "+e.intOrder;
                    break;
                }
                resulta[e.intOrder] = 'C';
            }else if(e.start>= j){
                j=e.end;
                if(e.intOrder>resulta.length){
                    result = "Error-> "+e.intOrder;
                    break;
                }

                resulta[e.intOrder] = 'J';
            }else{
                result = "IMPOSSIBLE";
                break;
            }
        }
        if(result.equals("")){
            result  = new String(resulta);
        }
        System.out.println("Case #"+caseN+": "+result);
    }
    private static final AtomicInteger gg = new AtomicInteger(0);

    static class Event implements Comparable<Event> {


        Event(int pstart, int pend){
            start = pstart;
            end = pend;
            intOrder = gg.getAndIncrement();
        }
        final int start;
        final int end;
        final int intOrder;



        @Override
        public int compareTo(Event event) {
            return start - event.start;
        }
    }


}



