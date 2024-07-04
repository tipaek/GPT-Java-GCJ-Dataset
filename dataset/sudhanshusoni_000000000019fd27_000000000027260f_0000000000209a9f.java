import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt ();
        in.nextLine ();
        for(int x=1;x<=t;x++){
            String str = in.nextLine ();
            String ans = new String();
            for(int i=0;i<str.length ();i++){
                char ch = str.charAt (i);
                if(ch == '0'){
                    ans += ch;
                    continue;
                }
                if(i==(str.length ()-1) && ch =='1'){
                    ans += "("+ch+")";
                }

                if(ch =='1' && (i+1)<str.length () && str.charAt (i+1) == '0' ){
                    ans += "("+ch+")";
                    continue;
                }
                if(ch =='1' && (i+1)<str.length () && str.charAt (i+1) == '1'){
                    ans += "(";
                    int j=i;
                    for(;j<str.length ();j++){
                        if(str.charAt (j)!='1'){
                            break;
                        }
                        ans+=str.charAt (j);
                    }
                    i=j;
                    ans += ")";
                    continue;
                }

            }
            System.out.println ("Case #"+x+": "+ans);

        }





    }


}