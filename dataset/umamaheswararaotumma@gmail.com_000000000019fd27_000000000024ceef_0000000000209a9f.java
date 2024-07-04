import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int caseNo = 1;
        int t = sc.nextInt();
        while(t--> 0){
            String s = sc.next();
            int noOfOpenParanthesis = 0;
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                int number = (int)(c-'0');
                if(number == 0){
                    while(noOfOpenParanthesis!=0){
                        sb.append(")");
                        noOfOpenParanthesis--;
                    }
                    sb.append("0");
                }
                else{
                    int noOfNewOpen = number - noOfOpenParanthesis;
                    if(noOfNewOpen > 0){
                        while(noOfNewOpen!=0){
                            sb.append("(");
                            noOfNewOpen--;
                            noOfOpenParanthesis++;
                        }
                    }
                    else if(noOfNewOpen < 0) {
                        while(noOfNewOpen!=0){
                            sb.append(")");
                            noOfNewOpen++;
                            noOfOpenParanthesis--;
                        }
                    }
                    sb.append(number);
                }
            }
            	while(noOfOpenParanthesis-- > 0) {
            		sb.append(")");
            	}
            System.out.println("Case #" + caseNo +": "+sb.toString());
        }
       
    }
    
}