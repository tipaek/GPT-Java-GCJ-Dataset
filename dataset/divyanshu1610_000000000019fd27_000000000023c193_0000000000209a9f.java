import java.io.*;
class Solution {

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t,T;
        T = Integer.parseInt(br.readLine());
        t = 1;
        char curr, prev;
        String inps, outs;
        while( t <= T){
            inps = br.readLine();
            outs = "";
            int l = inps.length();
            for(int i=0; i<l; i++){
                curr = inps.charAt(i);
                if(i > 0)
                    prev = inps.charAt(i-1);
                else
                    prev = '-';

                if(curr == '0'){

                    if(prev == '1')
                        outs+=")0";
                    else
                        outs+="0";
                }else {

                    if(prev == '1')
                        outs+="1";
                    else
                        outs+="(1";
                }
            }

            if(inps.charAt(l-1) == '1')
                outs+=")";
            System.out.println("Case #"+t+": "+outs);
            t++;
        }
    }

}
