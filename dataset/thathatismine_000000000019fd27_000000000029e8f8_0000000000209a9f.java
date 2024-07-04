import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        
        for(int c = 0; c < caseNum; c++){
            
            String currStr = in.nextLine().toString();
            
            System.out.println(currStr);
            
            char[] curr = currStr.toCharArray();
            StringBuilder sb = new StringBuilder();
            
            System.out.println(curr);
            
            if(curr.length == 0){
                break;
            }else if(curr.length == 1){
                for(int i = 0; i < curr[0]; i++){
                    sb.append("(");
                }
                sb.append(curr[0]);
                for(int i = 0; i < curr[0]; i++){
                    sb.append(")");
                }
            }else{
                int i = 0, 
                    j = 1, 
                    bal = curr[0];
                    
                while(i < curr.length){
                    for(int b = 0; b < bal; b++){
                        sb.append("(");
                    }
                    sb.append(curr[i]);
                    
                    if(j < curr.length){
                        if(curr[j] < curr[i]){
                            while(bal != curr[i]){
                                sb.append(")");
                                bal--;
                            }
                            sb.append(curr[j]);
                        }else if(curr[j] == curr[i]){
                            sb.append(curr[j]);
                        }else{
                            while(bal != curr[i]){
                                sb.append("(");
                                bal++;
                            }
                            sb.append(curr[j]);
                        }
                    }else{
                        while(bal != 0){
                            sb.append(")");
                            bal--;
                        }
                    }
                    i++;
                    j++;
                }
            }
            
            System.out.println("Case #" + (c+1) + ": " + sb.toString());
        }
    }
}