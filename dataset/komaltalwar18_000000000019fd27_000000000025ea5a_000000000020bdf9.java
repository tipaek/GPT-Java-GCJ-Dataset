import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int test_Cases = input.nextInt();

        int flag = -1, flag2 = 0;
        while (test_Cases != 0) {
            flag2++;
            flag++;
            int N = input.nextInt();
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                arr[i][0] = input.nextInt();
                arr[i][1] = input.nextInt();
            }
            int[][] temp= Arrays.copyOf(arr,N);

sortbyColumn(arr,1);

            String s="";
            for(int i=0;i<N;i++)
                for(int j=0;j<2;j++)
                    System.out.println(arr[i][j]);

                for(int i=0;i<arr.length;i++){
                    for(int j=i+1;j<arr.length;j++){
                        if(arr[i][0]<arr[j][1])
                            s+="J";
                        else
                            s+="C";
                    }
                }
String s_new="";
                for(int i=0;i<N;i++)
                    for(int j=0;j<N;j++){
                        if(temp[i][0]==arr[j][0])
                            s_new+=s.charAt(j);
                    }
            System.out.println(s_new);

        }
    }

    public static void sortbyColumn(int arr[][], int col) {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] < entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }
}