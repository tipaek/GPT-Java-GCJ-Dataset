import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            List<List<Integer>> val = new ArrayList<>();
            
            Partner C = new Partner();
            Partner J = new Partner();

            StringBuilder result = new StringBuilder();

            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int j2 = 0; j2 < 2; j2++) {
                    temp.add(sc.nextInt());
                }
                val.add(temp);
            }

            for (int k = 0; k < n; k++) {
                int start = val.get(k).get(0);
                int end = val.get(k).get(1);

                if(C.eTime <= start || C.sTime >= end ) {
                    C.sTime = start;
                    C.eTime = end;
                    result.append('C');
                }else if (J.eTime <= start || J.sTime >= end ) {
                    J.sTime = start;
                    J.eTime = end;
                    result.append('J');
                }else{
                    result.delete(0, result.length());
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);

        }

        sc.close();
    }
}

class Partner {

    int sTime, eTime;

    Partner() {
        sTime = 0;
        eTime = 0;
    }

}
