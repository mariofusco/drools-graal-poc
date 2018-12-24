package org.drools.project.model;

import org.drools.model.Model;
import org.drools.modelcompiler.CanonicalKieModuleModel;
import org.kie.api.builder.ReleaseId;
import org.drools.compiler.kproject.ReleaseIdImpl;

public class ProjectModel implements CanonicalKieModuleModel {

    public String getVersion() {
        return "7.16.0-SNAPSHOT";
    }

    public java.util.List<Model> getModels() {
        return java.util.Arrays.asList(new org.drools.simple.project.Rulesdefdd137fb1c44579a006fe172a17b7f());
    }

    public ReleaseId getReleaseId() {
        return new ReleaseIdImpl("org.drools", "drools-simple-project", "1.0-SNAPSHOT");
    }
}