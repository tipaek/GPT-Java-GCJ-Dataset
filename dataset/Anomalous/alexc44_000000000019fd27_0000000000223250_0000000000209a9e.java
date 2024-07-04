import java.util.Scanner;

public class Solution {

  // Function to reverse an array
  public static void reverse(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[n - i - 1];
      arr[n - i - 1] = temp;
    }
  }

  // Function to complement an array
  public static void comp(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (arr[i] == 0) ? 1 : 0;
    }
  }

  // Function to solve the problem for a given size
  public static void solve(Scanner input, int size) {
    int query = 0;
    int[] guess = new int[size];
    int same = -1;
    int diff = -1;
    int curr = 0;

    while (curr < size / 2) {
      if ((query + 1) % 10 == 1 && query != 0) {
        if (same != -1 && diff != -1) {
          System.out.println(same + 1);
          if (input.nextInt() == guess[same]) {
            System.out.println(diff + 1);
            if (input.nextInt() != guess[diff]) {
              reverse(guess);
            }
          } else {
            System.out.println(diff + 1);
            if (input.nextInt() == guess[diff]) {
              reverse(guess);
            }
            comp(guess);
          }
        } else if (same == -1) {
          System.out.println(diff + 1);
          if (input.nextInt() != guess[diff]) {
            comp(guess);
          }
          System.out.println(same + 1);
          input.nextInt();
        } else {
          System.out.println(same + 1);
          if (input.nextInt() != guess[same]) {
            comp(guess);
          }
          System.out.println(same + 1);
          input.nextInt();
        }
        query += 2;
      } else {
        System.out.println(curr + 1);
        guess[curr] = input.nextInt();
        System.out.println(size - curr);
        guess[size - 1 - curr] = input.nextInt();

        if (guess[curr] == guess[size - 1 - curr]) {
          same = curr;
        } else {
          diff = curr;
        }

        query += 2;
        curr++;
      }
    }

    StringBuilder output = new StringBuilder();
    for (int i : guess) {
      output.append(i);
    }

    System.out.println(output);
    String response = input.next();
    if (!response.equals("Y")) {
      System.exit(1);
    }
  }

  // Main function to read input and solve for each test case
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt();
    for (int i = 0; i < T; i++) {
      solve(input, B);
    }
  }
}