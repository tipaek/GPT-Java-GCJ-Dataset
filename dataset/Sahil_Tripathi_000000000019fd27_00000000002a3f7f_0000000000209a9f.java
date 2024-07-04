

import java.util.Scanner;


public class Solution {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

int test = sc.nextInt();

for(int i = 0; i < test; i++)
{
String S = sc.next();
S = "0" + S + "0";
String result = "";

char[] array = S.toCharArray();

for(int j = 0; j < array.length - 1; j++)
{
int current = Integer.parseInt(array[j] + "");
int next = Integer.parseInt(array[j + 1] + "");
int diff = next - current;
char brackets = '(';

result = result + current;

if(diff < 0)
{
brackets = ')';
diff = -diff;
}

for(int k = 0; k < diff; k++)
{
result = result + brackets;
}

}

System.out.println("Case #" + (i + 1) + ": " + result.substring(1));

}

}

}



