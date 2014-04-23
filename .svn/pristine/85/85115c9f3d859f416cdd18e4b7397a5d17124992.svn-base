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
public class OraclePlaneDao extends AbstractConnection implements PlaneDao {

    public OraclePlaneDao(DataSource sour) {
        super(sour);

    }

    @Override
    public List<Plane> getPlane() {
        try (Connection con = getConn()) {
            List<Plane> planes = new ArrayList<Plane>();
            Statement st = con.createStatement();// con.getConn();
            ResultSet rs = st.executeQuery("select * from unc_plane");
            while (rs.next()) {
          int id = rs.getInt("id");
                int parentId = rs.getInt("parent_id");
                String name = rs.getString("name");
                String character = rs.getString("characteristics");

                Plane plane = new Plane();
                plane.setId(id);
                plane.setParent_id(parentId);
                plane.setName(name);
                plane.setCharacter(character);
                planes.add(plane);
            }

            return planes;
        } catch (SQLException ex) {
            Logger.getLogger(OraclePlaneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;


    }

    @Override
    public Plane getPlane(int id) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("select * from unc_plane where id=?");
            ps.setInt(1, id);
             
            ResultSet rs = ps.executeQuery();

            rs.next();
            int parentId = rs.getInt("parent_id");
            String name = rs.getString("name");
            String character = rs.getString("characteristics");
            
            Plane plane = new Plane();
            plane.setParent_id(parentId);
            plane.setName(name);
            plane.setCharacter(character);

            return plane;
        } catch (SQLException ex) {
        }
        return null;

    }

    @Override
    public void insertPlane(Plane plane) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO unc_plane (id,parent_id,name,characteristics) VALUES (?,?,?,?)");
            ps.setInt(1, plane.getId());
            ps.setInt(2, plane.getParent_id());
            ps.setString(3, plane.getName());
            ps.setString(4, plane.getCharacter());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }

    @Override
    public void deletePlane(int id) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("delete from unc_plane where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    @Override
    public void updatePlane(Plane plane) {
      try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("update unc_plane set id = ?,parent_id = ?,name = ?,characteristics = ? where id = ? ");
            ps.setInt(1, plane.getId());
            ps.setInt(2, plane.getParent_id());
            ps.setString(3, plane.getName());
            ps.setString(4, plane.getCharacter());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
}
