import java.io.*;
class Solution{
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String s=br.readLine();
            String str="";
            int c=0;
            for(int j=0;j<s.length();j++){
                int ch=s.charAt(j)-48;
                if(c==ch)
                    str=str+ch;
                else if(c>ch){
                    for(int k=0;k<c-ch;k++)
                        str=str+')';
                    str=str+ch;
                    c=ch;
                }
                else{
                    for(int k=0;k<ch-c;k++)
                        str=str+'(';
                    str=str+ch;
                    c=ch;
                }
            }
            for(int j=0;j<c;j++)
                str=str+')';
            System.out.println("Case #"+(i+1)+": "+str);
        }
    }
}
