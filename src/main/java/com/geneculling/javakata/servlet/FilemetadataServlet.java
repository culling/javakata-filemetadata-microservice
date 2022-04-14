package com.geneculling.javakata.servlet;
//
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.StringWriter;

public class FilemetadataServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello World");
        response.flushBuffer();



//        VelocityEngine velocityEngine = new VelocityEngine();
//        velocityEngine.init();
//        VelocityContext context = new VelocityContext();
//        Template template = velocityEngine.getTemplate( "templates/hello.vm" );
//        StringWriter writer = new StringWriter();
//        template.merge( context, writer );
//
//        response.getWriter().write( writer.toString() );
//        response.flushBuffer();
    }

}
