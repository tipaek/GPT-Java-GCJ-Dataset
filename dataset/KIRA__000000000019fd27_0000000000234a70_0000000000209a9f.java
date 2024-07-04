import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
import java.util.HashMap;


public class Solution {


  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t1 = Integer.parseInt(br.readLine());

    for (int t = 0; t < t1; ++t) {
      String s=br.readLine();
      s=s+"0";
      int  a=0;
      char chn='(';
      char chp=')';
      StringBuilder answer=new StringBuilder();
      for(int i=0;i<s.length();++i)
      {
        int b=Character.getNumericValue(s.charAt(i));
        int diff=a-b;
        if(diff>0)
        { if(i!=0)
          answer.append(a);
        for(int j=0;j<Math.abs(diff);++j)
          answer.append(chp);
        }
        else
        {
          if(i!=0)
          answer.append(a);
          for(int j=0;j<Math.abs(diff);++j)
            answer.append(chn);
        }
        a=b;


      }
      System.out.println("Case #"+(t+1)+": "+answer);

    }


  }
}