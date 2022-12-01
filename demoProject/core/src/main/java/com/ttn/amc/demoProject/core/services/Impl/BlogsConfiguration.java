package com.ttn.amc.demoProject.core.services.Impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Blogs Configuration")
public @interface BlogsConfiguration {
    @AttributeDefinition(
            name = "noOfBlogs",
            description = "Enter the no of blogs",
            type = AttributeType.INTEGER
    )
    int no_of_blogs();
}
