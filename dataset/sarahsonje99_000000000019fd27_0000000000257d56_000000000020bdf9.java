import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int case_no = 1;
        while(case_no<=t) {
            String ans = "";
            int n = sc.nextInt();
            int[][] act = new int[n][3];
            Map<Integer, Integer> indx = new TreeMap<Integer, Integer>();
            for(int i = 0 ;i<n; i++){
                act[i][0] = sc.nextInt();
                act[i][1] = sc.nextInt();
                act[i][2] = i;
            }
            
            Comparator<int[]> cmp = new Comparator<int[]>() {
                @Override
                public int compare(int[] x, int[] y) {
                    if(x[0]!=y[0])
                        return x[0]-y[0];
                    return x[1]-y[1];
                }
            };
            int c_end = 0;
            int j_end = 0;
            Arrays.sort(act, cmp);
            
            for(int i=0; i<n; i++) {
                int start = act[i][0];
                int end = act[i][1];
                if(c_end<=start) {
                    c_end = end;
                    indx.put(act[i][2], new Integer(1));
                }
                else if(j_end <= start) {
                    j_end = end;
                    indx.put(act[i][2], new Integer(2));
                }
                else {
                    ans = "IMPOSSIBLE";
                    break;
                }
            }
            
            if(ans=="") {
                for(Integer i: indx.values().toArray(new Integer[n]))
                {
                    // System.out.print(i);
                    if(i==1)
                        ans += "C";
                    else
                        ans += "J";
                }
            }
                
            
            
            System.out.println("Case #"+case_no+++": "+ans);
        }
    }
}