import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Arrays.*;

public class Solution {

    public static void main(String[] args) {
        new Solution().haha();
    }

    public void haha() {
        BufferedReader in = null;

        try{
            //in = new BufferedReader(new FileReader("xxx.txt"));
            in = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(in.readLine());
            for(int i=0;i<T;i++){
                System.out.print("Case #"+(i+1)+":");
                String S = in.readLine();
                StringBuffer sb = new StringBuffer();
                int st = 0;
                int cn = 0;
                int cd = 0;
                for(int a=0;a<S.length();a++){
                    int d = Integer.parseInt(""+S.charAt(a));
                    if(st==0){
                        if(d==0){
                            sb.append(d);
                        } else {
                            cd = d;
                            cn = d;
                            for(int c=0;c<cd;c++){
                                sb.append('(');
                            }
                            sb.append(d);
                            st = 1;
                        }
                    } else {
                        if(d==0){
                            while(cn>0){
                                sb.append(')');
                                cn--;
                            }
                            sb.append(d);
                            st=0;
                        } else if(d>cn){
                            int diff = d - cn;
                            for(int c=0;c<diff;c++){
                                sb.append('(');
                            }
                            sb.append(d);
                            for(int c=0;c<diff;c++){
                                sb.append(')');
                            }
                            cd = d;
                            cn = cn;
                        } else if(d==cn){
                            sb.append(d);
                        } else { //d < cn
                            int diff = cn - d;
                            for(int c=0;c<diff;c++){
                                sb.append(')');
                            }
                            cn = cn - diff;
                            cd = d;
                            sb.append(d);
                            st = 1;
                        }
                    }
                }
                if(st==1){
                    for(int c=0;c<cn;c++){
                        sb.append(')');
                    }
                }
                System.out.print(" "+sb.toString()+"\n");
                
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            try{
                in.close();
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        //System.out.print("Ha Ha :D\n");
    }
}