import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {

    static class Activity {
        int start;
        int end;
        String lead;
        int seq;

        public Activity(int start, int end, String lead, int seq){
            this.start = start;
            this.end = end;
            this.lead = lead;
            this.seq = seq;
        }
    }

    static class DurationComparator implements Comparator<Activity>{

        @Override
        public int compare(Activity o1, Activity o2) {
            if(o1.start==o2.start){
                return 0;
            }
            else return o1.start<o2.start?-1:1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        int caseNo=0;

        while (tests-->0){
            int count = Integer.parseInt(br.readLine());
            List<Activity> list = new ArrayList<>();
            int[] res = new int[count];
            for(int i=0; i<count; i++){
                res[i] = i;
            }
            int seq = 0;
            while (count-->0){
                String[] s = br.readLine().trim().split(" ");
                Activity activity = new Activity(Integer.parseInt(s[0]), Integer.parseInt(s[1]), null, seq++);
                list.add(activity);
            }

            Collections.sort(list, new DurationComparator());
            String parenting = decideParenting(list, res);
            System.out.println("Case #"+ ++caseNo+ ": "+parenting);
        }

    }

    private static String decideParenting(List<Activity> list, int[]res) {
        int cs=0, js=0, ce=0, je=0;
        Activity ca=null, ja=null;
        char[] result = new char[res.length];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            if(null != ca){
                ce = ca.end;
            }
            if(null != ja){
                je = ja.end;
            }
            if(list.get(i).start >= ce){
                ca = list.get(i);
                ce = list.get(i).end;
                result[list.get(i).seq] = 'C';
            }
            else if(list.get(i).start >= je){
                ja = list.get(i);
                je = list.get(i).end;
                result[list.get(i).seq] ='J';
            }
            else return new String("IMPOSSIBLE");
        }
        return String.copyValueOf(result);
    }

}
