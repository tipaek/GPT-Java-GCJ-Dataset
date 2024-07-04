
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        List<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();
        List<ArrayList<Integer>> j = new ArrayList<ArrayList<Integer>>();
        String sp = new String("C");
        for (int k = 0; k<n; k++) {
            int s = in.nextInt();
            int e = in.nextInt();
            boolean svalid = true;
            boolean evalid = true;
            ArrayList<Integer> event = new ArrayList<Integer>();
            event.add(s);
            event.add(e);
            if (c.size()==0) {
            	c.add(event);
            	continue;
            }
            for (int m=0; m<c.size();m++) {
            	if (c.get(m).get(0)<=s && s<c.get(m).get(1)) {
                    svalid = false;
            	}
                if (s<= c.get(m).get(0) && c.get(m).get(0)<e){
                    svalid = false;
                }
                if (s<c.get(m).get(1) && c.get(m).get(1)<=e) {
                    evalid = false;
                }
                if (c.get(m).get(0)<e && e<=c.get(m).get(1)){
                    evalid = false;
                }
            }
            if (svalid && evalid) {
            	c.add(event);
            	sp = sp.concat("C");
            	continue;
            }
            boolean sjvalid = true;
            boolean ejvalid = true;
            if (j.size()==0) {
            	j.add(event);
            	sp = sp.concat("J");
            	continue;
            }
            for (int m=0; m<j.size();m++) {
            	if (j.get(m).get(0)<=s && s<j.get(m).get(1)) {
                    sjvalid = false;
            	}
                if (s<= j.get(m).get(0) && j.get(m).get(0)<e){
                    sjvalid = false;
                }
                if (s<j.get(m).get(1) && j.get(m).get(1)<=e) {
                    ejvalid = false;
                }
                if (j.get(m).get(0)<e && e<=j.get(m).get(1)){
                    ejvalid = false;
                }
            }
            if (sjvalid && ejvalid) {
            	j.add(event);
            	sp = sp.concat("J");
            	continue;
            }
            String ans = new String("IMPOSSIBLE");
            sp = ans;
            break;
        }
        System.out.println("Case #"+i+": "+ sp);
    }
  }
}