import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int cases = Integer.parseInt(in.nextLine());
    //int cases = in.nextInt();

    for (int c = 1; c <= cases; c++) {
      String answer = "Case #" + c + ": ";
      int N = Integer.parseInt(in.nextLine());
      String[][] ps = new String[N][3];
      for (int i = 0; i < N; i++) {
        String[] pattern = (in.nextLine()+"\n").split("\\*");
        ps[i][0] = pattern[0];
        ps[i][1] = "";
        ps[i][2] = pattern[pattern.length-1];
        for (int j = 1; j < pattern.length-1; j++) {
          ps[i][1] += pattern[j];
        }
      }

      String prefix = "";
      String suffix = "";
      boolean impossible = false;
      for (int i = 0; i < N && !impossible; i++) {
        if(!prefix.startsWith(ps[i][0])){
          if(ps[i][0].startsWith(prefix)) prefix = ps[i][0];
          else{
            impossible = true;
          }
        }
        if(!suffix.endsWith(ps[i][2])){
          if(ps[i][2].endsWith(suffix)) suffix = ps[i][2];
          else{
            impossible = true;
          }
        }
      }

      if(impossible){
        answer += "*\n";
      } else {
        answer += prefix;
        for (int i = 0; i < N; i++) {
          answer += ps[i][1];
        }
        answer += suffix;
      }
      out.print(answer);
    }

    in.close();
    out.close();
  }
}