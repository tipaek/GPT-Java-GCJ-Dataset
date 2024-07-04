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

            String answer = sc.next();
            boolean s = false;
            boolean r = false;
            boolean both = false;
            while(!answer.equals("Y")) {

                String output2 = "";

                if(!s) {
                    for(int i = 1; i <= result.length - 1; i++)
                        output2 += result[i] ? 0 : 1;

                    System.out.println(output2);
                    s = true;
                }

                else if(!r) {
                    for(int i = 1; i <= result.length - 1; i++) {
                        boolean aux = result[i];
                        result[i] = result[b + 1 - i];
                        result[b + 1 - i] = aux;
                    }

                    for(int i = 1; i <= result.length - 1; i++)
                        output2 += result[i] ? 1 : 0;


                    System.out.println(output2);
                    r = true;
                }

                else if(!both) {
                    for(int i = 1; i <= result.length - 1; i++) {
                        boolean aux = result[i];
                        result[i] = result[b + 1 - i];
                        result[b + 1 - i] = aux;
                    }

                    for(int i = 1; i <= result.length - 1; i++)
                        output2 += result[i] ? 0 : 1;

                    System.out.println(output2);
                    both = true;
                }


                answer = sc.next();

            }
        }


        sc.close();
    }
}
