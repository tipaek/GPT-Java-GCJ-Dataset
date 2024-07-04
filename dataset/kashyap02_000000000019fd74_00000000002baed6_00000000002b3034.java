import java.util.*;
class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++){
            int N = sc.nextInt();
            int max = 0;
            int index = 0;
            String S[] = new String[N];
            for(int j = 0; j < N; j++){
                S[j] = sc.next();
                if((S[j].length() - 1) > max) {
                    max = Math.max(max, S[j].length() - 1);
                    index = j;
                }
            }
            int len = S[index].length() - 1;
            int flag = 0;
            for(int j = 0; j < N; j++){
                int l = S[j].length() - 1;
//                System.out.println(len + " " + l);
                String s = S[index].substring((len - l + 1));
//                System.out.println(s + " " + S[j]);
                if(s.equals(S[j].substring(1)) == false){
                    flag = 1;
                    break;
                }
            }

            if(flag == 0)
                System.out.print("Case #" + i + ": " + S[index].substring(1));
            else
                System.out.print("Case #" + i + ": *");
            System.out.println();
        }
    }
}
