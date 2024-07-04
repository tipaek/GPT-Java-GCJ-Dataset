import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean DEBUG = false;

    private static String solve(int[][] matrixN){
        StringBuilder result= new StringBuilder();
        String impossile="IMPOSSIBLE";
        LinkedList<int[]> input = new LinkedList<>();
        input.add(matrixN[0]);
        for(int i=1;i<matrixN.length;i++){
            int flag=0;
            for(int j=0;j<i;j++){
                if (matrixN[i][0]<=input.get(j)[0]) {
                    input.add(j,matrixN[i]);
                    flag=1;
                    break;
                }
            }
            if (flag==0) {
                input.add(matrixN[i]);
            }
        }
        String J= "J";
        String C= "C";
        int JEnd=0;
        int CEnd=0;
        for (int[] activity: input){
            if(activity[0]>=JEnd){
                result.append(J);
                JEnd=activity[1];
            }else if(activity[0]>=CEnd){
                result.append(C);
                CEnd=activity[1];
            }else{
                return impossile;
            }
        }
        return result.toString();
    }

    public static void main(String []args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        // use for online test and submit
        // try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
        InputStream is = DEBUG ?new FileInputStream("resources/qualification/Parenting Partnering Returns") :System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int N=scanner.nextInt();
                int[][] matrixN = new int[N][2];
                for (int i=0;i<N;i++){
                    String input = scanner.nextLine();
                    if (input.equals("")) input =scanner.nextLine();
                    String[] numbers = input.split(" ");
                    for (int j=0;j<2;j++){
                        matrixN[i][j]=Integer.parseInt(numbers[j]);
                    }
                }
                String result = solve(matrixN);
                System.out.println("Case #" + testNumber + ": " +result);
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }

}
