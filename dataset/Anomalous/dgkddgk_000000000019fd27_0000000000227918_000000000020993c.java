package test;

import java.util.Scanner;
import java.util.TreeSet;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder op = new StringBuilder();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int ip = sc.nextInt();
            int[][] a = new int[ip][ip];
            int[][] b = new int[ip][ip];

            for (int j = 0; j < ip; j++) {
                for (int k = 0; k < ip; k++) {
                    a[j][k] = sc.nextInt();
                    b[k][j] = a[j][k];
                }
            }

            int sum = 0, rcount = 0, ccount = 0;
            TreeSet<Integer> s1 = new TreeSet<>();
            TreeSet<Integer> s2 = new TreeSet<>();

            for (int j = 0; j < ip; j++) {
                for (int k = 0; k < ip; k++) {
                    if (j == k) {
                        sum += a[j][k];
                    }
                    s1.add(a[j][k]);
                    s2.add(b[j][k]);
                }

                if (s1.size() != ip) {
                    rcount++;
                }
                if (s2.size() != ip) {
                    ccount++;
                }

                s1.clear();
                s2.clear();
            }

            op.append("Case #").append(i + 1).append(": ").append(sum).append(" ").append(rcount).append(" ").append(ccount).append("\n");
        }
        System.out.println(op.toString());
    }
}