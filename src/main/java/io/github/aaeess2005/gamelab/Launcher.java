package io.github.aaeess2005.gamelab;

import javax.swing.*;
import java.awt.*;

public class Launcher extends JFrame{
    private JPanel serverPanel,clientPanel;
    private JButton serverButton,clientButton;
    private JTextField serverIpField,clientIpField;
    private JTextField serverPortField,clientPortField;
    private JTextField serverGuiWidthField,clientGuiWidth;
    private JTextField serverGuiHeightField,clientGuiHeight;


    public Launcher(){
        initFrame();
    }

    private void initFrame(){
        String title=new StringBuffer()
                .append("GameLab Launcher  (")
                .append(SharedConstants.versionName)
                .append(")")
                .toString();

        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640,480);
        setLocationRelativeTo(null);
        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        setLayout(new FlowLayout());

        serverPanel=new JPanel();
        clientPanel=new JPanel();
        serverButton=new JButton("Start Server");
        clientButton=new JButton("Start Client");

        serverPanel.setLayout(new FlowLayout());

        add(serverPanel);
        add(clientPanel);
        serverPanel.add(serverButton);
        clientPanel.add(clientButton);
    }
}
