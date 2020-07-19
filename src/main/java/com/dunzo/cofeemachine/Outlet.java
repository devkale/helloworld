package com.dunzo.cofeemachine;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class Outlet {
    Store store;
    private int outletNumber;
    public Outlet(Store store, int outletNumber) {
        this.store = store;
        this.outletNumber = outletNumber;
    }

    public void getBeverage(Beverage beverage) {
        Thread t = new Thread(new OutletWorker(beverage, store, outletNumber));
        t.start();
    }
}
