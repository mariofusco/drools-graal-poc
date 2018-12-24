package org.drools.graal.kjar;

import org.drools.simple.project.Person;
import org.drools.simple.project.Result;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class DroolsMain {

    public static void main( String[] args ) {
        KieContainer kcontainer = KieServices.get().newKieClasspathContainer();
        KieSession ksession = kcontainer.newKieSession();

        Person mark = new Person("Mark", 37);
        Person edson = new Person("Edson", 35);
        Person mario = new Person("Mario", 40);

        Result result = new Result();
        ksession.insert( result );
        FactHandle markFH = ksession.insert(mark);
        FactHandle edsonFH = ksession.insert(edson);
        FactHandle marioFH = ksession.insert(mario);

        ksession.fireAllRules();
        if (!"Mario is older than Mark".equals( result.getValue() )) {
            throw new IllegalStateException();
        }

        result.setValue( null );
        ksession.delete( marioFH );
        ksession.fireAllRules();
        if (result.getValue() != null) {
            throw new IllegalStateException();
        }

        mark.setAge( 34 );
        ksession.update( markFH, mark, "age" );

        ksession.fireAllRules();
        if (!"Edson is older than Mark".equals( result.getValue() )) {
            throw new IllegalStateException();
        }

        System.out.println("SUCCESS!");
    }
}
