import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = sc.nextInt();
		String number= null;
		String crossnumber ="";
		char cnum;
		int num;
		int beforenum;
		for(int i=0; i<n;i++){
			crossnumber="";
		    number = sc.next();
		    cnum = number.charAt(0);
		    num = Character.getNumericValue(cnum);
		    for(int k=0;k<num;k++){
		    	crossnumber =crossnumber.concat("(");
		    }
		    crossnumber =crossnumber + cnum;
		    beforenum = num;
		    for(int j=1;j<number.length();j++){
		        cnum = number.charAt(j);
		        num = Character.getNumericValue(cnum);
		        if(num > beforenum){
		            int gap = num - beforenum;
		            for(int k=0;k<gap;k++){
        		        crossnumber =crossnumber.concat("(");
        		    }
		        }
		        else if(beforenum > num){
		            int gap = beforenum - num;
		            for(int k=0;k<gap;k++){
        		        crossnumber =crossnumber.concat(")");
        		    }
		        }
		        crossnumber =crossnumber + cnum;
		        beforenum = num;
		        
		    }
		    for(int k=0;k<num;k++){
		        crossnumber =crossnumber.concat(")");
		    }
		    System.out.println("Case #" + (i+1) + ": " +(crossnumber));
		    
		}
		

	}

}
