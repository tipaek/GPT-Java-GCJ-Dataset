import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

 class Vestigium {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {

            int N = Integer.parseInt(reader.readLine());
            int A[][] = new int[N][N];
            int diagonalSum = 0;
          for (int i = 0; i < N; i++) {

                String str=reader.readLine();
                String arr[]=str.split(" ");
                for(int j=0;j<N;j++)
                {
                    A[i][j]=Integer.parseInt(arr[j]);
                if(i==j)
                    diagonalSum+=A[i][j];
                }
            }
              long Maxsum = (N * (N + 1)) / 2;

            int rows = 0;
            int cols = 0;
            boolean[] nums = new boolean[N + 1];
          Arrays.fill(nums, false);
            for (int i = 0; i < N; i++) {
                long sum = 0;
                for (int j = 0; j < N; j++) {
                    if (nums[A[i][j]] == false)
                        nums[A[i][j]] = true;
                    else {
                        rows++;
                        break;
                    }
                }
                Arrays.fill(nums, false);
            }
                Arrays.fill(nums, false);
                for (int i = 0; i < N; i++) {
                    long sum = 0;
                    for (int j = 0; j < N; j++) {
                        if (nums[A[j][i]] == false)
                            nums[A[j][i]] = true;
                        else {
                            cols++;
                            break;

                        }
                    }
                        Arrays.fill(nums, false);
                }
                int v=t+1;
                    System.out.println("case #"+v+" "+diagonalSum + " " + rows + " " + cols);
                }
            }
        }
