package sadowski.wojciech.myServiceManagement.device;

import org.springframework.stereotype.Component;

@Component
public class DeviceIdCreator {
    public static Long createId(Device device) {
        String catalogNumber = device.getCatalogNumber();
        String serialNumber = device.getSerialNumber();
        String id = catalogNumber + serialNumber;
        return Long.valueOf(id);
    }
}
