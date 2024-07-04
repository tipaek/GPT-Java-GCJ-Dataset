import java.io.*;

class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t<=test; t++){
            String str = "0"+br.readLine()+"0";
            String strNew = "";
            for(int i = 1; i < str.length()-1; i++){
                int nPrev = Integer.parseInt(""+str.charAt(i-1));
                int n = Integer.parseInt(""+str.charAt(i));
                int nNext = Integer.parseInt(""+str.charAt(i+1));
                for(int b = 1; b <= n-nPrev; b++){
                    strNew += "(";
                }
                strNew += n;
                for(int b = 1; b <= n-nNext; b++){
                    strNew += ")";
                }
            }
            System.out.println("Case #"+t+": "+strNew);
        }
    }
}