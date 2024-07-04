//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int T = input.nextInt();
//        for(int cs=1; cs<=T; cs++) {
//            String raw = input.next();
//            String newS = "";
//            int nestDepth = 0;
//            int currentIndex = 0;
//            boolean hasFoundFirst = false;
//            for(int i=0; i<raw.length(); i++) {
//                char c = raw.charAt(i);
//                int n = c-48;
//
//                if(!hasFoundFirst) {
//                    if(n != 0) {
//                        hasFoundFirst = true;
//                        for(int j=0; j<n; j++) {
//                            newS += "(";
//                        }
//                        newS += n;
//                        for(int j=0; j<n; j++) {
//                            newS += ")";
//                        }
//                        nestDepth = n;
//                        currentIndex += n;
//                    } else {
//                        newS += 0;
//                        currentIndex++;
//                    }
//                } else {
//                    if (nestDepth < n) {
//                        String temp = newS.substring(0, currentIndex+1);
//                        for (int j = 0; j < n - nestDepth; j++) {
//                            temp += "(";
//                        }
//                        temp += n;
//                        for (int j = 0; j < n - nestDepth; j++) {
//                            temp += ")";
//                        }
//                        temp += newS.substring(currentIndex+1);
//                        newS = temp;
//                        currentIndex += nestDepth+1;
//                        nestDepth = n;
//                    } else {
//                        int index = newS.length() - n;
//                        newS = newS.substring(0, index) + c + newS.substring(index);
//                        nestDepth = n;
//                        currentIndex = index;
//                    }
//                }
//            }
//            System.out.println("Case #" + cs + ": " + newS);
//        }
//    }
//}

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int cs=1; cs<=T; cs++) {
            String raw = input.next();
            StringBuilder newS = new StringBuilder();
            int nestDepth = 0;
            for(int i=0; i<raw.length(); i++) {
                char c = raw.charAt(i);
                int n = c-48;
                if(nestDepth < n) {
                    for(int j=0; j<n-nestDepth; j++) {
                        newS.append("(");
                    }
                } else {
                    for(int j=0; j<nestDepth-n; j++) {
                        newS.append(")");
                    }
                }
                newS.append(n);
                nestDepth = n;
            }
            for(int i=0; i<nestDepth; i++) {
                newS.append(")");
            }
            System.out.println("Case #" + cs + ": " + newS);
        }
    }
}