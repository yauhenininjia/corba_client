package corbaclient;

/**
 * Created by ninjia on 19.11.16.
 */

import WeeksApp.WeekService;
import WeeksApp.WeekServiceHelper;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import DaysApp.*;

public class StartClient {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            DayService addobj = (DayService) DayServiceHelper.narrow(ncRef.resolve_str("ABC"));
            WeekService weekaddobj = (WeekService) WeekServiceHelper.narrow(ncRef.resolve_str("DEF"));

            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

            System.out.println("Welcome to the system:");
            for(;;){
                System.out.println("Enter first date:");
                String firstDate = scanner.nextLine();

                System.out.println("Enter last date:");
                String lastDate = scanner.nextLine();

                int daysDiff = addobj.add(firstDate, lastDate);
                System.out.println("Diff in days is : " + daysDiff);
                System.out.println("-----------------------------------");

                int weeksDiff = weekaddobj.add(firstDate, lastDate);
                System.out.println("Diff in weeks is : " + weeksDiff);
                System.out.println("-----------------------------------");
            }
        }
        catch (Exception e) {
            System.out.println("Hello Client exception: " + e);
            e.printStackTrace();
        }

    }
}
