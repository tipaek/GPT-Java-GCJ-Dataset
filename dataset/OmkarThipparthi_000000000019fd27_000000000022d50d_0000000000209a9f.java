import java.util.*;
class Test{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        int k=1;
        while(k<=t){
            String s=sc.nextLine();
            String res="";
            int prevnum=0,oc=0;
            for(int i=0;i<s.length();i++){
                int cur=Character.getNumericValue(s.charAt(i));
                if(prevnum==cur){
                    res=res+s.charAt(i);
                    continue;
                }
					
                if(prevnum>cur && i!=0){
                  //  String addclose=")";
                //addclose=addclose.repeat(Math.abs(cur-prevnum));
                for(int j=0;j<Math.abs(cur-prevnum);j++){ res=res+")"; }
                oc=oc-Math.abs(cur-prevnum);
                //res=res+addclose;
                res=res+s.charAt(i);
                prevnum=cur;
                continue;
                }
                if(Math.abs(cur-prevnum)>0){
                //String addopen="(";
                oc=oc+Math.abs(cur-prevnum);
                //addopen=addopen.repeat(Math.abs(cur-prevnum));
                for(int j=0;j<Math.abs(cur-prevnum);j++){ res=res+"("; }
                //res=res+addopen;
                }
                res=res+s.charAt(i);
                prevnum=cur;
            }
            
            if(oc>0){
                //res=res+")".repeat(oc);
                for(int j=0;j<oc;j++){  res=res+")";  }
            }
            
            
            
            System.out.println("Case #"+k+": "+res);
            k++;
        }
    }
}