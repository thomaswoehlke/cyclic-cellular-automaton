package org.woehlke.simulation.cyclic.cellular.automaton.view.desktop;

import org.woehlke.simulation.cyclic.cellular.automaton.view.applets.CyclicCellularAutomatonApplet;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * Cyclic Cellular Automaton.
 *
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/cyclic-cellular-automaton/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:47:46
 */
public class CyclicCellularAutomatonFrame extends JFrame implements ImageObserver,
        MenuContainer,
        Serializable,
        Accessible,
        WindowListener {

    private static final long serialVersionUID = 4357793241219932594L;

    private CyclicCellularAutomatonApplet exe;

    public CyclicCellularAutomatonFrame() {
        super("cyclic cellular automaton");
        exe = new CyclicCellularAutomatonApplet();
        exe.init();
        add("Center", exe);
        setBounds(100, 100, exe.getCanvasDimensions().getX(), exe.getCanvasDimensions().getY() + 30);
        pack();
        setVisible(true);
        toFront();
        addWindowListener(this);
    }

    public void windowOpened(WindowEvent e) {
        setBounds(100, 100, exe.getCanvasDimensions().getX(), exe.getCanvasDimensions().getY() + 30);
        setVisible(true);
        toFront();
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {
        setBounds(100, 100, exe.getCanvasDimensions().getX(), exe.getCanvasDimensions().getY() + 30);
        setVisible(true);
        toFront();
    }

    public void windowActivated(WindowEvent e) {
        toFront();
    }

    public void windowDeactivated(WindowEvent e) {
    }
}
