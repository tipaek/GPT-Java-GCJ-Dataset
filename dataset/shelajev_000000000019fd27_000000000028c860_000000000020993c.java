
import java.util.Arrays;
import java.util.Scanner;


class Main {

    public static void main(String[] args) {
	// write your code here
	while(true) {
	    int i = 1 / 3;
	}
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int caseNum = 1; caseNum <= T; caseNum++) {
            int n = sc.nextInt();

            int k = 0;
            long sum = 0;
            long product = 1;
            long[] rSum = new long[n];
            long[] rPro = new long[n];
            Arrays.fill(rPro, 1);
            long[] cSum = new long[n];
            long[] cPro = new long[n];
            Arrays.fill(cPro, 1);

            for(int i = 0; i < n; i++) {
                sum += (i + 1);
                product *= (i+1);
                for(int j = 0; j < n; j++) {
                    int e = sc.nextInt();
                    if(i == j) {
                        k += e;
                    }

                    rSum[i] += e;
                    rPro[i] *= e;

                    cSum[j] += e;
                    cPro[j] *= e;
                }
            }

//            System.out.println(n + " " + sum + " " + product);
//            System.out.println(Arrays.toString(rSum));
//            System.out.println(Arrays.toString(rPro));
            int rows = 0;
            int cols = 0;
            for(int i = 0; i < n; i++) {
                if(rSum[i] != sum || rPro[i] != product) {
                    rows++;
                }
                if(cSum[i] != sum || cPro[i] != product) {
                    cols++;
                }
            }

            System.out.println("Case #" + caseNum +":" + k + " " + rows + " " + cols);
        }
    }
}
