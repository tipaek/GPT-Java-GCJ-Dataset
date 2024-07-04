import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            StringBuilder sb=new StringBuilder();
            boolean hold=false;
            for (char c : s.toCharArray()) {
                if (c=='1' && hold==false){
                    sb.append('(');
                    sb.append('1');
                    hold=true;
                }
                else if(c=='1'&&hold==true){
                    sb.append('1');
                }
                else if(c=='0'&&hold==true){
                    sb.append(')');
                    sb.append('0');
                    hold=false;
                }
                else{
                    sb.append('0');
                }
            }
            int len=sb.toString().length()-1;
            if (sb.toString().charAt(len)=='1'){
                sb.append(')');
            }
            int testnumber=i+1;
            System.out.println("Case #"+testnumber+": "+ sb.toString());
        }
    }
}
