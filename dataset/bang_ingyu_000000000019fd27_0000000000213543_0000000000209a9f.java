import java.io.*;

public class Solution {
    public static int stoi(String s){
        return Integer.parseInt(s);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = stoi(br.readLine());
        
        for(int i = 1; i <= T; i++){
            sb.append("Case #");
            sb.append(i);
            sb.append(": ");
            
            char[] input = br.readLine().toCharArray();
            
            int x = 0;
            
            for(int j = 0; j < input.length; j++){
                int now = input[j] - 48;
                
                while(x > now){
                    sb.append(")");
                    x--;
                }
                while(x < now){
                    sb.append("(");
                    x++;
                }
                
                sb.append(now);
                
            }
            while(x > 0){
                sb.append(")");
                x--;
            }
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
    }
}