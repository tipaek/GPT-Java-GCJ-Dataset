import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    static int log2(int N)
    {
        return (int)(Math.log(N)/Math.log(2));
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int iter = 0;

        while(iter < T) {
            System.out.println("Case #"+(iter+1)+":");
            int N = Integer.parseInt(br.readLine());

            //cantidad de filas de pascal a recorrer
            int cantFilas = log2(N + 1);

            for (int i = 1; i <= cantFilas; ++i) {
                if (i % 2 == 0) {
                    //la i-esima fila tiene i elementos
                    for (int j = 1; j <= i; ++j) {
                        //en una fila impar empiez0 a la izquierda
                        System.out.println(i + " " + j);
                    }
                } else {
                    //en una fila impar empiez0 a la derecha
                    //la i-esima fila tiene i elementos
                    for (int j = i; j >= 1; --j) {
                        //en una fila impar empiez0 a la izquierda
                        System.out.println(i + " " + j);
                    }
                }
            }

            int diff = (int) Math.pow(2, cantFilas) - 1;
            diff = N - diff;


            for (int k = 0; k < diff; ++k) {
                if (cantFilas % 2 == 1) {
                    System.out.println((cantFilas + k + 1) + " " + 1);
                } else {
                    System.out.println((cantFilas + k + 1) + " " + (cantFilas + k + 1));
                }
            }
            iter++;
        }


//        while(iter < T)
//        {
//
//
//            int N =Integer.parseInt(br.readLine());
//            System.out.println("Case #" + (iter + 1) + ":");
//            if(N<=501) {
//                if (N != 501) {
//                    for (int i = 1; i <= N; ++i) {
//                        System.out.println(i + " " + 1);
//                    }
//                } else {
//                    System.out.println("1 1");
//                    System.out.println("2 1");
//                    System.out.println("2 2");
//                    for (int i = 3; i < 500; ++i) {
//                        System.out.println(i + " " + 1);
//                    }
//                }
//            }
//            else
//            {
//
//            }
//            iter++;
//        }
    }

}