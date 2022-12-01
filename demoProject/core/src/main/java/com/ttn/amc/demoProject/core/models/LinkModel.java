package com.ttn.amc.demoProject.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinkModel {
    @Inject
    private List<LinkField> dataList;
    public List<LinkField> getDataList()
    {
        return dataList;
    }




}
