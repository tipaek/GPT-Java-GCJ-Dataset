import java.io.*;
import java.util.*;
class Solution {
    public static void main (String[] args) {
        //System.out.println("GfG!");
        int t;
        Scanner sc = new Scanner(System.in);
        t =sc.nextInt();
        int cse = 0;
        while(t--!=0){
            cse++;
            String s = sc.next();
            String ans = "";
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c=='1'){
                    ans+='(';
                    for(int j=i;j<s.length();j++){
                        char k = s.charAt(j);

                        if(k=='1')
                        {ans+=k;
                            if(j==s.length()-1){
                                ans+=')';
                                i=j;
                                break;
                            }
                        }
                        else{
                            ans+=')';
                            ans+=k;
                            i=j;
                            break;
                        }
                    }

                }
                else
                    ans+=c;


            }

            System.out.println("Case #"+cse+": "+ans);
            //while
        }


    }}
