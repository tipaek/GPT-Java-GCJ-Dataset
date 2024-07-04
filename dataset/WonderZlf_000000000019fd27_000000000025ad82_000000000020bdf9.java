import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean DEBUG = false;

    private static String solve(int[][] matrixN){
        StringBuilder result= new StringBuilder();
        String impossile="IMPOSSIBLE";
        LinkedList<int[]> input = new LinkedList<>();
        LinkedList<Integer> order = new LinkedList<>();
        input.add(matrixN[0]);
        order.add(0);
        for(int i=1;i<matrixN.length;i++){
            int flag=0;
            for(int j=0;j<i;j++){
                if (matrixN[i][0]<=input.get(j)[0]) {
                    input.add(j,matrixN[i]);
                    order.add(j,i);
                    flag=1;
                    break;
                }
            }
            if (flag==0) {
                input.add(matrixN[i]);
                order.add(i);
            }
        }
        String J= "J";
        String C= "C";
        int JEnd=0;
        int CEnd=0;
        HashMap<Integer,String> line = new HashMap<>();
        for (int k=0;k<input.size();k++){
            if(input.get(k)[0]>=JEnd){
                line.put(order.get(k),J);
                JEnd=input.get(k)[1];
            }else if(input.get(k)[0]>=CEnd){
                line.put(order.get(k),C);
                CEnd=input.get(k)[1];
            }else{
                return impossile;
            }
        }
        for(int h=0;h<line.size();h++){
            result.append(line.get(h));
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
