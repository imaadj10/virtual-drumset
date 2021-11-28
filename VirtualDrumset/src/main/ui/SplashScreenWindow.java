package ui;

import javax.swing.*;

// Represents the JWindow for the splash screen
public class SplashScreenWindow extends JWindow {

    // EFFECTS: Creates and initializes a new instance of SplashScreenWindow
    public SplashScreenWindow() {
        this.add(new SplashScreenPanel());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
