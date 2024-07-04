import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String str = scanner.next();
            
            int[] front = new int[str.length() + 1];
            int[] back = new int[str.length() + 1];
            boolean[] blocked = new boolean[str.length() + 1];
            blocked[str.length()] = true;
            int curApplied = 0;

            for (int j = 0; j < 10; j++) {
                boolean factor = false;
                for (int k = 0; k < str.length(); k++) {
                    if(str.charAt(k) == (char)(j + '0')) {
                        factor = true;
                        break;
                    }
                }

                if(factor) {
                    boolean left = true;
                    for (int k = 0; k < blocked.length; k++) {
                        if(!blocked[k] && left) {
                            left = false;
                            front[k]+= j - curApplied;
                        }
                        else if (blocked[k] && !left){
                            left = true;
                            back[k]+= j - curApplied;
                        }
                        else {
                            continue;
                        }
                    }
                    curApplied = j;
                }

                for (int k = 0; k < str.length(); k++) {
                    if(str.charAt(k) == (char)(j + '0')) {
                        blocked[k] = true;
                    }
                }


            }

            String ans = "";
            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < front[j]; k++) {
                    ans += "(";
                }
                for (int k = 0; k < back[j]; k++) {
                    ans += ")";
                }
                ans += str.charAt(j);
            }

            for (int j = 0; j < back[str.length()]; j++) {
                ans += ")";
            }


            System.out.println("Case #" + (i + 1) + ": " + ans);
            

            


        }
    }
}
