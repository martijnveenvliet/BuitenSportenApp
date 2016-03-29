package v3tomd.buitensportenapp.Database.DAO.Impl;

import java.util.List;

import v3tomd.buitensportenapp.Database.DAO.GebruikerDAO;
import v3tomd.buitensportenapp.Model.Gebruiker;

/**
 * Created by Vidjinder on 27-3-2016.
 */
public class GebruikerDAOImpl implements GebruikerDAO{
    List<Gebruiker> gebruikers;

    public GebruikerDAOImpl(){


    }

    @Override
    public List<Gebruiker> getAllGebruikers() {
        return gebruikers;
    }


    @Override
    public Gebruiker getGebruiker(int gebruikerId) {
        return gebruikers.get(gebruikerId);
    }

    @Override
    public void updateGebruiker(Gebruiker gebruiker) {
        gebruikers.get(gebruiker.getMyID()).setMyNaam(gebruiker.getMyNaam());
        System.out.println("Gebruiker: " + gebruiker.GetGebruiker() + ", updated in the database");
    }

    @Override
    public void deleteGebruiker(Gebruiker gebruiker) {
       gebruikers.remove(gebruiker.GetGebruiker());
        System.out.println("Gebruiker: " + gebruiker.GetGebruiker() + ", deleted from database");
    }
}

