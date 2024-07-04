import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++) {

            int N = sc.nextInt();
            String[] words = new String[N];

            String unique = "";
            boolean impossible = false;

            for(int n = 1; n <= N; n++) {
                words[n-1] = sc.next();
                if(words[n-1].indexOf('*') == -1) {
                    unique = words[n-1];
                }
            }


            if(unique.length() > 0) {
                for(int n = 0; n < N; n++) {
                    if(!unique.matches(words[n])) {
                        impossible = true;
                        break;
                    }
                }
                if(!impossible) {
                    System.out.println("Case #"+t+": "+unique);
                } else {
                    System.out.println("Case #"+t+": *");
                }
                continue;
            }

            char[] answer = new char[10000];
            Arrays.fill(answer,'-');

            int[][] indexes = new int[N][2];

            int start = 0;
            int end = 9999;

            for(int n = 0; n < N && !impossible; n++) {
                String s = words[n];

                int j = 0;
                for(j  = 0; j <= s.length() - 1 && s.charAt(j) != '*'; j++) {
                    if(answer[j] != '-' && answer[j] != s.charAt(j)) {
                        impossible = true;
                        break;
                    }
                    answer[j] = s.charAt(j);
                }
                indexes[n][0] = j;

                int count = 0;
                for(j = s.length() - 1; j >= 0 && s.charAt(j) != '*'; j--) {
                    if(answer[9999-count] != '-' && answer[9999-count] != s.charAt(j)) {
                        impossible = true;
                        break;
                    }
                    answer[9999-count] = s.charAt(j);
                    count++;
                }
                indexes[n][1] = j;

            }

            if(impossible) {
                System.out.println("Case #"+t+": *");
                continue;
            }

            String body = "";



            for(int n = 0; n < N; n++) {

                for(int k = indexes[n][0]; k <= indexes[n][1]; k++) {
                    if(words[n].charAt(k) != '*') {
                        body += words[n].charAt(k);
                    }
                }

            }

            String head = "";
            String tail = "";

            for(int i = 0; i <= 9999 && answer[i] != '-'; i++) {
                head = head + answer[i];
            }

            for(int i = 9999; i >= 0 && answer[i] != '-'; i--) {
                tail = answer[i] + tail;
            }

            body  = head + body + tail;


            System.out.println("Case #"+t+": "+body);



        }
        
    }
}