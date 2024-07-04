import java.io.*;
class ABC{
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int k=0;
        while(t!=0){
            t--;
            k++;
            String s=br.readLine();
            int p=0;
            int i,q,j;
            char c1,c2;
            StringBuffer sb=new StringBuffer("");
            for(i=0;i<s.length();i++){
                c1= s.charAt(i);
                q=(int)c1-48;
                c2=c1;
                if(i>0){
                    c2=s.charAt(i-1);
                }
                if(q>0&&i==0){
                    for(j=1;j<=q;j++){
                        sb.append("(");
                        p++;
                    }
                }
                else if((int)c1>(int)c2){
                    int diff=(int)c1-(int)c2;
                    for(j=1;j<=diff;j++){
                        sb.append("(");
                        p++;
                    }
                }
                else if((int)c1<(int)c2){
                    int diff=(int)c2-(int)c1;
                    for(j=1;j<=diff;j++){
                        sb.append(")");
                        p--;
                    }
                }
                sb.append(c1);
                
            }
            for(j=1;j<=p;j++){
                sb.append(")");
             }
             System.out.println("Case #"+k+": "+sb);
        }
        
    }
}