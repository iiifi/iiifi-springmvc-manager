/**
 *
 */
package com.iiifi.framework.server.manager.common.supcan.freeform;

import com.iiifi.framework.server.manager.common.supcan.common.Common;
import com.iiifi.framework.server.manager.common.supcan.common.properties.Properties;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("FreeForm")
public class FreeForm extends Common {

	public FreeForm() {
		super();
	}
	
	public FreeForm(Properties properties) {
		this();
		this.properties = properties;
	}
	
}
