import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int N = scan.nextInt();
            String[] names = new String[N];
            for (int a = 0; a < N; a++) {
                names[a] = scan.next();
            }
            for(int b = 0;b < N;b++)
                System.out.println(names[b]);
            System.out.println("Case #" + (i + 1)+ ": " + solution(names));

        }
    }

    public static String solution(String[] names) {
        StringBuilder solution = new StringBuilder();
        String auxiliar;
        boolean solve = true;
        while(solve) {  //SACO UN ASTERISCO Y TODO EL STRING ANTES DEVUELVE FALSE SI NO SACO NADA
            auxiliar = prefix(names);
            if(auxiliar.equals("*")) {
                return "*";
            }
            else {
                solution.append(auxiliar);
            }
            solve = moveAsterisk(names);
        }
        return solution.toString();
    }


    public static String prefix(String[] names) {
        StringBuilder prefix = new StringBuilder();
        boolean flag;
        int i,a,b;
        boolean noAsterisk = false;
        for(i = 0; i < names.length; i++) { //recorro el vector de strings
            if(!names[i].isBlank()) {
                flag = true;
                noAsterisk = false;
                for (a = 0; a < names[i].length() && flag; a++) { //recorro la string
                    if (names[i].charAt(a) == 42) {
                        flag = false;
                    }
                }
                if(flag)
                    noAsterisk = true;
                flag = true;
                int z = 0;
                for (b = 0; b < prefix.length() && b < a - 1 && flag; b++) {
                    if (prefix.charAt(b) != names[i].charAt(b))
                        flag = false;
                    else
                        z++;
                }
                if (flag) {
                        prefix.append(names[i].substring(z, a - 1));
                        System.out.println(prefix);

                }
                if(!flag)
                    return "*";
            }
        }
        return prefix.toString();
    }

    public static boolean moveAsterisk(String[] names) {
        int i, a;
        boolean flag;
        for(i = 0; i < names.length; i++) {
            flag = true;
            for(a = 0; a < names[i].length() && flag; a++ ) {
                if (names[i].charAt(a) == 42) {
                    flag = false;
                }
            }
            if(!flag) {
                if(names[i].length() == a) {
                }
                else
                    names[i] = names[i].substring(a);
            }
            else
                return false;
        }
        return true;
    }
}
