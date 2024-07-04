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
                if(isImp)
                isImp = false;
                int start = s.nextInt();
                int end = s.nextInt();
    
                if(isBusy(start, end, ct) && isBusy(start, end, jt)) {   //both are busy
                    isImp = true;
                    System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                    break;
                } 
                else if(!isBusy(start, end, ct) && !isBusy(start, end, jt) && !isImp) { //both are free
                    fillIn(start, end, jt);
                    ans += "J";
                }
                else if(isBusy(start, end, ct) && !isImp) {   //c is busy
                    fillIn(start, end, jt);
                    ans += "J";
                }
                else if(isBusy(start, end, jt) && !isImp) {   //j is busy
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

    static boolean isBusy(int start, int end, List<Integer> times) {
        if(times.contains(start) && times.contains(end)) {
            return true;
        }
        for(int i=start+1; i<end; i++) {
            if(times.contains(i)) {
                return true;
            }
        }
        return false;
    }
}