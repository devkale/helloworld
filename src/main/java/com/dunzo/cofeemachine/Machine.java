package com.dunzo.cofeemachine;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private int numberOfOutlets;
    Store store;
    List<Outlet> outlets;
    // TODO make it singleton
    public Machine(int numberOfOutlets, Store store) {
        this.numberOfOutlets = numberOfOutlets;
        this.store = store;
        outlets = new ArrayList<>();
        for(int i=0;i<numberOfOutlets;i++) {
            outlets.add(new Outlet(store,i+1));
        }

    }

    public void getBeverage(int outletNumber, Beverage beverage) {
        outlets.get(outletNumber-1).getBeverage(beverage);
    }
}
