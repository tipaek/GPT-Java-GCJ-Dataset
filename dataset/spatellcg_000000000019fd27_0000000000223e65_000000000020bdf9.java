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
        List<ArrayList<Integer>> events = new ArrayList<ArrayList<Integer>>();
        TreeMap<Integer,Integer> times = new TreeMap<Integer,Integer>();
        TreeMap<Integer,String> who = new TreeMap<Integer,String>();
        List<Integer> starts = new ArrayList<Integer>();
        String sp = new String("");
        for (int k = 0; k<n; k++) {
            int s = in.nextInt();
            int e = in.nextInt();
            boolean valid = true;
            ArrayList<Integer> event = new ArrayList<Integer>();
            event.add(s);
            event.add(e);
            events.add(event);
            starts.add(s);
            times.put(s,e);
        }
        Collections.sort(starts);
        for (int k=0; k<starts.size(); k++) {
        	boolean valid = true;
        	int e = times.get(starts.get(k));
        	ArrayList<Integer> event = new ArrayList<Integer>();
            event.add(starts.get(k));
            event.add(e);
            int s = starts.get(k);
        	if (c.size()==0) {
            	c.add(event);
            	for (int m=0; m<events.size(); m++) {
            		if (events.get(m).get(0)==s && events.get(m).get(1)==e) {
            			who.put(m,"C");
            		}
            	}
            	continue;
            }
            for (int m=0; m<c.size();m++) {
            	if (c.get(m).get(0)<=s && s<c.get(m).get(1)) {
                    valid = false;
                    break;
            	}
                if (s<= c.get(m).get(0) && c.get(m).get(0)<e){
                    valid = false;
                    break;
                }
                if (s<c.get(m).get(1) && c.get(m).get(1)<=e) {
                    valid = false;
                    break;
                }
                if (c.get(m).get(0)<e && e<=c.get(m).get(1)){
                    valid = false;
                    break;
                }
            }
            if (valid) {
            	c.add(event);
            	for (int m=0; m<events.size(); m++) {
            		if (events.get(m).get(0)==s && events.get(m).get(1)==e) {
            			who.put(m,"C");
            		}
            	}
            	continue;
            }
            boolean jvalid = true;
            if (j.size()==0) {
            	j.add(event);
            	for (int m=0; m<events.size(); m++) {
            		if (events.get(m).get(0)==s && events.get(m).get(1)==e) {
            			who.put(m,"J");
            		}
            	}
            	continue;
            }
            for (int m=0; m<j.size();m++) {
            	if (j.get(m).get(0)<=s && s<j.get(m).get(1)) {
                    jvalid = false;
                    break;
            	}
                if (s<= j.get(m).get(0) && j.get(m).get(0)<e){
                    jvalid = false;
                    break;
                }
                if (s<j.get(m).get(1) && j.get(m).get(1)<=e) {
                    jvalid = false;
                    break;
                }
                if (j.get(m).get(0)<e && e<=j.get(m).get(1)){
                    jvalid = false;
                    break;
                }
            }
            if (jvalid) {
            	j.add(event);
            	for (int m=0; m<events.size(); m++) {
            		if (events.get(m).get(0)==s && events.get(m).get(1)==e) {
            			who.put(m,"J");
            		}
            	}
            	continue;
            }
            String ans = new String("IMPOSSIBLE");
            sp = ans;
            break;
        }
        if (!sp.equals("IMPOSSIBLE")) {
        	for (int m=0; m<events.size(); m++) {
        		String str = (String) who.put(m,"out");
        		sp = sp.concat(str);
             	}
        }
        System.out.println("Case #"+i+": "+ sp);
    }
  }
}