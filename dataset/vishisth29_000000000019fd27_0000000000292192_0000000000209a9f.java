import java.util.*;
public class Solution {
    private static Scanner scn;
    private static int cases=1;

    public static void main(String args[]) {
    scn=new Scanner(System.in);
        int t=scn.nextInt();
        scn.nextLine();

            while(t-->0){
                solve();
            }

        }

        private static void solve(){

        String s=scn.nextLine();
        char[] ch=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int temp=0;
        int balance=0;

        int shuru = Character.getNumericValue(ch[0]);
        temp=shuru;
        balance=shuru;

        for(int i=0;i<shuru;i++){
            sb.append('(');
        }
        sb.append(shuru);

        for(int i=1;i<ch.length;i++){
            int s_temp=Character.getNumericValue(ch[i]);

            if(s_temp==temp){
                sb.append(s_temp);
            }else if(s_temp>temp){
                int dif=s_temp-temp;
                for(int j=0;j<dif;j++){
                    sb.append('(');
                    balance++;
                }

               sb.append(s_temp);
            }else{
                int dif=temp-s_temp;
                for(int j=0;j<dif;j++){
                    sb.append(')');
                    balance--;
                }
                sb.append(s_temp);
            }
            temp=Character.getNumericValue(ch[i]);
        }

        while(balance-->0){
            sb.append(')');
        }


        System.out.println("Case #" + (cases++)+": "+sb.toString());


        }




    }







