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
            while(i<input.length()){
                int now = input.charAt(i)-'0';
                if(now==1){
                    sb.append('(');
                    sb.append(now);

                    int cnt = 1;
                    i++;
                    while(i<input.length()){
                        int tmp = input.charAt(i)-'0';
                        if(now==tmp){
                            sb.append(tmp);
                            cnt++;
                            i++;
                        }
                        else{

                            break;
                        }
                    }
                    sb.append(')');

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
