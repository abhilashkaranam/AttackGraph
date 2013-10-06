import java.io.IOException;

import org.owasp.dependencycheck.Engine;
import org.owasp.dependencycheck.reporting.ReportGenerator;


public class CCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Engine engine = new Engine();
		engine.scan("./Dependency-lib/");
		 // an individual file or directory
		engine.analyzeDependencies();
		ReportGenerator r = new ReportGenerator("report name",engine.getDependencies(),engine.getAnalyzers());
		try {
			r.generateReports("./",ReportGenerator.Format.ALL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
