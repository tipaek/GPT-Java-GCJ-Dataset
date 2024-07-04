import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author owen
 */
public class Solution {
static String itsOut;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
       int t=in.nextInt();
        for (int q = 1; q <= t; q++) {
            
            System.out.print("Case #"+q+":");
           String finalOut="";
         String numString=in.next();
         String []arrOutF;//POSSIBIBLY FOR OUT OF BOUND ERROR
         List arrList=new LinkedList();
            for (int w = 0; w < numString.length(); w++) {
                //System.out.println("LENGTH "+numString.length());
                String digit=""+numString.charAt(w);
                //System.out.println(w);
                    Solution s=new Solution();
                    
                    finalOut=finalOut+s.openP(digit);
                
                finalOut=finalOut+digit;
                
                    
                    finalOut=finalOut+s.closedP(digit);
                
                
            }
            arrOutF=new String[finalOut.length()];
            for (int u = 0; u < finalOut.length(); u++) {
                
                arrOutF[u]=""+(finalOut.charAt(u));//remove if error
                //System.out.println(arrOutF[u]);
                //arrList.add(""+finalOut.charAt(u));
                
            }
            
            for (int r = 0; r < arrOutF.length-1; r++) {
                 
                    if (")".equals(arrOutF[r]) && "(".equals(arrOutF[r+1])) {
                        arrOutF[r]="%";
                        arrOutF[r+1]="%";
                       // System.out.println("REMOVED "+"R:"+r+" y:"+(r+1));
                          
                        
                    }
                }
            
            
            for (int o = 0; o < arrOutF.length; o++) {
                //System.out.println(arrOutF[o]);
                if (!"%".equals(arrOutF[o])) {
                    
                    arrList.add(arrOutF[o]);
                }
            }
            itsOut="";
            for (int o = 0; o < arrList.size(); o++) {
               itsOut=itsOut+arrList.get(o);
            }
            
            boolean done = false;
            while(done==false){
                boolean checked=false;
            for (int p = 0; p < (itsOut.length()-1) && checked==false; p++) {
                if(itsOut.charAt(p)==')' && itsOut.charAt(p+1)=='('){
                    checked=true;
                    Solution.removeB();
                    
                }
                
            }
            if(checked==false){
                done=true;
            }
            }
            if(done==true){
                System.out.print(" "+itsOut+"\n");
            }
        }
        
    }
    public static void removeB(){
        List newList=new LinkedList();
        int newLen=itsOut.length();
        String arrNew []= new String[newLen];
        String bye="";
        for (int r = 0; r < itsOut.length(); r++) {
                arrNew[r]=""+(itsOut.charAt(r));
            }
            for (int i = 0; i < arrNew.length-1; i++) {
                if(")".equals(arrNew[i]) && "(".equals(arrNew[i+1])){
                    arrNew[i]="%";
                    arrNew[i+1]="%";
                }
        }
            for (int i = 0; i < arrNew.length; i++) {
                if (arrNew[i]!="%") {
                newList.add(arrNew[i]);
            }
        }
            for (int f = 0; f < newList.size(); f++) {
            bye=bye+newList.get(f);
        }
                
              itsOut=bye;    
                }
    
    
    public String openP(String num){
        int n=Integer.parseInt(num);
        String out="";
        for (int i = 0; i < n; i++) {
            out=out+"(";
            
        }
        return out;
    }
    
     public String closedP(String num){
        int n=Integer.parseInt(num);
        String out="";
        for (int i = 0; i < n; i++) {
            out=out+")";
            
        }
        return out;
    }
}
