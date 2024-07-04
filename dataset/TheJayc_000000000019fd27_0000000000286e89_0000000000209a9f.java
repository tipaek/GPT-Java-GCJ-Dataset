import java.util.Scanner;
public class Solution{
    public static void main(String[]args) { 
   
        Scanner scan=new Scanner(System.in);
        int numTimes=Integer.parseInt(scan.nextLine());
        String s;
        
        for(int a=0;a<numTimes;a++){
            s=scan.nextLine();
            String y="";
            char endc=s.charAt(0);
            int end=Character.getNumericValue(endc);
            
            if(s.length()==1) {
            	int abc=Integer.parseInt(s);
            	for(int ii=0;ii<abc;ii++)
            		y+="(";
            	y+=abc;
            	for(int ii=0;ii<abc;ii++)
            		y+=")";
            }
            
            if(s.length()!=1) {
            for(int d=0;d<end;d++) {
            	y+="(";
            }
            
            y+=s.charAt(0);
            
            for(int c=0;c<s.length()-1;c++) {	
            	char char1=s.charAt(c);
            	char char2=s.charAt(c+1);
            
            	if(char2==char1) {
            		y+=char2;
            	}
            	
            	if(char2>char1) {
            		int dif=char2-char1;
            		for(int b=0;b<dif;b++) {
            			y+="(";
            		}
            		y+=char2;
            	}
            	
            	if(char2<char1) {
            		int dif=char1-char2;
            		for(int b=0;b<dif;b++) {
            			y+=")";
            		}
            		y+=char2;
            	}
            }
            
            
            char end2c=s.charAt(s.length()-1);
            int end2=Character.getNumericValue(end2c);
            for(int d=0;d<end2;d++) {
            	y+=")";}
            
            
        }System.out.println("Case #"+(a+1)+": "+y);
        }
    }
}