package com.ttn.amc.demoProject.core.models;

import com.ttn.amc.demoProject.core.services.Blogs;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PublishedBlogsModel {
    @Inject
    @Named("./publishedBlogsFieldList/")
    private List<PublishedBlogsField> publishedBlogsFieldList;

    public List<PublishedBlogsField> getPublishedBlogsFieldList() {
        return publishedBlogsFieldList;
    }
    @OSGiService
    Blogs blog;

     int val;

    public int getVal() {
        return blog.noOfBlogs();
    }
}
