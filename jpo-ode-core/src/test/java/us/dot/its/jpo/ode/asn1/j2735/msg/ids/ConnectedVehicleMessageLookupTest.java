/*******************************************************************************
 * Copyright 2018 572682
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package us.dot.its.jpo.ode.asn1.j2735.msg.ids;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;

import us.dot.its.jpo.ode.asn1.j2735.UnitTestHelper;

public class ConnectedVehicleMessageLookupTest {

	static final private boolean isDebugOutput = false;
	static final private String newLine = System.lineSeparator();
	
	private static final Logger log = Logger.getLogger(ConnectedVehicleMessageLookupTest.class);

	@BeforeClass
	public static void init() {
		UnitTestHelper.initLog4j(isDebugOutput);
	}

   //TODO open-ode
//	@Test
//	public void testGetMessageList() {
//		List<String> messages = ConnectedVehicleMessageLookup.getMessageList();
//		StringBuilder sb = new StringBuilder(newLine + "Message List");
//		messages.stream().forEach(m -> sb.append(newLine).append("    ").append(m));
//		log.debug(sb.toString());
//	}
//	
//	@Test
//	public void testLookupMessageByName() {
//		List<String> names = ConnectedVehicleMessageLookup.getMessageList();
//		names.stream().forEach(name -> {
//			log.debug("Looking up " + name);
//			AbstractData obj = ConnectedVehicleMessageLookup.lookupMessage(name);
//			assertNotNull(obj);
//			assertEquals(obj.getClass().getSimpleName(), name);
//		});
//	}

}
