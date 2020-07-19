package com.dunzo.cofeemachine;

import java.util.ArrayList;
import java.util.List;

public class OutletWorker implements Runnable {
    //public Beverage beverage;
    private Store store;
    private int outletNumber;
    public List<Beverage> beverages;

    public OutletWorker(Store store,int outletNumber) {
        this.outletNumber = outletNumber;
        this.store = store;
        beverages = new ArrayList<>();

    }

    public void AddBeverage(Beverage beverage) {
        synchronized (this) {
            beverages.add(beverage);
        }
    }

    private Beverage RemoveBeverage(){
        synchronized (this) {
            Beverage beverage = null;
            if(beverages.size()!=0) {
                beverage=beverages.get(0);
                beverages.remove(0);
            }
            return beverage;
        }
    }

    public OutletWorker(Beverage beverage, Store store, int outletNumber) {
        //this.beverage = beverage;
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
        while(true) {
            Beverage beverage = RemoveBeverage();
            if(beverage!=null)
            {
                getBeverage(beverage);
            }
        }


    }
    public void getBeverage(Beverage beverage) {
        boolean fulFilled =  store.getIngredients(beverage.getIngredients());
        if(fulFilled) {
            System.out.println(String.format("%s is prepared", beverage.getName()));
        } else {
            System.out.println(String.format("%s cannot be prepared", beverage.getName()));
        }

    }
}
