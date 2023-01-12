package com.gaaji.town.applicationservice;

import com.gaaji.town.controller.dto.TownRetrieveResponse;
import java.util.List;

public interface TownRetrieveService {

    List<TownRetrieveResponse> retrieveMyTown(String authId);
}
