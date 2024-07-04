import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int start=0,end=0,op=0,cl=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<test;i++){
            String str=sc.next();
            int prev=-1,temp=0;
            for(Character ch:str.toCharArray()){
                int cur=Integer.parseInt(ch.toString());
                if(prev==-1){
                    prev=cur;
                    temp=cur;
                }else{
                    temp=cur-prev;
                    prev=cur;
                }
                if(temp < 0){
                    for(int j=0;j<Math.abs(temp);j++){
                        sb.append(")");
                        cl++;
                    }
                }else{
                    for(int j=0;j<Math.abs(temp);j++){
                        sb.append("(");
                        op++;
                    }
                }
                sb.append(cur);
            }
            if(op > cl){
                for(int j=0;j<op-cl;j++)
                    sb.append(")");
            }
            op=0;cl=0;
            System.out.println("Case #"+(i+1)+": "+sb.toString());
            sb.setLength(0);
        }
    }
}