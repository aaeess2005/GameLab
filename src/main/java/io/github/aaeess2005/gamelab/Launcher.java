package io.github.aaeess2005.gamelab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher extends JFrame{
    private JPanel serverPanel,clientPanel;
    private JButton serverButton,clientButton;
    private JTextField serverIpField,clientIpField;
    private JTextField serverPortField,clientPortField;
    private JTextField clientGuiWidth;
    private JTextField clientGuiHeight;


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
        setLayout(new GridLayout(1,3));

        serverPanel=new JPanel();
        clientPanel=new JPanel();
        serverButton=new JButton("Start Server");
        clientButton=new JButton("Start Client");
        serverIpField=new JTextField("0.0.0.0");
        clientIpField=new JTextField("");
        serverPortField=new JTextField("10514");
        clientPortField=new JTextField("10514");
        clientGuiWidth=new JTextField("854");
        clientGuiHeight=new JTextField("480");

        serverPanel.setLayout(new FlowLayout());
        clientPanel.setLayout(new FlowLayout());

        add(serverPanel);
        add(new JSeparator());
        add(clientPanel);
        serverPanel.add(serverButton);
        clientPanel.add(clientButton);

        serverPanel.add(new JLabel("Host Name"));
        serverPanel.add(serverIpField);
        clientPanel.add(new JLabel("Host Name"));
        clientPanel.add(clientIpField);

        serverPanel.add(new JLabel("Port"));
        serverPanel.add(serverPortField);
        clientPanel.add(new JLabel("Port"));
        clientPanel.add(clientPortField);

        clientPanel.add(new JLabel("Width"));
        clientPanel.add(clientGuiWidth);

        clientPanel.add(new JLabel("Height"));
        clientPanel.add(clientGuiHeight);

        serverButton.setPreferredSize(new Dimension (200,30));
        clientButton.setPreferredSize(new Dimension (200,30));
        serverIpField.setPreferredSize(new Dimension (200,30));
        clientIpField.setPreferredSize(new Dimension (200,30));
        serverPortField.setPreferredSize(new Dimension (200,30));
        clientPortField.setPreferredSize(new Dimension (200,30));
        clientGuiWidth.setPreferredSize(new Dimension (50,30));
        clientGuiHeight.setPreferredSize(new Dimension (50,30));

        serverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test 514");
            }
        });
    }


}
