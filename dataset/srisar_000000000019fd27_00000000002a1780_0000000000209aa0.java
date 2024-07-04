import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;



 class Solution {
     
     public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        long test = scanner.nextInt();

        long t = 0;

        while (t < test) {


            BigInteger[][] a =  new BigInteger[1][2];

            for (int i = 0; i <1 ; i++) {
                for (int j = 0; j <2 ; j++) {
                    a[i][j] = scanner.nextBigInteger();
                }

            }

            BigInteger n = a[0][0];

            BigInteger k = a[0][1];

            int n1 = n.intValue();

             BigInteger[] num = new BigInteger[n1];

            BigInteger[] num1 = new BigInteger[num.length-1];

             BigInteger e = BigInteger.ONE;

            BigInteger q = k.divide(n);

            int j1 = 0;


            for (int i = 0; i <n1 ; i++) {

                num[i] = e;
                e  = e.add(BigInteger.ONE);
            }


            boolean p = false;

            for (int i = 0; i <num.length ; i++) {

                if(num[i].multiply(n).equals(k)){
                   p = true;
                }
            }


            for (int i = 0; i < num.length ; i++) {
                if(!q.equals(num[i])) {
                    num1[j1] = num[i];

                    j1++;
                }
            }



            Arrays.sort(num1);

            if(p){

                System.out.println("Case"+" "+"#"+(t+1)+":"+" "+"POSSIBLE");



                BigInteger[][] y = new BigInteger[n1][n1];

                for (int i = 0; i <n1 ; i++) {

                    int j2 = 0;


                        BigInteger last = num1[num1.length - 1];
                    for (int j = num1.length-1; j >0 ; j--) {
                        num1[j] = num1[j-1];
                    }

                        num1[0] = last;





                    for (int j = 0; j <n1 ; j++) {
                        if(i==j){
                            y[i][j] = q;
                        }

                        if(i!=j){
                            y[i][j] = num1[j2];

                            j2++;
                        }
                    }

                }

                for (BigInteger[] x:y) {
                    System.out.println(Arrays.toString(x).replaceAll(",", " ").replaceAll("\\[|\\]", ""));
                }



            }else{

                System.out.println("Case"+" "+"#"+(t+1)+":"+" "+"IMPOSSIBLE");


            }

            t++;


        }
    }
 }