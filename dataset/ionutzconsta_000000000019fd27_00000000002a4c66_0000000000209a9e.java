import java.util.Scanner;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();
        int b = sc.nextInt();

        for(int t = 0; t < tests; t++) {


            boolean[] result = new boolean[b+1];

            //skip first because it changes anyway
            System.out.println(1);
            sc.nextInt();

            //read first and last


            for(int i = 1 ; i <= b; i++) {
                System.out.println(i);
                result[i] = sc.nextInt() != 0;
            }


            String output = "";
            for(int i = 1; i <= result.length - 1; i++)
                output += result[i] ? 1 : 0;

            System.out.println(output);
        }


        sc.close();
    }
}
