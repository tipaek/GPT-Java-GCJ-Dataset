import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
            int T = input.nextInt();
            for (int t = 1; t <= T; t++) {
                Hashtable<Character, Integer> pos = new Hashtable<Character, Integer>();
                HashSet<Character> done = new HashSet<Character>();
                int U = input.nextInt();
                input.next();
                String M, R;
                String[] line;
                int track = 1;
                Character[] digitString = new Character[10];
                for (int x=0; x<Math.pow(10, 4); x++) {
                    line = input.nextLine().split(" ");
                    M = line[0];
                    R = line[1];
                    if (M.equals("-1") || M.length() != R.length()) {
                        for (int i = 0; i < R.length(); i++) {
                            if (!pos.containsKey(R.charAt(i)) && !done.contains(R.charAt(i))) {
                                pos.put(R.charAt(i), 10);
                            }
                        }
                    }
                    else {
                        if (R.length()==1 && track==9 && !done.contains(R.charAt(0))) {
                            digitString[track]= R.charAt(0);
                            pos.remove(R.charAt(0));
                            break;
                        }
                        for (int i = 0; i < R.length(); i++) {
                            char letter = R.charAt(i);
                            int rightBound = (i==0)?Integer.parseInt(M.substring(i, i + 1)):10;
                            if (done.contains(letter)) {
                                continue;
                            }
                            if (!pos.containsKey(letter)) {
                                pos.put(letter, rightBound);
                            }
                            if (rightBound < pos.get(letter)) {
                                pos.replace(letter, rightBound);
                            }

                            if (pos.get(letter) == track && track<=9) {
                                digitString[track] = letter;
                                track++;
                                done.add(letter);
                                pos.remove(letter);
                            }
                        }

                    }
                }

                Set<Character> lastLetter = pos.keySet();
                for (Character key : lastLetter) {
                    digitString[0] = key;
                }
                System.out.print("Case #" + t + ": ");
                for (char c: digitString) {
                    System.out.print(c);
                }
                System.out.println();
            }
    }
}
