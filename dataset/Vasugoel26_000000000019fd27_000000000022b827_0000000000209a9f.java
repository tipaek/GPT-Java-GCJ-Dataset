import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int notc = in.nextInt();
        in.nextLine();
        for(int i=0;i<notc;i++){


            int case_np = i+1;

            String tc = in.nextLine();
            StringBuilder _sb = new StringBuilder(tc);
            _sb.insert(0,"0");
            _sb.append("0");
          //  System.out.print("\n"+_sb);
            //String ftc = _sb.toString();
            for(int j =0;j<_sb.length()-1;j++){
                boolean negative = false;
                int f = Integer.parseInt(String.valueOf(_sb.charAt(j)));
                int b = Integer.parseInt(String.valueOf(_sb.charAt(j+1)));
                int diff = f-b;
                if(diff <0){
                    negative=true;
                    diff = Math.abs(diff);
                }
                for(int k =0; k<diff;k++){
                    if(negative==true){

                        _sb.insert(j+1,"(");
                         j++;
                    }
                    if(negative==false){

                        _sb.insert(j+1,")");
                        j++;
                    }

                }

            }
            String fans = _sb.substring(1,_sb.length()-1);
            System.out.print("\nCase #"+case_np+": "+fans);


        }
    }
}
