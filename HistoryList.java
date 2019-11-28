import java.util.List;
import java.util.Vector;

public class HistoryList {
    private class HistoryItem {
        public int id;
        public VectorClock timestamp;
        public HistoryItem(int id, VectorClock timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    private List<HistoryItem> history;
    
    public HistoryList() {
        this.history = new Vector<HistoryItem>();
    }

    public void add(int id, VectorClock timestamp) {
        this.history.add(new HistoryItem(id, timestamp));
    }

    public static boolean deliveryTest(int pid, VectorClock clock, Message m ){
        //returns false if massage can not be delivered
        for (HistoryItem item: m.history.history){
            if(item.id==pid){
                
                System.out.println("message from"+ m.src+ " to "+ m.dst+ "with history P"+item.id +" to P" + pid);
             
                return !VectorClock.isbehind(clock, m.timestamp);
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (HistoryItem i : this.history) {
            str.append("P"+i.id+" "+i.timestamp.toString()+"\n");
        }
        return str.toString();
    }
}