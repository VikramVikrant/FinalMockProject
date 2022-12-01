package com.ttn.amc.demoProject.core.models;

import org.apache.jackrabbit.api.security.user.User;
import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Reference;

import javax.annotation.PostConstruct;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Header {
    @ValueMapValue
    @Default(values = "Bootcamp Blog")
    protected  String text;
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @SlingObject
    ResourceResolver resourceResolver;

    @ValueMapValue
    private String UserName;
    public String getUserName() {
        return UserName;
    }
    @PostConstruct
   public void init() throws LoginException, RepositoryException {
       Session session = resourceResolver.adaptTo(Session.class);
       String userId=session.getUserID();
       UserManager userManager = resourceResolver.adaptTo(UserManager.class);
       User user = (User) userManager.getAuthorizable(userId);
        UserName=user.toString();
    }
}
