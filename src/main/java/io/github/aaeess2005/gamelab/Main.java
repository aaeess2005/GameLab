package io.github.aaeess2005.gamelab;

import io.github.aaeess2005.gamelab.server.main.ServerMain;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger("Main");

    public static void main(String[] args) {
        OptionParser optionParser = new OptionParser();
        optionParser.allowsUnrecognizedOptions();
        optionParser.accepts("noguiserver");
        OptionSet optionSet = optionParser.parse(args);

        //启动GameLab启动器
        if(!optionSet.hasOptions()){
            new Launcher();
        }

        //判断是否启用无图形界面的服务端
        if (optionSet.has("noguiserver")) {
            logger.info("NoGUI server enable.");
            //TODO Server
        }
    }
}