package factorypractice.spring2;

/**
 *
 * @author jlombardo
 */
public class TipService {
    private TipCalculator tipCalculator;

    public TipService(TipCalculator tipCalculator) {
        this.tipCalculator = tipCalculator;
    }
    
    public double getTip() {
        return tipCalculator.getTip();
    }

    public TipCalculator getTipCalculator() {
        return tipCalculator;
    }
    
    
}
