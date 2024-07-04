import java.util.*;
class codejam1
{
    public static void main(String[] args)throws Exception
    {
        Scanner ob=new Scanner(System.in);
        int t,i,j,k,cas=0;
        String s,m="";
        char p;
        t=ob.nextInt();
        while(t-->0){
            cas++;
            s=ob.next();
            for(i=0;i<s.length();i++){
                p=s.charAt(i);
                k=Character.getNumericValue(p);
                for(j=1;j<=k;j++){
                    m+="(";
                }
                m+=p;
                for(j=1;j<=k;j++){
                    m+=")";
                }
            }
            System.out.println("Case #"+cas+": "+m);
            m="";
        }
    }
}