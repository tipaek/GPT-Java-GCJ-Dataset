    import java.util.Scanner;
    import java.util.*;
    public class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int cas = sc.nextInt();
            for (int i = 0; i<cas; i++) {
                int lines = sc.nextInt();
                String[] conds = new String[lines];
                for (int j = 0; j<lines; j++) {
                    conds[j]=sc.next();
                }
                boolean done = false;
                for (int j = 0; j<lines; j++) {
                    boolean b = true;
                    for (int k = 0; k<lines; k++) {
                        if (!(conds[j].substring(1).contains(conds[k].substring(1)))) {
                            b=false;
                        }
                    }
                    if (b&&(!done)) {
                        System.out.println("Case #"+(i+1)+": "+conds[j].substring(1));
                        done=true;
                    }
                }
                if (!done) {
                    System.out.println("Case #"+(i+1)+": *");
                }
            }
        }
    }