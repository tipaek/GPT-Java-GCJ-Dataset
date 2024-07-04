import java.util.Scanner;

public class Solution {
    static int[] pow2 = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++) {
            System.out.println("Case #"+t+": ");
            StringBuilder result = new StringBuilder("Case #");
            result.append(t);
            result.append(": ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a==0 && b==0) {
                System.out.println(result);
                continue;
            }
            int i=0;
            if((a+b)%2 == 0) {
                result.append("IMPOSSIBLE");
            } else if(a ==0 || b==0) {
                while(a+b<pow2[i]) {
                    i++;
                }
                if(a+b+1 == pow2[i]) {
                    addSequence(result, a, b);
                } else {
                    result.append("IMPOSSIBLE");
                }
                result.append(addSequence(result, a, b));
            } else {

            }

            System.out.println(result);
        }
    }

    private static StringBuilder addSequence(StringBuilder result, int a, int b) {
        int i=0;
        if(a==0 && b>0) {
            while(b>0) {
                result.append('N');
                b = b- pow2[i];
                i++;
            }
        } else if(a==0 && b<0) {
            b = Math.abs(b);
            while(b>0) {
                result.append('S');
                b = b- pow2[i];
                i++;
            }

        } else if(b==0 && a>0) {
            while(a>0) {
                result.append('E');
                a = a- pow2[i];
                i++;
            }
        } else {
            a = Math.abs(b);
            while(a>0) {
                result.append('W');
                a = a- pow2[i];
                i++;
            }
        }
        return result;
    }
}
