/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.objects;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author pixel
 */
public class PixTomMessages {
    
    public PixTomMessages()
    {
        //
    }
    
    public static void addFlash(String flash)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, flash, ""));
        
    }
    
    public static void addErrormessage(String error)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, error, ""));
    }
    
}
