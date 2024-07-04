import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        int T = sc.nextInt();
        int x = 0;
        while (x < T) {
            boolean cc = false, cr = false;
            int i = 0, j = 0, k = 0, r = 0, c = 0, countR=0, countC=0;
            System.out.println("");
            int n = sc.nextInt();
            int M[][] = new int[n][n];
            int dupR[] = new int[n];
            int dupC[] = new int[n];
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    M[i][j] = sc.nextInt();
            }
            }
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (i == j) {
                        k += M[i][j];
                    }
                }
            }
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    int num = M[i][j];
                    for (int otherCol = j + 1; otherCol < n; otherCol++) {
                        if (num == M[i][otherCol]) {
                            //r += 1; this is wrong... This gives the number of duplicate elements same goes with c
                            /*countR += 1;
                            for(int p = 0; p < n; p++){
                                dupR[p] = countR;
                            }*/
                            /*if(r < 1){
                                r += 1;
                            }
                            else{
                                r = r-(n+1);
                            }*/
                            cr = true;
                        }
                        else{
                            cr = false;
                        }
                    }
                    for (int otherRow = i + 1; otherRow < n; otherRow++) {
                        if (num == M[otherRow][j]) {
                            //c += 1;
                            /*countC += 1;
                            for(int p = 0; p < n; p++){
                                dupC[p] = countC;
                            }*/
                            /*if(c < 1){
                                c += 1;
                            }
                            else{
                                c = c-(n+1);
                            }*/
                            cc = true;
                        }
                        else{
                            cc = false;
                        }
                    }
                    if(cc == true && cr == true){
                        r += 1;
                        c += 1;
                    }
                }
            }
            x += 1;
            System.out.println("case #" + x + ": " + k + " " + r + " " + c);
        }
    }
}