

import java.util.*;
import java.math.*;


public class Main
{
	public static Scanner cin = new Scanner(System.in);
	public static BigInteger ton = BigInteger.valueOf(0);
	public static BigInteger res = BigInteger.valueOf(0);
	
	public static void main(String[] args)
	{
		int t = cin.nextInt();
		int p = t;
		while(t-- > 0)
		{
			BigInteger a = cin.nextBigInteger();
			BigInteger b = cin.nextBigInteger();
			if(a.compareTo(b) < 0) 
			{
				BigInteger tt = a;
				a = b;
				b = tt;
			}
			
			BigInteger ans = BigInteger.ZERO;
			cal(a.subtract(b));
			ans = ans.add(ton);
			a = a.subtract((ton.add(BigInteger.valueOf(1)).multiply(ton).divide(BigInteger.valueOf(2))));
			BigInteger aa = ton.add(BigInteger.valueOf(1));
			BigInteger bb = aa.add(BigInteger.valueOf(1));
			//System.out.println(ton + " " + aa + " " + bb);
			
			calcal(a,aa);
			ans = ans.add(ton);
			a = a.subtract(aa.multiply(BigInteger.valueOf(2)).add(ton.subtract(BigInteger.valueOf(1)).multiply(BigInteger.valueOf(2))).multiply(ton).divide(BigInteger.valueOf(2)));
			
			calcal(b,bb);
			ans = ans.add(ton);
			b = b.subtract(bb.multiply(BigInteger.valueOf(2)).add(ton.subtract(BigInteger.valueOf(1)).multiply(BigInteger.valueOf(2))).multiply(ton).divide(BigInteger.valueOf(2)));
			
			System.out.println("Case #" + (p-t) + ": " + ans + " " + a + " " + b);
		}
	}
	
	public static void cal(BigInteger a)
	{
		ton = BigInteger.ZERO;
		BigInteger l = BigInteger.ZERO;
		BigInteger r = a;
		
		while(l.compareTo(r) <= 0)
		{
			BigInteger mid = (l.add(r).divide(BigInteger.TWO));
			if( (mid.add(BigInteger.valueOf(1)).multiply(mid).divide(BigInteger.valueOf(2))).compareTo(a) <= 0)
			{
				ton = mid;
				l = mid.add(BigInteger.ONE);
			}
			else r = mid.subtract(BigInteger.ONE);
		}
	}
	
	public static void calcal(BigInteger a,BigInteger b)
	{
		ton = BigInteger.ZERO;
		BigInteger l = BigInteger.ZERO;
		BigInteger r = a;
		
		while(l.compareTo(r) <= 0)
		{
			BigInteger mid = (l.add(r).divide(BigInteger.TWO));
			if( b.multiply(BigInteger.valueOf(2)).add(mid.subtract(BigInteger.valueOf(1)).multiply(BigInteger.valueOf(2))).multiply(mid).divide(BigInteger.valueOf(2)).compareTo(a) <= 0)
			{
				ton = mid;
				l = mid.add(BigInteger.ONE);
			}
			else r = mid.subtract(BigInteger.ONE);
		}
	}
}