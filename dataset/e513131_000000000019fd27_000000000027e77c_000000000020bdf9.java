import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int merp = s.nextInt();

        for(int i=0; i<merp; i++) {
            boolean isImp = false;
            int N = s.nextInt();
            String ans = "";
            List<Integer> ct = new ArrayList<Integer>();
            List<Integer> jt = new ArrayList<Integer>();
            
            for(int j=0; j<N; j++) {
                isImp = false;
                int start = s.nextInt();
                int end = s.nextInt();
    
                if((ct.contains(start+1) || ct.contains(end-1)) && (jt.contains(start+1) || jt.contains(end-1))) {   //both are busy
                    System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                    isImp = true;
                } 
                else if(!ct.contains(start+1) && !ct.contains(end-1) && !jt.contains(start+1) && !jt.contains(end-1)) { //both are free
                    fillIn(start, end, jt);
                    ans += "J";
                }
                else if(ct.contains(start+1) || ct.contains(end-1)) {   //c is busy
                    fillIn(start, end, jt);
                    ans += "J";
                }
                else if(jt.contains(start+1) || jt.contains(end-1)) {   //j is busy
                    fillIn(start, end, ct);
                    ans += "C";
                }
            }

            if(!isImp) {
                System.out.println("Case #" + (i+1) + ": " + ans);
            }
            
        }

        s.close();
    }

    static void fillIn(int start, int end, List<Integer> times) {
        for(int i=start; i<=end; i++) {
            times.add(i);
        }
    }
}