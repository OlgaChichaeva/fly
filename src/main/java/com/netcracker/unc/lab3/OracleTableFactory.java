package com.netcracker.unc.lab3;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.netcracker.unc.lab3.TableFactory;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;

   

/**
 *
 * @author Ольга
 */
public class OracleTableFactory extends TableFactory{
     
    DataSource sour;
   public void init(String dataSourceName) throws NamingException {      
             InitialContext initContext;         
                initContext = new InitialContext();           
           
        sour = (DataSource) initContext.lookup(dataSourceName);     
               }

    public OracleTableFactory() throws NamingException {

        super();
         Locale.setDefault(Locale.ENGLISH);
        
   init("java:comp/env/jdbc/Datasource");
        } 

    @Override
    public PlaneDao makePlane() {
     return new OraclePlaneDao(sour);
    }

    @Override   
    public CityDao makeCity() {
        return new OracleCityDao(sour);
    }

    @Override
    public FlightDao makeFlight() {
   return new OracleFlightDao(sour);
    }

    @Override
    public RouteDao makeRoute() {
      return new OracleRouteDao(sour);
    }

    }
   

    

