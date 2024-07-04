import java.io.*;
import java.util.Scanner;
class Parenting
{
	public static void main(String [] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int test_case,i,j,t,n,no_of_activities=0,temp,pre_t_C,pre_t_J;
		int ind[] = new int[1000];
		int schedule_s[] = new int[1000];
		int schedule_e[] = new int[1000];
		String final_output[] = new String[100];
		String s;
		boolean c,ja,impossible;
		char ch;
		char output[] = new char[1000];
		test_case = Integer.parseInt(br.readLine());
		for(t=0;t<test_case;t++)
		{
			no_of_activities = Integer.parseInt(br.readLine());
			for(n=0;n<no_of_activities;n++)
			{
				 schedule_s[n] = sc.nextInt();
				 schedule_e[n] = sc.nextInt();
			}
			for(i=0;i<no_of_activities;i++)
				ind[i] = i;
			for(i=0;i<no_of_activities;i++)
				for(j=0;j<no_of_activities-i-1;j++)
					if(schedule_s[j]>schedule_s[j+1])
					{
						temp=schedule_s[j];
						schedule_s[j] = schedule_s[j+1];
						schedule_s[j+1] = temp;
						temp=schedule_e[j];
						schedule_e[j] = schedule_e[j+1];
						schedule_e[j+1] = temp;
						temp = ind[j];
						ind[j] = ind[j+1];
						ind[j+1] = temp;

					}

			c = true;
			ja = true;
			impossible = false;
			pre_t_C = 0;
			pre_t_J = 0;
			for(i=0;i<no_of_activities;i++)
			{
				if (schedule_s[i] >= pre_t_C)
					c = true;
				if (schedule_s[i] >= pre_t_J)
					ja = true;

				if (c)
				{
					output[i] = 'C';
					pre_t_C = schedule_e[i];
					c = false;
				}
				else if(ja)
				{
					output[i] = 'J';
					pre_t_J = schedule_e[i];
					ja = false;
				}
				else
				{
					impossible = true;
					break;
				}
			}
			if(impossible)
				final_output[t] = "IMPOSSIBLE";
			else
			{
				for(i=0;i<no_of_activities;i++)
					for(j=0;j<no_of_activities-i-1;j++)
						if (ind[j] > ind[j+1])
						{
							temp = ind[j];
							ind[j] = ind[j+1];
							ind[j+1] = temp;
							ch = output[j];
							output[j] = output[j+1];
							output[j+1] = ch;
						}
				s="";
				for(i=0;i<no_of_activities;i++)
					s+=output[i];
				final_output[t] = s;
			}
		}
		for(i=0;i<test_case;i++)
			System.out.println("Case #"+(i+1)+": "+final_output[i]);

	}
}