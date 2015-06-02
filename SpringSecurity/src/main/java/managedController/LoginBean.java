package managedController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean(name="loginMgmtBean")
@RequestScoped
public class LoginBean {
  
    private String userName = null; 
    private String password = null;

    @ManagedProperty(value="#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

    
    public String processPage1(){
		return "success";
	}
 
	public String processPage2(){
		return "success";
	}
    
    public String login() {
        try {
        	
        	System.out.println("entro al metodo login");
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUserName(), this.getPassword());
            System.out.println("salio del request");
            Authentication result = authenticationManager.authenticate(request);
            System.out.println("salio del result");
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("ENTRA A LOGIN Y RETONAR incorrect");
            return "incorrect";
        }
        System.out.println("ENTRA A LOGIN Y RETONAR correct");
        return "correct";
    }

    public String cancel() {
        return null;
    }

    public String logout(){
        SecurityContextHolder.clearContext();
        return "loggedout";
    }
 
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
}