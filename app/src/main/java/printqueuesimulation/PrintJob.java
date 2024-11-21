package printqueuesimulation;
public class PrintJob {
    private int jobID;
    private String description;
    public PrintJob(int jobID, String description){
        this.jobID = jobID;
        this.description = description;
        if(description == null || description.equals("")){
            throw new IllegalArgumentException("Description must not be null, nor an empty string");
        }
    }
    
    public int getJobID() {
        return jobID;
    }
    
    public String getDescription() {
        return description;
    }
}
