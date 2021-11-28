package ui;

import model.Instrument;
import model.Track;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the JFrame for the VirtualDrumset GUI
public class VirtualDrumsetPanel extends JPanel implements ActionListener {

    private static final int TRACK_BUTTON_WIDTH = 200;
    private static final int TRACK_BUTTON_HEIGHT = 100;
    private static final int DRUM_BUTTON_WIDTH = 120;
    private static final int DRUM_BUTTON_HEIGHT = 120;
    private static final int TRACK_LABEL_WIDTH = 1600;
    private static final int TRACK_LABEL_HEIGHT = 255;
    private static final Font TRACK_LABEL_FONT = new Font("Helvetica", Font.BOLD, 24);
    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 800;
    private static final Color PANEL_COLOR = Color.lightGray;

    private final JButton bassButton = new JButton(
            new ImageIcon(new ImageIcon("data/DrumImages/bass_drum.png").getImage()
            .getScaledInstance(DRUM_BUTTON_WIDTH, DRUM_BUTTON_HEIGHT, Image.SCALE_DEFAULT)));
    private final JButton snareButton = new JButton(
            new ImageIcon(new ImageIcon("data/DrumImages/snare_drum.png").getImage()
            .getScaledInstance(DRUM_BUTTON_WIDTH, DRUM_BUTTON_HEIGHT, Image.SCALE_DEFAULT)));
    private final JButton crashButton = new JButton(
            new ImageIcon(new ImageIcon("data/DrumImages/crash_cymbal.png").getImage()
            .getScaledInstance(DRUM_BUTTON_WIDTH, DRUM_BUTTON_HEIGHT, Image.SCALE_DEFAULT)));
    private final JButton rideButton = new JButton(
            new ImageIcon(new ImageIcon("data/DrumImages/ride_cymbal.png").getImage()
            .getScaledInstance(DRUM_BUTTON_WIDTH, DRUM_BUTTON_HEIGHT, Image.SCALE_DEFAULT)));
    private final JButton floorButton = new JButton(
            new ImageIcon(new ImageIcon("data/DrumImages/floor_tom.png").getImage()
            .getScaledInstance(DRUM_BUTTON_WIDTH, DRUM_BUTTON_HEIGHT, Image.SCALE_DEFAULT)));
    private final JButton highButton = new JButton(
            new ImageIcon(new ImageIcon("data/DrumImages/high_tom.png").getImage()
            .getScaledInstance(DRUM_BUTTON_WIDTH, DRUM_BUTTON_HEIGHT, Image.SCALE_DEFAULT)));
    private final JButton lowButton = new JButton(
            new ImageIcon(new ImageIcon("data/DrumImages/low_tom.png").getImage()
            .getScaledInstance(DRUM_BUTTON_WIDTH, DRUM_BUTTON_HEIGHT, Image.SCALE_DEFAULT)));
    private final JButton openButton = new JButton(
            new ImageIcon(new ImageIcon("data/DrumImages/open_hi_hat.png").getImage()
            .getScaledInstance(DRUM_BUTTON_WIDTH, DRUM_BUTTON_HEIGHT, Image.SCALE_DEFAULT)));
    private final JButton closedButton = new JButton(
            new ImageIcon(new ImageIcon("data/DrumImages/closed_hi_hat.png").getImage()
            .getScaledInstance(DRUM_BUTTON_WIDTH, DRUM_BUTTON_HEIGHT, Image.SCALE_DEFAULT)));

    private final JButton saveButton = new JButton("Save Track");
    private final JButton loadButton = new JButton("Load Track");
    private final JButton recordButton = new JButton("Record Track");
    private final JButton playButton = new JButton("Play Track");
    private final JButton stopButton = new JButton("Stop Recording");
    private final JButton clearButton = new JButton("Clear Track");

    private JTextArea trackLabel;
    private JLabel recordingLabel;
    private JLabel maxReachedLabel;
    private JLabel trackStoredLabel;

    private final VirtualDrumsetApp drumsetApp;
    private Track track;

    private final GridBagConstraints layoutConstraints = new GridBagConstraints();

    // EFFECTS: Creates and initializes a new instance of VirtualDrumsetPanel
    public VirtualDrumsetPanel() {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(PANEL_COLOR);

        drumsetApp = new VirtualDrumsetApp();
        track = drumsetApp.getTrack();

        setLabels();
        setTrackButtonSize();
        setTrackButtonFont();
        setActionListeners();
        setDrumButtonStyle();

        addTrackButtons();
        addDrumButtons();
        addLabels();
    }

    // EFFECTS: Sets label text and font for all labels
    private void setLabels() {
        recordingLabel = new JLabel("");
        recordingLabel.setForeground(Color.red);
        recordingLabel.setFont(new Font("Helvetica", Font.PLAIN, 24));
        maxReachedLabel = new JLabel("");
        maxReachedLabel.setForeground(Color.red);
        maxReachedLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        trackStoredLabel = new JLabel("");
        trackStoredLabel.setForeground(new Color(50, 127, 38));
        trackStoredLabel.setFont(new Font("Helvetica", Font.BOLD, 26));

        trackLabel = new JTextArea(track.trackString());
        trackLabel.setWrapStyleWord(true);
        trackLabel.setLineWrap(true);
        trackLabel.setOpaque(false);
        trackLabel.setEditable(false);
        trackLabel.setFocusable(false);
        trackLabel.setFont(TRACK_LABEL_FONT);
        trackLabel.setPreferredSize(new Dimension(TRACK_LABEL_WIDTH, TRACK_LABEL_HEIGHT));
        trackLabel.setMinimumSize(new Dimension(TRACK_LABEL_WIDTH, TRACK_LABEL_HEIGHT));
        trackLabel.setMaximumSize(new Dimension(TRACK_LABEL_WIDTH, TRACK_LABEL_HEIGHT));
    }

    // EFFECTS: Sets size for all track control buttons
    private void setTrackButtonSize() {
        saveButton.setPreferredSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
        saveButton.setMaximumSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
        saveButton.setMinimumSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));

        loadButton.setPreferredSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
        loadButton.setMaximumSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
        loadButton.setMinimumSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));

        recordButton.setPreferredSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
        recordButton.setMaximumSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
        recordButton.setMinimumSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));

        stopButton.setPreferredSize(new Dimension(TRACK_BUTTON_WIDTH + 50, TRACK_BUTTON_HEIGHT));
        stopButton.setMaximumSize(new Dimension(TRACK_BUTTON_WIDTH + 50, TRACK_BUTTON_HEIGHT));
        stopButton.setMinimumSize(new Dimension(TRACK_BUTTON_WIDTH + 50, TRACK_BUTTON_HEIGHT));

        playButton.setPreferredSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
        playButton.setMaximumSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
        playButton.setMinimumSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));

        clearButton.setPreferredSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
        clearButton.setMaximumSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
        clearButton.setMinimumSize(new Dimension(TRACK_BUTTON_WIDTH, TRACK_BUTTON_HEIGHT));
    }

    // EFFECTS: Sets font for all track control buttons
    private void setTrackButtonFont() {
        saveButton.setFont(TRACK_LABEL_FONT);
        loadButton.setFont(TRACK_LABEL_FONT);
        recordButton.setFont(TRACK_LABEL_FONT);
        stopButton.setFont(TRACK_LABEL_FONT);
        playButton.setFont(TRACK_LABEL_FONT);
        clearButton.setFont(TRACK_LABEL_FONT);
    }

    // MODIFIES: this
    // EFFECTS: Adds all labels to VirtualDrumsetPanel
    private void addLabels() {
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.insets = new Insets(20, 15, 0, 0);
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 4;
        layoutConstraints.gridwidth = 7;
        layoutConstraints.gridheight = 2;
        this.add(trackLabel, layoutConstraints);

        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.gridx = 4;
        layoutConstraints.gridy = 0;
        this.add(recordingLabel, layoutConstraints);

        layoutConstraints.gridx = 4;
        layoutConstraints.gridy = 1;
        this.add(trackStoredLabel, layoutConstraints);

        layoutConstraints.gridx = 4;
        layoutConstraints.gridy = 2;
        this.add(maxReachedLabel, layoutConstraints);
    }

    // EFFECTS: Sets ActionListener for all JButtons
    private void setActionListeners() {
        bassButton.addActionListener(this);
        snareButton.addActionListener(this);
        crashButton.addActionListener(this);
        rideButton.addActionListener(this);
        floorButton.addActionListener(this);
        highButton.addActionListener(this);
        lowButton.addActionListener(this);
        openButton.addActionListener(this);
        closedButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        recordButton.addActionListener(this);
        stopButton.addActionListener(this);
        playButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Adds track control buttons to VirtualDrumsetPanel
    private void addTrackButtons() {
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.insets = new Insets(0, 20, 0, 0);
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        this.add(saveButton, layoutConstraints);

        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.insets = new Insets(0, 0, 0, 0);
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 0;
        this.add(loadButton, layoutConstraints);

        layoutConstraints.gridx = 2;
        layoutConstraints.gridy = 0;
        this.add(recordButton, layoutConstraints);

        layoutConstraints.gridx = 3;
        layoutConstraints.gridy = 0;
        this.add(stopButton, layoutConstraints);

        layoutConstraints.gridx = 4;
        layoutConstraints.gridy = 0;
        this.add(playButton, layoutConstraints);

        layoutConstraints.gridx = 5;
        layoutConstraints.gridy = 0;
        this.add(clearButton, layoutConstraints);
    }

    // MODIFIES: this
    // EFFECTS: Adds drum buttons to VirtualDrumsetPanel
    private void addDrumButtons() {
        addTopRowDrumButtons();
        addMiddleRowDrumButtons();
        addBottomRowDrumButtons();
    }

    // MODIFIES: this
    // EFFECTS: Adds top row of drumset to VirtualDrumsetPanel
    private void addTopRowDrumButtons() {
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.insets = new Insets(20, 0, 0, 0);
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 1;
        this.add(crashButton, layoutConstraints);

        layoutConstraints.gridx = 2;
        layoutConstraints.gridy = 1;
        this.add(highButton, layoutConstraints);

        layoutConstraints.gridx = 3;
        layoutConstraints.gridy = 1;
        this.add(rideButton, layoutConstraints);
    }

    // MODIFIES: this
    // EFFECTS: Adds middle row of drumset to VirtualDrumsetPanel
    private void addMiddleRowDrumButtons() {
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.insets = new Insets(0, 0, 0, 0);
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 2;
        this.add(closedButton, layoutConstraints);

        layoutConstraints.gridx = 2;
        layoutConstraints.gridy = 2;
        this.add(lowButton, layoutConstraints);

        layoutConstraints.gridx = 3;
        layoutConstraints.gridy = 2;
        this.add(openButton, layoutConstraints);
    }

    // MODIFIES: this
    // EFFECTS: Adds bottom row of drumset to VirtualDrumsetPanel
    private void addBottomRowDrumButtons() {
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 3;
        this.add(snareButton, layoutConstraints);

        layoutConstraints.gridx = 2;
        layoutConstraints.gridy = 3;
        this.add(bassButton, layoutConstraints);

        layoutConstraints.gridx = 3;
        layoutConstraints.gridy = 3;
        this.add(floorButton, layoutConstraints);
    }

    // EFFECTS: Sets drumset button color and style
    private void setDrumButtonStyle() {
        bassButton.setBorderPainted(false);
        snareButton.setBorderPainted(false);
        crashButton.setBorderPainted(false);
        rideButton.setBorderPainted(false);
        openButton.setBorderPainted(false);
        closedButton.setBorderPainted(false);
        floorButton.setBorderPainted(false);
        highButton.setBorderPainted(false);
        lowButton.setBorderPainted(false);

        bassButton.setBackground(PANEL_COLOR);
        snareButton.setBackground(PANEL_COLOR);
        crashButton.setBackground(PANEL_COLOR);
        rideButton.setBackground(PANEL_COLOR);
        openButton.setBackground(PANEL_COLOR);
        closedButton.setBackground(PANEL_COLOR);
        floorButton.setBackground(PANEL_COLOR);
        highButton.setBackground(PANEL_COLOR);
        lowButton.setBackground(PANEL_COLOR);
    }

    // EFFECTS: Determines what action to take when button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        identifySoundButton(e);
        identifyTrackButton(e);
    }

    // EFFECTS: Identifies which drumset button was pressed and what sound to play
    private void identifySoundButton(ActionEvent e) {
        identifySoundButtonDrums(e);
        identifySoundButtonCymbals(e);
        identifySoundButtonToms(e);
        identifySoundButtonHiHat(e);
    }

    // EFFECTS: Plays sound if one of the drum instrument buttons was pressed
    private void identifySoundButtonDrums(ActionEvent e) {
        if (e.getSource().equals(bassButton)) {
            drumsetApp.drumset.playBassDrum();
            if (track.getRecordingStatus()) {
                maxReachedLabel.setText(track.addBeat(new Instrument("bass")));
                trackLabel.setText(track.trackString());
            }
        } else if (e.getSource().equals(snareButton)) {
            drumsetApp.drumset.playSnareDrum();
            if (track.getRecordingStatus()) {
                maxReachedLabel.setText(track.addBeat(new Instrument("snare")));
                trackLabel.setText(track.trackString());
            }
        }
    }

    // EFFECTS: Plays sound if one of the cymbal instrument buttons was pressed
    private void identifySoundButtonCymbals(ActionEvent e) {
        if (e.getSource().equals(crashButton)) {
            drumsetApp.drumset.playCrashCymbal();
            if (track.getRecordingStatus()) {
                maxReachedLabel.setText(track.addBeat(new Instrument("crash")));
                trackLabel.setText(track.trackString());
            }
        } else if (e.getSource().equals(rideButton)) {
            drumsetApp.drumset.playRideCymbal();
            if (track.getRecordingStatus()) {
                maxReachedLabel.setText(track.addBeat(new Instrument("ride")));
                trackLabel.setText(track.trackString());
            }
        }
    }

    // EFFECTS: Plays sound if one of the tom instrument buttons was pressed
    private void identifySoundButtonToms(ActionEvent e) {
        if (e.getSource().equals(floorButton)) {
            drumsetApp.drumset.playFloorTom();
            if (track.getRecordingStatus()) {
                maxReachedLabel.setText(track.addBeat(new Instrument("floor")));
                trackLabel.setText(track.trackString());
            }
        } else if (e.getSource().equals(highButton)) {
            drumsetApp.drumset.playHighTom();
            if (track.getRecordingStatus()) {
                maxReachedLabel.setText(track.addBeat(new Instrument("high")));
                trackLabel.setText(track.trackString());
            }
        } else if (e.getSource().equals(lowButton)) {
            drumsetApp.drumset.playLowTom();
            if (track.getRecordingStatus()) {
                maxReachedLabel.setText(track.addBeat(new Instrument("low")));
                trackLabel.setText(track.trackString());
            }
        }
    }

    // EFFECTS: Plays sound if one of the hi-hat instrument buttons was pressed
    private void identifySoundButtonHiHat(ActionEvent e) {
        if (e.getSource().equals(openButton)) {
            drumsetApp.drumset.playOpenHiHat();
            if (track.getRecordingStatus()) {
                maxReachedLabel.setText(track.addBeat(new Instrument("open")));
                trackLabel.setText(track.trackString());
            }
        } else if (e.getSource().equals(closedButton)) {
            drumsetApp.drumset.playClosedHiHat();
            if (track.getRecordingStatus()) {
                maxReachedLabel.setText(track.addBeat(new Instrument("closed")));
                trackLabel.setText(track.trackString());
            }
        }
    }

    // EFFECTS: Performs appropriate action for whichever track control button was pressed
    private void identifyTrackButton(ActionEvent e) {

        try {
            identifySaveTrackButtons(e);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        if (e.getSource().equals(recordButton) && !track.getRecordingStatus()) {
            track.startRecording();
            recordingLabel.setText("◉ Recording");
        } else if (e.getSource().equals(stopButton) && track.getRecordingStatus()) {
            track.stopRecording();
            recordingLabel.setText("");
        } else if (e.getSource().equals(playButton) && !track.getRecordingStatus()) {
            track.playTrack();
        } else if (e.getSource().equals(clearButton)) {
            track.clearTrack();
            trackLabel.setText(track.trackString());
            maxReachedLabel.setText("");
        }
    }

    // EFFECTS: Saves and loads track depending on which button was pressed
    private void identifySaveTrackButtons(ActionEvent e) throws InterruptedException {
        Timer labelTimer;
        if (e.getSource().equals(saveButton)) {
            trackStoredLabel.setText("Saved track!");
            labelTimer = new Timer(2000, event -> trackStoredLabel.setText(""));
            drumsetApp.setTrack(track);
            drumsetApp.saveTrack();
            labelTimer.start();
        } else if (e.getSource().equals(loadButton)) {
            trackStoredLabel.setText("Loaded track!");
            labelTimer = new Timer(2000, event -> trackStoredLabel.setText(""));
            drumsetApp.loadTrack();
            track = drumsetApp.getTrack();
            trackLabel.setText(track.trackString());
            if (track.trackLength() >= track.getMaxTrackLength()) {
                maxReachedLabel.setText("Your track is full!");
            }
            labelTimer.start();
        }
    }

}
