package data;

public class LoginData {
    private String testCase;
    public String username;
    public String password;
    public String emailErrorMessage;
    public String passwordErrorMessage;
    public String headerMessage;
    public String footerMessage;
    public boolean isLogout;

    public String getTestCase() {
        return testCase;
    }

    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { 
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
