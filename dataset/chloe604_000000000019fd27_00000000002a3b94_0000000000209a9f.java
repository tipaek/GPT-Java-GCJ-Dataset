package googlecodejam;
import java.util.*;

public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        ArrayList<String> a = new ArrayList();
        ArrayList<String> b = new ArrayList();
        StringBuilder sb1 = new StringBuilder("testing");
        int T = in.nextInt();
        for(int i=0;i<T;i++){
            a.add(in.next());}
        //input ends
        
        //if 00000000
        for(int i=0;i<a.size();i++){
            if("0".equals(String.valueOf(a.get(i).charAt(0))) && same(a.get(i)))
            {b.add(i,a.get(i));}
            else 
            { for(int j=0;j<a.get(i).length();j++){
                if("1".equals(String.valueOf(a.get(i).charAt(j)))){
                     sb1 = new StringBuilder(a.get(i));
                    sb1.insert(j, "(");
                    //checking if same characters
                    if(j!=a.get(i).length()-1){
                        //System.out.println("check");
                    if(a.get(i).charAt(j) != a.get(i).charAt(j+1)){
                    sb1.insert(j+2,")");}
                    } //if j isn't the last character ENDS
                    else {sb1.insert(j+2,")");}
                   
                //a.get(i). = a.get(i).substring(0, j);
                }
                
                else {}
                
            }//inner for
             b.add(i,sb1.toString());}
        } //for ends
       
            
        
        
        
        for(int i=0;i<b.size();i++){
            System.out.println("Case #"+(i+1)+":" + b.get(i));
        }
        
    } //main ends
   //method to check if same
    static boolean same(String s) 
{ 
    int n = s.length(); 
    for (int i = 1; i < n; i++) 
        if (s.charAt(i) != s.charAt(0)) 
            return false; 
          
    return true; 
} 
}
