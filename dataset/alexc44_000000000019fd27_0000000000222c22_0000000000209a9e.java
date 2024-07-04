import java.util.Scanner;

public class Solution {
  public static void reverse(int[] arr) {
    for(int i = 0; i < arr.length/2; i++) {
      int tmp = arr[i];
      arr[i] = arr[arr.length-i-1];
      arr[arr.length-i-1] = tmp;
    }
  }

  public static void comp(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      arr[i] = (arr[i] == 0) ? 1 : 0;
    }
  }

  public static void solve(Scanner input, int size) {
    int query = 0;
    int[] guess = new int[size];
    int same = -1;
    int diff = -1;
    int curr = 0;

    while(curr < size/2){
      if((query+1) % 10 == 1 && query != 0) {
        if(same != -1 && diff != -1) {
          System.out.println(same+1);
          if(input.nextInt() == guess[curr]) { // arr[i] same
            System.out.println(diff+1);
            if(input.nextInt() != guess[diff]) { // arr[j] diff, reversed
              reverse(guess);
            }
          }
          else {  // arr[i] diff, complement
            System.out.println(diff+1);
            if (input.nextInt() == guess[diff]) {  // arr[j] same, reverse and complement
              reverse(guess);
            }
            comp(guess);
          }
          System.out.println(same+1);
          input.nextInt();
          query += 3;
        }
        else if (same == -1) {
          System.out.println(diff+1);
          if (input.nextInt() != guess[diff]) {  // arr[j] same, reverse/complement (same thing)
            comp(guess);
          }
          query++;
        }
        else {
          System.out.println(same+1);
          if(input.nextInt() != guess[curr]) { // arr[i] diff, complement
            comp(guess);
          }
          query++;
        }
      }
      else {
        System.out.println(curr+1);
        guess[curr] = input.nextInt();
        System.out.println(size-curr);
        guess[size-1-curr] = input.nextInt();

        if(guess[curr] == guess[size-1-curr])
          same = curr;
        else
          diff = curr;

        curr++;
      }
      query += 2;
    }

    String output = "";
    for(int i = 0; i < size; i++) {
      output += Integer.toString(guess[i]);
    }

    System.out.println(output);
    String s = input.next();
    if (s.equals("Y")) {
      return;
    } else {
      System.exit(1);
    }
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt();
    for(int i = 0; i < T; i++) {
      solve(input, B);
    }
  }
}