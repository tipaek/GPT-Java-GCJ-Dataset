import java.util.*;

// Java program to pritn Latin Square
public class Solution  {

    static void printLatin(int n,int s,int taaa) {
        if (s % n == 0) {

            int divi=s/n;
            int a[][] = new int[n][n];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    a[i][j] = (i + j) % n + 1;
                }
            }


            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (i == j) {
                        a[i][j] = divi;
                    }
                    for (int k = 0; k < a.length; k++) {
                        if (i != k) {
                            if (a[i][k] == 2) {
                                a[i][k] = (i + j) % n + 1;
                            }
                        }
                    }
                }
            }

            TreeSet<Integer> t = new TreeSet<>();

//for rows

            for (int i = 1; i <= n; i++) {
                if (i != divi) {
                    t.add(i);
                }
            }

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (i == j) {
                        a[i][j] = divi;
                    } else {
                        int d = a[i][j];
                        if (t.contains(d)) {
                            t.remove(d);
                        } else {
                            if (!t.isEmpty()) {
                                int ta = t.first();
                                a[i][j] = ta;
                                t.remove(ta);
                            }
                        }
                    }

                }

                for (int k = 1; k <= n; k++) {
                    if (k != divi) {
                        t.add(k);
                    }
                }


            }
//for columns
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (i == j) {
                        // a[i][j]=2;
                    } else {
                        int d = a[j][i];
                        if (t.contains(d)) {
                            t.remove(d);
                        } else {
                            if (!t.isEmpty()) {
                                int ta = t.first();
                                a[j][i] = ta;
                                t.remove(ta);
                            }
                        }
                    }
                }
                for (int k = 1; k <= n; k++) {
                    if (k != divi) {
                        t.add(k);

                    }
                }
            }


            System.out.println("Case #"+taaa+": POSSIBLE");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();

            }


        } else {
                System.out.println("Case #"+taaa+": IMPOSSIBLE");

            }

        }


    public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int test=1;
        while(t-->0) {
            int n=sc.nextInt(),sum=sc.nextInt();
             printLatin(n,sum,test);
            test++;
        }
    }
}


