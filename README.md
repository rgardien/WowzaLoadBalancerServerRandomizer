# WowzaLoadBalancerServerRandomizer
The **WowzaLoadBalancerServerRandomizer** is a load balancer decision extension for Wowza which does a very simple job as in randomizing the remaining list of servers to one server only. This is useful as an additional decision to configure to ensure that when all other decisions (eg bandwidth, or connections) are all equal (or zero) that there is still some "balancing" done. By default, Wowza returns always the first server when no decision can be made. This causes newly initialised servers/viewers to all end up on one server only at the start: unwanted! :)

## Prerequisites
Wowza Streaming Engine 4.0.0 or later is required.

## Usage
Define your own class name (replace xxx), and compile the source into a .jar.
Upload your .jar to the Wowza lib folder.
Add a custom variable **loadbalanceServerProcessAddClasses** to the VHosts or Server.xml file to initialise the module.
Add the decision **ServerExtensionRandomizer** to your list of decisions where you want it (probably at the end).
Restart Wowza and enjoy!
