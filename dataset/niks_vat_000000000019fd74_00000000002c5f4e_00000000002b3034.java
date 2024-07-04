import java.util.*;

class Solution{

    
    public static String matchLast(String a, String b){ //b>a
        
        

        if(a.length()>b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        if(a.equals("")){
            return b;
        }
        int i = a.length()-1;
        int j = b.length()-1;

        while(i>=0 && a.charAt(i)==b.charAt(j)){
            i--;
            j--;
        }

        if(i==-1){
            return b;
        }

        return "-1";

    }

    
    public static String matchFirst(String a, String b){ //b>a
        
        //System.out.println(match)

        if(a.length()>b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        if(a.length()==0){
            return b;
        }

        int i = 0;
        int j = 0;

        while(i<a.length() && a.charAt(i)==b.charAt(j)){
            i++;
            j++;
        }

        if(i==a.length()){
            return b;
        }

        return "-1";

    }
    
    public static void main(String... args){
        
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=1;t<=T;t++){
            

            int n = in.nextInt();
            StringBuilder match = new StringBuilder("");
            
            boolean notposs = false;

            for(int i=0;i<n;i++){
                String so = in.next();
                if(notposs){
                    continue;
                }
                String s="";
                for(int ii=0;ii<so.length();ii++){
                    if(ii==0){
                        s+=so.charAt(ii);
                    }else{
                        if(so.charAt(ii)=='*'){
                            if(s.charAt(s.length()-1)=='*'){
                                continue;
                            }
                        }
                        s+=so.charAt(ii);
                    }
                }



                if(match.toString().equals("")){
                    match = new StringBuilder(s);
                    continue;  
                }

                int mfirst = match.indexOf("*");
                int mlast = match.lastIndexOf("*");

                int sfirst = s.indexOf("*");
                int slast = s.lastIndexOf("*");

                

                    //setting first part

                    String af = match.substring(0,mfirst);
                    String bf = s.substring(0,sfirst);
                    String matched = matchFirst(af,bf);
                    //System.out.println(af);
                    //System.out.println(bf);
                    //System.out.println("fmatched:"+matched);
                    if(matched.equals("-1")){
                        notposs=true;
                    }
                    match.replace(0,mfirst+1, matched+"*");
                    //System.out.println("first:"+ match);

                    //setting last part
                     mfirst = match.indexOf("*");
                     mlast = match.lastIndexOf("*");

                     sfirst = s.indexOf("*");
                     slast = s.lastIndexOf("*");
                        
                    String a = match.substring(mlast+1);
                    String b = s.substring(slast+1);
                    matched = matchLast(a,b);
                    //System.out.println(s);
                    //System.out.println("a:"+a);
                    //System.out.println("b:"+b);
                    
                    //System.out.println("secmatched:"+matched);
                    if(matched.equals("-1")){
                        notposs=true;
                    }
                    match.replace(mlast+1,match.length(),matched);
                   
                    //System.out.println("sec:"+match);
                    //System.out.println();

             

            }
            //System.out.println("MM:"+match);
            if(match.toString().contains("-1")){
                System.out.println("Case #"+t+":"+" *");
            }else{
                System.out.print("Case #"+t+":"+" ");
                for(int ii=0;ii<match.length();ii++){
                    if(match.charAt(ii)!='*'){
                        System.out.print(match.charAt(ii));
                    }
                }
                System.out.println();

            }
            

        }
        
    }

   
   
    
}