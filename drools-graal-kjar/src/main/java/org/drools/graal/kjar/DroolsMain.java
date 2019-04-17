package org.drools.graal.kjar;

import org.drools.simple.project.Person;
import org.drools.simple.project.Result;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsMain {

    public static void main( String[] args ) {
        KieContainer kcontainer = KieServices.get().newKieClasspathContainer();
        KieSession ksession = kcontainer.newKieSession();

        Result result = new Result();
        ksession.insert( result );
        ksession.insert(new Person(args[0], Integer.parseInt( args[1] )));

        ksession.fireAllRules();

        System.out.println(result);
    }
}
