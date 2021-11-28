package ui;

import javax.swing.*;
import java.awt.*;

// Represents the JPanel for the splash screen
public class SplashScreenPanel extends JPanel  {

    private static final Font LOGO_TEXT_FONT = new Font("Helvetica", Font.BOLD, 28);

    // Creates and initializes a new instance of SplashScreenPanel
    public SplashScreenPanel() {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(600, 660));

        JLabel logoText = new JLabel("Java Virtual Drumset");
        JLabel logoImage = new JLabel(
                new ImageIcon(new ImageIcon("data/drumset_logo.png").getImage()
                        .getScaledInstance(525, 500, Image.SCALE_DEFAULT)));
        JLabel loadingGIF = new JLabel(
                new ImageIcon(new ImageIcon("data/loading.gif").getImage()
                        .getScaledInstance(125, 125, Image.SCALE_DEFAULT)));

        logoText.setFont(LOGO_TEXT_FONT);
        logoText.setBackground(Color.BLACK);

        this.add(logoText);
        this.add(logoImage);
        this.add(loadingGIF);

        this.setBackground(Color.white);
    }

}
