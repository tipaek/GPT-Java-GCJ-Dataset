import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int cases = Integer.parseInt(br.readLine());

            for (int x=0; x<cases; x++) {
                int  tasks = Integer.parseInt(br.readLine());

                ArrayList<Integer> s = new ArrayList<Integer>();
                ArrayList<Integer> e = new ArrayList<Integer>();
                String o = "";

                for (int i=0; i<tasks; i++) {
                    String[] a = br.readLine().split(" ");
                    int currStart = Integer.parseInt(a[0]);
                    int currEnd = Integer.parseInt(a[1]);

                    if (s.size()==0 || currStart >= s.get(s.size()-1)) {
                        s.add(currStart);
                        e.add(currEnd);
                    }
                    else {
                        int n = s.size()-1;
                        while (n > 0 && currStart < s.get(n-1))
                            n--;
                        s.add(n, currStart);
                        e.add(n, currEnd);
                    }
                }

                ArrayList<Integer> cs = new ArrayList<Integer>();
                ArrayList<Integer> ce = new ArrayList<Integer>();
                ArrayList<Integer> js = new ArrayList<Integer>();
                ArrayList<Integer> je = new ArrayList<Integer>();

                for (int i=0; i<tasks; i++) {
                    int currStart = s.get(i);
                    int currEnd = e.get(i);
                    if (cs.size() == 0 || currStart >= ce.get(ce.size() - 1)) {
                        o += "C";
                        cs.add(currStart);
                        ce.add(currEnd);
                    }
                    else if (js.size()== 0 || currStart >= je.get(je.size()-1)){
                        o += "J";
                        js.add(currStart);
                        je.add(currEnd);
                    }
                    else {
                        for (int j = i+1; j<tasks; j++) {
                            br.readLine();
                        }
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
