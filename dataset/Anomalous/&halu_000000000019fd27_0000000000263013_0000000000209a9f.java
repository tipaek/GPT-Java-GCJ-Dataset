import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        
        for (int i = 0; i < t; i++) {
            String s = kb.next();
            StringBuilder str = new StringBuilder();
            int[] a = new int[s.length()];
            
            for (int j = 0; j < s.length(); j++) {
                a[j] = Character.getNumericValue(s.charAt(j));
            }
            
            int openParens = 0;
            
            for (int j = 0; j < a[0]; j++) {
                str.append("(");
                openParens++;
            }
            str.append(a[0]);
            
            for (int j = 0; j < s.length() - 1; j++) {
                int current = a[j];
                int next = a[j + 1];
                
                if (next == 0) {
                    for (int k = 0; k < openParens; k++) {
                        str.append(")");
                    }
                    openParens = 0;
                    str.append("0");
                } else if (current > next) {
                    for (int k = 0; k < (current - next); k++) {
                        str.append(")");
                        openParens--;
                    }
                    str.append(next);
                } else if (current < next) {
                    for (int k = 0; k < (next - current); k++) {
                        str.append("(");
                        openParens++;
                    }
                    str.append(next);
                } else {
                    str.append(next);
                }
            }
            
            for (int k = 0; k < openParens; k++) {
                str.append(")");
            }
            
            System.out.println("Case #" + (i + 1) + ": " + str);
        }
        
        kb.close();
    }
}