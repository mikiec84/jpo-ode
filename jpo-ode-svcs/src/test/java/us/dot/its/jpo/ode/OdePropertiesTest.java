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
package us.dot.its.jpo.ode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.env.Environment;

import groovy.lang.MissingPropertyException;
import mockit.Capturing;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import us.dot.its.jpo.ode.util.CommonUtils;

public class OdePropertiesTest {

   @Tested
   OdeProperties testOdeProperties;
   @Injectable
   Environment mockEnv;

   @Capturing
   CommonUtils capturingCommonUtils;

   @Before
   public void setup() {
      new Expectations() {
         {
            CommonUtils.getEnvironmentVariable("DOCKER_HOST_IP");
            result = "testKafkaBrokers";
         }
      };
   }

   @Test
   public void testInit() {
      new Expectations() {
         {
         }
      };
      try {
         new OdeProperties();
      } catch (Exception e) {
         fail("Unexpected exception: " + e);
      }
   }

   @Test
   public void initShouldCatchUnknownHostException(@Mocked final InetAddress mockInetAddress) {
      try {
         new Expectations() {
            {
               InetAddress.getLocalHost();
               result = new UnknownHostException("testException123");
            }
         };
      } catch (Exception e) {
         fail("Unexpected exception in expectations block: " + e);
      }

      try {
         new OdeProperties().initialize();
      } catch (Exception e) {
         fail("Unexpected exception in init: " + e);
      }
   }

   @Test
   public void missingDockerHostIpShouldThrowException(@Mocked final InetAddress mockInetAddress) {
      try {
         new Expectations() {
            {
               CommonUtils.getEnvironmentVariable("DOCKER_HOST_IP");
               result = null;
            }
         };
      } catch (Exception e) {
         fail("Unexpected exception in expectations block: " + e);
      }

      try {
         new OdeProperties().initialize();
      } catch (Exception e) {
         assertTrue(e instanceof MissingPropertyException);
      }
   }

   @Test
   public void testSettersAndGetters() {

      String testDdsCasPassword = "testDdsCasPassword123456";
      String testDdsCasUrl = "testDdsCasUrl123456";
      String testDdsCasUsername = "testDdsCasUsername123456";
      String testDdsWebsocketUrl = "testDdsWebsocketUrl123456";
      String testKafkaBrokers = "testKafkaBrokers123456";
      String testKafkaProducerType = "testKafkaProducerType123456";
      String testPluginsLocations = "testpluginsLocations123456";
      String testUploadLocationObuLog = "testuploadLocationObuLog123456";
      String testUploadLocationRoot = "testUploadLocationRoot123456";
      String testSdcIp = "testSdcIp";
      int testSdcPort = 123;
      String testExternalIpv4 = "testExternalIpv4";
      String testExternalIpv6 = "testExternalIpv6";
      String testKafkaTopicEncodedIsd = "testKafkaTopicEncodedIsd";
      int testVsdDepositorPort = 321;
      int testIsdDepositorPort = 322;
      int testIsdReceiverPort = 323;
      int testBsmReceiverPort = 324;
      int testBsmBufferSize = 10;
      boolean testDepositSanitizedBsmToSdc = true;
      int testServiceRespExpirationSeconds = 12;
      int testServiceResponseBufferSize = 13;
      int testVsdTrustport = 14;
      int testIsdTrustPort = 15;
      int testDataReceiptExpirationSeconds = 16;
      int testMessagesUntilTrustReestablished = 17;
      int testDataReceiptBufferSize = 18;
      String testCaCertPath = "testCaCertPath";
      String testSelfCertPath = "testSelfCertPath";
      String testSelfPrivateKeyReconstructionFilePath = "testSelfPrivateKeyReconstructionFilePath";
      String testSelfSigningPrivateKeyFilePath = "testSelfSigningPrivateKeyFilePath";
      int testIsdBufferSize = 19;
      String testKafkaTopicBsmFilteredJson = "testKafkaTopicBsmFilteredJson";
      int testVsdBufferSize = 20;
      int testVsdReceiverPort = 21;
      boolean testVerboseJson = true;
      int testRsuSrmSlots = 22;
      int testTrustRetries = 23;
      String testKafkaTopicEncodedVsd = "testKafkaTopicEncodedVsd";
      String testKafkaTopicOdeBsmPojo = "testKafkaTopicOdeBsmPojo";
      String testKafkaTopicOdeBsmJson = "testKafkaTopicOdeBsmJson";
      String testVersion = "1.1.0-SNAPSHOT";
      int testImportProcessorBufferSize = 83;

      String[] testKafkaTopicsDisabled = new String[] { "testKafkaTopicsDisabled0" };
      Set<String> testKafkaTopicsDisabledSet = new HashSet<>();
      testKafkaTopicsDisabledSet.add("testKafkaTopicsDisabledSet0");

      String testKafkaTopicAsn1DecoderInput = "testKafkaTopicAsn1DecoderInput";
      String testKafkaTopicAsn1DecoderOutput = "testKafkaTopicAsn1DecoderOutput";
      String testKafkaTopicAsn1EncoderInput = "testKafkaTopicAsn1EncoderInput";
      String testKafkaTopicAsn1EncoderOutput = "testKafkaTopicAsn1EncoderOutput";
      String testKafkaTopicOdeTimPojo = "testKafkaTopicOdeTimPojo";
      String testKafkaTopicOdeDNMsgPojo = "testKafkaTopicOdeDNMsgPojo";
      String testKafkaTopicOdeDNMsgJson = "testKafkaTopicOdeDNMsgJson";
      String testKafkaTopicOdeTimJson = "testKafkaTopicOdeTimJson";
      String testKafkaTopicOdeBsmDuringEventPojo = "testKafkaTopicOdeBsmDuringEventPojo";
      String testKafkaTopicOdeBsmRxPojo = "testKafkaTopicOdeBsmRxPojo";
      String testKafkaTopicOdeBsmTxPojo = "testKafkaTopicOdeBsmTxPojo";
      String testKafkaTopicOdeTimRxJson = "testKafkaTopicOdeTimRxJson";
      String testKafkaTopicOdeTimBroadcastPojo = "testKafkaTopicOdeTimBroadcastPojo";
      String testKafkaTopicOdeTimBroadcastJson = "testKafkaTopicOdeTimBroadcastJson";
      String testKafkaTopicJ2735TimBroadcastJson = "testKafkaTopicJ2735TimBroadcastJson";
      String testKafkaTopicFilteredOdeTimJson = "testKafkaTopicFilteredOdeTimJson";
      String testKafkaTopicDriverAlertJson = "testKafkaTopicDriverAlertJson";

      Integer testFileWatcherPeriod = 5;
      String testSecuritySvcsSignatureUri = "testSecuritySvcsSignatureUri";
      String testRsuUsername = "testRsuUsername";
      String testRsuPassword = "testRsuPassword";

      testOdeProperties.setDdsCasPassword(testDdsCasPassword);
      testOdeProperties.setDdsCasUrl(testDdsCasUrl);
      testOdeProperties.setDdsCasUsername(testDdsCasUsername);
      testOdeProperties.setDdsWebsocketUrl(testDdsWebsocketUrl);
      testOdeProperties.setEnv(mockEnv);
      testOdeProperties.setEnvironment(mockEnv);
      testOdeProperties.setKafkaBrokers(testKafkaBrokers);
      testOdeProperties.setKafkaProducerType(testKafkaProducerType);
      testOdeProperties.setPluginsLocations(testPluginsLocations);
      testOdeProperties.setUploadLocationObuLog(testUploadLocationObuLog);
      testOdeProperties.setUploadLocationRoot(testUploadLocationRoot);
      testOdeProperties.setSdcIp(testSdcIp);
      testOdeProperties.setSdcPort(testSdcPort);
      testOdeProperties.setExternalIpv4(testExternalIpv4);
      testOdeProperties.setExternalIpv6(testExternalIpv6);
      testOdeProperties.setKafkaTopicIsdPojo(testKafkaTopicEncodedIsd);
      testOdeProperties.setVsdDepositorPort(testVsdDepositorPort);
      testOdeProperties.setIsdDepositorPort(testIsdDepositorPort);
      testOdeProperties.setIsdReceiverPort(testIsdReceiverPort);
      testOdeProperties.setBsmReceiverPort(testBsmReceiverPort);
      testOdeProperties.setBsmBufferSize(testBsmBufferSize);
      testOdeProperties.setDepositSanitizedBsmToSdc(testDepositSanitizedBsmToSdc);
      testOdeProperties.setServiceRespExpirationSeconds(testServiceRespExpirationSeconds);
      testOdeProperties.setServiceResponseBufferSize(testServiceResponseBufferSize);
      testOdeProperties.setVsdTrustport(testVsdTrustport);
      testOdeProperties.setIsdTrustPort(testIsdTrustPort);
      testOdeProperties.setDataReceiptExpirationSeconds(testDataReceiptExpirationSeconds);
      testOdeProperties.setMessagesUntilTrustReestablished(testMessagesUntilTrustReestablished);
      testOdeProperties.setDataReceiptBufferSize(testDataReceiptBufferSize);
      testOdeProperties.setCaCertPath(testCaCertPath);
      testOdeProperties.setSelfCertPath(testSelfCertPath);
      testOdeProperties.setSelfPrivateKeyReconstructionFilePath(testSelfPrivateKeyReconstructionFilePath);
      testOdeProperties.setSelfSigningPrivateKeyFilePath(testSelfSigningPrivateKeyFilePath);
      testOdeProperties.setIsdBufferSize(testIsdBufferSize);
      testOdeProperties.setKafkaTopicFilteredOdeBsmJson(testKafkaTopicBsmFilteredJson);
      testOdeProperties.setVsdBufferSize(testVsdBufferSize);
      testOdeProperties.setVsdReceiverPort(testVsdReceiverPort);
      testOdeProperties.setVerboseJson(testVerboseJson);
      testOdeProperties.setRsuSrmSlots(testRsuSrmSlots);
      testOdeProperties.setTrustRetries(testTrustRetries);
      testOdeProperties.setKafkaTopicVsdPojo(testKafkaTopicEncodedVsd);
      testOdeProperties.setKafkaTopicOdeBsmPojo(testKafkaTopicOdeBsmPojo);
      testOdeProperties.setKafkaTopicOdeBsmJson(testKafkaTopicOdeBsmJson);
      testOdeProperties.setVersion(testVersion);
      testOdeProperties.setImportProcessorBufferSize(testImportProcessorBufferSize);
      testOdeProperties.setKafkaTopicsDisabled(testKafkaTopicsDisabled);
      testOdeProperties.setKafkaTopicsDisabledSet(testKafkaTopicsDisabledSet);

      testOdeProperties.setKafkaTopicAsn1DecoderInput(testKafkaTopicAsn1DecoderInput);
      testOdeProperties.setKafkaTopicAsn1DecoderOutput(testKafkaTopicAsn1DecoderOutput);
      testOdeProperties.setKafkaTopicAsn1EncoderInput(testKafkaTopicAsn1EncoderInput);
      testOdeProperties.setKafkaTopicAsn1EncoderOutput(testKafkaTopicAsn1EncoderOutput);
      testOdeProperties.setKafkaTopicOdeTimPojo(testKafkaTopicOdeTimPojo);
      testOdeProperties.setKafkaTopicOdeDNMsgPojo(testKafkaTopicOdeDNMsgPojo);
      testOdeProperties.setKafkaTopicOdeDNMsgJson(testKafkaTopicOdeDNMsgJson);
      testOdeProperties.setKafkaTopicOdeTimJson(testKafkaTopicOdeTimJson);
      testOdeProperties.setKafkaTopicOdeBsmDuringEventPojo(testKafkaTopicOdeBsmDuringEventPojo);
      testOdeProperties.setKafkaTopicOdeBsmRxPojo(testKafkaTopicOdeBsmRxPojo);
      testOdeProperties.setKafkaTopicOdeBsmTxPojo(testKafkaTopicOdeBsmTxPojo);
      testOdeProperties.setKafkaTopicOdeTimRxJson(testKafkaTopicOdeTimRxJson);
      testOdeProperties.setKafkaTopicOdeTimBroadcastPojo(testKafkaTopicOdeTimBroadcastPojo);
      testOdeProperties.setKafkaTopicOdeTimBroadcastJson(testKafkaTopicOdeTimBroadcastJson);
      testOdeProperties.setKafkaTopicJ2735TimBroadcastJson(testKafkaTopicJ2735TimBroadcastJson);
      testOdeProperties.setKafkaTopicFilteredOdeTimJson(testKafkaTopicFilteredOdeTimJson);
      testOdeProperties.setKafkaTopicDriverAlertJson(testKafkaTopicDriverAlertJson);

      testOdeProperties.setFileWatcherPeriod(testFileWatcherPeriod);
      testOdeProperties.setSecuritySvcsSignatureUri(testSecuritySvcsSignatureUri);
      testOdeProperties.setRsuUsername(testRsuUsername);
      testOdeProperties.setRsuPassword(testRsuPassword);

      assertEquals("Incorrect testDdsCasPassword", testDdsCasPassword, testOdeProperties.getDdsCasPassword());
      assertEquals("Incorrect testDdsCasUrl", testDdsCasUrl, testOdeProperties.getDdsCasUrl());
      assertEquals("Incorrect testDdsCasUsername", testDdsCasUsername, testOdeProperties.getDdsCasUsername());
      assertEquals("Incorrect testDdsWebsocketUrl", testDdsWebsocketUrl, testOdeProperties.getDdsWebsocketUrl());
      assertEquals("Incorrect testEnv", mockEnv, testOdeProperties.getEnv());
      assertEquals("Incorrect testKafkaBrokers", testKafkaBrokers, testOdeProperties.getKafkaBrokers());
      assertEquals("Incorrect testKafkaProducerType", testKafkaProducerType, testOdeProperties.getKafkaProducerType());
      assertEquals("Incorrect testpluginsLocations", testPluginsLocations, testOdeProperties.getPluginsLocations());
      assertEquals("Incorrect testUploadLocationObuLog", testUploadLocationObuLog,
            testOdeProperties.getUploadLocationObuLog());
      assertEquals("Incorrect testUploadLocationRoot", testUploadLocationRoot,
            testOdeProperties.getUploadLocationRoot());
      assertEquals("Incorrect testSdcIp", testSdcIp, testOdeProperties.getSdcIp());
      assertEquals("Incorrect testSdcPort", testSdcPort, testOdeProperties.getSdcPort());
      assertEquals("Incorrect testExternalIpv4", testExternalIpv4, testOdeProperties.getExternalIpv4());
      assertEquals("Incorrect testExternalIpv6", testExternalIpv6, testOdeProperties.getExternalIpv6());
      assertEquals("Incorrect testKafkaTopicEncodedIsd", testKafkaTopicEncodedIsd,
            testOdeProperties.getKafkaTopicIsdPojo());
      assertEquals("Incorrect testVsdDepositorPort", testVsdDepositorPort, testOdeProperties.getVsdDepositorPort());
      assertEquals("Incorrect testIsdDepositorPort", testIsdDepositorPort, testOdeProperties.getIsdDepositorPort());
      assertEquals("Incorrect testIsdReceiverPort", testIsdReceiverPort, testOdeProperties.getIsdReceiverPort());
      assertEquals("Incorrect testBsmReceiverPort", testBsmReceiverPort, testOdeProperties.getBsmReceiverPort());
      assertEquals("Incorrect testBsmBufferSize", testBsmBufferSize, testOdeProperties.getBsmBufferSize());
      assertEquals("Incorrect testDepositSanitizedBsmToSdc", testDepositSanitizedBsmToSdc,
            testOdeProperties.getDepositSanitizedBsmToSdc());
      assertEquals("Incorrect testServiceRespExpirationSeconds", testServiceRespExpirationSeconds,
            testOdeProperties.getServiceRespExpirationSeconds());
      assertEquals("Incorrect testServiceResponseBufferSize", testServiceResponseBufferSize,
            testOdeProperties.getServiceResponseBufferSize());
      assertEquals("Incorrect testVsdTrustport", testVsdTrustport, testOdeProperties.getVsdTrustport());
      assertEquals("Incorrect testIsdTrustPort", testIsdTrustPort, testOdeProperties.getIsdTrustPort());
      assertEquals("Incorrect testDataReceiptExpirationSeconds", testDataReceiptExpirationSeconds,
            testOdeProperties.getDataReceiptExpirationSeconds());
      assertEquals("Incorrect testMessagesUntilTrustReestablished", testMessagesUntilTrustReestablished,
            testOdeProperties.getMessagesUntilTrustReestablished());
      assertEquals("Incorrect testDataReceiptBufferSize", testDataReceiptBufferSize,
            testOdeProperties.getDataReceiptBufferSize());
      assertEquals("Incorrect testCaCertPath", testCaCertPath, testOdeProperties.getCaCertPath());
      assertEquals("Incorrect testSelfCertPath", testSelfCertPath, testOdeProperties.getSelfCertPath());
      assertEquals("Incorrect testSelfPrivateKeyReconstructionFilePath", testSelfPrivateKeyReconstructionFilePath,
            testOdeProperties.getSelfPrivateKeyReconstructionFilePath());
      assertEquals("Incorrect testSelfSigningPrivateKeyFilePath", testSelfSigningPrivateKeyFilePath,
            testOdeProperties.getSelfSigningPrivateKeyFilePath());
      assertEquals("Incorrect testIsdBufferSize", testIsdBufferSize, testOdeProperties.getIsdBufferSize());
      assertEquals("Incorrect testKafkaTopicBsmFilteredJson", testKafkaTopicBsmFilteredJson,
            testOdeProperties.getKafkaTopicFilteredOdeBsmJson());
      assertEquals("Incorrect testVsdBufferSize", testVsdBufferSize, testOdeProperties.getVsdBufferSize());
      assertEquals("Incorrect testVsdReceiverPort", testVsdReceiverPort, testOdeProperties.getVsdReceiverPort());
      assertEquals("Incorrect testVerboseJson", testVerboseJson, testOdeProperties.getVerboseJson());
      assertEquals("Incorrect testRsuSrmSlots", testRsuSrmSlots, testOdeProperties.getRsuSrmSlots());
      assertEquals("Incorrect testTrustRetries", testTrustRetries, testOdeProperties.getTrustRetries());
      assertEquals("Incorrect testKafkaTopicEncodedVsd", testKafkaTopicEncodedVsd,
            testOdeProperties.getKafkaTopicVsdPojo());
      assertEquals("Incorrect testKafkaTopicOdeBsmPojo", testKafkaTopicOdeBsmPojo,
            testOdeProperties.getKafkaTopicOdeBsmPojo());
      assertEquals("Incorrect testKafkaTopicOdeBsmJson", testKafkaTopicOdeBsmJson,
            testOdeProperties.getKafkaTopicOdeBsmJson());
      assertEquals("Incorrect testVersion", testVersion, testOdeProperties.getVersion());
      assertEquals("Incorrect testImportProcessorBufferSize", testImportProcessorBufferSize,
            testOdeProperties.getImportProcessorBufferSize());
      assertEquals("Incorrect testKafkaTopicsDisabled", testKafkaTopicsDisabled[0],
            testOdeProperties.getKafkaTopicsDisabled()[0]);
      assertTrue("Incorrect testKafkaTopicsDisabledSet",
            testOdeProperties.getKafkaTopicsDisabledSet().contains("testKafkaTopicsDisabledSet0"));

      assertEquals("Incorrect testKafkaTopicAsn1DecoderInput", testKafkaTopicAsn1DecoderInput,
            testOdeProperties.getKafkaTopicAsn1DecoderInput());
      assertEquals("Incorrect testKafkaTopicAsn1DecoderOutput", testKafkaTopicAsn1DecoderOutput,
            testOdeProperties.getKafkaTopicAsn1DecoderOutput());
      assertEquals("Incorrect testKafkaTopicAsn1EncoderInput", testKafkaTopicAsn1EncoderInput,
            testOdeProperties.getKafkaTopicAsn1EncoderInput());
      assertEquals("Incorrect testKafkaTopicAsn1EncoderOutput", testKafkaTopicAsn1EncoderOutput,
            testOdeProperties.getKafkaTopicAsn1EncoderOutput());
      assertEquals("Incorrect testKafkaTopicOdeTimPojo", testKafkaTopicOdeTimPojo,
            testOdeProperties.getKafkaTopicOdeTimPojo());
      assertEquals("Incorrect testKafkaTopicOdeDNMsgPojo", testKafkaTopicOdeDNMsgPojo,
            testOdeProperties.getKafkaTopicOdeDNMsgPojo());
      assertEquals("Incorrect testKafkaTopicOdeDNMsgJson", testKafkaTopicOdeDNMsgJson,
            testOdeProperties.getKafkaTopicOdeDNMsgJson());
      assertEquals("Incorrect testKafkaTopicOdeTimJson", testKafkaTopicOdeTimJson,
            testOdeProperties.getKafkaTopicOdeTimJson());
      assertEquals("Incorrect testKafkaTopicOdeBsmDuringEventPojo", testKafkaTopicOdeBsmDuringEventPojo,
            testOdeProperties.getKafkaTopicOdeBsmDuringEventPojo());
      assertEquals("Incorrect testKafkaTopicOdeBsmRxPojo", testKafkaTopicOdeBsmRxPojo,
            testOdeProperties.getKafkaTopicOdeBsmRxPojo());
      assertEquals("Incorrect testKafkaTopicOdeBsmTxPojo", testKafkaTopicOdeBsmTxPojo,
            testOdeProperties.getKafkaTopicOdeBsmTxPojo());
      assertEquals("Incorrect testKafkaTopicOdeTimRxJson", testKafkaTopicOdeTimRxJson,
            testOdeProperties.getKafkaTopicOdeTimRxJson());
      assertEquals("Incorrect testKafkaTopicOdeTimBroadcastPojo", testKafkaTopicOdeTimBroadcastPojo,
            testOdeProperties.getKafkaTopicOdeTimBroadcastPojo());
      assertEquals("Incorrect testKafkaTopicOdeTimBroadcastJson", testKafkaTopicOdeTimBroadcastJson,
            testOdeProperties.getKafkaTopicOdeTimBroadcastJson());
      assertEquals("Incorrect testKafkaTopicJ2735TimBroadcastJson", testKafkaTopicJ2735TimBroadcastJson,
            testOdeProperties.getKafkaTopicJ2735TimBroadcastJson());
      assertEquals("Incorrect testKafkaTopicFilteredOdeTimJson", testKafkaTopicFilteredOdeTimJson,
            testOdeProperties.getKafkaTopicFilteredOdeTimJson());
      assertEquals("Incorrect testKafkaTopicDriverAlertJson", testKafkaTopicDriverAlertJson,
            testOdeProperties.getKafkaTopicDriverAlertJson());

      assertEquals("Incorrect testFileWatcherPeriod", testFileWatcherPeriod, testOdeProperties.getFileWatcherPeriod());
      assertEquals("Incorrect testSecuritySvcsSignatureUri", testSecuritySvcsSignatureUri,
            testOdeProperties.getSecuritySvcsSignatureUri());
      assertEquals("Incorrect testRsuUsername", testRsuUsername, testOdeProperties.getRsuUsername());
      assertEquals("Incorrect RsuPassword", testRsuPassword, testOdeProperties.getRsuPassword());

      OdeProperties.getJpoOdeGroupId();
      testOdeProperties.getHostId();
      testOdeProperties.getProperty("testProperty");
      testOdeProperties.getProperty("testProperty", 5);
      testOdeProperties.getProperty("testProperty", "testDefaultValue");
      testOdeProperties.getUploadLocations();
   }

}
