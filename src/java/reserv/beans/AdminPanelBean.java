/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import reserv.objects.PixTomMessages;

/**
 *
 * @author pixel
 */
@ManagedBean(name="AdminPanelBean")
@SessionScoped
public class AdminPanelBean {

    private String name;
    private String password;
    private Boolean isLogged;
    
    public String authorize()
    {
        if(!isLogged) {
            try {
                
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");                
                
            } catch (IOException ex) {
                Logger.getLogger(AdminPanelBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return "";
    }
    

    public Boolean getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Boolean isLogged) {
        //
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String login()
    {
        if (name.equals("admin") && password.equals("admin123"))
        {
            this.name = "";
            this.password = "";
            this.isLogged = true;
            return "panel";
        }
        
        PixTomMessages.addErrormessage("Niepoprawny login lub hasło !");
        return "login";
    }
    
    public String logout()
    {
        isLogged = false;
        return "index";
    }
    
    
    /**
     * Creates a new instance of AdminPanelBean
     */
    public AdminPanelBean() {
        isLogged = false;
    }
    
    
    
    
    
}
