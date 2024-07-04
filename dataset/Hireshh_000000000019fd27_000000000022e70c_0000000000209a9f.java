import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for(int i=1;i<=t;i++){
            String s = "0"+in.nextLine()+"0";
            StringBuilder ans = new StringBuilder();
            int firstInt = Integer.parseInt(s.charAt(0)+"");
            appendParan(firstInt,true,ans);
            ans.append(firstInt+"");
            for(int j=0;j<s.length()-1;j++){
                int curr = Integer.parseInt(s.charAt(j)+"");
                int next = Integer.parseInt(s.charAt(j+1)+"");
                int count = curr-next;
                if(j!=0)
                    ans.append(curr+"");
                if(count>0){
                    appendParan(count,false,ans);
                }else if(count<0){
                    appendParan(count*-1,true,ans);
                }
            }
            System.out.println("Case #"+i+": "+ans.delete(0,1));
        }
    }

    private static void appendParan(int count,boolean open,StringBuilder ans){
        String op="(";String cl=")";
        String app = cl;
        if(open){
            app=op;
        }
        for(int i=0;i<count;i++){
            ans.append(app);
        }
    }
}
