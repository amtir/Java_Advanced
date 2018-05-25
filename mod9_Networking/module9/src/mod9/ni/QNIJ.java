package mod9.ni;

import java.net.*;
import java.util.*;

import org.apache.log4j.Logger;

import static java.lang.System.out;

public class QNIJ {
	
	private static final Logger log4j = Logger.getLogger(QueryNetworkInterface.class.getName());
	
    public static void main(String args[]) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets)) {
            displayInterfaceInformation(netint);
        }
    }

    static void displayInterfaceInformation(NetworkInterface netint) throws

    SocketException {
        log4j.info("Display name: " + netint.getDisplayName());
        log4j.info("Name: "+ netint.getName());
        
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();

        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            log4j.info("Name: "+ inetAddress);
        }

        List<InterfaceAddress> ias = netint.getInterfaceAddresses();

        Iterator<InterfaceAddress> iias = ias.iterator();
        while (iias.hasNext()) {
            InterfaceAddress ia = iias.next();

            log4j.info(" Interface Address");
            log4j.info("   Address: " + ia.getAddress());
            log4j.info("   Broadcast: " + ia.getBroadcast());
            log4j.info("  Prefix length: "
                               + ia.getNetworkPrefixLength());
        }

        Enumeration<NetworkInterface> subIfs = netint.getSubInterfaces();

        for (NetworkInterface subIf : Collections.list(subIfs)) {
            log4j.info("\tSub Interface Display name: " +  subIf.getDisplayName());
            
            log4j.info("\tSub Interface Name: " + subIf.getName());
        }
        log4j.info("Up? : " +  netint.isUp());
        log4j.info("Loopback? : " + netint.isLoopback());
        log4j.info("PointToPoint? : "+ netint.isPointToPoint());
        log4j.info("Supports multicast? : "+ netint.supportsMulticast());
        log4j.info("Virtual? : " + netint.isVirtual());
        log4j.info("Hardware address: " + Arrays.toString(netint.getHardwareAddress()));
        log4j.info("MTU: " + netint.getMTU());
        out.printf("\n");
        

    }

}


