package com.ttn.amc.demoProject.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import javax.jcr.*;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.version.VersionException;
import javax.servlet.Servlet;
import java.io.IOException;
@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
        "sling.servlet.paths=" + "/bin/submitdata" })
public class DataCollectServlet  extends SlingAllMethodsServlet{
    @Override
    protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws IOException {
        ResourceResolver resourceResolver = req.getResourceResolver();
        Resource resource = resourceResolver.getResource("/content/Users");
        //log.info("Resource is at path {}", resource.getPath());
       try{
           Node node = resource.adaptTo(Node.class);
           Node newNode = node.addNode(getNodeName(req,"NodeModel"), "nt:unstructured");

//            newNode.setProperty("name", "Demo NodeModel");
           newNode.setProperty("Fullname", getRequestParameter(req,"Fullname"));
           newNode.setProperty("age",getRequestParameter(req,"age"));
           newNode.setProperty("phoneNo",getRequestParameter(req,"phoneNo"));
           newNode.setProperty("dob",getRequestParameter(req,"dob"));

           resp.sendRedirect("/content/demoProject/us/en/form.html");
           resourceResolver.commit();
       } catch (LockException e) {
           throw new RuntimeException(e);
       } catch (ItemExistsException e) {
           throw new RuntimeException(e);
       } catch (ConstraintViolationException e) {
           throw new RuntimeException(e);
       } catch (ValueFormatException e) {
           throw new RuntimeException(e);
       } catch (PathNotFoundException e) {
           throw new RuntimeException(e);
       } catch (NoSuchNodeTypeException e) {
           throw new RuntimeException(e);
       } catch (VersionException e) {
           throw new RuntimeException(e);
       } catch (RepositoryException e) {
           throw new RuntimeException(e);
       }

    }

    public static String getRequestParameter(SlingHttpServletRequest request,String s) {
        String var= request.getParameter(s);
        return var;
    }

    public static String getNodeName(SlingHttpServletRequest request,String s) {

        String Phone= request.getParameter("phoneNo");

        String UserNodeName= Phone;
        return UserNodeName;
    }
}
