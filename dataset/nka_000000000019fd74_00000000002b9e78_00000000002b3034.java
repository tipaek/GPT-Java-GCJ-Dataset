import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=sc.nextInt();
        int x=1;
        while(T>0){
            int n=sc.nextInt();
            String[] patterns=new String[n];
            String prefix="";
            boolean pFlag=false;
            String suffix="";
            String output="";
            for(int i=0;i<n;i++){
                patterns[i]=sc.next();
                int len=patterns[i].length();
                String tprefix="";
                pFlag=false;
                String tsuffix="";
                output="";
                for(int j=0;j<len;j++){
                    if(!pFlag){
                        if(patterns[i].charAt(j)=='*'){
                            pFlag=true;
                        }
                        else{
                            tprefix+=patterns[i].charAt(j);
                        }
                    }
                    else{
                        if(patterns[i].charAt(j)=='*'){
                            tsuffix="";
                        }
                        else{
                            tsuffix+=patterns[i].charAt(j);
                        }
                    }
                }
                //System.out.println("prefix"+tprefix+"  suffix"+tsuffix);
                int tplen=tprefix.length();
                int plen=prefix.length();
                int k=0;
                while(k<tplen && k<plen){
                    if(prefix.charAt(k)!=tprefix.charAt(k)){
                        output="*";
                        break;
                    }
                    k++;
                }
                if(output.equals("*")){
                    break;
                }

                int tslen=tsuffix.length();
                int slen=suffix.length();

                k=tslen-1;
                int q=slen-1;
                while(k>=0 && q>=0){
                    //System.out.println(suffix.charAt(q)+" "+tsuffix.charAt(k));
                    if(suffix.charAt(q)!=tsuffix.charAt(k)){
                        output="*";
                        break;
                    }
                    k--;
                    q--;
                }
                if(output.equals("*")){
                    break;
                }

                if(tprefix.length()>prefix.length()){
                    prefix=tprefix;
                }
                if(tsuffix.length()>suffix.length()){
                    suffix=tsuffix;
                }


            }
            if(!output.equals("*")) {
                output = prefix + suffix;
            }
            if(output.length()>0 && !output.equals("*")){
                System.out.println("Case #" + x + ": " + output);
            }
            else{
                System.out.println("Case #" + x + ": " + "*");
            }



            T--;
            x++;
        }
    }
}
