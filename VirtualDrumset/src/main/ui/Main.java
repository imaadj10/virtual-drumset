package ui;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SplashScreenWindow loadingScreen = new SplashScreenWindow();
        Thread.sleep(2500);
        loadingScreen.dispose();
        new VirtualDrumsetFrame();
    }

}
