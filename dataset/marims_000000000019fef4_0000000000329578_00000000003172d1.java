import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = sc.nextInt();
        for (int k = 1; k <= testCase; k++) {
            System.out.printf("Case #%d: ", k);

            long N = sc.nextLong();
            long D = sc.nextLong();
            List<Long> A = new ArrayList();
            for (int i = 0; i < N; i++) {
                A.add(sc.nextLong());
            }
            Collections.sort(A);
            Set<Long> s = new HashSet<>(A);

            long prevSize = A.get(0);
            long curSize;
            long count = 0;
            List<long[]> dup = new ArrayList<>();
            for (int i = 1; i < N; i ++) {
                curSize = A.get(i);
                if (prevSize == curSize) {
                    count++;
                } else {
                    if (count >= 2) {
                        long[] tmp = {prevSize, count};
                        dup.add(tmp);
                    }
                    count = 0;
                }
                prevSize = curSize;
            }

            if (D == 2) {
                if (s.size() < A.size()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
                continue;
            } else if (D == 3) {
                boolean found = false;
                for (int i = 0; i < dup.size(); i++) {
                    long[] d = dup.get(i);
                    if (d[1] >= 3) {
                        found = true;
                        System.out.println(0);
                        break;
                    }
                }
                if (found) continue;
                for (int j = 0; j < A.size() - 1; j++) {
                    long a = A.get(j);
                    for (int h = j + 1; h < A.size(); h++) {
                        long a1 = A.get(h);
                        if (a * 2 == a1) {
                            found = true;
                            System.out.println(1);
                            break;
                        } else if (a * 2 < a1) {
                            break;
                        }
                    }
                }
                if (found) continue;
                System.out.println(2);
                continue;
            }

            System.out.println(D - 1);


        }
        sc.close();

    }
}