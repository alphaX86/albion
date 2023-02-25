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

public class albion {
    public static void main(String[] args) {
        System.out.println("-- ALBION --");
        if(args.length != 0) {
            System.err.println("In progress...");
        }
        else {
            var sim = new CloudSim();
            var brk0 = new DatacenterBrokerSimple(sim, "Round Robin");
            long ram = 10000;
            long storage = 10000;
            long bw = 10000;

            var host0 = new HostSimple(ram,bw,storage,List.of(new PeSimple(20000)));
            var dc0 = new DatacenterSimple(sim, List.of(host0));

            //Creates one VM to run applications.
            //Uses a CloudletSchedulerTimeShared by default to schedule Cloudlets
            var vm0 = new VmSimple(1000, 1);
            vm0.setRam(1000).setBw(1000).setSize(1000);

            //Creates Cloudlets that represent applications to be run inside a VM.
            //UtilizationModel defining the Cloudlets use only 50% of any resource all the time
            var utilizationModel = new UtilizationModelDynamic(0.5);
            var cloudlet0 = new CloudletSimple(10000, 1, utilizationModel);
            var cloudlet1 = new CloudletSimple(10000, 1, utilizationModel);
            var cloudletList = List.of(cloudlet0, cloudlet1);

            brk0.submitVmList(List.of(vm0));
            brk0.submitCloudletList(cloudletList);

            /*Starts the simulation and waits all cloudlets to be executed, automatically
            stopping when there is no more events to process.*/
            sim.start();

            /*Prints the results when the simulation is over
            (you can use your own code here to print what you want from this cloudlet list).*/
            new CloudletsTableBuilder(brk0.getCloudletFinishedList()).build();
                    }
    }
}
