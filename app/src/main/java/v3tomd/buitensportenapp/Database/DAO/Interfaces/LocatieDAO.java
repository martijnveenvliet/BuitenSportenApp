package v3tomd.buitensportenapp.Database.DAO.Interfaces;

import java.util.ArrayList;

import v3tomd.buitensportenapp.Model.Locatie;

/**
 * Created by Vidjinder on 28-3-2016.
 */
public interface LocatieDAO {
    public ArrayList<Locatie> getAllLocaties();
    public Locatie getLocatie(int gebruikerId);
    public void updateLocatie(Locatie locatie);
    public void deleteLocatie(Locatie locatie);
}
