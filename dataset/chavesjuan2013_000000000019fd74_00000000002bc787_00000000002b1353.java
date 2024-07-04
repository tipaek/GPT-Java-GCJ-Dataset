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

    static int choose(int n , int k)
    {
        if(k == 0||k==n)
            return n;
        return choose(n-1, k-1)+choose(n-1,k);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int iter = 0;

        while(iter < T) {
            System.out.println("Case #"+(iter+1)+":");
            int N = Integer.parseInt(br.readLine());
            int total = 0;
            int pasos = 0;

            //cantidad de filas de pascal a recorrer
            int cantFilas = log2(N + 1);

            for (int i = 1; i <= cantFilas; ++i) {
                if (i % 2 == 0) {
                    //la i-esima fila tiene i elementos
                    for (int j = 1; j <= i; ++j) {
                        //en una fila impar empiez0 a la izquierda
                        System.out.println(i + " " + j);
                        total += choose(i, j);
                        pasos++;
                    }
                } else {
                    //en una fila impar empiez0 a la derecha
                    //la i-esima fila tiene i elementos
                    for (int j = i; j >= 1; --j) {
                        //en una fila impar empiez0 a la izquierda
                        System.out.println(i + " " + j);
                        total += choose(i, j);
                        pasos++;
                    }
                }
            }

            if(N<962) {
                int diff = (int) Math.pow(2, cantFilas) - 1;
                diff = N - diff;


                for (int k = 0; k < diff; ++k) {
                    if (cantFilas % 2 == 1) {
                        System.out.println((cantFilas + k + 1) + " " + 1);
                        total += choose((cantFilas + k + 1), 1);
                        pasos++;
                    } else {
                        System.out.println((cantFilas + k + 1) + " " + (cantFilas + k + 1));
                        total += choose((cantFilas + k + 1), (cantFilas + k + 1));
                        pasos++;
                    }
                }
            }
            else
            {
                for(int i = 9; i <= 38; ++i)
                {
                    System.out.println(i+" "+ 2);
                }

                int diff = N-960;
                for(int k = 39; k < diff + 39; ++k)
                {
                    System.out.println(k+" "+1);
                    total += choose((cantFilas + k + 1), (cantFilas + k + 1));
                    pasos++;
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