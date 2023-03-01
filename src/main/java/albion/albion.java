package albion;

import java.util.List;

import org.cloudbus.cloudsim.brokers.DatacenterBrokerSimple;
import org.cloudbus.cloudsim.cloudlets.CloudletSimple;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.datacenters.DatacenterSimple;
import org.cloudbus.cloudsim.hosts.HostSimple;
import org.cloudbus.cloudsim.resources.Pe;
import org.cloudbus.cloudsim.resources.PeSimple;
import org.cloudbus.cloudsim.utilizationmodels.UtilizationModelDynamic;
import org.cloudbus.cloudsim.vms.VmSimple;
import org.cloudsimplus.builders.tables.CloudletsTableBuilder;

import albion.LoadBalancer.AntColony;
import albion.LoadBalancer.HoneyBee;
import albion.LoadBalancer.RoundRobin;

public class albion {
    public static void main(String[] args) {
        System.out.println("-- ALBION --");
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RED = "\u001B[31m";
  
        System.out.println(ANSI_RED + "Work is still in progress" + ANSI_RESET);
        if(args.length != 0) {
            if(args[0] == "Round Robin") {
                RoundRobin.main(null);
            }
            else if(args[0] == "Honey Bee") {
                HoneyBee.main(null);
            }
            else if(args[0] == "Ant Colony") {
                AntColony.main(null);
            }
        }
        else {
            System.out.println("In progress...");
        }
    }
}
