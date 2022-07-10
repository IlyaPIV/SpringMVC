package my.springcourse.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * замена для applicationContextMVC.xml
 */

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        /*      эквивалент следующему коду в web.xml:
        *       <servlet-mapping>
        *           <servlet-name>dispatcher</servlet-name>
        *           <url-pattern>/</url-pattern>
        *       </servlet-mapping>
         */
        return new String[] {"/"};
    }
}
