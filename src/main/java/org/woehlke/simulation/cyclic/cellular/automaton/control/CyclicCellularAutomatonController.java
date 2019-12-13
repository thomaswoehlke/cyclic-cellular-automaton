package org.woehlke.simulation.cyclic.cellular.automaton.control;

import org.woehlke.simulation.cyclic.cellular.automaton.config.ObjectRegistry;

import java.io.Serializable;

import static org.woehlke.simulation.cyclic.cellular.automaton.config.CyclicCellularAutomatonConfig.THREAD_SLEEP_TIME;

/**
 * Cyclic Cellular Automaton.
 *
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/cyclic-cellular-automaton/
 * @author Thomas Woehlke
 *
 * Date: 05.02.2006
 * Time: 00:36:20
 */
public class CyclicCellularAutomatonController extends Thread
        implements Runnable, Serializable {

    private static final long serialVersionUID = 3642865135701767557L;

    private Boolean goOn;

    private final ObjectRegistry ctx;

    public CyclicCellularAutomatonController(ObjectRegistry ctx) {
        this.ctx = ctx;
        goOn = Boolean.TRUE;
    }

    public void run() {
        boolean doIt;
        do {
            synchronized (goOn) {
                doIt = goOn.booleanValue();
            }
            ctx.getLattice().step();
            ctx.getCanvas().repaint();
            try { sleep(THREAD_SLEEP_TIME); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        while (doIt);
    }

    public void exit() {
        synchronized (goOn) {
            goOn = Boolean.FALSE;
        }
    }


}
