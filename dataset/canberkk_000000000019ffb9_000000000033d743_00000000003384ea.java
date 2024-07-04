import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    long cases = in.nextLong();

    for (int c = 1; c <= cases; c++) {
      String answer = "Case #" + c + ": ";

      long left = in.nextLong();
      long right = in.nextLong();

      long dif = Math.abs(left-right);
      long steps = (long)Math.sqrt(dif*2);

      //sanity check
      if((steps*(steps+1))/2 > dif) steps--;
      if((steps*(steps+1))/2 > dif) System.exit(1);
      if(((steps+1)*(steps+2))/2 <= dif) System.exit(2);

      if(right > left) right -= (steps*(steps+1))/2;
      else left -= (steps*(steps+1))/2;

      long rightMax, leftMax;

      if(right > left){
         rightMax = binarySearch(right,steps+1);
         leftMax = binarySearch(left,steps+2);
         right -= ((steps+1)+rightMax-1)*rightMax;
         left -= ((steps+2)+leftMax-1)*leftMax;
         steps += leftMax + rightMax;
      } else {
        leftMax = binarySearch(left,steps+1);
        rightMax = binarySearch(right,steps+2);
        left -= ((steps+1)+leftMax-1)*leftMax;
        right -= ((steps+2)+rightMax-1)*rightMax;
        steps += leftMax + rightMax;
      }

      out.println(answer + steps + " " + left + " " + right);
    }

    in.close();
    out.close();
  }

  //Binary search for number of possible steps
  static long binarySearch(long target,long start){
    long l = 0;
    long r = target/start;
    while (l+1 < r){
      long i = (l+r+1)/2;
      long val = (start+i-1)*i;
      if(val>target) r = i;
      else if(val < target) l = i;
      else return i;
    }
    if((start+l)*(l+1)<=target) return l+1;
    else return l;
  }
}