
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

class Solution{
	public static String addFirst(int n)
    {
         return String.join("", Collections.nCopies(n, "("));
    }
    public static String addLast(int n)
    {
         return String.join("", Collections.nCopies(n, ")"));
    }

    
    
    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        
        
        for (int x = 0; x < tests; x++){
            String s = br.readLine();
            int n = s.length();
            int b = 0;
            StringBuilder sb = new StringBuilder();
            
            
            for(int i = 0 ; i < n ; i++){
                int num = s.charAt(i)-48;
                if(num == b){
                    sb.append(s.charAt(i));
                    
                }else if(num > b){
                    int diff = num - b;
                    sb.append(addFirst(diff)).append(s.charAt(i));
                    b = b + diff;
                }else{
                    int diff = b - num;
                    sb.append(addLast(diff)).append(s.charAt(i));
                    b = b - diff;
                }
            }
            if(b > 0){
                sb.append(addLast(b));
            }
            
            System.out.println("Case #" + (x+1)+ ": "+sb.toString());

        }
        System.exit(0);
    }

    


}