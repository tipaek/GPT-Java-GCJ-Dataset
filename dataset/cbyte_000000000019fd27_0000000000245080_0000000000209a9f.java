import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int counts = Integer.parseInt(br.readLine()); 
    int k = counts;
    while (counts-->0){
      String input = br.readLine();
      String ans = ""; 
      
      int curr = Integer.parseInt(input.substring(0, 1));
      for (int i=0; i<curr; i++)  ans+="(";

      ans += input.substring(0, 1);
      for (int i=0; i<input.length()-1; i++){

        curr = Integer.parseInt(input.substring(i, i+1));
        int next = Integer.parseInt(input.substring(i+1, i+2));

        if (curr < next)
          for (int x=0; x<next-curr; x++) ans += "(";

        else if (curr > next)
          for (int x=0; x<curr-next; x++) ans+=")";

        ans+=input.substring(i+1, i+2);
      }
      curr = Integer.parseInt(input.substring(input.length()-1));
      for (int i=0; i<curr; i++)  ans+=")";
      sb.append("Case #" + (k - counts) + ": " + ans + "\n");
    }
    System.out.print(sb);
  }
}