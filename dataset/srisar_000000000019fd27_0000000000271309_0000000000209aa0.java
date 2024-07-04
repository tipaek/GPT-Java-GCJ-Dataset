import java.util.*;


class  Solution{

  public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();

        int t = 0;

        while (t < test) {


            long[][] a =  new long[1][2];

            for (int i = 0; i <1 ; i++) {
                for (int j = 0; j <2 ; j++) {
                    a[i][j] = scanner.nextLong();
                }

            }

            long n = a[0][0];

            long k = a[0][1];

            int n1 = (int)n;

             int[] num = new int[n1];

             int e = 1;

            long q = k/n;

            int[] num1 = new int[num.length-1];

            int j1 = 0;

            for (int i = 0; i <n ; i++) {

                num[i] = e;
                e++;



            }



            boolean p = false;

            for (int i = 0; i <num.length ; i++) {

                if(num[i]*n==k){
                   p = true;
                }
            }


            for (int i = 0; i < num.length ; i++) {
                if(q!=num[i]) {
                    num1[j1] = num[i];

                    j1++;
                }
            }



            Arrays.sort(num1);

            if(p){

                System.out.println("Case"+" "+"#"+(t+1)+":"+" "+"POSSIBLE");

               

                long[][] y = new long[n1][n1];

                for (int i = 0; i <n ; i++) {

                    int j2 = 0;


                        int last = num1[num1.length - 1];
                        for (int g = num1.length - 1; g > 0; g--) {
                            num1[g] = num1[g-1];
                        }

                        num1[0] = last;





                    for (int j = 0; j <n ; j++) {
                        if(i==j){
                            y[i][j] = q;
                        }

                        if(i!=j){
                            y[i][j] = num1[j2];

                            j2++;
                        }
                    }

                }
                for (int i = 0; i <y.length ; i++) {
                    for (int j = 0; j <y.length ; j++) {

                        System.out.print(y[i][j]+" ");
                    }
                    System.out.println(" ");

                }


            }else{

                System.out.println("Case"+" "+"#"+(t+1)+":"+" "+"IMPOSSIBLE");


            }

            t++;


        }
    }

}