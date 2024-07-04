import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int turn = 0; turn < T; turn++) {
            long a = input.nextLong();
            long b = input.nextLong();
            long i = 1;
            long k = 0;
            boolean huhuan = false;
            if (a < b) {
                huhuan = true;
                long c = b;
                b = a;
                a = c;
            }
            k = a-b;

            //xiao k
            if (k >= i) {
                long j = (long)Math.floor((-2*i-1+Math.sqrt(4*i*i-4*i+1+8*k))/2);
                k = k-(2*i+j)*(j+1)/2;
                i = i+j+1;
                a = b+k;
            }
            if (k == 0) {
                huhuan = false;
            }
            if (b >= i+1) {
                //zeng k huo sha b
                long j = (long) Math.floor((-i - 2 + Math.sqrt((i + 2) * (i + 2) - 4 * (i + 1 - b))) / 2);
                b = b - (i + j + 1) * (j + 1);
                a = a - (i + j) * (j + 1);
                i = i + 2 * j + 2;//sha b de i
            }else {
                if (a >= i) {
                    a = a - i;
                    i++;
                }
            }
            if (a >= i) {
                a = a - i;
                i++;
            }
            if (huhuan) {
                System.out.println("Case #" + (turn + 1) + ": " + (i-1) + " "+b+" " +a);
            }else {
                System.out.println("Case #" + (turn + 1) + ": " + (i-1) + " "+a+" " +b);
            }


//            Iterator mapIterator = map.entrySet().iterator();
//            while (mapIterator.hasNext()) {
//                Map.Entry mapElement = (Map.Entry)mapIterator.next();
//                intmap.add((int)mapElement.getValue());
//                chmap.add((char)mapElement.getKey());
//            }
        }
    }
}