import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int T = in.nextInt();		
		for (int casNumero = 1; casNumero <= T; casNumero++) {
			StringBuilder resultat = new StringBuilder();
			resultat.append("Case #");
			resultat.append(casNumero);
			resultat.append(": ");
			
			BigInteger x = in.nextBigInteger();
			BigInteger y = in.nextBigInteger();
			
			BigInteger sum = x.abs().add(y.abs());
			int steps = sum.toString(2).length();
			String maxValue = "";
			for (int i = 0; i < steps; i++) {
				maxValue += "1";
			}
			BigInteger maxNumber = new BigInteger(maxValue, 2);
			if (sum.add(maxNumber).mod(new BigInteger("2")) == BigInteger.ZERO) {
				BigInteger positive = sum.add(maxNumber).divide(new BigInteger("2"));
				BigInteger negative = maxNumber.subtract(positive);
				
				String positiveString = new StringBuilder(positive.toString(2)).reverse().toString();
				String negativeString = new StringBuilder(negative.toString(2)).reverse().toString();
				
				String value = "";
				String other = "";
				String rest = "";
				String otherRest = "";
				for (int i = 0; i < steps - 1; i++) {
					value += "0";
					rest += "0";
					other += positiveString.charAt(i);
				}
				value += "1";
				rest += "0";
				other += "0";
				int max = steps - 2;
				int compare = 0;
				if (x.abs().compareTo(y.abs()) < 0) {
					while ((compare = new BigInteger(new StringBuilder(value).reverse().toString(), 2).subtract(new BigInteger(new StringBuilder(rest).reverse().toString(), 2)).compareTo(y.abs())) != 0) {
						if (compare < 0) {
							if (other.charAt(max) == '1' && new BigInteger(new StringBuilder(other.substring(0, max) + '0' + other.substring(max + 1)).reverse().toString(), 2).compareTo(x.abs()) >= 0) {
								value = value.substring(0, max) + '1' + value.substring(max + 1);
								other = other.substring(0, max) + '0' + other.substring(max + 1);								
							}
							max--;
						}
						else {
							String possibleRest = new StringBuilder(new BigInteger(new StringBuilder(value).reverse().toString(), 2).subtract(y.abs()).toString(2)).reverse().toString();
							boolean wrong = false;
							for (int i = 0; i < possibleRest.length(); i++) {
								if (possibleRest.charAt(i) == '1' && negativeString.charAt(i) != '1') {
									wrong = true;
								}
							}
							if (wrong) {
								if (other.charAt(max) == '1' && new BigInteger(new StringBuilder(other.substring(0, max) + '0' + other.substring(max + 1)).reverse().toString(), 2).compareTo(x.abs()) > 0) {
									value = value.substring(0, max) + '1' + value.substring(max + 1);
									other = other.substring(0, max) + '0' + other.substring(max + 1);									
								}
								max--;
							}
							else {
								rest = possibleRest;
							}							
						}
					}
					otherRest = new StringBuilder(new BigInteger(new StringBuilder(negativeString).reverse().toString(), 2).subtract(new BigInteger(new StringBuilder(rest).reverse().toString(), 2)).toString(2)).reverse().toString();
					for (int i = 0; i < steps; i++) {						
						if (value.charAt(i) == '1') {
							if (y.compareTo(BigInteger.ZERO) > 0) {
								resultat.append("N");
							}
							else {
								resultat.append("S");
							}
						}
						else if (i < rest.length() && rest.charAt(i) == '1') {
							if (y.compareTo(BigInteger.ZERO) > 0) {
								resultat.append("S");
							}	
							else {
								resultat.append("N");
							}
						}
						else if (other.charAt(i) == '1') {
							if (x.compareTo(BigInteger.ZERO) > 0) {
								resultat.append("E");
							}	
							else {
								resultat.append("W");
							}							
						}
						else if (i < otherRest.length() && otherRest.charAt(i) == '1') {
							if (x.compareTo(BigInteger.ZERO) > 0) {
								resultat.append("W");
							}
							else {
								resultat.append("E");
							}
						}
					}	
				}
				else {		
					while ((compare = new BigInteger(new StringBuilder(value).reverse().toString(), 2).subtract(new BigInteger(new StringBuilder(rest).reverse().toString(), 2)).compareTo(x.abs())) != 0) {
						if (compare < 0) {
							if (other.charAt(max) == '1' && new BigInteger(new StringBuilder(other.substring(0, max) + '0' + other.substring(max + 1)).reverse().toString(), 2).compareTo(y.abs()) >= 0) {
								value = value.substring(0, max) + '1' + value.substring(max + 1);
								other = other.substring(0, max) + '0' + other.substring(max + 1);								
							}
							max--;
						}
						else {
							String possibleRest = new StringBuilder(new BigInteger(new StringBuilder(value).reverse().toString(), 2).subtract(x.abs()).toString(2)).reverse().toString();
							boolean wrong = false;
							for (int i = 0; i < possibleRest.length(); i++) {
								if (possibleRest.charAt(i) == '1' && negativeString.charAt(i) != '1') {
									wrong = true;
								}
							}
							if (wrong) {
								if (other.charAt(max) == '1' && new BigInteger(new StringBuilder(other.substring(0, max) + '0' + other.substring(max + 1)).reverse().toString(), 2).compareTo(y.abs()) > 0) {
									value = value.substring(0, max) + '1' + value.substring(max + 1);
									other = other.substring(0, max) + '0' + other.substring(max + 1);									
								}
								max--;
							}
							else {
								rest = possibleRest;
							}							
						}
					}
					otherRest = new StringBuilder(new BigInteger(new StringBuilder(negativeString).reverse().toString(), 2).subtract(new BigInteger(new StringBuilder(rest).reverse().toString(), 2)).toString(2)).reverse().toString();
					for (int i = 0; i < steps; i++) {						
						if (value.charAt(i) == '1') {
							if (x.compareTo(BigInteger.ZERO) > 0) {
								resultat.append("E");
							}
							else {
								resultat.append("W");
							}
						}
						else if (i < rest.length() && rest.charAt(i) == '1') {
							if (x.compareTo(BigInteger.ZERO) > 0) {
								resultat.append("W");
							}	
							else {
								resultat.append("E");
							}
						}
						else if (other.charAt(i) == '1') {
							if (y.compareTo(BigInteger.ZERO) > 0) {
								resultat.append("N");
							}	
							else {
								resultat.append("S");
							}							
						}
						else if (i < otherRest.length() && otherRest.charAt(i) == '1') {
							if (y.compareTo(BigInteger.ZERO) > 0) {
								resultat.append("S");
							}
							else {
								resultat.append("N");
							}
						}
					}	
				}
			}
			else {
				resultat.append("IMPOSSIBLE");
			}
			
			writer.print(resultat.toString());
			writer.println();			
		}
		in.close();
		writer.close();
	}	
	
}
