//0((2)1), (((3))1(2)), ((((4)))), ((2))((2))(1)
//((22)1)

/*
4
0000
101
111000
1


Case #1: 0000
Case #2: (1)0(1)
Case #3: (111)000
Case #4: (1)

*/
import java.util.*;
public class Solution
{

	public static void appendBraces(StringBuilder sb, int nB, int dig){
		if(nB == 0){
				sb.append(dig);
		}else if(nB<0){
			int count = nB*-1;
			for(int i=0; i<count;i++)sb.append("(");
			sb.append(dig);
		}else{
			int count = nB;
			for(int i=0; i<count;i++)sb.append(")");
			sb.append(dig);
		}
	}
    public static void main(String[] args) {

    	//take the string
    	//check the numbr on left (abs(numbr - left)) those many parantesis on left
    	//check the number on right do (abs(numb - right)) those many prathesis on right

    	//if number is negative then put ( ; if number is positive put )

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); int count = 1;
         // 0((2)1) st = 012    (((3))1(2)) //000 //(1)0(1) //(111)000
        StringBuilder sb;
        while(count<=t){
        	sb = new StringBuilder();
        	String st = sc.next();
        	String arr[] = st.split("");
        	int prev = 0;
        	int numBraces = 0;
        	int dig = 0;
        	for(int i=0;i<arr.length; i++){
        		 dig = Integer.parseInt(arr[i]);
        		if(prev==0 && dig==0){
        		 //simply append 0 
        		 sb.append("0");
        		 prev = 0;
        		 continue;
        		}
        		numBraces = prev - dig;
        		appendBraces(sb, numBraces, dig); //appends a brace followed by the numBraces
        		prev = dig;
        	}
        	appendBraces(sb, prev, prev);
        	
        	if(sb.length()>st.length())
        	sb.deleteCharAt( sb.length() - 1 );
        	
        	
        	System.out.println("Case #"+count+": "+sb.toString());

         count++;
        }
    }

}