import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int t=1; t<=T; t++) {
            Hashtable<Character, Integer> pos= new Hashtable<Character, Integer>();
            HashSet<Character> done = new HashSet<Character>();
            int U=input.nextInt();
            String M, R;
            String[] line;
            int track = 1;
            Character[] digitString = new Character[10];

            while (input.hasNext()) {
                line = input.nextLine().split(" ");
                M = line[0];
                R = line[1];
                if (!M.equals("-1") || M.length() != R.length()) {
                    for (int i=0; i<R.length(); i++) {
                        if (!pos.containsKey(R.charAt(i)) && !done.contains(R.charAt(i))) {
                            pos.put(R.charAt(i), 9);
                        }
                    }
                }
                else {
                    ArrayList<Integer> range = new ArrayList<Integer>();
                    range.add(9);
                    for (int i=0; i<R.length(); i++) {
                        char letter = R.charAt(i);
                        int rightBound = Integer.parseInt(M.substring(i, i+1));
                        if (done.contains(letter)) {
                            continue;
                        }
                        if (!pos.containsKey(letter)) {
                            pos.put(letter, 9);
                        }
                        if (rightBound < pos.get(letter)) {
                            pos.replace(letter, rightBound);
                        }

                        if (pos.get(letter) == track) {
                            digitString[track]=letter;
                            track++;
                            done.add(letter);
                            pos.remove(letter);
                        }
                    }

                }

                if (track == 9 && !pos.isEmpty()) {
                    break;
                }
            }
            Set<Character> lastLetter = pos.keySet();
            for (Character key: lastLetter) {
                digitString[0] = key;
            }
            System.out.println("Case #"+t+": "+digitString.toString());
        }
    }
}
