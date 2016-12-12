package factorypractice.spring2;

/**
 *
 * @author jlombardo
 */
public interface TipCalculator {

    public abstract double getTip();

    public abstract Object getInputData();
    
    public abstract void setInputData(Object inputData);
    
    public abstract void setServiceQuality(ServiceQuality q);
    
    public abstract ServiceQuality getServiceQuality();
    
}
