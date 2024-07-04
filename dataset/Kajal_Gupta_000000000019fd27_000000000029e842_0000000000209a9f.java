
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class NestingDepth {
    public static void main(String[] args) throws NumberFormatException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
         int t = in.nextInt();
       // for (int t = Integer.parseInt(br.readLine()); t>0; t++) {
            for (int i = 1; i <= t; ++i) {
            String str = in.next();
            int n = str.length();
            int j = 0;
            StringBuilder sb = new StringBuilder(" ");
            int flag = 0;
            while (j<n) {
              if (str.charAt(j)=='1') {
                  sb.append("(");
                  sb.append(1);
                  while ((j<n-1) &&(str.charAt(++j)=='1')){
                      flag = 1;
                    //System.out.println("str is"+str.charAt(i));
                      sb.append("1");
                       //System.out.println("sb is"+sb.toString());
                      
                  }
                  if (j==n-1) {
                      ++i;
                  }
                  sb.append(')');
                  //System.out.println("sb is"+sb.toString());
              }
              else{
                  sb.append(0);//str.charAt(i)
                  //System.out.println("sb is"+sb.toString());
                  i++;
              }  
            }
            System.out.println(sb.toString());
        }
    }

}