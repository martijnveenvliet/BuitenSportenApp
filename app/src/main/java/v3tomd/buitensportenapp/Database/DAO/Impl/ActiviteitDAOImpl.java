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
        Locatie locatie1 = new Locatie(52.102834, 5.108794);
        Locatie locatie2 = new Locatie(52.097161, 5.111634);
        Locatie locatie3 = new Locatie(52.102584, 5.100789);

        Activiteit activiteit1 = new Activiteit("Trap die bal!", Activiteit.eSportType.Voetbal, new Date(), 1, 99,  locatie1);
        Activiteit activiteit2 = new Activiteit("Win die Jordans", Activiteit.eSportType.Basketbal, new Date(), 1, 99,  locatie2);
        Activiteit activiteit3 = new Activiteit("Hockey met een stockey!", Activiteit.eSportType.Hockey, new Date(), 1, 99,  locatie3);

        activiteiten.add(activiteit1);
        activiteiten.add(activiteit2);
        activiteiten.add(activiteit3);
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
