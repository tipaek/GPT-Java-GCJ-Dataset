

import java.util.*;
import java.io.*;

/**
 *
 * @author EliteBook
 */
public class Solution {

    class Activities implements Comparable<Activities> {

        int an;

        int st;
        int et;

        @Override
        public int compareTo(Activities o) {
            return this.et - o.et;
        }

        public Activities(int st, int et, int an) {

            this.st = st;
            this.et = et;
            this.an = an;
        }

        @Override
        public String toString() {
            return "Activities{" + "an=" + an + ", st=" + st + ", et=" + et + '}';
        }


    }

    public static void main(String arg[]) throws Exception {
        new Solution().getResult();
    }

    public void getResult() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= tc; t++) {

            int n = Integer.parseInt(br.readLine().trim());
            List<Activities> act = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] ip = br.readLine().trim().split(" ");
                int st = Integer.parseInt(ip[0]);
                int et = Integer.parseInt(ip[1]);
                act.add(new Activities(st, et,i));

            }
//            System.out.println(act);
            Collections.sort(act);
//                System.out.println(act);
            int jim = 0;
            int pam = 0;
//               <-- The Office Referance-->
            char[] res=new char[n];
            boolean comp=true;
            for (Activities a : act) {
                if (jim <= a.st) {
                    res[a.an]='J';
                    jim = a.et;
                } else if (pam <= a.st) {
                    res[a.an]='C';
                    pam = a.et;
                } else {
                    comp=false;
                    
                }
            }
//                System.out.println(res);
            String ans=null;
            if(comp){
                ans=new String(res);
                
            }
            else{
                ans="IMPOSSIBLE";
            }
            System.out.println("Case #" + t + ": " + ans);

        }
    }
}
