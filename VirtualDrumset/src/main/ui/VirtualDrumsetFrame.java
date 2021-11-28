package ui;

import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Represents the JFrame for the VirtualDrumset GUI
public class VirtualDrumsetFrame extends JFrame {

    // EFFECTS: Creates and initializes a new instance of VirtualDrumsetFrame
    public VirtualDrumsetFrame() {
        Image logoImage = Toolkit.getDefaultToolkit().getImage("data/drumset_logo.png");

        this.add(new VirtualDrumsetPanel());
        this.setTitle("Java Virtual Drumset");
        this.setIconImage(logoImage);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                printLog(EventLog.getInstance());
                System.exit(0);
            }
        });
    }

    // EFFECTS: Prints log of all events done by user
    public static void printLog(EventLog el) {
        for (Event next : el) {
            System.out.println(next.toString() + "\n");
        }
    }

}
