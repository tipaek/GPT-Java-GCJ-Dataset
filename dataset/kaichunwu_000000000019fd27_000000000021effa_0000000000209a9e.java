import java.util.*;
import java.io.*;

public class Solution {
  private static String solve(Scanner input, int B) {
    int[] res = new int[B+1];
    Arrays.fill(res,-1);
    int time = 1;
    int same = -1;
    int diff = -1;
    for(int i = 1;i < B/2+1;++i) {
        if((time%10==1)&&time!=1) {
            time = test(input,res,same,diff,time);
        }
        System.out.println(i);
        String ans = input.next();
        time++;
        res[i] = Integer.valueOf(ans);
        if((time%10==1)&&time!=1) {
            time = test(input,res,same,diff,time);
        }
        System.out.println(B-i);
        ans = input.next();
        time++;
        res[B+1-i] = Integer.valueOf(ans);
        if(same==-1||diff==-1) {
            if(same==-1&&res[i]==res[B+1-i]) same = i;
            else if(diff==-1&&res[i]!=res[B+1-i]) diff = i;
        }
    }
    String ss = "";
    for(int i = 1;i < B+1;++i) ss+=res[i];
    return ss;
  }
  
  private static int test(Scanner input,int[] arr,int same,int diff,int time) {
      if(same==-1||diff==-1) {
          int test = same==-1?diff:same;
          System.out.println(test);
          int ans = Integer.valueOf(input.next());
          time++;
          if(ans==arr[test]) return time;
          for(int i = 1;i < arr.length;++i) {
              if(arr[i]!=-1) arr[i] = arr[i]==1?0:1;
          }
          return time;
      }
      int B = arr.length;
      System.out.println(same);
      int sa = Integer.valueOf(input.next());
      time++;
      System.out.println(diff);
      int da = Integer.valueOf(input.next());
      time++;
      int[] narr = Arrays.copyOf(arr,B);
      if(sa==arr[same]&&da==arr[diff]) {
          return time;
      }else if(sa!=arr[same]&&da!=arr[diff]) {
          for(int i = 1;i < B;++i) {
              if(arr[i]!=-1) arr[i] = arr[i]==1?0:1;
          }
          return time;
      }else if(sa==arr[same]&&da!=arr[diff]) {
          for(int i = 1;i < B;++i) {
              narr[i] = arr[B-i];
          }
      }else {
          for(int i = 1;i < B;++i) {
              if(arr[B-i]!=-1) narr[i] = arr[B-i]==1?0:1;
              else narr[i] = -1;
          }
      }
      for(int i = 1;i < B;++i) {
          arr[i] = narr[i];
      }
      return time;
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = Integer.parseInt(input.next());
    int B = Integer.parseInt(input.next());
    for (int ks = 1; ks <= T; ks++) {
      String res = solve(input,B);
      System.out.println(res);
      String s = input.next();
      if(s.equals("Y")) continue;
      else break;
    }
  }
}