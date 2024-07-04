package Codejam2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ParentingPartnering {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int cases = Integer.parseInt(br.readLine());

            for (int x=0; x<cases; x++) {
                int  tasks = Integer.parseInt(br.readLine());

                ArrayList<Integer> c = new ArrayList<Integer>();
                ArrayList<Integer> j = new ArrayList<Integer>();
                ArrayList<Integer> cs = new ArrayList<Integer>();
                ArrayList<Integer> js = new ArrayList<Integer>();
                String o = "";

                for (int i=0; i<tasks; i++) {
                    String[] a = br.readLine().split(" ");
                    int currStart = Integer.parseInt(a[0]);
                    int currEnd = Integer.parseInt(a[1]);

                    if (c.size()==0 || currStart >= c.get(c.size()-1)) {
                        cs.add(Integer.parseInt(a[0]));
                        c.add(Integer.parseInt(a[1]));
                        o += "C";
                    }
                    else if (currEnd <= cs.get(cs.size()-1)){
                        int n = cs.size()-1;
                        while (n > 0 && currEnd < cs.get(n-1))
                            n--;
                        cs.add(n,currStart);
                        cs.add(n, currEnd);
                        o += "C";
                    }
                    else if (j.size()==0 || currStart >= j.get(j.size()-1)){
                        js.add(Integer.parseInt(a[0]));
                        j.add(Integer.parseInt(a[1]));
                        o += "J";

                    }
                    else if (currEnd <= js.get(js.size()-1)){
                        int n = js.size()-1;
                        while (n > 0 && currEnd <= js.get(n-1))
                            n--;
                        js.add(n, currStart);
                        j.add(n, currEnd);
                        o += "J";

                    }
                    else {
                        for (int n=i+1; n<tasks; n++)
                            br.readLine();
                        break;
                    }
                }

                if (o.length() < tasks)
                    System.out.println("CASE # "+(x+1)+": IMPOSSIBLE");
                else
                    System.out.println("CASE # "+(x+1)+": "+o);

            }
    }
}
