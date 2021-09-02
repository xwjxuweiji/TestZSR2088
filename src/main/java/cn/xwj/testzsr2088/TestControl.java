package cn.xwj.testzsr2088;

import cn.xwj.serial.CRC16Tool;
import cn.xwj.serial.HexStrTool;
import cn.xwj.serial.SerialTool;
import gnu.io.SerialPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControl {

    @RequestMapping("/open")
    public String doOpen(){
        SerialPort serialPort = null;
        System.out.println("doOpen");
        try {
            String commName = "COM3";
            String bpsStr = "9600";
            int bps = Integer.parseInt(bpsStr);
            serialPort = SerialTool.openPort(commName, bps);
            String hexString = "64 10 00 14 00 01 02 00 01";
            byte[] bytes = HexStrTool.hexStringToBytes(hexString);
            String crcStr = CRC16Tool.getCRC3(bytes);
            byte[] data = HexStrTool.hexStringToBytes(hexString+crcStr);
            SerialTool.sendToPort(serialPort, data);
            return  "OK";
        } catch (Exception e2) {
            e2.printStackTrace();
            return  e2.getMessage();
        } finally {
            SerialTool.closePort(serialPort);
        }
    }

    @RequestMapping("/close")
    public String doClose(){
        System.out.println("doOpen");
        SerialPort serialPort = null;
        try {
            String commName = "COM3";
            String bpsStr = "9600";
            int bps = Integer.parseInt(bpsStr);
            serialPort = SerialTool.openPort(commName, bps);
            String hexString = "64 10 00 14 00 01 02 00 00";
            byte[] bytes = HexStrTool.hexStringToBytes(hexString);
            String crcStr = CRC16Tool.getCRC3(bytes);
            byte[] data = HexStrTool.hexStringToBytes(hexString+crcStr);
            SerialTool.sendToPort(serialPort, data);
            return  "OK";
        } catch (Exception e2) {
            return  e2.getMessage();
        } finally {
            SerialTool.closePort(serialPort);
        }
    }

    @RequestMapping("/hello")
    public String hello(String name){
        return "hello "+name;
    }
}
