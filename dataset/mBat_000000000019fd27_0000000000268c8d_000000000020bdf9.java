import java.io.*;
import java.util.*;

class Activity {
    int start;
    int end;
    
    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    
    public static void main(String args[]) throws Exception{
        int t, n, finalC, finalJ;
        String str;
        String arr[];
        StringBuilder builder = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        List<Activity> list = null;
        boolean ch;
        for(int a=0;a<t;a++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            for(int i=0;i<n;i++) {
                str = br.readLine();
                arr = str.split(" ");
                Activity ac = new Activity(
                    Integer.parseInt(arr[0]), 
                    Integer.parseInt(arr[1]));
                list.add(ac);
            }
            Collections.sort(list, new Comparator() {
                
                public int compare(Object o1, Object o2) {
                    Activity a1 = (Activity)o1;
                    Activity a2 = (Activity)o2;
                    Integer i1 = new Integer(a1.start);
                    Integer i2 = new Integer(a2.start);
                    return i1.compareTo(i2);
                }
            });
            builder = new StringBuilder();
            finalC = finalJ = -1;
            ch = true;
            for(int i=0;i<n;i++) {
                if(finalC <= list.get(i).start) {
                    builder.append("C");
                    finalC = list.get(i).end;
                }
                else if(finalJ <= list.get(i).start) {
                    builder.append("J");
                    finalJ = list.get(i).end;
                }
                else {
                    ch = false;
                    break;
                }
            }
            if(ch)
                System.out.println("Case #" + 
                    (a+1) + ": " + builder);
            else
                System.out.println("Case #" + 
                    (a+1) + ": " + "IMPOSSIBLE");
        }
    }
}