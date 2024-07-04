import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;


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

             int[] num = new int[n1];

            int[] num1 = new int[num.length-1];

             int e = 1;

            BigInteger q = k.divide(n);

            int j1 = 0;


            num = IntStream.rangeClosed(e,n1).toArray();


            boolean p = false;

            for (int i = 0; i <num.length ; i++) {
                if(BigInteger.valueOf(num[i]).multiply(n).equals(k)){
                   p = true;
                }
            }


            for (int i = 0; i < num.length ; i++) {
                if(!q.equals(BigInteger.valueOf(num[i]))) {
                    num1[j1] = num[i];

                    j1++;
                }
            }



            Arrays.sort(num1);

            if(p){

                System.out.println("Case"+" "+"#"+(t+1)+":"+" "+"POSSIBLE");



                int[][] y = new int[n1][n1];

                for (int[] i:y ) {

                    int j2 = 0;


                        int last = num1[num1.length - 1];
                    for (int j = num1.length-1; j >0 ; j--) {
                        num1[j] = num1[j-1];
                    }

                        num1[0] = last;





                    for (int x:i) {
                        if(x==i.length){
                            y[i][j] = q.intValue();
                        }

                        if(x!=i.length){
                            y[i][j] = num1[j2];

                            j2++;
                        }
                    }

                }

                for (int[] x:y) {
                    System.out.println(Arrays.toString(x).replaceAll(",", " ").replaceAll("\\[|\\]", ""));
                }

                


            }else{

                System.out.println("Case"+" "+"#"+(t+1)+":"+" "+"IMPOSSIBLE");


            }

            t++;


        }
    }
 }