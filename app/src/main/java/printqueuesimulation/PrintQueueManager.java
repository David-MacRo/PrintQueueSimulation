package printqueuesimulation;
import linkedlistqueue.LinkedListQueue;


public class PrintQueueManager {
    private LinkedListQueue<PrintJob> print_queue;
    private int nextJobID;
    public PrintQueueManager(){
        this.nextJobID = 1;
        this.print_queue = new LinkedListQueue<>();
    }

    public void addPrintJob(String description){
        try{
            print_queue.add(new PrintJob(nextJobID++, description));
        }catch(IllegalArgumentException e){
            print_queue.add(new PrintJob(nextJobID, "Description not given."));
        }
    }

    public PrintJob processNextPrintJob() throws EmptyQueueException{
        try {
            return print_queue.deque();
        } catch (IllegalStateException e) {
            throw new EmptyQueueException();
        }
    }

    public int size(){
        return print_queue.size();
    }
}
