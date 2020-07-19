package com.dunzo.cofeemachine;

public class OutletWorker implements Runnable {
    public Beverage beverage;
    private Store store;
    private int outletNumber;

    public OutletWorker(int outletNumber, Store store) {
        this.outletNumber = outletNumber;
        this.store = store;
    }

    public OutletWorker(Beverage beverage, Store store, int outletNumber) {
        this.beverage = beverage;
        this.store = store;
        this.outletNumber = outletNumber;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        getBeverage();

    }
    public void getBeverage() {
        boolean fulFilled =  store.getIngredients(beverage.getIngredients());
        if(fulFilled) {
            System.out.println(String.format("%s is prepared", beverage.getName()));
        } else {
            System.out.println(String.format("%s cannot be prepared", beverage.getName()));
        }

    }
}
