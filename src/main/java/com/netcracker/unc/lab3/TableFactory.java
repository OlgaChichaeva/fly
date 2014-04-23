/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.unc.lab3;

/**
 *
 * @author Ольга
 */
public abstract class TableFactory {

    public TableFactory() {
        super();
    }

    public abstract PlaneDao makePlane();

    public abstract CityDao makeCity();

    public abstract FlightDao makeFlight();

    public abstract RouteDao makeRoute();
}
