package cn.xwj.testzsr2088;

import cn.xwj.serial.CRC16Tool;
import cn.xwj.serial.HexStrTool;
import cn.xwj.serial.SerialTool;
import gnu.io.SerialPort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class TestZsr2088Application {

    public static void main(String[] args) {
        SpringApplication.run(TestZsr2088Application.class, args);
    }



}
