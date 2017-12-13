/**
*@author Erlandson
*/

package webservice;

import java.util.Set;
import javax.ws.rs.core.Application;



@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(webservice.Estoque.class);
        resources.add(webservice.LoginResourse.class);
    }
    
}
