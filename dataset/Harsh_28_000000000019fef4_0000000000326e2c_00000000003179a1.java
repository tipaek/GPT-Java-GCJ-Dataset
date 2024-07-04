import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        //Problem1
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {

                ArrayList<Character> map[] = new ArrayList[10];

                for (int j = 0; j < 10; j++) {
                    map[j] = new ArrayList<>();
                }
                for (int j = 0; j < 1000; j++) {
                    int U = sc.nextInt();
                    int M = sc.nextInt();
                    String Q = sc.next();
                    int digits[] = new int[U];

                    if (M >= 0 && M <= 9) {
                        map[M].add(Q.charAt(0));
                    } else {

                        while (M > 0) {
                            digits[--U] = M % 10;
                            M = M / 10;
                        }

                        for (int k = 0; k < digits.length; k++) {
                            map[M].add(Q.charAt(k));
                        }
                    }
                }

                Character finalmap[] = new Character[10];
                for (int l = 0; l < 10; l++) {
                    int max = 0;
                    int curr = 0;
                    Character currKey = null;
                    Set<Character> unique = new HashSet<Character>(map[l]);
                    for (Character key : unique) {
                        curr = Collections.frequency(map[l], key);

                        if (max < curr) {
                            max = curr;
                            currKey = key;
                        }
                    }
                    
                    finalmap[l]=currKey;
                }
                
                System.out.println("Case #" + (i+1) + ": " + finalmap );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
