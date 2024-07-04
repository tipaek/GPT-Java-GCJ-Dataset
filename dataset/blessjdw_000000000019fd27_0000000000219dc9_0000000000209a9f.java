import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            char[] word = in.next().toCharArray();
            List<Character> arr = new ArrayList<>();
            int pCount = 0;
            for (int i = 0; i < word.length; i++) {
                if (arr.size() == 0) {
                    pCount = word[i] - '0';
                    for (int j = 0; j < pCount; j++) arr.add('(');
                } else {
                    char lastC = arr.get(arr.size()-1);
                    if (lastC < word[i]) {
                        int diff = word[i] - lastC;
                        for (int j = 0; j < diff; j++) arr.add('(');
                        pCount += diff;
                    } else if (lastC > word[i]) {
                        int diff = lastC - word[i];
                        for (int j = 0; j < diff; j++) arr.add(')');
                        pCount -= diff;
                    }
                }
                arr.add(word[i]);
            }

            for (int j = 0; j < pCount; j++) arr.add(')');

            /////
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}

//312
//Case #1: (((3)))(1)((2)) => (((3))1(2))