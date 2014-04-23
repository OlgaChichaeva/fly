/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.unc.lab3;

import com.netcracker.unc.lab3.AbstractConnection;
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
 *
 * @author Ольга
 */
public class OracleFlightDao extends AbstractConnection implements FlightDao {

    public OracleFlightDao(DataSource sour) {
        super(sour);

    }

    @Override
    public List<Flight> getAllFligh() {
        try (Connection con = getConn()) {
            List<Flight> flights = new ArrayList<Flight>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from unc_flight");
            while (rs.next()) {
                int flightId = rs.getInt("id_flight");
                int routId = rs.getInt("id_route");
                int planeId = rs.getInt("id_plane");
                int timeFly = rs.getInt("beg_fly_time");
                int cost = rs.getInt("ticket_cost");
                Flight flight = new Flight();
                flight.setIdFlight(flightId);
                flight.setIdPlane(planeId);
                flight.setIdRoute(cost);
                flight.setBegFly(timeFly);
                flight.setCost(cost);
                flights.add(flight);
            }

            return flights;
        } catch (SQLException ex) {
            Logger.getLogger(OracleFlightDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Flight getFligh(int id) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("select * from unc_flight where id_flight=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            int routId = rs.getInt("id_route");
            int planeId = rs.getInt("id_plane");
            int timeFly = rs.getInt("beg_fly_time");
            int cost = rs.getInt("ticket_cost");
            Flight flight = new Flight();
            flight.setIdFlight(id);
            flight.setIdPlane(planeId);
            flight.setIdRoute(cost);
            flight.setBegFly(timeFly);
            flight.setCost(cost);

            return flight;
        } catch (SQLException ex) {
        }
        return null;

    }

    @Override
    public void insertFligh(Flight flight) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO unc_flight (id_route,id_plane,beg_fly_time,ticket_cost) VALUES (?,?,?,?)");
            ps.setInt(1, flight.getIdRoute());
            ps.setInt(2, flight.getIdPlane());
            ps.setInt(3, flight.getBegFly());
            ps.setInt(4, flight.getCost());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }

    @Override
    public void deleteFligh(int id) {
      try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("delete from  unc_flight where id_flight = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }    
    }

    @Override
    public void updateFligh(Flight fligh) {
    try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("update unc_fligh set id_route = ?,id_plane = ?,beg_fly_time = ?,ticket_cost = ? where id_flight = ? ");
            ps.setInt(1, fligh.getIdRoute());
            ps.setInt(2, fligh.getIdPlane());
            ps.setInt(3, fligh.getBegFly());
             ps.setInt(4,fligh.getCost());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
}
