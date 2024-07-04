import java.util.*;

class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String arr[] = new String[t];
		int a=0;
		
		for(int k=0; k<t; k++)
		{
			String numstr = sc.next();
			
			ArrayList<String> ns = new ArrayList<>();
			
			for(int i=0; i<numstr.length(); i++)
			{
				if(numstr.charAt(i) == '1')
				{
					ns.add("@");
					ns.add(Character.toString(numstr.charAt(i)));
					ns.add("#");
				}
				else if(numstr.charAt(i) == '2')
				{
					for(int p=0; p<2; p++)
					{
						ns.add("@");
					}
					
					ns.add(Character.toString(numstr.charAt(i)));
					
					for(int p=0; p<2; p++)
					{
						ns.add("#");
					}
				}
				else if(numstr.charAt(i) == '3')
				{
					for(int p=0; p<3; p++)
					{
						ns.add("@");
					}
					
					ns.add(Character.toString(numstr.charAt(i)));
					
					for(int p=0; p<3; p++)
					{
						ns.add("#");
					}
				}
				else if(numstr.charAt(i) == '4')
				{
					for(int p=0; p<4; p++)
					{
						ns.add("@");
					}
					
					ns.add(Character.toString(numstr.charAt(i)));
					
					for(int p=0; p<4; p++)
					{
						ns.add("#");
					}
				}
				else if(numstr.charAt(i) == '5')
				{
					for(int p=0; p<5; p++)
					{
						ns.add("@");
					}
					
					ns.add(Character.toString(numstr.charAt(i)));
					
					for(int p=0; p<5; p++)
					{
						ns.add("#");
					}
				}
				else if(numstr.charAt(i) == '6')
				{
					for(int p=0; p<6; p++)
					{
						ns.add("@");
					}
					
					ns.add(Character.toString(numstr.charAt(i)));
					
					for(int p=0; p<6; p++)
					{
						ns.add("#");
					}
				}
				else if(numstr.charAt(i) == '7')
				{
					for(int p=0; p<7; p++)
					{
						ns.add("@");
					}
					
					ns.add(Character.toString(numstr.charAt(i)));
					
					for(int p=0; p<7; p++)
					{
						ns.add("#");
					}
				}
				else if(numstr.charAt(i) == '8')
				{
					for(int p=0; p<8; p++)
					{
						ns.add("@");
					}
					
					ns.add(Character.toString(numstr.charAt(i)));
					
					for(int p=0; p<8; p++)
					{
						ns.add("#");
					}
				}
				else if(numstr.charAt(i) == '9')
				{
					for(int p=0; p<9; p++)
					{
						ns.add("@");
					}
					
					ns.add(Character.toString(numstr.charAt(i)));
					
					for(int p=0; p<9; p++)
					{
						ns.add("#");
					}
				}
				else if(numstr.charAt(i) == '0')
				{
					ns.add(Character.toString(numstr.charAt(i)));
				}
				
			}
			String st="";
			for(String s : ns)
			{
				st+=s;
			}
			String h = "";
			String[] nums = st.split("#@");
			for(String s1 : nums)
			{
				h+=s1;
			}
			String fs = h.replace('@','(');
			String fs1 = fs.replace('#',')');
			arr[a]=fs1;
			a++;
		}
		
		for(int m=0; m<arr.length; m++)
		{
			System.out.println("Case #"+(m+1)+": "+arr[m]);
		}
	}
}