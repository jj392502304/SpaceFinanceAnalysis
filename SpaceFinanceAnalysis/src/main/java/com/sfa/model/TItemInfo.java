package com.sfa.model;

import javax.persistence.*;

@Table(name = "t_item_info")
public class TItemInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_STATE")
    private String itemState;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return ITEM_NAME
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return ITEM_STATE
     */
    public String getItemState() {
        return itemState;
    }

    /**
     * @param itemState
     */
    public void setItemState(String itemState) {
        this.itemState = itemState;
    }
}