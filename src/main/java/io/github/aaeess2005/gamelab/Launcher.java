package io.github.aaeess2005.gamelab;

import io.github.aaeess2005.gamelab.client.main.ClientMain;
import io.github.aaeess2005.gamelab.server.main.ServerMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.PortUnreachableException;
import java.net.UnknownHostException;

public class Launcher extends JFrame {
    private static final Logger logger = LoggerFactory.getLogger(Launcher.class);
    private JPanel serverPanel, clientPanel;
    private JButton serverButton, clientButton;
    private JTextField serverIpField;
    private JTextField serverPortField;
    private JTextField clientGuiWidth;
    private JTextField clientGuiHeight;


    public Launcher() {
        initFrame();
    }

    private void initFrame() {
        String title = "GameLab Launcher  " + SharedConstants.versionName;

        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        setLayout(new GridLayout(1, 3));

        serverPanel = new JPanel();
        clientPanel = new JPanel();
        serverButton = new JButton("Start Server");
        clientButton = new JButton("Start Client");
        serverIpField = new JTextField("0.0.0.0");
        serverPortField = new JTextField("10514");
        clientGuiWidth = new JTextField("854");
        clientGuiHeight = new JTextField("480");

        serverPanel.setLayout(new FlowLayout());
        clientPanel.setLayout(new FlowLayout());

        add(serverPanel);
        add(new JLabel("GameLab", JLabel.CENTER));
        add(clientPanel);
        serverPanel.add(serverButton);
        clientPanel.add(clientButton);

        serverPanel.add(new JLabel("Host Name"));
        serverPanel.add(serverIpField);

        serverPanel.add(new JLabel("Port"));
        serverPanel.add(serverPortField);

        clientPanel.add(new JLabel("Width"));
        clientPanel.add(clientGuiWidth);

        clientPanel.add(new JLabel("Height"));
        clientPanel.add(clientGuiHeight);

        serverButton.setPreferredSize(new Dimension(200, 30));
        clientButton.setPreferredSize(new Dimension(200, 30));
        serverIpField.setPreferredSize(new Dimension(200, 30));
        serverPortField.setPreferredSize(new Dimension(200, 30));
        clientGuiWidth.setPreferredSize(new Dimension(50, 30));
        clientGuiHeight.setPreferredSize(new Dimension(50, 30));

        serverButton.addActionListener(e -> {
            try {
                InetAddress hostname = InetAddress.getByName(serverIpField.getText());
                int port = Integer.parseInt(serverPortField.getText());
                new Thread(new ServerMain(hostname, port)).start();
            } catch (UnknownHostException uhe) {
                logger.warn("Unknown host: " + uhe);
            } catch (NumberFormatException nfe) {
                logger.warn("The entered port is Not a Number.");
            }
        });

        clientButton.addActionListener(e -> {
            try {
                int width = Integer.parseInt(clientGuiWidth.getText());
                int height = Integer.parseInt(clientGuiHeight.getText());
                new Thread(new ClientMain(width, height)).start();
            } catch (NumberFormatException nfe) {
                logger.warn("The entered width or height is Not a Number.");
            }
        });
    }


}
