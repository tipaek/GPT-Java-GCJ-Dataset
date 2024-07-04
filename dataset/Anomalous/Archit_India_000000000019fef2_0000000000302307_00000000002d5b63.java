import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();

            boolean foundCenter = false;

            for (int j = -5; j <= 5; j++) {
                for (int k = -5; k <= 5; k++) {
                    System.out.println(j + " " + k);
                    String response = sc.nextLine();

                    if (response.equalsIgnoreCase("CENTER")) {
                        foundCenter = true;
                        break;
                    }
                }
                if (foundCenter) {
                    break;
                }
            }
        }

        sc.close();
    }
}