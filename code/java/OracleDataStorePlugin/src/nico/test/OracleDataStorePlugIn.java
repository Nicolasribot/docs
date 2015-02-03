/*
 * created on 		04.10.2005
 * last modified: 	05.10.2005 comments added
 * 
 * author:			sstein
 * 
 **/
package nico.test;

import com.vividsolutions.jump.datastore.DataStoreDriver;
import com.vividsolutions.jump.workbench.plugin.AbstractPlugIn;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;
import java.sql.Driver;
import nico.test.oracle.OracleDataStoreDriver;
import static nico.test.oracle.OracleDataStoreDriver.JDBC_CLASS;

/**
 * @description: testplugin for jump<p>
 * shows hello world - window in Jump
 *
 * @author sstein
 *
 */
public class OracleDataStorePlugIn extends AbstractPlugIn {

    public OracleDataStorePlugIn() {
        // empty constructor
    }

    public void initialize(PlugInContext context) throws Exception {
        // registers the OracleDataStore driver to the system:
        try {
            Driver driver = (Driver) Class.forName(JDBC_CLASS).newInstance();
            context.getWorkbenchContext().getRegistry().createEntry(DataStoreDriver.REGISTRY_CLASSIFICATION,
                new OracleDataStoreDriver());
            System.out.println("Oracle Spatial Data Store added");
        } catch (Exception e) {
            // TODO: replace by log ?
            System.out.println("oracle driver not found: " + e.toString() + ". Oracle Spatial Data Store NOT added");
        }

    }
}
