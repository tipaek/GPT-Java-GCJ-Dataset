import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int x = 0; x < cases; x++) {
            String s = br.readLine();
            String[] a = s.split("");
            String o = "";
            int open=0;
            int closed=0;


            for(int i = 0; i<a.length; i++) {
                int first = Integer.parseInt(a[i]);
                if (!a[i].equals("0")) {

                    if (i>0 && Integer.parseInt(a[i-1])-first > open-closed) {
                        o = o.substring(0, o.length() - first);
                        closed -= first;
                    }
                    else if (i > 0 && Integer.parseInt(a[i-1]) > 0 && first - Integer.parseInt(a[i-1]) > open-closed) {
                        o = o.substring(0, o.length() - (Integer.parseInt(a[i-1])));
                        closed -= Integer.parseInt(a[i-1]);
                    }
                    for(int j=open-closed;j<first; j++) {
                        o += "(";
                        open++;
                    }

                    o+=first;
                    int n = i + 1;
                    while (n < a.length && Integer.parseInt(a[n]) == first) {
                        o += first;
                        n++;
                        i++;
                    }
                    for(int j=closed; j<open; j++) {
                        o += ")";
                        closed++;
                    }
                }
                else
                    o += "0";
            }
            System.out.println("Case #"+(x+1)+": "+o);

        }
    }
}
