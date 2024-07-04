import java.util.*;

public class Solution
{
    public static void main (String [] args) {
        Solution s = new Solution();
        s.run();
    }
    
    public void run()
    {
      Scanner scan = new Scanner(System.in);
      int T = scan.nextInt();
      for (int a = 0; a < T; a++) {
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[][] arr = new int[N][N];
        System.out.print("Case #"+(a+1)+": ");
        boolean possible = true;
        if (N == 2) {
          if (K == 2) {
            arr[0] = new int[] {1,2};
            arr[1] = new int[] {2,1};
          } else if (K == 3) {
            possible = false;
          } else {
            arr[0] = new int[] {2,1};
            arr[1] = new int[] {1,2};
          }
        } else if (N == 3) {
          if (K == 4 || K == 5 || K == 7 || K == 8) possible = false;
          else if (K == 3) {
            arr[0] = new int[] {1,2,3};
            arr[1] = new int[] {3,1,2};
            arr[2] = new int[] {2,3,1};
          } else if (K == 6) {
            arr[0] = new int[] {2,1,3};
            arr[1] = new int[] {3,2,1};
            arr[2] = new int[] {1,3,2};
          } else if (K == 9) {
            arr[0] = new int[] {3,2,1};
            arr[1] = new int[] {1,3,2};
            arr[2] = new int[] {2,1,3};
          }
        } else if (N == 4) {
          if (K == 5 || K == 9 || K == 13 || K == 15) {
            possible = false;
          } else if (K == 4) {
            arr[0] = new int[] {1,2,3,4};
            arr[1] = new int[] {4,1,2,3};
            arr[2] = new int[] {3,4,1,2};
            arr[3] = new int[] {2,3,4,1};
          } else if (K == 6) {
            arr[0] = new int[] {1,4,2,3};
            arr[1] = new int[] {4,2,3,1};
            arr[2] = new int[] {2,3,1,4};
            arr[3] = new int[] {3,1,4,2};
          } else if (K == 7) {
            arr[0] = new int[] {1,3,4,2};
            arr[1] = new int[] {2,1,3,4};
            arr[2] = new int[] {4,2,1,3};
            arr[3] = new int[] {3,4,2,1};
          } else if (K == 10) {
            arr[0] = new int[] {2,3,1,4};
            arr[1] = new int[] {3,2,4,1};
            arr[2] = new int[] {1,4,3,2};
            arr[3] = new int[] {4,1,2,3};
          } else if (K == 11) {
            arr[0] = new int[] {2,3,4,1};
            arr[1] = new int[] {4,2,1,3};
            arr[2] = new int[] {1,4,3,2};
            arr[3] = new int[] {3,1,2,4};
          } else if (K == 14) {
            arr[0] = new int[] {3,4,1,2};
            arr[1] = new int[] {4,3,2,1};
            arr[2] = new int[] {1,2,4,3};
            arr[3] = new int[] {2,1,3,4};
          } else if (K == 8) {
            arr[0] = new int[] {2,1,3,4};
            arr[1] = new int[] {4,2,1,3};
            arr[2] = new int[] {3,4,2,1};
            arr[3] = new int[] {1,3,4,2};
          } else if (K == 12) {
            arr[0] = new int[] {3,2,1,4};
            arr[1] = new int[] {4,3,2,1};
            arr[2] = new int[] {1,4,3,2};
            arr[3] = new int[] {2,1,4,3};
          } else if (K == 16) {
            arr[0] = new int[] {4,2,3,1};
            arr[1] = new int[] {1,4,2,3};
            arr[2] = new int[] {3,1,4,2};
            arr[3] = new int[] {2,3,1,4};
          } 
        } else {
          if (K == 6 || K == 21 || K == 24) possible = false;
          else if (K == 5) {
            arr[0] = new int[] {1,2,3,4,5};
            arr[1] = new int[] {5,1,2,3,4};
            arr[2] = new int[] {4,5,1,2,3};
            arr[3] = new int[] {3,4,5,1,2};
            arr[4] = new int[] {2,3,4,5,1};
          } else if (K == 7) {
            arr[0] = new int[] {1,3,2,5,4};
            arr[1] = new int[] {2,1,5,4,3};
            arr[2] = new int[] {4,2,1,3,5};
            arr[3] = new int[] {3,5,4,2,1};
            arr[4] = new int[] {5,4,3,1,2};
          } else if (K == 8) {
            arr[0] = new int[] {1,2,3,4,5};
            arr[1] = new int[] {3,1,2,5,4};
            arr[2] = new int[] {5,4,1,3,2};
            arr[3] = new int[] {4,3,5,2,1};
            arr[4] = new int[] {2,5,4,1,3};
          } else if (K == 9) {
            arr[0] = new int[] {1,2,4,3,5};
            arr[1] = new int[] {4,1,2,5,3};
            arr[2] = new int[] {5,3,1,4,2};
            arr[3] = new int[] {3,4,5,2,1};
            arr[4] = new int[] {2,5,3,1,4};
          } else if (K == 10) {
            arr[0] = new int[] {1,2,5,4,3};
            arr[1] = new int[] {5,1,2,3,4};
            arr[2] = new int[] {3,4,1,5,2};
            arr[3] = new int[] {4,5,3,2,1};
            arr[4] = new int[] {2,3,4,1,5};
          } else if (K == 11) {
            arr[0] = new int[] {1,3,5,4,2};
            arr[1] = new int[] {5,1,3,2,4};
            arr[2] = new int[] {2,4,1,5,3};
            arr[3] = new int[] {4,5,2,3,1};
            arr[4] = new int[] {3,2,4,1,5};
          } else if (K == 12) {
            arr[0] = new int[] {1,4,5,3,2};
            arr[1] = new int[] {5,1,4,2,3};
            arr[2] = new int[] {2,3,1,5,4};
            arr[3] = new int[] {3,5,2,4,1};
            arr[4] = new int[] {4,2,3,1,5};
          } else if (K == 13) {
            arr[0] = new int[] {1,2,3,4,5};
            arr[1] = new int[] {2,5,4,1,3};
            arr[2] = new int[] {3,4,1,5,2};
            arr[3] = new int[] {4,3,5,2,1};
            arr[4] = new int[] {5,1,2,3,4};
          } else if (K == 14) {
            arr[0] = new int[] {1,2,3,4,5};
            arr[1] = new int[] {2,1,4,5,3};
            arr[2] = new int[] {3,4,5,2,1};
            arr[3] = new int[] {4,5,1,3,2};
            arr[4] = new int[] {5,3,2,1,4};
          } else if (K == 15) {
            arr[0] = new int[] {1,2,3,4,5};
            arr[1] = new int[] {2,3,4,5,1};
            arr[2] = new int[] {3,1,5,2,4};
            arr[3] = new int[] {4,5,1,3,2};
            arr[4] = new int[] {5,4,2,1,3};
          } else if (K == 16) {
            arr[0] = new int[] {1,2,3,4,5};
            arr[1] = new int[] {2,4,5,1,3};
            arr[2] = new int[] {3,1,4,5,2};
            arr[3] = new int[] {4,5,2,3,1};
            arr[4] = new int[] {5,3,1,2,4};
          } else if (K == 17) {
            arr[0] = new int[] {1,2,3,4,5};
            arr[1] = new int[] {2,5,4,1,3};
            arr[2] = new int[] {3,1,5,2,4};
            arr[3] = new int[] {4,3,1,5,2};
            arr[4] = new int[] {5,4,2,3,1};
          } else if (K == 18) {
            arr[0] = new int[] {1,2,3,4,5};
            arr[1] = new int[] {2,4,5,3,1};
            arr[2] = new int[] {3,5,4,1,2};
            arr[3] = new int[] {4,1,2,5,3};
            arr[4] = new int[] {5,3,1,2,4};
          } else if (K == 19) {
            arr[0] = new int[] {1,2,3,4,5};
            arr[1] = new int[] {2,5,1,3,4};
            arr[2] = new int[] {3,4,5,1,2};
            arr[3] = new int[] {4,3,2,5,1};
            arr[4] = new int[] {5,1,4,2,3};
          } else if (K == 20) {
            arr[0] = new int[] {1,2,3,4,5};
            arr[1] = new int[] {2,5,4,1,3};
            arr[2] = new int[] {3,4,5,2,1};
            arr[3] = new int[] {4,3,1,5,2};
            arr[4] = new int[] {5,1,2,3,4};
          } else if (K == 22) {
            arr[0] = new int[] {4,3,5,1,2};
            arr[1] = new int[] {5,4,1,2,3};
            arr[2] = new int[] {2,5,5,3,1};
            arr[3] = new int[] {3,1,2,5,4};
            arr[4] = new int[] {1,2,3,4,5};
          } else if (K == 23) {
            arr[0] = new int[] {5,3,4,1,2};
            arr[1] = new int[] {4,5,1,2,3};
            arr[2] = new int[] {2,4,5,3,1};
            arr[3] = new int[] {3,1,2,4,5};
            arr[4] = new int[] {1,2,3,5,4};
          } else if (K == 25) {
            arr[0] = new int[] {5,1,2,3,4};
            arr[1] = new int[] {4,5,1,2,3};
            arr[2] = new int[] {3,4,5,1,2};
            arr[3] = new int[] {2,3,4,5,1};
            arr[4] = new int[] {1,2,3,4,5};
          } 
        }
        if (possible) {
          System.out.println("POSSIBLE");
          for (int j = 0; j < N; j++) {
            String s = "";
            for (int k = 0; k < N; k++) {
              s += (arr[j][k]+" ");
            }
            System.out.println(s.substring(0, s.length()-1));
          }
        } else System.out.println("IMPOSSIBLE");
      }
    }
}

