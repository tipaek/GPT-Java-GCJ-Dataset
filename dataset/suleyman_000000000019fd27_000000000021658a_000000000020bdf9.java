import java.util.Scanner;

public class Solution {

    static int size = 1440;
    static int[] t = new int[size];
    static int[] cam = new int[size];
    static int[] jam = new int[size];
    static int N;
    static int T;

    static String assign(int[] s, int[] e) {

        String imp = "IMPOSSIBLE";
        StringBuilder sb = new StringBuilder(N);

        for(int i=0; i<N; i++) {    // each activity

            for(int j=s[i]; j<e[i]; j++) {  // possibility check

                t[j]++;
                if(t[j] > 2)
                    return imp;
            }

            boolean canCam = true;

            for(int j=s[i]; j<e[i]; j++) {

                cam[j]++;
                if(cam[j] > 1) {
                    canCam = false;
                    break;
                }
            }

            if(!canCam) {   // cannot assign to cameron

                for(int j=s[i]; j<e[i]; j++) {

                    cam[j]--;   // remove cameron
                    jam[j]++;   // assign jamie
                }

                sb.append('J');
            }
            else {

                sb.append('C');
            }
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        for(int c=1; c<=T; c++) {    // each case

            for(int i=0; i<size; i++) {   // init time, cameron, and jamie
                t[i] = 0;
                cam[i] = 0;
                jam[i] = 0;
            }

            N = scanner.nextInt();
            int[] s = new int[N];
            int[] e = new int[N];

            for(int i=0; i<N; i++) {    // each activity

                s[i] = scanner.nextInt();
                e[i] = scanner.nextInt();
            }

            String result = assign(s,e);
            System.out.println("Case #" + c + ": " + result);
        }
    }
}
