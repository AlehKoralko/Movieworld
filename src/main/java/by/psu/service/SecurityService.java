package by.psu.service;

public interface SecurityService {

    String getLoggedInUsername();

    void autoLogin(String username, String password);

}
