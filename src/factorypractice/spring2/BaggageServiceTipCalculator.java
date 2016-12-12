package factorypractice.spring2;

/**
 * An example low-level class. Does this class definition follow the DIP?
 * If not, fix it.
 *
 * Any other best practice violations? Fix them too.
 *
 * @author your name goes here
 */
public class BaggageServiceTipCalculator implements TipCalculator {
    private double minBill = 0.00;
    private double maxBill = 100.00;
    private static final String BILL_ENTRY_ERR =
            "Error: bill must be between 0 and 10000";
    private double goodRate = 0.20;
    private double fairRate = 0.15;
    private double poorRate = 0.10;

    private double baseTipPerBag = 1.00;
    private Object inputData; // bagCount
   
    private ServiceQuality serviceQuality;
    
    public BaggageServiceTipCalculator(double baseTipPerBag) {
        this.baseTipPerBag = baseTipPerBag;
    }

    @Override
    public final double getTip() {
        double tip = 0.00; // always initialize local variables

        switch(serviceQuality) {
            case GOOD:
                tip = baseTipPerBag * (Integer)inputData * (1 + goodRate);
                break;
            case FAIR:
                tip = baseTipPerBag * (Integer)inputData * (1 + fairRate);
                break;
            case POOR:
                tip = baseTipPerBag * (Integer)inputData * (1 + poorRate);
                break;
        }

        return tip;
    }

    @Override
    public final ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

    @Override
    public final void setServiceQuality(ServiceQuality serviceQuality) {
        this.serviceQuality = serviceQuality;
    }

 
    @Override
    public final Object getInputData() {
        return inputData;
    }

    @Override
    public final void setInputData(Object inputData) {
        if(!(inputData instanceof Integer) || (Integer)inputData < 0) {
            throw new IllegalArgumentException(
                    "bag count must be greater than or equal to zero");
        }
        this.inputData = inputData;
    }

    public final double getBaseTipPerBag() {
        return baseTipPerBag;
    }

    public final void setBaseTipPerBag(double baseTipPerBag) {
        if(baseTipPerBag < 0) {
            throw new IllegalArgumentException(
                    "error: base tip must be greater than or equal to zero");
        }
        this.baseTipPerBag = baseTipPerBag;
    }

}
