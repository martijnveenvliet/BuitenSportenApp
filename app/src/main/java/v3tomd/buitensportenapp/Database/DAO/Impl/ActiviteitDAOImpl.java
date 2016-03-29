package v3tomd.buitensportenapp.Database.DAO.Impl;

import java.util.ArrayList;
import java.util.Date;

import v3tomd.buitensportenapp.Database.DAO.Interfaces.ActiviteitDAO;
import v3tomd.buitensportenapp.Model.Activiteit;
import v3tomd.buitensportenapp.Model.Locatie;

/**
 * Created by Vidjinder on 28-3-2016.
 */
class ActiviteitDAOImpl implements ActiviteitDAO{


    ArrayList<Activiteit> activiteiten;

    public ActiviteitDAOImpl(){
        activiteiten = new ArrayList<Activiteit>();
        Locatie MyLocatie = new Locatie(52.103178, 5.105735);
        Activiteit activiteit1 = new Activiteit("Voetbal", Activiteit.eSportType.Voetbal, new Date(), 1, 99,  MyLocatie);
        Activiteit activiteit2 = new Activiteit("Basketbal", Activiteit.eSportType.Basketbal, new Date(), 1, 99,  MyLocatie);
        activiteiten.add(activiteit1);
        activiteiten.add(activiteit2);
    }
    @Override
    public ArrayList<Activiteit> getAllActivities() {
        return activiteiten;
    }

    @Override
    public Activiteit getActiviteit(int activiteitId) {
        return activiteiten.get(activiteitId);
    }

    @Override
    public void updateActiviteit(Activiteit activiteit) {
        activiteiten.get(activiteit.getMyID()).setTitel(activiteit.getTitel());
        System.out.println("Activiteit: " + activiteit.getTitel() + ", updated in the database");
    }

    @Override
    public void deleteActiviteit(Activiteit activiteit) {
        activiteiten.remove(activiteit.getMyID());
        System.out.println("Activiteit: " + activiteit.getTitel() + ", deleted from database");
    }
}
