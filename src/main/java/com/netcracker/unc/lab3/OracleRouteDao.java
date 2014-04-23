/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.unc.lab3;

import com.netcracker.unc.lab3.AbstractConnection;
import com.netcracker.unc.lab3.City;
import com.netcracker.unc.lab3.CityDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 * Id_route number CONSTRAINT route_pk_route_id PRIMARY KEY, Id_departure number
 * CONSTRAINT rout_fk_departur_id REFERENCES city(Id_city), Id_arrival number
 * CONSTRAINT rout_fk_arrival REFERENCES city(Id_city), Time_fly number
 *
 * @author Ольга
 */
public class OracleRouteDao extends AbstractConnection implements RouteDao {

    public OracleRouteDao(DataSource sour) {
        super(sour);

    }

    @Override
    public List<Route> getAllRoute() {
        try (Connection con = getConn()) {


            List<Route> routes = new ArrayList<Route>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from unc_route");
            while (rs.next()) {
                int routeID = rs.getInt("Id_route");
                int departureID = rs.getInt("Id_departure");
                int arrivalID = rs.getInt("Id_arrival");
                String timeFly = rs.getString("Time_fly");
                Route route = new Route();
                route.setRouteID(routeID);
                route.setDepartureID(departureID);
                route.setArrivalID(arrivalID);
                route.setTimeFly(routeID);
                routes.add(route);
            }

            return routes;
        } catch (SQLException ex) {
            Logger.getLogger(OracleRouteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Route getRout(int routeID) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("select * from unc_route where Id_route=?");
            ps.setInt(1, routeID);
            ResultSet rs = ps.executeQuery();

            rs.next();

            int departureID = rs.getInt("Id_departure");
            int arrivalID = rs.getInt("Id_arrival");
            int timeFly = rs.getInt("Time_fly");
            Route route = new Route();

            route.setRouteID(routeID);
            route.setDepartureID(departureID);
            route.setArrivalID(arrivalID);
            route.setTimeFly(timeFly);


            return route;
        } catch (SQLException ex) {
        }
        return null;

    }

    @Override
    public void insertRoute(Route route) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO unc_route (Id_departure,Id_arrival,Time_fly) VALUES (?,?,?)");
            ps.setInt(1, route.getDepartureID());
            ps.setInt(2, route.getArrivalID());
            ps.setInt(3, route.getTimeFly());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }

    @Override
    public void deleteRoutr(int routeID) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("delete from unc_route where Id_route = ?");
            ps.setInt(1, routeID);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }    
    }

    @Override
    public void updateRoutr(Route route) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("update unc_route set Id_departure = ?,Id_arrival = ?,Time_fly = ? where Id_route = ? ");
            ps.setInt(1, route.getDepartureID());
            ps.setInt(2, route.getArrivalID());
            ps.setInt(3, route.getTimeFly());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
}