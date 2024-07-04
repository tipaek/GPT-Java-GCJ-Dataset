import java.util.*;
class Solution {
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder result = new StringBuilder();
            int pre = 0;
            String line = sc.next();
            for(int i = 0; i < line.length(); i ++){
                int num = line.charAt(i) - '0';
                if(num < pre){
                    int close = pre - num;
                    for(int index = 0; index < close; index++){
                        result.append(")");
                    }
                }else if(num > pre){
                    int open = num - pre;
                    for(int index = 0; index < open; index++){
                        result.append("(");
                    }
                }
                result.append(num);
                pre = num;
            }
            for(int i = 0; i < pre; i++){
                result.append(")");
            }
            System.out.println("case #" + t + ": " + result.toString());
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        s.solve();
    }

}