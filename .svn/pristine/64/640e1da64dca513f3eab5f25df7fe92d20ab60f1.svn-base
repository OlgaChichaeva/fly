package com.netcracker.unc.lab3;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Ольга
 */
public abstract class AbstractConnection {

    private DataSource sour;

 
    
    public AbstractConnection(DataSource sour) {
        this.sour = sour;
    }

    public Connection getConn() throws SQLException {
        return sour.getConnection();
    }

    protected Plane makePlane(ResultSet rs) throws SQLException {
        Plane plane = new Plane();
        plane.setId(rs.getInt("id"));
        plane.setParent_id(rs.getInt("parent_id"));
        plane.setName(rs.getString("name"));
        plane.setCharacter(rs.getString("characteristics"));
        return plane;
    }

    protected City makeCity(ResultSet rs) throws SQLException {
       City city = new City();
       city.setId(rs.getInt("id"));
       city.setId(rs.getInt("parent_id"));
       city.setId(rs.getInt("name"));
        return city;
    }

protected Flight makeFlight(ResultSet rs) throws SQLException {
       Flight flight = new Flight();
       flight.setIdFlight(rs.getInt("id_flight"));
       flight.setIdRoute(rs.getInt("id_route"));
       flight.setIdPlane(rs.getInt("id_plane"));
       flight.setBegFly(rs.getInt("beg_fly_time"));
       flight.setCost(rs.getInt("ticket_cost"));
        return flight;
    }
protected Route makeRoute(ResultSet rs) throws SQLException {
      Route route = new Route();
       route.setRouteID(rs.getInt("id_route"));
       route.setDepartureID(rs.getInt("id_departure"));
       route.setArrivalID(rs.getInt("id_arrival"));
       route.setTimeFly(rs.getInt("time_fly"));
        return route;
    }
}