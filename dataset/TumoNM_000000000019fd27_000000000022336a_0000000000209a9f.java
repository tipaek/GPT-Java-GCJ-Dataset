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
            int runningValue = -1;
            for (int size = 0; size < s.length(); size++) { // Read eacCharacter.h digit and add parenthesis
                int indexCounter = 1;
                if (s.charAt(size) == '0'){
                    y.append(s.charAt(size));
                }
                else {
                    boolean valid = false;
                    char p = 'x';
                    while (true){ // Get repeated chars in a row
                                try {
                                    p = s.charAt(size + indexCounter);
                                    valid = true;
                                }catch (Exception e){
                                    valid = false;
                                }

                            if (valid && (s.charAt(size) == p)){
                                skipCounter += 1;
                                indexCounter += 1;
                                continue;
                            }
                            else {
                                int count = Integer.parseInt(String.valueOf(s.charAt(size)));
                                String number = String.valueOf(s.charAt(size));
                                size += (indexCounter-1);
                                String one = "",two = "",three = "";
                                int tempNumber = Integer.parseInt(number);
                                if (runningValue == -1){// Need a new running total
                                    runningValue = tempNumber;
                                }


                                if (runningValue - tempNumber > 0){ // Value to insert is smaller, don't open
                                    two = new String(new char[indexCounter]).replace("\0", number);
                                    runningValue -=tempNumber;
                                    three = new String(new char[runningValue - Integer.parseInt(String.valueOf(s.charAt(size+1)))]).replace("\0", ")");
                                }
                                else if (runningValue - tempNumber == 0 && size == 0){ // Value is bigger, open brackets.
                                    one = new String(new char[count]).replace("\0", "(");
                                    two = new String(new char[indexCounter]).replace("\0", number);
                                    try{
                                        three = new String(new char[runningValue-Integer.parseInt(String.valueOf(s.charAt(size+1)))]).replace("\0", ")");
                                    }
                                    catch (Exception e){
                                        three = new String(new char[Integer.parseInt(String.valueOf(s.charAt(size)))]).replace("\0", ")");
                                    }
                                }else if (runningValue - tempNumber == 0){
                                    if (runningValue == 2 && size == 2){
                                        one = new String(new char[count/2]).replace("\0", "(");
                                    }
                                    else{
                                        one = new String(new char[count]).replace("\0", "(");

                                    }
                                    two = new String(new char[indexCounter]).replace("\0", number);
                                    three = new String(new char[count]).replace("\0", ")");
                                    try {
                                        three = new String(new char[runningValue-Integer.parseInt(String.valueOf(s.charAt(size+1)))]).replace("\0", ")");

                                    }catch (Exception e){
                                        three = new String(new char[Integer.parseInt(String.valueOf(s.charAt(size)))]).replace("\0", ")");
                                    }
                                    runningValue -=tempNumber;
                                }
                                else if (runningValue - tempNumber < 0){ // Value is bigger, open brackets.
                                    one = new String(new char[count]).replace("\0", "(");
                                    two = new String(new char[indexCounter]).replace("\0", number);
                                    runningValue -=tempNumber;
                                    try {
                                        three = new String(new char[runningValue-Integer.parseInt(String.valueOf(s.charAt(size+1)))]).replace("\0", ")");

                                    }catch (Exception e){
                                        three = new String(new char[Integer.parseInt(String.valueOf(s.charAt(size)))]).replace("\0", ")");
                                    }
                                }

                                y.append(one+two+three);
                                indexCounter = 1;
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