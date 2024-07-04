import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Reads in number of lines
        String[] answers = new String[t];
        for (int i = 0; i < t; ++i) { // For every N
            String s = in.next(); // Reads in the string
            StringBuilder y = new StringBuilder();
            int skipCounter = 0;
            for (int size = 0; size < s.length(); size++) { // Read eacCharacter.h digit and add parenthesis
                if (s.charAt(size) == '0'){
                    y.append(s.charAt(size));
                }
                else {
                    boolean valid = false;
                    char p = 'x';
                    while (true){ // Get repeated chars in a row
                                try {
                                    if (size == 0 && skipCounter == 0){
                                        skipCounter+=1;
                                    }
                                    p = s.charAt(size + skipCounter);
                                    valid = true;
                                }catch (Exception e){
                                    valid = false;
                                }

                            if (valid && (s.charAt(size) == p)){
                                skipCounter += 1;
                                continue;
                            }
                            else {
                                int count = Integer.parseInt(String.valueOf(s.charAt(size)));
                                String number = String.valueOf(s.charAt(size));
                                if (size == 0 && skipCounter == 1){
                                    skipCounter -= 1;
                                }
                                size += (skipCounter);
                                if (skipCounter == 0) {
                                    skipCounter = 1;
                                }
                                String one = new String(new char[count]).replace("\0", "(");
                                String two = new String(new char[skipCounter]).replace("\0", number);
                                String three = new String(new char[count]).replace("\0", ")");
                                y.append(one+two+three);
                                if (skipCounter > 1) size -= 1;
                                break;
                            }
                    }
                }
            }
            answers[i] = ("Case #" + (i+1) + ": " + y.toString());
        }
        for (String str : answers){
            System.out.println(str);
        }
    }
}