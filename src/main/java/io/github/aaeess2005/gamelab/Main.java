package io.github.aaeess2005.gamelab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        //判断是否启用无图形界面的服务端
        if(args==null){
            if(args[0].equals("noguiserver")){
                logger.info("NoGUI server enable.");
            }
        }

        //启动GameLab启动器
        new Launcher();
    }
}