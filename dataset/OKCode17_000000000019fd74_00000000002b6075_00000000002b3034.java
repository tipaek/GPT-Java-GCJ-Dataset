import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;

    private void solve() {
        int num = sc.nextInt();
        String left = null;
        String right = null;
        List<String> leftList = new ArrayList<>();
        List<String> rightList = new ArrayList<>();
        for(int i=0;i<num;i++){
            String s = sc.next();
            String[] parts = s.split("\\*");
            if(parts.length>2) {
                break;
            }
            leftList.add(parts[0]);
            left = left == null ? parts[0] : (parts[0].length() > left.length() ? parts[0] : left);
            if(s.endsWith("*")){

                rightList.add("");
            }else {
                rightList.add(parts[1]);
                right = right == null ? parts[1] : (parts[1].length() > right.length() ? parts[1] : right);
            }
        }
        if(leftList.size()>0)
            for(String leftS : leftList){
                if(leftS.isEmpty()){
                    continue;
                }
                if(!left.startsWith(leftS)){
                    out.println("*");
                    return;
                }
            }
        if(rightList.size()>0)
            for(String rightS : rightList){
                if(rightS.isEmpty()){
                    continue;
                }
                if(!right.endsWith(rightS)){
                    out.println("*");
                    return;
                }
            }
        out.println(left+right);
    }

    private void run() throws Exception {
        // out = new PrintStream(new FileOutputStream(OUT));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}