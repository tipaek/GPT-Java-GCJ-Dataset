import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++){
            String input = sc.next();
            Stack<Integer> st = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            sb.append("Case #"+tc+": ");
            while(i<input.length()){
                int now = input.charAt(i)-'0';
                if(now!=0){
                    int cnt = 0;
                   for(int j=0;j<now;j++){
                       sb.append('(');
                       cnt++;
                   }

                   sb.append(now);
                   i++;
                   while(i<input.length()){
                       int tmp = input.charAt(i)-'0';
                       if(tmp==0){
                           break;
                       }
                       if(tmp==now){
                           sb.append(tmp);
                           i++;
                       }
                       else if(tmp>now){
                            int dif = tmp-now;
                            for(int j=0;j<dif;j++){
                                sb.append('(');
                                cnt++;
                            }
                            sb.append(tmp);
                            now = tmp;
                            i++;
                       }
                       else {
                            int dif = now - tmp;
                            for(int j=0;j<dif;j++){
                                sb.append(')');
                                cnt--;
                            }
                            sb.append(tmp);
                            now = tmp;
                            i++;
                       }

                   }
                   for(int j=0;j<cnt;j++){
                       sb.append(')');
                   }

                }
                else {
                    sb.append(now);
                    i++;
                }

            }
            System.out.println(sb.toString());


        }
    }
}
