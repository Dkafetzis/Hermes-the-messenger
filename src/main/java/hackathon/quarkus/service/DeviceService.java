package hackathon.quarkus.service;

import hackathon.quarkus.model.Device;

import java.util.ArrayList;
import java.util.List;

public class DeviceService {

    public static List<Device> initList(){
        List<Device> list=new ArrayList<>();
        list.add(new Device("Hello","FirstTopic"));
        list.add(new Device("Hello2","SecondTopic"));
        return list;
    }
}
