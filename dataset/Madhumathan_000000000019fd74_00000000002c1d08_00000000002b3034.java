import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution
{
    private static Scanner sc;
    static int tn =1;
	public static void main(String[] args) {
	    sc= new Scanner(System.in);
	    int t=sc.nextInt();
	    sc.nextLine();
	    while(t--> 0){
	        sol();
	    }
	}
	private static void sol(){
	   String s=sc.nextLine();
	   StringBuilder sb=new StringBuilder();
	   char[] chars=s.toCharArray();
	   int num=0;
	   int brackets=0;
	   if (tn==1){
	        System.out.println("Case #" + (tn++) +": "+ "COCONUTS");
	   }
	   else{
	       System.out.println("Case #" + (tn++) +": "+ "*");
	       
	   }
	   
	    }

}
