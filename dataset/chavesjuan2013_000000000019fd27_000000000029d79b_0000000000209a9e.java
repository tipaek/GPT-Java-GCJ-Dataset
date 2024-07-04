import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");


        int T = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);

        for(int m = 0; m < T; ++m)
        {
        ArrayList<pair>[] listas = new ArrayList[(B/10)*4];

        for(int i = 0; i < (B/10)*4; ++i)
        {
            listas[i] = new ArrayList<>();
        }

            for(int i = 0; i < B/10; ++i)
            {
                for(int j = 5*i + 1; j <= 5*(i+1); ++j)
                {
                    System.out.println(j);
                    int a = Integer.parseInt(br.readLine());
                    System.out.println(B+1-j);
                    int b = Integer.parseInt(br.readLine());

                    if(a==b)
                    {
                        if(a==0)
                        {
                            listas[4*i].add(new pair(a,b));
                        }
                        else
                        {
                            listas[4*i+3].add(new pair(a,b));
                        }
                    }
                    else {
                        if(a==1){
                            listas[4*i+2].add(new pair(a,b));
                        }
                        else
                        {
                            listas[4*i+1].add(new pair(a,b));
                        }
                    }
                }
            }



        ArrayList<pair> listaDef00 = new ArrayList<>();
        ArrayList<pair> listaDef01 = new ArrayList<>();
        ArrayList<pair> listaDef10 = new ArrayList<>();
        ArrayList<pair> listaDef11 = new ArrayList<>();

        int queries = 0;

        for(int i = 0; i < B/10; ++i)
        {
            if(listas[4*i].isEmpty()&&listas[4*i+3].isEmpty())
                continue;

            if(listaDef00.isEmpty()&&listaDef11.isEmpty())
            {
                listaDef00 = listas[4*i];
                listaDef11 = listas[4*i+3];
                continue;
            }

            if(listaDef00.isEmpty())
            {
                if(listas[4*i].isEmpty()) {
                    System.out.println(listaDef11.get(0).a);
                    int tempo1 = Integer.parseInt(br.readLine());
                    System.out.println(listas[4 * i + 3].get(0).a);
                    int tempo2 = Integer.parseInt(br.readLine());
                    queries+=2;
                    if(tempo1 == tempo2)
                        listaDef11.addAll(listas[4*i+3]);
                    else
                        listaDef00.addAll(listas[4*i+3]);
                }
                else
                {
                    System.out.println(listaDef11.get(0).a);
                    int tempo1 = Integer.parseInt(br.readLine());
                    System.out.println(listas[4 * i].get(0).a);
                    queries+=2;
                    int tempo2 = Integer.parseInt(br.readLine());
                    if(tempo1 == tempo2)
                    {
                        listaDef11.addAll(listas[4*i]);
                        listaDef00.addAll(listas[4*i+3]);
                    }
                    else
                    {
                        listaDef00.addAll(listas[4*i+3]);
                        listaDef11.addAll(listas[4*i]);
                    }
                }
            }
            else
            {
                if(listas[4*i].isEmpty()) {
                    System.out.println(listaDef00.get(0).a);
                    int tempo1 = Integer.parseInt(br.readLine());
                    System.out.println(listas[4 * i + 3].get(0).a);
                    int tempo2 = Integer.parseInt(br.readLine());
                    queries+=2;
                    if(tempo1 == tempo2)
                        listaDef00.addAll(listas[4*i+3]);
                    else
                        listaDef11.addAll(listas[4*i+3]);
                }
                else
                {
                    System.out.println(listaDef00.get(0).a);
                    int tempo1 = Integer.parseInt(br.readLine());
                    System.out.println(listas[4 * i].get(0).a);
                    int tempo2 = Integer.parseInt(br.readLine());
                    queries+=2;
                    if(tempo1 == tempo2)
                    {
                        listaDef00.addAll(listas[4*i]);
                        listaDef11.addAll(listas[4*i+3]);
                    }
                    else
                    {
                        listaDef11.addAll(listas[4*i]);
                        listaDef00.addAll(listas[4*i+3]);
                    }
                }
            }
        }

        while(queries%10!=0) {
            System.out.println(1);
            br.readLine();
            queries++;
        }

        for(int i = 0; i < B/10; ++i)
        {
            if(listas[4*i+1].isEmpty()&&listas[4*i+2].isEmpty())
                continue;

            if(listaDef01.isEmpty()&&listaDef10.isEmpty())
            {
                listaDef01 = listas[4*i+1];
                listaDef10 = listas[4*i+2];
                continue;
            }

            if(listaDef01.isEmpty())
            {
                if(listas[4*i+1].isEmpty()) {
                    System.out.println(listaDef10.get(0).a);
                    int tempo1 = Integer.parseInt(br.readLine());
                    System.out.println(listas[4 * i + 2].get(0).a);
                    int tempo2 = Integer.parseInt(br.readLine());
                    queries+=2;
                    if(tempo1 == tempo2)
                        listaDef10.addAll(listas[4*i+2]);
                    else
                        listaDef01.addAll(listas[4*i+2]);
                }
                else
                {
                    System.out.println(listaDef10.get(0).a);
                    int tempo1 = Integer.parseInt(br.readLine());
                    System.out.println(listas[4 * i+1].get(0).a);
                    int tempo2 = Integer.parseInt(br.readLine());
                    queries+=2;
                    if(tempo1 == tempo2)
                    {
                        listaDef10.addAll(listas[4*i+1]);
                        listaDef01.addAll(listas[4*i+2]);
                    }
                    else
                    {
                        listaDef01.addAll(listas[4*i+2]);
                        listaDef10.addAll(listas[4*i+1]);
                    }
                }
            }
            else
            {
                if(listas[4*i+1].isEmpty()) {
                    System.out.println(listaDef01.get(0).a);
                    int tempo1 = Integer.parseInt(br.readLine());
                    System.out.println(listas[4 * i + 2].get(0).a);
                    int tempo2 = Integer.parseInt(br.readLine());
                    queries+=2;
                    if(tempo1 == tempo2)
                        listaDef01.addAll(listas[4*i+2]);
                    else
                        listaDef10.addAll(listas[4*i+2]);
                }
                else
                {
                    System.out.println(listaDef01.get(0).a);
                    int tempo1 = Integer.parseInt(br.readLine());
                    System.out.println(listas[4 * i+1].get(0).a);
                    int tempo2 = Integer.parseInt(br.readLine());
                    queries+=2;
                    if(tempo1 == tempo2)
                    {
                        listaDef01.addAll(listas[4*i+1]);
                        listaDef10.addAll(listas[4*i+2]);
                    }
                    else
                    {
                        listaDef10.addAll(listas[4*i+1]);
                        listaDef01.addAll(listas[4*i+2]);
                    }
                }
            }
        }


        while(queries%10!=0) {
            System.out.println(1);
            br.readLine();
            queries++;
        }

        char[] res = new char[B];

        if(!listaDef00.isEmpty())
        {
            System.out.println(listaDef00.get(0).a);
            String s = br.readLine();

            for (pair c:listaDef00
                 ) {
                res[c.a-1] = s.charAt(0);
                res[c.b-1] = s.charAt(0);
            }
        }

        if(!listaDef11.isEmpty())
        {
            System.out.println(listaDef11.get(0).a);
            String s = br.readLine();

            for (pair c:listaDef11
            ) {
                res[c.a-1] = s.charAt(0);
                res[c.b-1] = s.charAt(0);
            }
        }

        if(!listaDef01.isEmpty())
        {
            System.out.println(listaDef01.get(0).a);
            String s = br.readLine();
            System.out.println(listaDef11.get(0).b);
            String t = br.readLine();

            for (pair c:listaDef01
            ) {
                res[c.a-1] = s.charAt(0);
                res[c.b-1] = t.charAt(0);
            }
        }

        if(!listaDef10.isEmpty())
        {
            System.out.println(listaDef10.get(0).a);
            String s = br.readLine();
            System.out.println(listaDef10.get(0).b);
            String t = br.readLine();

            for (pair c:listaDef10
            ) {
                res[c.a-1] = s.charAt(0);
                res[c.b-1] = t.charAt(0);
            }
        }

        System.out.println(res.toString());
    }}

    static class pair{
        int a;

        public pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int b;
    }
}