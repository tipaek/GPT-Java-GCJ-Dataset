import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++) {
            String numstr = sc.next();
            char[] numarray = numstr.toCharArray();

            int len = numarray.length;
            int[] iarray = new int[len];
            for (int index = 0; index < len; index++) {
                iarray[index] = Character.getNumericValue(numarray[index]);
            }

            System.out.print("Case #" + i + ": ");
            int count = 0;

            for(int j=0;j<len;j++) {
                int num = iarray[j] - count;
                if(num > 0) {
                    for(int k=0;k<num;k++) {
                        count++;
                        System.out.print("(");
                    }
                } else if(num < 0) {
                    for(int k=0;k>num;k--) {
                        count--;
                        System.out.print(")");
                    }
                }
                System.out.print(iarray[j]);
            }
            for(int k=0;k<count;k++){
                System.out.print(")");
            }
            System.out.println();
        }
    }
}
