import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();
        int size = input.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
//            System.err.println(caseNum);
            int sameIndex = -1;
            int diffIndex = -1;
            int[] vals = new int[size];
            for (int i = 0; i < size; i++)
                vals[i] = -1;

            for (int part = 0; part <= size / 2; part += 4) {
                boolean sameChanged = false, diffChanged = false;
//                System.err.println(sameIndex + " " + diffIndex);
                if (sameIndex == -1) {
                    System.out.println(1);
                    System.out.flush();
                    input.nextInt();
                } else {
                    System.out.println(sameIndex + 1);
                    System.out.flush();
                    int bit = input.nextInt();
                    sameChanged = bit != vals[sameIndex];
                }
                if (diffIndex == -1) {
                    System.out.println(1);
                    System.out.flush();
                    input.nextInt();
                } else {
                    System.out.println(diffIndex + 1);
                    System.out.flush();
                    int bit = input.nextInt();
                    diffChanged = bit != vals[diffIndex];
                }
//                System.err.println(sameChanged + " " + diffChanged);
                if (sameChanged) {
                    for (int i = 0; i < size; i++)
                        if (vals[i] != -1)
                            vals[i] = 1 - vals[i];
                }
                if (diffChanged ^ sameChanged) {
                    for (int i = 0; i < size / 2; i++) {
                        int temp = vals[i];
                        vals[i] = vals[size - 1 - i];
                        vals[size - 1 - i] = temp;
                    }
                }
//                System.err.println(Arrays.toString(vals));
                for (int i = 0; i < 4 && part + i <= size / 2; i++) {
                    System.out.println(part + i + 1);
                    System.out.flush();
                    int bit1 = input.nextInt();
                    System.out.println(size - part - i);
                    System.out.flush();
                    int bit2 = input.nextInt();
                    vals[part + i] = bit1;
                    vals[size - part - i - 1] = bit2;
                    if (bit1 == bit2)
                        sameIndex = part + i;
                    else
                        diffIndex = part + i;
                }

//                System.err.println(Arrays.toString(vals));
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++)
                sb.append(vals[i]);
            System.out.println(sb);
            System.out.flush();

            String correct = input.next();
            if (correct.equals("N"))
                break;
        }
    }
}
