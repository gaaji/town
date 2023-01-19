package com.gaaji.town.applicationservice;

public interface TownAuthenticationService {


    void authenticateTown(String townId, String authId);

    boolean checkAuthentication(String townId, String authId);


}
