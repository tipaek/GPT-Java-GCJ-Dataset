import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public  class Solution {
    public static void main(String[] arg)throws IOException{

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int numCases= Integer.parseInt(reader.readLine());

        for(int i =0;i<numCases;i++){
            CaseInputs inp=readCase(reader);


            CaseOutputs outp=processCase(inp);
            printOutput(i+1,outp);
        }
    }

    private static CaseOutputs processCase(CaseInputs inputs){
        CaseOutputs outputs=new CaseOutputs();


        //sort
        inputs.schedule.sort(Comparator.comparing(Event::getStart).thenComparing(Event::getFinish));


        Event jamieEvent=null;
        Event cameronEvent=null;


        for(Event e:inputs.schedule){

            if(jamieEvent!=null){
                if(jamieEvent.getFinish()<=e.getStart()){
                    jamieEvent=null;
                }
            }
            if(cameronEvent!=null){
                if(cameronEvent.getFinish()<=e.getStart()){
                    cameronEvent=null;
                }
            }

            if(jamieEvent==null){
                jamieEvent=e;
                e.setExecutor("J");
            }else if(cameronEvent==null){
                cameronEvent=e;
                e.setExecutor("C");
            }else{
                outputs.result="IMPOSSIBLE";
                return outputs;
            }
        }

        inputs.schedule.sort(Comparator.comparing(Event::getOrder));

        StringBuffer sb=new StringBuffer();
        for(Event e: inputs.schedule){
            sb.append(e.getExecutor());
        }

        outputs.result=sb.toString();

        return outputs;
    }

    private static CaseInputs readCase(BufferedReader reader)throws IOException{
        CaseInputs inputs=new CaseInputs();
        int lines=Integer.parseInt(reader.readLine());
        inputs.activities=lines;
        inputs.schedule=new ArrayList<>();
        for(int i=0;i<lines;i++){
            String lineString=reader.readLine();

            String[] split=lineString.split(" ");
            int s=Integer.parseInt(split[0]);
            int f=Integer.parseInt(split[1]);
            Event e=new Event();
            e.setStart(s);
            e.setFinish(f);
            e.setOrder(i);
            inputs.schedule.add(e);

        }

        return inputs;
    }
    private static void printOutput(int caseNum,CaseOutputs outputs){
        StringBuilder sb=new StringBuilder();
        sb.append("Case #").append(caseNum)
                .append(": ").append(outputs.result);
        System.out.println(sb.toString());
    }

    public static class Event{
        private int start;
        private int order;
        private String executor;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getFinish() {
            return finish;
        }

        public void setFinish(int finish) {
            this.finish = finish;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getExecutor() {
            return executor;
        }

        public void setExecutor(String executor) {
            this.executor = executor;
        }

        private int finish;

    }
    public static class CaseInputs{

        public int activities;
        public List<Event> schedule;
    }
    public static class CaseOutputs{

        public String result;
    }
}
