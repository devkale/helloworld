package com.dunzo.cofeemachine;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class Outlet {
    Store store;
    private int outletNumber;
    OutletWorker outletWorker;
    public Outlet(Store store, int outletNumber) {
        this.store = store;
        this.outletNumber = outletNumber;
        this.outletWorker = new OutletWorker(store, outletNumber);
        Thread t = new Thread(this.outletWorker);
        t.start();
    }

    public void getBeverage(Beverage beverage) {
        outletWorker.AddBeverage(beverage);
    }
}
