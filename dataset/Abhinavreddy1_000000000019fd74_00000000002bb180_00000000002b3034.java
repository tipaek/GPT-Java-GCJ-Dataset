import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++){
            int n=Integer.parseInt(br.readLine());
            String[] ar=new String[n];
            int maxl=-1;
            int maxi=-1;
            for(int i=0;i<n;i++){
                ar[i]=br.readLine();
                if(ar[i].length()>maxl){
                    maxl=ar[i].length();
                    maxi=i;
                }
            }
            StringBuilder sb=new StringBuilder("");
            for(char c:ar[maxi].toCharArray()) if(c!='*') sb.append(c);
            String target=sb.toString();
            boolean flag=true;
            for(int i=0;i<n;i++){
                int si=0;
                int ei=0;
                for(int j=0;j<ar[i].length();j++){
                    if(ar[i].charAt(j)=='*'){
                        ei=j;
                        if(ei>si)
                            if(!target.contains(ar[i].substring(si,ei))){
                                flag=false;
                                break;
                            }
                        si=j+1;
                    }
                    if(j==ar[i].length()-1 && ar[i].charAt(j)!='*' && !target.contains(ar[i].substring(si,j+1))) flag=false;
                }
            }
            System.out.print("Case #"+(p+1)+": ");
            if(flag==false) System.out.println("*");
            else System.out.println(target);
        }
    }
}