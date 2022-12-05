package com.ttn.amc.demoProject.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.inject.Inject;
import java.util.Iterator;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CollectDataModel {
    @SlingObject
    ResourceResolver resourceResolver;
    @Inject
   private String path;

    public String getPath() {
        return resourceResolver.getResource("/content/Users").getPath();
    }

    public Iterator<Resource> getAllChildren() {
        return resourceResolver.getResource("/content/Users").listChildren();
    }
}
