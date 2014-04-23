/*id number CONSTRAINT city_pk_country_id PRIMARY KEY,
parent_id number,
name varchar(255)
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.unc.lab3;

import java.util.List;

/**
 *
 * @author Ольга
 */
public interface PlaneDao {
   List<Plane> getPlane();
   Plane getPlane(int id);
   void insertPlane (Plane plane);
   void deletePlane(int id);
   void updatePlane(Plane plane);   
    
}
