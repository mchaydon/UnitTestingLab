package factorypractice.spring2;

/**
 * An example low-level class. Does this class definition follow the DIP?
 * If not, fix it.
 *
 * Any other best practice violations? Fix them too.
 *
 * @author your name goes here
 */
public class FoodServiceTipCalculator implements TipCalculator {
    private double minBill = 0.00;
    private static final String BILL_ENTRY_ERR =
            "Error: bill must be greater than or equal to 0";
    private double goodRate = 0.20;
    private double fairRate = 0.15;
    private double poorRate = 0.10;

    private Object inputData; // bill
    
    private ServiceQuality serviceQuality;
    
    public FoodServiceTipCalculator() {
        
    }

    @Override
    public final double getTip() {
        double tip = 0.00; // always initialize local variables

        switch(serviceQuality) {
            case GOOD:
                tip = (Double)inputData * goodRate;
                break;
            case FAIR:
                tip = (Double)inputData * fairRate;
                break;
            case POOR:
                tip = (Double)inputData * poorRate;
                break;
        }
        
        return tip;
    }

    @Override
    public final Object getInputData() {
        return inputData;
    }

    @Override
    public final void setInputData(Object inputData) {
        if(!(inputData instanceof Double) || (Double)inputData < 0) {
            throw new IllegalArgumentException(
                    "bill amount must be greater than or equal to zero");
        }
        this.inputData = inputData;
    }

    @Override
    public final void setServiceQuality(ServiceQuality q) {
        // No need to validate because enums provide type safety!
        serviceQuality = q;
    }

    @Override
    public final ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

}
