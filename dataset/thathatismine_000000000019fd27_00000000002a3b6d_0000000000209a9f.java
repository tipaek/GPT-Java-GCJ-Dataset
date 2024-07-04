import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        in.nextLine();
        
        for(int c = 0; c < caseNum; c++){
            
            String currStr = in.nextLine();
            
            char[] curr = currStr.toCharArray();
            StringBuilder sb = new StringBuilder();
            int bal = 0;
            
            for(int i = 0; i < curr.length; i++){
                
                int currNum = curr[i] - '0';
                
                if(currNum > bal){
                    while(bal != currNum){
                        sb.append("(");
                        bal++;
                    }
                }else{//curr[i] > bal
                    while(bal != currNum){
                        sb.append(")");
                        bal--;
                    }
                }
                sb.append(curr[i]);
            }
            while(bal != 0){
                sb.append(")");
                bal--;
            }
            
            System.out.println("Case #" + (c+1) + ": " + sb.toString());
        }
    }
}