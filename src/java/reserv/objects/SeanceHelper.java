/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.objects;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pixel
 */
public class SeanceHelper {
    
    public static List<String> getHours()
    {
        List<String> hours = new ArrayList<String>();
        hours.add("07:10");
        hours.add("10:00");
        hours.add("13:20");
        hours.add("16:00");
        hours.add("19:40");
        hours.add("22:00");        
        return hours;
    }
    
    public static List<String> getDays()
    {
        List<String> days = new ArrayList<String>();
        
        for (Integer i=1; i < 32; i++)
            days.add(i.toString());
            
        return days;
    }
    
    public static List<String> getMonths()
    {
        List<String> months = new ArrayList<String>();
        
        for (Integer i=1; i < 13; i++)
            months.add(i.toString());
            
        return months;
    }
    
}
