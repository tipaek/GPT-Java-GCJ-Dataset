import java.util.ArrayList;

// Java program to pritn Latin Square
class codejam {

    static void printLatin(int n) {
        int a[][] = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                a[i][j] = (i + j) % n + 1;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();

        }

        int temp = 0;
        int t = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == j) {
                    temp = a[i][j];
                    t = 8 / n;
                    a[i][j] = t;

                    if (j != 0 && a[i][j - 1] == t) {
                        a[i][j - 1] = temp;
                        

                    }
                    if (j != a.length - 1 && a[i][j + 1] == t) {
                        a[i][j + 1] = temp;

                    }
                }
            }
        }




         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(i!=j){
                    if(i!=a.length -1&& j!=a.length-1) {
                        if (a[i][j] == a[i + 1][j]) {
                            int tempo = a[i + 1][j];
                            a[i + 1][j] = a[i + 1][j + 1];
                            a[i + 1][j + 1] = tempo;

                        }
                    }

                }
            }
        }


/*

        for (int k = 0; k < n; k++) {
            if (i != k) {
                if (a[k][i] == t) {
                    a[k][i]=a[0][1];

                }
                if (a[i][k] == t) {
                    a[i][k] = temp;
                    break;
                }

            }
*/

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();

        }


    }


    public static void main (String[] args)
    {
        int n = 4;
        printLatin(n);
    }
}


