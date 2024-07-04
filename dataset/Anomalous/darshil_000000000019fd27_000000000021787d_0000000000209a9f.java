import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            StringBuilder op = new StringBuilder();
            int openCount = 0;
            int closeCount = 0;

            for (int x = 0; x < s.length(); x++) {
                int currentDigit = Character.getNumericValue(s.charAt(x));
                
                if (currentDigit == 0) {
                    for (int comp = 0; comp < openCount - closeCount; comp++) {
                        op.append(')');
                        closeCount++;
                    }
                    op.append('0');
                } else {
                    int diff = currentDigit - (openCount - closeCount);
                    if (diff >= 0) {
                        for (int comp = 0; comp < diff; comp++) {
                            op.append('(');
                            openCount++;
                        }
                        op.append(currentDigit);
                    } else {
                        for (int comp = diff; comp < 0; comp++) {
                            op.append(')');
                            closeCount++;
                        }
                        op.append(currentDigit);
                    }
                }
            }

            for (int comp = 0; comp < openCount - closeCount; comp++) {
                op.append(')');
                closeCount++;
            }

            System.out.println("Case #" + (i + 1) + ": " + op.toString());
        }
        
        sc.close();
    }
}