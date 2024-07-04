

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class NestingDepth {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t++) {
            String str = br.readLine();
            int n = str.length();
            int i = 0;
            StringBuilder sb = new StringBuilder(" ");
            int flag = 0;
            while (i<n) {
              if (str.charAt(i)=='1') {
                  sb.append("(");
                  sb.append(1);
                  while ((i<n-1) &&(str.charAt(++i)=='1')){
                      flag = 1;
                    //System.out.println("str is"+str.charAt(i));
                      sb.append("1");
                       //System.out.println("sb is"+sb.toString());
                      
                  }
                  if (i==n-1) {
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