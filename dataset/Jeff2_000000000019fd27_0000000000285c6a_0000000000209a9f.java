import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Solution {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(entrada.readLine());
		int oParentheses=0;
		String salida="";
		for (int i = 0; i < casos; i++) {
			int[] numbers = Arrays.stream(entrada.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < numbers.length; j++) {
				if(oParentheses==0&&numbers[j]!=0) {
					salida=salida.concat(leftParentheses(numbers[j]))+numbers[j];
					oParentheses+=numbers[j];
				}
				else if(oParentheses==0&&numbers[j]==0) {
					salida+=numbers[j];
				}
				else if (oParentheses>numbers[j]) {
					salida=salida.concat(rightParentheses(oParentheses-numbers[j]))+numbers[j];
					oParentheses-=oParentheses-numbers[j];
				}
				else if (oParentheses<numbers[j]) {
					salida=salida.concat(leftParentheses(numbers[j]-oParentheses))+numbers[j];
					oParentheses+=numbers[j]-oParentheses;
				}
				else {
					salida+=numbers[j];
				}
				
				if(j==numbers.length-1 && oParentheses>0)salida+=rightParentheses(oParentheses);
			//	System.out.println(salida+"  "+oParentheses);
			}
			System.out.println("Case #"+(i+1)+": "+salida);
			salida="";
			oParentheses=0;
		}

	}

	public static String leftParentheses(int n) {
		String ret="";
		if(n==0)return "";
		for (int i = 0; i < n; i++) {
			ret+="(";
		}
		return ret;
	}
	public static String rightParentheses(int n) {
		String ret="";
		if(n==0)return "";
		for (int i = 0; i < n; i++) {
			ret+=")";
		}
		return ret;
	}
}
