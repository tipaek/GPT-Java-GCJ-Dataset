import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++){
            //init for this test case
//            StringBuilder output = new StringBuilder();
            String output = "";
            int N = sc.nextInt();
            int length = 0;
            int flag = 0;
            for (int j = 0; j < N; j++) {
                String cur = sc.next();
                String tem = cur.substring(1, cur.length());
                if (tem.length() >= output.length()) {
                    if (tem.contains(output)) {
                        output = tem;
                        continue;
                    } else {
                        flag = 1;
                        break;
                    }
                } else {
                    if (output.contains(tem)) {
                        continue;
                    }else {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 1) {
                output = "*";
            }
            //output
            System.out.println("case #" + i + ": " + output);
        }
    }
}