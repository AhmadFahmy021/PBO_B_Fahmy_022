import java.math.BigInteger;

public class Admin {
    String username;
    String password;

    String setUsername;
    String setPassword;

    public Admin(){}

    Boolean login(){
        boolean status = false;
        if (this.username.equals(this.setUsername) && this.password.equals(this.setPassword)){
            status = true;
        }
        return status;
    }
}
