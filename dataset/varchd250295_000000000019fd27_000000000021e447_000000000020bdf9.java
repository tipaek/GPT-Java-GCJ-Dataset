// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9
// TIME - O(n^2)

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int test = 1; test <= t; test++ ) {

            String ans = "";
            int endTimeC = 0, endTimeJ = 0;
            int n = Integer.parseInt(buf.readLine());
            List<Integer> start = new LinkedList<>();
            List<Integer> end = new LinkedList<>();
            for(int i = 0; i < n; i++) { 
                StringTokenizer st = new StringTokenizer(buf.readLine());
                start.add(Integer.parseInt(st.nextToken()));
                end.add(Integer.parseInt(st.nextToken()));
            }

            // sort END times based on START times
            for(int i = 0; i < n; i++) {
                int min = start.get(i);
                int minIdx = i;
                for(int j = i + 1; j < n; j++)
                    if(start.get(j) < start.get(minIdx)) {
                        minIdx = j;
                        min = start.get(j);
                    }
                start.set(minIdx, start.get(i));
                start.set(i, min);
                min = end.get(minIdx);
                end.set(minIdx, end.get(i));
                end.set(i, min);
            }

            for(int i = 0; i < n; i++) {

                if(start.get(i) < endTimeC && start.get(i) < endTimeJ) { // BOTH BUSY
                    ans = "IMPOSSIBLE";
                    break;
                }
                else {
                    if(start.get(i) >= endTimeC) {
                        ans += "C";
                        endTimeC = end.get(i);
                    }
                    else {
                        ans += "J";
                        endTimeJ = end.get(i);
                    }
                }
            }

            System.out.println("Case #" + test + ": " + ans);
        }
    } 
}
