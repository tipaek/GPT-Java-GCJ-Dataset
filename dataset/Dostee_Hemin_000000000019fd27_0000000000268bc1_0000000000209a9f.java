import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int cs=1; cs<=T; cs++) {
            String raw = input.next();
            String newS = "";
            int nestDepth = 0;
            int currentIndex = 0;
            for(int i=0; i<raw.length(); i++) {
                char c = raw.charAt(i);
                int n = c-48;

                if(i == 0) {
                    for(int j=0; j<n-nestDepth; j++) {
                        newS += "(";
                    }
                    newS += c;
                    for(int j=0; j<n-nestDepth; j++) {
                        newS += ")";
                    }
                    nestDepth = n;
                    currentIndex = n;
                    continue;
                }
                if(nestDepth < n) {
                    String temp = newS.substring(0, currentIndex);
                    for(int j=0; j<n-nestDepth; j++) {
                        temp += "(";
                    }
                    temp += n;
                    for(int j=0; j<n-nestDepth; j++) {
                        temp += ")";
                    }
                    temp += newS.substring(currentIndex);
                    newS = temp;
                    currentIndex += nestDepth+1;
                    nestDepth = n;
                } else {
                    int index = newS.length()-n-1;
                    newS = newS.substring(0,index+1) + c + newS.substring(index+1);
                    nestDepth = n;
                    currentIndex = index+2;
                }
            }
            System.out.println("Case #" + cs + ": " + newS);
        }
    }
}