//coding jam#2
import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc= new Scanner(System.in);

        int t=1;

        t= Integer.parseInt(br.readLine());
        int caseNo=1;

        while(caseNo<=t){
            String str = br.readLine();
            System.out.println(findSolution(str,str.length(),caseNo));
            caseNo++;
        }

    }

    static String findSolution(String str, int n,int caseNo){
        String res="Case #"+caseNo+": ";

        String str1="";

        int curr=0;

        for(int i=0;i<n;i++){
            int val=Integer.parseInt(str.charAt(i)+"");
            if(val>curr){
                for(int j=0;j<(val-curr);j++){
                    str1+='(';
                }
            }else if(curr>val){
                for(int j=0;j<(curr-val);j++){
                    str1+=')';
                }
            }
            curr=val;
            str1+=val;
        }

        for(int j=0;j<(curr);j++){
            str1+=')';
        }

        return res+=str1;
    }



}









