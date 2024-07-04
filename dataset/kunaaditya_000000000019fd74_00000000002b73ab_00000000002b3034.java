import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        while(T-->0){
            int n=Integer.parseInt(br.readLine());
            String[] arr=new String[n];
            String[] f=new String[n];
            String[] l=new String[n];
            Arrays.fill(f,"");
            Arrays.fill(l,"");
            for(int i=0;i<n;i++){
                arr[i]=br.readLine();
                int j=0;
                while(arr[i].charAt(j)!='*'){
                    f[i]+=arr[i].charAt(j);
                    j++;
                }
                j=j+1;
                while(j<arr[i].length()){
                    l[i]+=arr[i].charAt(j);
                    j++;
                }
            }
            String ans1="",ans2="";
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(f[i].length()>=ans1.length()){
                    if(f[i].indexOf(ans1)==0)
                        ans1=f[i];
                    else{
                        flag=false;
                        break;
                    }
                }
                else{
                    if(ans1.indexOf(f[i])==0)
                        ans1=ans1;
                    else{
                        flag=false;
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++){
                if(l[i].length()>=ans2.length()){
                    if(f[i].lastIndexOf(ans1)==f[i].length()-ans1.length())
                        ans2=l[i];
                    else{
                        flag=false;
                        break;
                    }
                }
                else{
                    if(ans2.indexOf(l[i])==ans2.length()-l[i].length())
                        ans2=ans2;
                    else{
                        flag=false;
                        break;
                    }
                }
            }
            System.out.println(ans1+ans2);
        }
    }
}