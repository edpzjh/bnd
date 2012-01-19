package aQute.bnd.make.metatype;

import java.util.*;

import aQute.bnd.annotation.metatype.*;
import aQute.bnd.service.*;
import aQute.lib.osgi.*;
import aQute.lib.osgi.Clazz.*;

/**
 * This class is responsible for meta type types. It is a plugin that can 
 * @author aqute
 *
 */
public class MetatypePlugin implements AnalyzerPlugin {

	public boolean analyzeJar(Analyzer analyzer) throws Exception {

		Map<String, Map<String, String>> map = analyzer.parseHeader(analyzer
				.getProperty(Constants.METATYPE));

		Jar jar = analyzer.getJar();
		for (String name : map.keySet()) {
			Collection<Clazz> metatypes = analyzer.getClasses("", QUERY.ANNOTATED.toString(),
					Meta.OCD.class.getName(), // 
					QUERY.NAMED.toString(), name //
					);
			for (Clazz c : metatypes) {
				jar.putResource("OSGI-INF/metatype/" + c.getFQN() + ".xml", new MetaTypeReader(c,
						analyzer));
			}
		}
		return false;
	}
}
