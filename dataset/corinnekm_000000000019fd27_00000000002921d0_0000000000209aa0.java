import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("resources/input1.txt"));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line;
        /****************************************************************************/
        int T = Integer.parseInt(sc.nextLine());


        for (int t = 0; t < T; t++) {
            String input = sc.nextLine();
            int N = Integer.parseInt(input.split(" ")[0]);
            int K = Integer.parseInt(input.split(" ")[1]);
            boolean impossible = false;

            String[] lines = new String[N];

            if (K < N || K > N * N || K % N > 0) {
                impossible = true;
            }
            int[] nb = new int[N];
            for (int i = 0; i < N; i++) {
                nb[i]=i;
            }
            for (int i = 0; i < N; i++) {
                lines[i] = fillLineStart(K / N, i, N);
            }
            if(impossible) {
                System.out.println("Case #" + (t+1) + ": " + "IMPOSSIBLE");
            } else{
                System.out.println("Case #" + (t+1) + ": " + "POSSIBLE");
                for (int i = 0; i < N; i++) {
                    System.out.println(lines[i]);
                }
            }
        }
    }

    private static String fillLineStart(int start, int current, int N) {
        StringBuffer buff = new StringBuffer();
        start = (start - current) <= 0 ? (start - current) + N : start - current;
        for (int i = 0; i <N ; i++) {
            if (buff.length()>0){
                buff.append(" ");
            }
            if ((start + i) > N ){
                buff.append((start + i) % N);
            } else {
                buff.append( (start + i));
            }

        }
        return buff.toString();

    }
}
