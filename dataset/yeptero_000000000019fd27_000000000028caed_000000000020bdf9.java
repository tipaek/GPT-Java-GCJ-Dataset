import java.util.Scanner;

public class Solution {

    public static boolean intersects(int aStart, int aEnd, int bStart, int bEnd){
        if(bEnd <= aStart || bStart >= aEnd){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int cStart[];
        int cEnd[];
        int jStart[];
        int jEnd[];
        int cSize;
        int jSize;
        String[] total;
        int totalCounter;
        boolean inC;
        boolean inJ;
        boolean impossible;

        for(int i = 1; i <= T; i ++){
            totalCounter = 0;
            impossible = false;

            int N = input.nextInt();

            total = new String[N];
            cStart = new int[N];
            cEnd = new int[N];
            jStart = new int[N];
            jEnd = new int[N];
            cSize = 0;
            jSize = 0;

            for(int k = 0; k < N; k ++){
                inC = false;
                inJ = false;
                //check if in C or J
                int tempStart = input.nextInt();
                int tempEnd = input.nextInt();

                for(int c = 0; c < cSize; c ++){
                    if(intersects(cStart[c], cEnd[c], tempStart, tempEnd)) {
                        inC = true;
                        c = cSize;
                    }
                }
                for(int j = 0; j < jSize; j ++){
                    if(intersects(jStart[j], jEnd[j], tempStart, tempEnd)) {
                        inJ = true;
                        j = jSize;
                    }
                }

                if(inC == true && inJ == true){
                    impossible = true;
                }
                else{
                    if(inC == false && inJ == true){
                        cStart[cSize] = tempStart;
                        cEnd[cSize] = tempEnd;
                        cSize ++;
                        total[totalCounter] = "C";
                        totalCounter ++;
                    }
                    else if(inJ == false && inC == true){
                        jStart[jSize] = tempStart;
                        jEnd[jSize] = tempEnd;
                        jSize ++;
                        total[totalCounter] = "J";
                        totalCounter ++;
                    }
                    else{
                        cStart[cSize] = tempStart;
                        cEnd[cSize] = tempEnd;
                        cSize ++;
                        total[totalCounter] = "C";
                        totalCounter ++;
                    }

                }

            }

            if(impossible){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            else{
                StringBuilder a = new StringBuilder("Case #");
                a.append(i);
                a.append(": ");

                for(int iter = 0; iter < N; iter ++){
                    a.append(total[iter]);
                }
                System.out.println(a);
            }
        }
    }
}
