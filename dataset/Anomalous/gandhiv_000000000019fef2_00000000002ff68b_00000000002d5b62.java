import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        
        for (int i1 = 1; i1 <= n1; i1++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            String result = "";

            System.out.print("Case #" + i1 + ": ");
            
            if ((absX + absY) % 2 == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                if (absX == 1 && absY == 0) result += "E";
                else if (absX == 0 && absY == 1) result += "N";
                else if (absX == 2 && absY == 1) result += "NE";
                else if (absX == 1 && absY == 2) result += "EN";
                else if (absX == 3 && absY == 0) result += "EE";
                else if (absX == 0 && absY == 3) result += "NN";
                else if (absX == 2 && absY == 3) result += "SEN";
                else if (absX == 3 && absY == 2) result += "WNE";
                else if (absX == 4 && absY == 1) result += "SNE";
                else if (absX == 1 && absY == 4) result += "WEN";
                else if (absX == 3 && absY == 4) result += "EEE";
                else if (absX == 4 && absY == 1) result += "NNE";

                if (x < 0) {
                    result = result.replace('W', 'e').replace('E', 'w').toUpperCase();
                }
                
                if (y < 0) {
                    result = result.replace('N', 's').replace('S', 'n').toUpperCase();
                }

                System.out.println(result);
            }
        }
        
        sc.close();
    }
}