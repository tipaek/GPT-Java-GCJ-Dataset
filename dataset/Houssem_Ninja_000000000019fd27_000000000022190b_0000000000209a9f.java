
import java.util.Scanner;
public class ProbB{


public static String ans(String s){
    
    
    String s1 = new String();
    int k;
    int i=0;
    while(i < s.length()){
        int nbrCh = Integer.parseInt(String.valueOf(s.charAt(i)));
        int nbr = nbrCh;

        for(int j = 0 ; j < nbr ; j++){
            s1+='(';
        }
        
        s1+=(String.valueOf(nbr));

        if(i < s.length()){  
        k=i+1;
            if(k < s.length()){
        while(nbr == Integer.parseInt(String.valueOf(s.charAt(k)))){
            
            s1+=(String.valueOf(nbr));
            k++;
            if(k >= s.length()) break;
              
        }
        }
        i=k;
        }
        for(int j = 0 ; j < nbr ; j++){
            s1+=')';
        }

    }

    return s1;
}

public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    int t,x=1;
    t = scan.nextInt();
    
    while(t>0){

    String s,y;
    s = scan2.nextLine();	  
    y = ans(s);  
    
    System.out.println("Case #"+x+": "+y);

        
        
    x++;
    t--;	
    }



}

}