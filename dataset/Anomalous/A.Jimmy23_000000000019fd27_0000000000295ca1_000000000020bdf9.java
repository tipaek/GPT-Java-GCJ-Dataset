import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int cas = 1; cas <= t; cas++) {
            int T = scan.nextInt();
            int[] arr = new int[T * 2];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scan.nextInt();
            }
            
            StringBuilder Snew = new StringBuilder("J");
            char currentChar = 'J';
            boolean isImpossible = false;
            int impooCount = 0;
            boolean none = false;

            for (int i = 1; i < arr.length; i++) {
                int imp = arr[1];

                if (!none) {
                    if ((i + 1 < arr.length) && (arr[i + 1] < imp && arr[i + 2] < imp)) {
                        impooCount++;
                    } else {
                        none = true;
                    }
                }

                if (impooCount >= 2 || (i + 1 < arr.length && arr[i] == 1440)) {
                    Snew = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }

                if ((i + 1 < arr.length) && arr[i + 1] < arr[i]) {
                    currentChar = (currentChar == 'J') ? 'C' : 'J';
                    Snew.append(currentChar);
                } else {
                    Snew.append(currentChar);
                }

                i++;
            }

            System.out.println("Case #" + cas + ": " + Snew.toString());
        }
    }
}