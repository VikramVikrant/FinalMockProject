package com.ttn.amc.demoProject.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ListOfBlogsField {
    @Inject
    private String blogimage;
    @Inject
    private String caption;
    @Inject
    private String blogtitle;
    @Inject
    private String description;
    @Inject
    private String blogdate;

    @Inject
    private String contReading;

    public String getContReading() {
        return contReading;
    }

    public void setContReading(String contReading) {
        this.contReading = contReading;
    }

    public String getBlogimage() {
        return blogimage;
    }

    public void setBlogimage(String blogimage) {
        this.blogimage = blogimage;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getBlogtitle() {
        return blogtitle;
    }

    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBlogdate() {
        return blogdate;
    }

    public void setBlogdate(String blogdate) {
        this.blogdate = blogdate;
    }
}
