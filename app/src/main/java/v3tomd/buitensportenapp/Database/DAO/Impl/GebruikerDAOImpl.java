package v3tomd.buitensportenapp.Database.DAO.Impl;

import java.util.ArrayList;

import v3tomd.buitensportenapp.Database.DAO.Interfaces.GebruikerDAO;
import v3tomd.buitensportenapp.Model.Gebruiker;

/**
 * Created by Vidjinder on 27-3-2016.
 */
class GebruikerDAOImpl implements GebruikerDAO{
    ArrayList<Gebruiker> gebruikers;

    public GebruikerDAOImpl(){


    }

    @Override
    public ArrayList<Gebruiker> getAllGebruikers() {
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


    public Gebruiker getGebruikerByUsername(String username){

        return null;
    }
}

