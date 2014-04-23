/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.unc.lab3;

/**
 *Id_city number CONSTRAINT city_pk_city_id PRIMARY KEY,
City varchar(255)
 * @author Ольга
 */
public class City {
  private int id;
  private int parentId;
  private String name;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the parentId
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}

 
   
