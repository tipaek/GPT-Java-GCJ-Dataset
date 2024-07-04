import java.util.ArrayList;
import java.util.Scanner;

public class Solution{
    public static int T;
    public static ArrayList<ArrayList<Integer>> s;
    public static ArrayList<String> sP;
    
    public static void main(String[] args){
    	
    	s=new ArrayList<>();
    	sP=new ArrayList<>();
        readInput();
        solve();
        printOutput();
    }
    
    public static void readInput(){
        Scanner in = new Scanner(System.in);
        T=in.nextInt();
        String current="";
        for(int i=0; i<T;i++){
        	s.add(new ArrayList<>());
            current = in.next();
            for(int j=0; j<current.length();j++) {
            	s.get(i).add(Integer.parseInt(current.charAt(j)+""));
            }
        }
    }
    
    public static void solve(){
        for(int i=0; i<T;i++){        	
            String currentSP="";
            ArrayList<Integer> currentS = s.get(i);
            int currentOpen = 0;
            //System.out.println(i);
            for(int j=0; j<currentS.size();j++) {
            	
            	int currentElement = currentS.get(j);
        		while(currentElement>currentOpen) {
        			currentOpen++;
        			currentSP+="(";
        		}
        		while(currentElement<currentOpen) {
        			currentOpen--;
        			currentSP+=")";
        		}
        		
        		currentSP+=""+currentElement; 
            }
            while(currentOpen>0) {
            	currentOpen--;
    			currentSP+=")";
            }
            sP.add(currentSP);
            
        }
    }
    
    public static void printOutput(){
        for(int i=0; i<T;i++){
            System.out.println("Case #"+(i+1)+": "+sP.get(i));
        }
    }
}