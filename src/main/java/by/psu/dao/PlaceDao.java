package by.psu.dao;

import by.psu.model.Place;

import java.util.List;

public interface PlaceDao extends CrudDao<Place> {

    List<Place> getAll();

    Boolean checkSessionStatus(int placeId, int sessionId);

    Boolean checkSessionStatus(int placeId, int sessionId, String username);

}
