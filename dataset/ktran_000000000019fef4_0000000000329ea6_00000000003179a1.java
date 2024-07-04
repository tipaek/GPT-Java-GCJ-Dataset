
import java.util.*;


public class Solution {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();



        for(int t = 1; t <= T; t++) {

            int U = sc.nextInt();

            Map<Character,int[]> choices = new HashMap<>();


            String answer;
            String Q;




            for(int i = 0; i < 10000; i++) {

                Q = sc.next();

                answer = sc.next();

                //if(!Q.equals("-1")) {
                int length = 0;
                int d = 0;

                if(Q.equals("-1")) {
                    length = U;
                    d = 0;
                } else {
                    length = Q.length();
                    d = (Q+"").charAt(0) - '0';
                }



                    for(char c : answer.toCharArray()) {
                        if(!choices.containsKey(c)) {
                            choices.put(c, new int[] {0 , 9});
                        }
                    }

                    char c = answer.charAt(0);



                    int[] choice = choices.getOrDefault(c, new int[]{0,9});

                    if(answer.length() == 1 && length < 2) {
                        choice[0] = Math.max(choice[0],0);
                        choice[1] = Math.min(choice[1],d);
                    } else {
                        if(length == answer.length()) {
                            choice[0] = Math.max(choice[0], 1);
                            choice[1] = Math.min(choice[1],d);
                        } else {
                            choice[0] = Math.max(choice[0], 1);
                        }
                    }

                    choices.put(c, choice);

                }
            //}

            char[] D = new char[10];
            int count = 10*11/2;

            for(int i = 0; i < count; i++) {
                for(char c : choices.keySet()) {
                    int[] choice = choices.get(c);
                    if(choice[0] == 0) {
                        D[0] = c;
                        continue;
                    }
                    if(choice[0] == choice[1] ) {
                        D[choice[0]] = c;
                        for(char c1 : choices.keySet()) {
                            int[] tmp = choices.get(c1);
                            if(tmp[0] != 0 && tmp[0] != tmp[1])
                                tmp[0] = Math.max(tmp[0], choice[0]+1);

                        }
                    }

                }
            }

            System.out.println("Case #"+t+": "+new String(D));

        }

    }
}