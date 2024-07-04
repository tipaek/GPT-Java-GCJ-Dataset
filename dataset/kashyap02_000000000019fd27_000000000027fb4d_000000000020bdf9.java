import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int S[] = new int[N];
            int F[] = new int[N];

            char c[] = new char[N];
            Arrays.fill(c, '0');

            boolean check[] = new boolean[N];
            for (int j = 0; j < N; j++) {
                S[j] = sc.nextInt();
                F[j] = sc.nextInt();
            }

            int S_copy[] = new int[N];
            int F_copy[] = new int[N];
            for (int j = 0; j < N; j++) {
                F_copy[j] = F[j];
                S_copy[j] = S[j];
            }

            Arrays.sort(F);


            boolean aval[] = new boolean[N];
            for (int j = 0; j < N; j++){
                for (int k = 0; k < N; k++){
                    if(F_copy[j] == F[k] && aval[k] == false){
                        aval[k] = true;
                        S[k] = S_copy[j];
                        break;
                    }
                }
            }

//            for (int j = 0; j < N; j++){
//                System.out.print(S[j] + " " + F[j] + "\n");
//            }
//
//            for (int j = 0; j < N; j++){
//                System.out.print(S_copy[j] + " " + F_copy[j] + "\n");
//            }
            Stack<Integer> s1 = new Stack<Integer>();
            Stack<Integer> s2 = new Stack<Integer>();
            int ind = 0;
            s1.push(F[ind]);
            c[ind] = 'C';
            for (int j = 1; j < N; j++){
                if(S[j] >= s1.peek()){
//                    System.out.println(F[j] + " " + s1.peek());
                    s1.push(F[j]);
                    c[j] = 'C';
                    continue;
                } else if(s2.isEmpty() == true){
                    s2.push(F[j]);
                    c[j] = 'J';
                    continue;
                } else if(S[j] >= s2.peek()){
                    s2.push(F[j]);
                    c[j] = 'J';
                    continue;
                } else {
                    c[j] = '0';
                    break;
                }
            }

            if ((String.valueOf(c)).indexOf('0') != -1) {
                System.out.print("Case #" + i + ": " + "IMPOSSIBLE");
                System.out.println();
            } else {
                char ch[] = new char[N];
                boolean available[] = new boolean[N];
                Arrays.fill(available, false);
                for (int j = 0; j < N; j++) {
                    int index = 0;
                    for (int k = 0; k < N; k++) {
                        if (S_copy[k] == S[j] && F_copy[k] == F[j] && available[k] == false) {
                            index = k;
                            available[k] = true;
                            break;
                        }
                    }
                    ch[index] = c[j];
                }
                System.out.print("Case #" + i + ": " + String.valueOf(ch));
                System.out.println();
            }
        }
    }
}

