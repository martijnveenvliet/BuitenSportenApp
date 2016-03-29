package v3tomd.buitensportenapp.Database.DAO.Impl;

import v3tomd.buitensportenapp.Database.DAO.Interfaces.ActiviteitDAO;
import v3tomd.buitensportenapp.Database.DAO.Interfaces.GebruikerDAO;
import v3tomd.buitensportenapp.Database.DAO.Interfaces.LocatieDAO;

/**
 * Created by Martijn on 29-3-2016.
 */
public class DAOFacade {

    public ActiviteitDAO getMyActiviteitDAO() {
        return MyActiviteitDAO;
    }

    public GebruikerDAO getMyGebruikerDAO() {
        return MyGebruikerDAO;
    }

    public LocatieDAO getMyLocatieDAO() {
        return MyLocatieDAO;
    }

    private ActiviteitDAO MyActiviteitDAO;
    private GebruikerDAO MyGebruikerDAO;
    private LocatieDAO MyLocatieDAO;
    private static DAOFacade theInstance;

    private DAOFacade(){
        MyActiviteitDAO = new ActiviteitDAOImpl();
        MyGebruikerDAO = new GebruikerDAOImpl();
        MyLocatieDAO = new LocatieDAOImpl();
    }

    public static DAOFacade getInstance(){
        if (theInstance == null){
            theInstance = new DAOFacade();
        }
        return theInstance;
    }




}
