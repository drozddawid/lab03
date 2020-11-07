import java.io.Serializable;
import java.time.LocalDate;

public class Sample implements Serializable {
    private int id;
    private int customerId;
    private LocalDate samplingDate;
    private LocalDate testingDate;
    private boolean wasTested;
    private String sampleType;
    private String result;
    private String testerName;

    public Sample(int id, int customerId, LocalDate samplingDate, String sampleType){
        this.id = id;
        this.customerId = customerId;
        this.samplingDate = samplingDate;
        this.sampleType = sampleType;
        setTestingDate(LocalDate.of(0,0,0));
        result = "Nie testowano.";
        testerName = "Nie testowano.";
        wasTested = false;
    }

    @Override
    public String toString(){
        String element = "";
        element += "\n----------------------------------";
        element += "\nID: " + this.getId();
        element += "\nData pobrania: " + this.getSamplingDate().toString();
        element += "\nTyp: " + this.getSampleType();
        element += "\nStatus: " + (this.getWasTested()? "Testowano"+"\nData testu: "+ this.getTestingDate().toString() +
                "\nWynik poprzedniego badania: " + this.getResult() + "\nOstatni test wykonał: " + this.getTesterName() :"Nie testowano");
        return element;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getSamplingDate() {
        return samplingDate;
    }

    public void setTestingDate (LocalDate date){
        this.testingDate = date;
    }

    public LocalDate getTestingDate() {
        return testingDate;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }

    public void setWasTested(boolean wasTested){
        this.wasTested = wasTested;
    }

    public boolean getWasTested(){
        return this.wasTested;
    }
}
