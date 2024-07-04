
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution{
    public static void main(String args[]) throws IOException{
        process();
    }
    public static void process() throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        for(int t=0;t<T;t++){
            String str=in.readLine();
            int n=str.length();
            int y=0;
            int previous=Character.getNumericValue(str.charAt(0));
            String arr[]=produce(Character.getNumericValue(str.charAt(0)));
            String ans=arr[0]+str.charAt(0)+arr[1];
            for(int i=1;i<n;i++){
                String a="";
                String b="";
                int present=Character.getNumericValue(str.charAt(i));
                if(present==0){
                    previous=present;
                    ans+="0";
                    continue;
                }
                if(present<previous)
                    y=0;
                else
                    y=Math.abs(present-previous);
                arr=produce(y);
                String temp=arr[0]+present+arr[1];
                if(y==present) {
                    previous=present;
                    ans += temp;
                    continue;
                }
                if(present==previous)
                    y=Math.abs(ans.length()-present);
                else
                    y=Math.abs(Math.abs(previous-present)-ans.length());
                if(present<previous) {
                    a = ans.substring(0, y+1);
                    b = ans.substring(y+1);
                }
                else{
                    a = ans.substring(0, y);
                    b = ans.substring(y);
                }
                ans= a+temp+b;
                previous=present;
            }
            System.out.println("Case #"+(t+1)+": "+ans);
        }
    }
    public static String[] produce(int n){
        String arr[]=new String[2];
        for(int i=0;i<2;i++)
            arr[i]="";
        for(int i=0;i<n;i++){
            arr[0]+="(";
            arr[1]+=")";
        }
        return arr;
    }
}
