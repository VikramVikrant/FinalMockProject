package com.ttn.amc.demoProject.core.services.Impl;

import com.ttn.amc.demoProject.core.services.Blogs;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = Blogs.class)
@Designate(ocd = BlogsConfiguration.class)
public class BlogsImplementation implements Blogs{
    public int cntBlogs;
    @Activate
    public  void activate(BlogsConfiguration config)
    {
        cntBlogs=config.no_of_blogs();
    }

    @Override
    public int noOfBlogs() {
        return cntBlogs;
    }


}
