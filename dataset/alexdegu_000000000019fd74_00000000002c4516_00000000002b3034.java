 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
       for (int l = 1; l <= t; ++l) {
                int n = in.nextInt();
                String[] patt_array = new String[n];

                for (int i = 0; i < n; i++) {
                    String pattern = in.next();
                    patt_array[i] = pattern;
                }

                String patt = "";
                boolean found = true;
                String patt1 = patt_array[0];
                for (int i = 1; i < n; i++) {
                    //System.out.println(patt);
                    String patt2 = patt_array[i];
                    patt = "";
                    int num1 = patt1.indexOf("*");
                    int num2 = patt2.indexOf("*");

                    if (num1 > 0 && num2 > 0) {
                        if (!patt1.substring(0, num1).startsWith(patt2.substring(0, num2)) && !patt2.substring(0, num2).startsWith(patt1.substring(0, num1))) {
                            //System.out.println("Case #" + l + ": *");
                            //System.out.println(patt1.substring(0, num1) + " : " + patt2.substring(0, num2));
                            found = false;
                            break;
                        } else {

                        }
                    } else if (num1 == 0 && num2 > 0) {
                        patt += patt2.substring(0, num2);
                        //patt2 = patt2.substring(num2 + 1);
                    } else if (num1 > 0 && num2 == 0) {
                        patt += patt1.substring(0, num1);
                        //patt1 = patt1.substring(num1 + 1);
                    }

                    patt2 = patt2.substring(num2 + 1);
                    patt1 = patt1.substring(num1 + 1);
                   // System.out.println(patt1 + " :  " + patt2);

                    num1 = patt1.indexOf("*");
                    num2 = patt2.indexOf("*");

                    while (num1 != -1 && num2 != -1) {

                        String str1 = patt1.substring(0, num1);
                        String str2 = patt2.substring(0, num2);

                        //System.out.println(str1 + "  " + str2 + " " + num2);
                        if (str1.contains(str2)) {
                            patt += str1;
                        } else if (str2.contains(str1)) {
                            patt += str2;
                        } else {
                           // System.out.println(patt);
                            patt += str1 + "*" + str2;
                        }

                        patt2 = patt2.substring(num2 + 1);
                        patt1 = patt1.substring(num1 + 1);

                        num1 = patt1.indexOf("*");
                        num2 = patt2.indexOf("*");
                        patt += "*";
                    }

                    if (patt1.length() == 0) {
                        patt += patt2;
                    } else if (patt2.length() == 0) {
                        patt += patt1;
                    } else if (!patt1.contains("*") && !patt2.contains("*")) {
                        if (patt2.endsWith(patt1)) {
                            patt += patt2;
                        } else if (patt1.endsWith(patt2)) {
                            patt += patt1;
                        } else {
                            found = false;
                            //System.out.println(patt1 + " : " + patt2 +  " " + i);
                            break;
                        }
                    } else if (patt1.contains("*")) {
                        if (patt1.substring(patt1.lastIndexOf("*") + 1).endsWith(patt2)) {
                            patt += patt1;
                        } else if (patt1.endsWith("*")) {
                            patt += patt2;
                        } else {
                            found = false;
                            //System.out.println(patt1 + " : " + patt2);
                            break;
                        }
                    } else {
                        if (patt2.substring(patt2.lastIndexOf("*") + 1).endsWith(patt1)) {
                            patt += patt2;
                        } else if (patt2.endsWith("*")) {
                            patt += patt1;
                        } else {
                            found = false;
                            //System.out.println(patt1 + " : " + patt2 + " " + patt);
                            break;
                        }
                    }

                    patt1 = patt;
                }

                if (found) {
                    patt = patt.replace("*", "");
                    System.out.println("Case #" + l + ": " + patt);
                } else {
                    System.out.println("Case #" + l + ": *");
                }

                //System.out.println("Case #" + l + ": " + s);
            }
      }
    }