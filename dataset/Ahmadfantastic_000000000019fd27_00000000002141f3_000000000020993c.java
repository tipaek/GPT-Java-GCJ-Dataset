import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int[] primes;

    public static void main(String[] args) throws FileNotFoundException {
        //in = new Scanner(Vestigium.class.getResourceAsStream("file.in"));
        int T = Integer.parseInt(in.nextLine());
        generatePrimes(100);
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            in.nextLine();;

            int trace = 0;
            int[] multR = new int[N];
            int[] multC = new int[N];

            Arrays.fill(multR, 1);
            Arrays.fill(multC, 1);

            int totalMult = 1;
            for (int i = 0; i < N; i++) {
                totalMult *= primes[i];
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = in.nextInt();
                    multR[i] *= primes[value-1];
                    multC[j] *= primes[value-1];
                    if (i == j) {
                        trace += value;
                    }
                }
                if (in.hasNextLine()) {
                    in.nextLine();
                }
            }

            int r = 0, c = 0;
            for (int i = 0; i < N; i++) {
                if (multR[i] != totalMult) {
                    r++;
                }
                if (multC[i] != totalMult) {
                    c++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
        }
    }

    private static void generatePrimes(int size) {
        primes = new int[size];
        int num = 2;
        int counter = 0;
        while(counter < size) {
            boolean isPrime = true;
            for (int i= num-1; i >= Math.sqrt(num) && i > 2; i--) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
               primes[counter++] = num; 
            }
            num++;
        }
    }

}
