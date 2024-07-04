import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        int counter = 1;
        StringBuilder stringBuilder =  new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                String[] strings = bufferedReader.readLine().split("\\s+");
                for(int j=0;j<n;j++){
                    arr[i][j] = Integer.parseInt(strings[j]);
                }
            }
            long k = findTrace(arr);
            int r = findRowRepeated(arr);
            int c = findColumnRepeated(arr);
            stringBuilder.append("Case #" + counter + ": " + k + " " + r + " " + c).append("\n");
            counter++;
        }
        System.out.print(stringBuilder);
    }

    public static long findTrace(int[][] arr){
        long sum = 0;
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i][i];
        }
        return sum;
    }

    public static int findRowRepeated(int[][] arr){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(isRepeated(arr[i])){
                count++;
            }
        }
        return count;
    }

    public static int findColumnRepeated(int[][] arr){
        int count = 0;

        for(int c=0;c<arr.length;c++){
            int[] temp = new int[arr.length];
            int counter = 0;
            for(int r=0;r<arr.length;r++){
                temp[counter] = arr[r][c];
                counter++;
            }
            if(isRepeated(temp)){
                count++;
            }
        }

        return count;
    }

    public static boolean isRepeated(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

}
