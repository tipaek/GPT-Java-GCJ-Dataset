import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            StringBuilder m = new StringBuilder();
            String n = in.nextLine();
            if (n.equals("1")) {
                System.out.println("Case #" + i + ": (1)");
            }
            else if (n.equals("0")){
                System.out.println("Case #" + i + ": 0");
            }
            else {

                int whereweat = n.length()-1; //Length of orig line
                System.out.println("Where we at?" +whereweat);
                int placeholder = 1;
                //System.out.println("first number:" + n.charAt(0));
                if (n.charAt(1) == 1)  {
                    m.append("(1");
                }
                else { //if the first one from the original is a 0
                    m.append("0");
                }

                while (placeholder <= whereweat) {
                    if (n.charAt(placeholder) == 1) { //if the current char is a 1
                        if (m.toString().charAt(m.length()-1) == 1) { //check to see if the last # added is a 1
                            m.append("1");
                        }
                        else { //if the next # from original string is a 0
                            if (m.toString().charAt(m.length()-1) == 1) { //check to see if the last # added is a 1
                                m.append(")0");
                            }
                            else { //if the last added is a 0
                                m.append("0");
                            }
                        }

                    }
                    placeholder++;

                }
                System.out.println("Case #" + i + ": " + m.toString());


            }
        }

    }
} 