
import java.util.Random;
import java.util.Scanner;

class Solution {
    static Random random = new Random(123);
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        int MAX;
        char[] A;
        for (int i = 0; i < T; i++) {
            MAX = 150;
            A = new char[B];
            for (int j = 0; j < B; j++) {
                System.out.println(j + 1);
                System.out.flush();
                A[j] = (char) (input.nextInt()+'0');
            }
            System.out.println(new String(A));
            System.out.flush();
            String response = input.next();
            for (int j = B; j < MAX && response.equals("N"); j++) {
                operateArray(A);
                System.out.println(new String(A));
                System.out.flush();
                response = input.next();
            }


        }
    }

    private static void operateArray(char[] a) {
        int n = random.nextInt()%4;
        switch (n) {
            case 1: complement(a); break;
            case 2: invert(a);
            break;
            case 3: both(a);break;
            default:break;
        }
    }

    private static void both(char[] a) {
        invert(a);
        complement(a);
    }

    private static void invert(char[] a) {
        for(int j=0;j<a.length;j++){
            a[j]=a[a.length-j-1];
        }
    }

    private static void complement(char[] a) {
        
        for(int j=0;j<a.length;j++){
            a[j]=a[j]=='0'?'1':'0';
        }
    }
}
