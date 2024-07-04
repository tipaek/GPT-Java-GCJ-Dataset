import java.util.*;
import java.io.*;

class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine().trim());
        for(int cas = 1; cas <= testCases; cas++) {
            String ar = scan.nextLine().trim();
            String ar2 = String.valueOf(ar);
            for(int i = 9; i >= 1; i--) {
                String temp = "";
                for(int j = 0; j < ar2.length(); j++) {
                    if(ar2.charAt(j) == (char) (i+'0')) {
                        for(int k = j+1; k <= ar2.length(); k++) {
                            if(k == ar2.length()) {
                                temp += "(";
                                for(int lol = 0; lol < k-j; lol++) {
                                    if(ar2.charAt(lol+j) == ')' || ar2.charAt(lol+j) == '(') temp += ar2.charAt(lol+j);
                                    else temp += Integer.toString(i-1);
                                }
                                temp += ")";
                                j = k;
                                break;
                            }
                            if(ar2.charAt(k) != ar2.charAt(j) && ar2.charAt(k) != '(' && ar2.charAt(k) != ')') {
                                temp += "(";
                                for(int lol = 0; lol < k-j; lol++) {
                                    if(ar2.charAt(lol+j) == ')' || ar2.charAt(lol+j) == '(') temp += ar2.charAt(lol+j);
                                    else temp += Integer.toString(i-1);
                                }
                                temp += ")";
                                j = k-1;
                                break;
                            }
                        }
                    }
                    else {
                        temp += ar2.charAt(j);
                    }
                }
                ar2 = temp;
            }
            int pointer = 0;
            String ans = "";
            for(int i = 0; i < ar2.length(); i++) {
                if(ar2.charAt(i) == '0') {
                    if(pointer >= ar.length()) ans += "*";
                    else ans += ar.charAt(pointer);
                    pointer++;
                }
                else ans += ar2.charAt(i);
            }
            System.out.println("Case #" + cas + ": " + ans);
        }
    }
}
