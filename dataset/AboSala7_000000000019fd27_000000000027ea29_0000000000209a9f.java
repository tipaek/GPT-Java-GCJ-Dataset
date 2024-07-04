import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int testsNum = sc.nextInt();

        while (testsNum> 0){
            String curr = sc.next() ;
            StringBuilder out = new StringBuilder("");
            int x = 0;
            for(int i =0 ; i< curr.length() ; i++){
                if(curr.charAt(i)=='0')out.append('0');
                else{
                    out.append('(').append('1');
                    int y = i+1 ;
                    while (curr.length()> y && curr.charAt(y) == '1'){
                        out.append('1');
                        i++;
                        y++;
                    }
                    out.append(')');
                }
            }
            System.out.println("Case #"+ ++x +": " +out);
        }
    }
}
