// a plugin to randomize Edge servers in a Wowza loadbalancer Origin/Edge scenario
// just compile to a .jar, add to the lib folder and add this one to the Server or VHost.xml as per the documentation
// then just add the ServerExtensionRandomizer to always return a random Edge server if all other decisions return more than one server in the end
package com.wowza.plugin.xxx;

import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.wowza.wms.application.WMSProperties; 
import com.wowza.wms.logging.WMSLoggerFactory;
import com.wowza.wms.plugin.loadbalancer.server.ILoadBalancerServerClient;
import com.wowza.wms.plugin.loadbalancer.server.ILoadBalancerServerDataExtension;
import com.wowza.wms.plugin.loadbalancer.utils.Logger;

public class LoadBalancerServerRandomizer implements ILoadBalancerServerDataExtension {
	private boolean debug = true;
	private boolean active = false;
	private final String COMPONENT_NAME = "ServerExtensionRandomizer"; 
	private Logger logger = null;
	
	public void init(WMSProperties props) {
	}
	
	public void setDebug(boolean debug) {
		this.debug = debug; 
	}
	
	public boolean getDebug() {
		return this.debug; 
	}
	
	public void setLogger(Logger log) {
		this.logger = log; 
	}
	
	public Logger getLogger() {
		return this.logger;
	}
	
	public void updateComponent(HashMap<String, String> data) {
	}
	
	public void setActive(boolean active) {
		this.active = active; 
	} 
	
	public boolean getActive() {
		return this.active; 
	}
	
	public String getComponentName() {
		return COMPONENT_NAME; 
	}

	@Override
	public List<ILoadBalancerServerClient> processClientInformation(List<ILoadBalancerServerClient> clientList,
			Map<String, String> params) {
		// The processClientInformation function is run each time a client request is made for load balancing.
		// clientList contains the clients available to be checked
		// params contains any custom parameters added by client requests when a request is received.
		
		if (!getActive()) 
			return clientList;
		
		// output clients
		List<ILoadBalancerServerClient> outputClients = new ArrayList<ILoadBalancerServerClient>();
		
		// random one from clientList
	    	Random rand = new Random();
	    	ILoadBalancerServerClient randomElement = clientList.get(rand.nextInt(clientList.size()));
		
		// add to output clients
		outputClients.add(randomElement);
		
		return outputClients; 
	}
}
