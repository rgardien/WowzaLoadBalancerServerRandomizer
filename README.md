# WowzaLoadBalancerServerRandomizer
The **WowzaLoadBalancerServerRandomizer** is a load balancer decision extension for Wowza which does a very simple job as in shuffling the list of servers. This is useful as an additional decision to configure to ensure that when all other decisions (eg bandwidth, or connections) are all equal (or zero) that there is still some "balancing" done. By default, Wowza returns always the first server when no decision can be made. This causes newly initialised servers/viewers to all end up on one server only at the start: unwanted! :)

## Prerequisites
Wowza Streaming Engine 4.0.0 or later is required.

## Installation and compilation
* Upload the .jar file to the Wowza lib folder.
* Add a custom property to your Server.xml or VHost.xml file (where you have configured the load balancer), the Name of the property is `loadbalanceServerProcessAddClasses`, the type is `String` and the Value is `com.wowza.plugin.rgardien.LoadBalancerServerRandomizer`.
* Add the decision **ServerExtensionRandomizer** to your `loadbalanceServerDecisionOrder` property at the beginning, before other decisions. This ensures that if all other decisions are equal, a random client is returned.
* Restart Wowza and enjoy!
