package org.daniel;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@RequestScoped
public class GreetingsResource {

    @Inject
    @Claim(standard = Claims.sub)
    //JsonWebToken token;
    String sub;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("Subscriber")
    public String hello() {
        //return token.getIssuer();
        return sub;
    }
}