package Codejam2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int x=1; x<=cases; x++) {
            int  tasks = Integer.parseInt(br.readLine());

            ArrayList<Integer> cs = new ArrayList<Integer>();
            ArrayList<Integer> js = new ArrayList<Integer>();
            ArrayList<Integer> ce = new ArrayList<Integer>();
            ArrayList<Integer> je = new ArrayList<Integer>();
            String o = "";

            for (int i=0; i<tasks; i++) {
                String[] a = br.readLine().split(" ");
                int currStart = Integer.parseInt(a[0]);
                int currEnd = Integer.parseInt(a[1]);
                boolean keepGoing = true;

                if (cs.size()==0) {
                    o += "C";
                    cs.add(currStart);
                    ce.add(currEnd);
                    keepGoing=false;
                }
                else {
                    boolean placeable = true;
                    for (int j=0; j<cs.size(); j++) {
                        if (!(currStart >= ce.get(j) || currEnd <= cs.get(j))) {
                            placeable = false;
                            break;
                        }
                    }
                    if (placeable) {
                        o += "C";
                        cs.add(currStart);
                        ce.add(currEnd);
                        keepGoing=false;
                    }

                }
                if (keepGoing) {
                    if (js.size() == 0) {
                        o += "J";
                        js.add(currStart);
                        je.add(currEnd);
                        keepGoing = false;
                    }
                    else {
                        boolean placeable = true;
                        for (int j=0; j<js.size(); j++) {
                            if (!(currStart >= je.get(j) || currEnd <= js.get(j))) {
                                placeable = false;
                                break;
                            }
                        }
                        if (placeable) {
                            o += "J";
                            js.add(currStart);
                            je.add(currEnd);
                            keepGoing = false;
                        }
                    }
                }
                if (keepGoing) {
                    for (int j = i+1; j<tasks; j++) {
                        br.readLine();
                    }
                    break;
                }

            }
            if (o.length() < tasks)
                System.out.println("Case #"+(x)+": IMPOSSIBLE");
            else
                System.out.println("Case #"+(x)+": "+o);
        }
    }
}
