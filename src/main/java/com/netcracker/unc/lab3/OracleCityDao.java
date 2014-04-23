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
public class OracleCityDao extends AbstractConnection implements CityDao {

    public OracleCityDao(DataSource sour) {
        super(sour);

    }

    @Override
    public List<City> getCity() {
        try (Connection con = getConn()) {

            List<City> citys = new ArrayList<City>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from unc_city");
            while (rs.next()) {
                int id = rs.getInt("id");
                int parentId = rs.getInt("parent_id");
                String name = rs.getString("name");

                City city = new City();
                city.setId(id);
                city.setParentId(parentId);
                city.setName(name);    
                citys.add(city);
            }

            return citys;
        } catch (SQLException ex) {
            Logger.getLogger(OracleCityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public City getCity(int id) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("select * from unc_city where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            String name = rs.getString("name");
            int parentId = rs.getInt("parent_id");
            City city = new City();
            city.setId(id);
            city.setParentId(parentId);
            city.setName(name);
            

            return city;
        } catch (SQLException ex) {
        }
        return null;

    }

    @Override
    public void insertCity(City city) {
         try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO unc_city (id,parent_id,name) VALUES (?,?,?)");
            ps.setInt(1, city.getParentId());
            ps.setInt(2, city.getParentId());
            ps.setString(3, city.getName());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }

    @Override
    public void deleteCity(int id) {
     try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("delete from unc_city where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }    
    }

    @Override
    public void updateCity(City city) {
    try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("update unc_city set id = ?,parent_id = ?,name = ? where id = ? ");
            ps.setInt(1, city.getId());
            ps.setInt(2, city.getParentId());
            ps.setString(3, city.getName());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
    }

   