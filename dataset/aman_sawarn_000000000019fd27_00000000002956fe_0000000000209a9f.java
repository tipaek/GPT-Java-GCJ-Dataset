import java.util.*;
class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        int tCount = 0;
        StringBuilder sb = new StringBuilder();
        while(tCount++<tc){
            String str = scn.next();
            StringBuilder res = new StringBuilder();
            int prevNum = 0;
            int numOfOpenBraces = 0;
            for(char ch : str.toCharArray()){
                int num =(int) ch-'0';
                if(num==prevNum){
                    res.append(ch);
                    prevNum = num;
                }
                else if(num>prevNum){
                    for(int i=0;i<num-prevNum;i++){
                        res.append("(");
                        numOfOpenBraces++;
                    }
                    res.append(ch);
                    prevNum=num;
                }else if(num<prevNum){
                    for(int i=0;i<prevNum-num;i++){
                        res.append(")");
                        numOfOpenBraces--;
                    }
                    res.append(ch);
                    prevNum=num;
                }
            }
            while(numOfOpenBraces-->0){
                res.append(")");
            }
            sb.append("Case #"+tCount+": ").append(res).append("\n");
        }
        System.out.println(sb);
    }
}
