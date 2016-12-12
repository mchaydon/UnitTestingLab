package factorypractice.spring2;

import java.util.Scanner;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Startup {

    public static void main(String[] args) {
        /* 
         * Retrieve a Spring application context from the classpath. All beans
         * are configured in the XML file. You could
         * use a different Spring class for an external file path. 
         * This causes Spring to instantiate all beans. You only need to do 
         * this once, but if you do it again, it returns a copy.
         */
        final AbstractApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        // Now ask Spring to give you a fully configured TipService object. Note
        // that the TipCalculator has already been injected by Spring.
        TipService service = null;
        int bags = 0;
        double billAmt = 0;
        
        Scanner in = new Scanner(System.in);
        System.out.println("What kind of service? 1=Food, 2=Baggage");
        int serviceType = in.nextInt();
        
        if(serviceType == 1) {
            service = (TipService)ctx.getBean("tipServiceAlt");
            System.out.println("What was your total dinner bill?");
            billAmt = in.nextDouble();
        } else {
            service = (TipService)ctx.getBean("tipService");
            System.out.println("How many bags do you have?");
            bags = in.nextInt();
        }

        System.out.println("How was the Service Quality? 1=GOOD, 2=FAIR, 3=POOR");
        int quality = in.nextInt();
        in.close();
        
        switch(quality) {
            case 1:
                service.getTipCalculator().setServiceQuality(ServiceQuality.GOOD);
                break;
            case 2:
                service.getTipCalculator().setServiceQuality(ServiceQuality.FAIR);
                break;
            case 3:
                service.getTipCalculator().setServiceQuality(ServiceQuality.POOR);
                break;
        }                
        
        if(serviceType == 1) {
            service.getTipCalculator().setInputData(billAmt);
        } else {
            service.getTipCalculator().setInputData(bags);
        }
        
        double tip = service.getTip();
        
        if(serviceType == 1) {
            System.out.println("The food service tip is calculated to be: " + tip);
        } else {
            System.out.println("The baggage handler tip is calculated to be: " + tip);
        }
    }

}
