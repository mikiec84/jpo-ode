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
package us.dot.its.jpo.ode.services.vsd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import us.dot.its.jpo.ode.OdeProperties;
import us.dot.its.jpo.ode.model.OdeBsmData;
import us.dot.its.jpo.ode.wrapper.MessageConsumer;
import us.dot.its.jpo.ode.wrapper.MessageProducer;

@Controller
public class BsmToVsdPackagerController {

   private static final Logger logger = LoggerFactory.getLogger(BsmToVsdPackagerController.class);

   @Autowired
   protected BsmToVsdPackagerController(OdeProperties odeProps) {
      super();

      String inputTopic = odeProps.getKafkaTopicFilteredOdeBsmJson();
      // String inputTopic = odeProps.getKafkaTopicOdeBsmJson();

      String outputTopic = odeProps.getKafkaTopicVsdPojo();

      if (odeProps.getDepositSanitizedBsmToSdc()) {
         logger.info("Converting {} records from topic {} and publishing to topic {} ",
               OdeBsmData.class.getSimpleName(), inputTopic, outputTopic);

         BsmToVsdPackager converter = new BsmToVsdPackager(
            MessageProducer.defaultByteArrayMessageProducer(
               odeProps.getKafkaBrokers(), odeProps.getKafkaProducerType(), 
               odeProps.getKafkaTopicsDisabledSet()), outputTopic);

         MessageConsumer<String, String> consumer = new MessageConsumer<String, String>(odeProps.getKafkaBrokers(),
               this.getClass().getSimpleName(), converter, MessageConsumer.SERIALIZATION_STRING_DESERIALIZER);

         consumer.setName(BsmToVsdPackager.class.getSimpleName());
         converter.start(consumer, inputTopic);
      } else {
         logger.warn("WARNING - VSD Kafka topic disabled, BSM-to-VSD packager not started.");
      }
   }
}
