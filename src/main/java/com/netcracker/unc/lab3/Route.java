/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.unc.lab3;

/**
 *
 * @author Ольга
 */
public class Route {
    
 private int routeID;
   private int departureID;
   private int arrivalID;
   private int timeFly;

    /**
     * @return the routeID
     */
    public int getRouteID() {
        return routeID;
    }

    /**
     * @param routeID the routeID to set
     */
    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    /**
     * @return the departureID
     */
    public int getDepartureID() {
        return departureID;
    }

    /**
     * @param departureID the departureID to set
     */
    public void setDepartureID(int departureID) {
        this.departureID = departureID;
    }

    /**
     * @return the arrivalID
     */
    public int getArrivalID() {
        return arrivalID;
    }

    /**
     * @param arrivalID the arrivalID to set
     */
    public void setArrivalID(int arrivalID) {
        this.arrivalID = arrivalID;
    }

    /**
     * @return the timeFly
     */
    public int getTimeFly() {
        return timeFly;
    }

    /**
     * @param timeFly the timeFly to set
     */
    public void setTimeFly(int timeFly) {
        this.timeFly = timeFly;
    }

}