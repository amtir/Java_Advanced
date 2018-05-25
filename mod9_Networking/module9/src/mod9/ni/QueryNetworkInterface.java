package mod9.ni;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.apache.log4j.Logger;

public class QueryNetworkInterface {

	private static final Logger log4j = Logger.getLogger(QueryNetworkInterface.class.getName());

	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();

			NetworkInterface element = null;
			InetAddress address = null;

			while (ni.hasMoreElements()) {
				element = ni.nextElement();
				log4j.info("###*** Network Interface ***###");
				log4j.info(element.getDisplayName());

				Enumeration<InetAddress> address_list = element.getInetAddresses();
				while (address_list.hasMoreElements()) {
					address = address_list.nextElement();
					log4j.info("InetAddress --> " + address.getHostAddress());
				}

				log4j.info("Is up? : " + element.isUp());
				log4j.info("isPointToPoint? : " + element.isPointToPoint());

				log4j.info("Does this interface supports multicast? : " + element.supportsMulticast());

				byte[] mac = element.getHardwareAddress();
				System.out.println("Current MAC address : " + mac);
				if (mac != null) {

					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < mac.length; i++) {
						sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
					}
					System.out.println(sb.toString());
				}

			}
		} catch (SocketException e) {
			log4j.error("SocketException ", e);
		}
	}
}
