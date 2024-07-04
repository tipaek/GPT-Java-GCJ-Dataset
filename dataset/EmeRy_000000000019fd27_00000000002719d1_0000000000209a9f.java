import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
  
	String openParenthesis = "(((((((((";
	String closeParenthesis = ")))))))))";
	
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt(); 
    in.nextLine(); //OJO, para cambiar de linea
    for (int t = 1; t <= cases; ++t) {
		StringBuilder s = new StringBuilder().append(in.nextLine());
		StringBuilder s_prima = new StringBuilder();
	  //primer caso
	  int x = Character.getNumericValue(s.charAt(0)); 
	  if(x > 0){
			  s_prima.append( openParenthesis.substring(0,x) );
			  }
	  int cont = 1; //voy a anadir 1 vez el digito
		
	for (int i = 1; i < s.length(); i++) 
	{
		int y = Character.getNumericValue(s.charAt(i)); 
		 
		if(x==y)
		{ cont++;
		}
		else
		{
			if (cont == 1)
			{ s_prima.append(x);
			}
			else
			{ 
				for(int a = 0 ; a < cont; a++)
				{
					s_prima.append(x);
				}
			}
			cont=0;
		
			if(x<y)
			{
				s_prima.append( openParenthesis.substring(0,y-x) );
			}
			else
			{	
				s_prima.append( closeParenthesis.substring(0,x-y) );
			}		
			x=y;cont=1;		
		}
	}	
	//se ha quedado el ultimo sin imprimir
	if (cont == 1)
	{ s_prima.append(x); }
	else
	{ 
		for(int a = 0 ; a < cont; a++)
		{
			s_prima.append(x);
		}
	}
	if(x > 0)
	s_prima.append( closeParenthesis.substring(0,x) );
       
    System.out.println("Case #" + t + ": " + s_prima);
    }
	
  }
}