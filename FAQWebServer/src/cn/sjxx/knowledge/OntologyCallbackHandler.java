
/**
 * OntologyCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package cn.sjxx.knowledge;

    /**
     *  OntologyCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class OntologyCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public OntologyCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public OntologyCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for updateLimit_ method
            * override this method for handling normal response from updateLimit_ operation
            */
           public void receiveResultupdateLimit_(
                    cn.sjxx.knowledge.UpdateLimit_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateLimit_ operation
           */
            public void receiveErrorupdateLimit_(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteDescriptionOntologyObject method
            * override this method for handling normal response from deleteDescriptionOntologyObject operation
            */
           public void receiveResultdeleteDescriptionOntologyObject(
                    cn.sjxx.knowledge.DeleteDescriptionOntologyObjectResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteDescriptionOntologyObject operation
           */
            public void receiveErrordeleteDescriptionOntologyObject(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateLimit method
            * override this method for handling normal response from updateLimit operation
            */
           public void receiveResultupdateLimit(
                    cn.sjxx.knowledge.UpdateLimitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateLimit operation
           */
            public void receiveErrorupdateLimit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for moveOntologyFile method
            * override this method for handling normal response from moveOntologyFile operation
            */
           public void receiveResultmoveOntologyFile(
                    cn.sjxx.knowledge.MoveOntologyFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from moveOntologyFile operation
           */
            public void receiveErrormoveOntologyFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOntologyFileList method
            * override this method for handling normal response from getOntologyFileList operation
            */
           public void receiveResultgetOntologyFileList(
                    cn.sjxx.knowledge.GetOntologyFileListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOntologyFileList operation
           */
            public void receiveErrorgetOntologyFileList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addOWLFAQType method
            * override this method for handling normal response from addOWLFAQType operation
            */
           public void receiveResultaddOWLFAQType(
                    cn.sjxx.knowledge.AddOWLFAQTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addOWLFAQType operation
           */
            public void receiveErroraddOWLFAQType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addDescriptionOntologyObject_ method
            * override this method for handling normal response from addDescriptionOntologyObject_ operation
            */
           public void receiveResultaddDescriptionOntologyObject_(
                    cn.sjxx.knowledge.AddDescriptionOntologyObject_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addDescriptionOntologyObject_ operation
           */
            public void receiveErroraddDescriptionOntologyObject_(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteLimit_ method
            * override this method for handling normal response from deleteLimit_ operation
            */
           public void receiveResultdeleteLimit_(
                    cn.sjxx.knowledge.DeleteLimit_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteLimit_ operation
           */
            public void receiveErrordeleteLimit_(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setIndividualObjectProPerty method
            * override this method for handling normal response from setIndividualObjectProPerty operation
            */
           public void receiveResultsetIndividualObjectProPerty(
                    cn.sjxx.knowledge.SetIndividualObjectProPertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setIndividualObjectProPerty operation
           */
            public void receiveErrorsetIndividualObjectProPerty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFaqIndividualByClass method
            * override this method for handling normal response from getFaqIndividualByClass operation
            */
           public void receiveResultgetFaqIndividualByClass(
                    cn.sjxx.knowledge.GetFaqIndividualByClassResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFaqIndividualByClass operation
           */
            public void receiveErrorgetFaqIndividualByClass(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOntologyDataType method
            * override this method for handling normal response from getOntologyDataType operation
            */
           public void receiveResultgetOntologyDataType(
                    cn.sjxx.knowledge.GetOntologyDataTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOntologyDataType operation
           */
            public void receiveErrorgetOntologyDataType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOntologyOWLString method
            * override this method for handling normal response from getOntologyOWLString operation
            */
           public void receiveResultgetOntologyOWLString(
                    cn.sjxx.knowledge.GetOntologyOWLStringResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOntologyOWLString operation
           */
            public void receiveErrorgetOntologyOWLString(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteOWLFaqDataProperty method
            * override this method for handling normal response from deleteOWLFaqDataProperty operation
            */
           public void receiveResultdeleteOWLFaqDataProperty(
                    cn.sjxx.knowledge.DeleteOWLFaqDataPropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteOWLFaqDataProperty operation
           */
            public void receiveErrordeleteOWLFaqDataProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getIndividualDataProperty method
            * override this method for handling normal response from getIndividualDataProperty operation
            */
           public void receiveResultgetIndividualDataProperty(
                    cn.sjxx.knowledge.GetIndividualDataPropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getIndividualDataProperty operation
           */
            public void receiveErrorgetIndividualDataProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createFaqIndividual method
            * override this method for handling normal response from createFaqIndividual operation
            */
           public void receiveResultcreateFaqIndividual(
                    cn.sjxx.knowledge.CreateFaqIndividualResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createFaqIndividual operation
           */
            public void receiveErrorcreateFaqIndividual(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateIndividualObjectProPerty method
            * override this method for handling normal response from updateIndividualObjectProPerty operation
            */
           public void receiveResultupdateIndividualObjectProPerty(
                    cn.sjxx.knowledge.UpdateIndividualObjectProPertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateIndividualObjectProPerty operation
           */
            public void receiveErrorupdateIndividualObjectProPerty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteOWLFAQType method
            * override this method for handling normal response from deleteOWLFAQType operation
            */
           public void receiveResultdeleteOWLFAQType(
                    cn.sjxx.knowledge.DeleteOWLFAQTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteOWLFAQType operation
           */
            public void receiveErrordeleteOWLFAQType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for initBuildFaqDB method
            * override this method for handling normal response from initBuildFaqDB operation
            */
           public void receiveResultinitBuildFaqDB(
                    cn.sjxx.knowledge.InitBuildFaqDBResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from initBuildFaqDB operation
           */
            public void receiveErrorinitBuildFaqDB(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteLimit method
            * override this method for handling normal response from deleteLimit operation
            */
           public void receiveResultdeleteLimit(
                    cn.sjxx.knowledge.DeleteLimitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteLimit operation
           */
            public void receiveErrordeleteLimit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOntologyIsOthersSyn method
            * override this method for handling normal response from getOntologyIsOthersSyn operation
            */
           public void receiveResultgetOntologyIsOthersSyn(
                    cn.sjxx.knowledge.GetOntologyIsOthersSynResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOntologyIsOthersSyn operation
           */
            public void receiveErrorgetOntologyIsOthersSyn(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setIndividualDataProperty method
            * override this method for handling normal response from setIndividualDataProperty operation
            */
           public void receiveResultsetIndividualDataProperty(
                    cn.sjxx.knowledge.SetIndividualDataPropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setIndividualDataProperty operation
           */
            public void receiveErrorsetIndividualDataProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateIndividualType method
            * override this method for handling normal response from updateIndividualType operation
            */
           public void receiveResultupdateIndividualType(
                    cn.sjxx.knowledge.UpdateIndividualTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateIndividualType operation
           */
            public void receiveErrorupdateIndividualType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMyWordSet method
            * override this method for handling normal response from getMyWordSet operation
            */
           public void receiveResultgetMyWordSet(
                    cn.sjxx.knowledge.GetMyWordSetResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMyWordSet operation
           */
            public void receiveErrorgetMyWordSet(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteIndividualType_ method
            * override this method for handling normal response from deleteIndividualType_ operation
            */
           public void receiveResultdeleteIndividualType_(
                    cn.sjxx.knowledge.DeleteIndividualType_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteIndividualType_ operation
           */
            public void receiveErrordeleteIndividualType_(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUserAnnotationsType method
            * override this method for handling normal response from getUserAnnotationsType operation
            */
           public void receiveResultgetUserAnnotationsType(
                    cn.sjxx.knowledge.GetUserAnnotationsTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUserAnnotationsType operation
           */
            public void receiveErrorgetUserAnnotationsType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteIndividualType method
            * override this method for handling normal response from deleteIndividualType operation
            */
           public void receiveResultdeleteIndividualType(
                    cn.sjxx.knowledge.DeleteIndividualTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteIndividualType operation
           */
            public void receiveErrordeleteIndividualType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setLimit_ method
            * override this method for handling normal response from setLimit_ operation
            */
           public void receiveResultsetLimit_(
                    cn.sjxx.knowledge.SetLimit_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setLimit_ operation
           */
            public void receiveErrorsetLimit_(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for closeOntologyFile method
            * override this method for handling normal response from closeOntologyFile operation
            */
           public void receiveResultcloseOntologyFile(
                    cn.sjxx.knowledge.CloseOntologyFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from closeOntologyFile operation
           */
            public void receiveErrorcloseOntologyFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createNewOntologyFile method
            * override this method for handling normal response from createNewOntologyFile operation
            */
           public void receiveResultcreateNewOntologyFile(
                    cn.sjxx.knowledge.CreateNewOntologyFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createNewOntologyFile operation
           */
            public void receiveErrorcreateNewOntologyFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCharacteristics method
            * override this method for handling normal response from getCharacteristics operation
            */
           public void receiveResultgetCharacteristics(
                    cn.sjxx.knowledge.GetCharacteristicsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCharacteristics operation
           */
            public void receiveErrorgetCharacteristics(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addDescriptionOntologyObject method
            * override this method for handling normal response from addDescriptionOntologyObject operation
            */
           public void receiveResultaddDescriptionOntologyObject(
                    cn.sjxx.knowledge.AddDescriptionOntologyObjectResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addDescriptionOntologyObject operation
           */
            public void receiveErroraddDescriptionOntologyObject(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setLimit method
            * override this method for handling normal response from setLimit operation
            */
           public void receiveResultsetLimit(
                    cn.sjxx.knowledge.SetLimitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setLimit operation
           */
            public void receiveErrorsetLimit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getIndividuals method
            * override this method for handling normal response from getIndividuals operation
            */
           public void receiveResultgetIndividuals(
                    cn.sjxx.knowledge.GetIndividualsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getIndividuals operation
           */
            public void receiveErrorgetIndividuals(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteIndividualObjectProPerty method
            * override this method for handling normal response from deleteIndividualObjectProPerty operation
            */
           public void receiveResultdeleteIndividualObjectProPerty(
                    cn.sjxx.knowledge.DeleteIndividualObjectProPertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteIndividualObjectProPerty operation
           */
            public void receiveErrordeleteIndividualObjectProPerty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createOntologyDirectory method
            * override this method for handling normal response from createOntologyDirectory operation
            */
           public void receiveResultcreateOntologyDirectory(
                    cn.sjxx.knowledge.CreateOntologyDirectoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createOntologyDirectory operation
           */
            public void receiveErrorcreateOntologyDirectory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for multilayerReasoning method
            * override this method for handling normal response from multilayerReasoning operation
            */
           public void receiveResultmultilayerReasoning(
                    cn.sjxx.knowledge.MultilayerReasoningResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from multilayerReasoning operation
           */
            public void receiveErrormultilayerReasoning(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteAnnotations method
            * override this method for handling normal response from deleteAnnotations operation
            */
           public void receiveResultdeleteAnnotations(
                    cn.sjxx.knowledge.DeleteAnnotationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteAnnotations operation
           */
            public void receiveErrordeleteAnnotations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllFaqIndividualAndQ method
            * override this method for handling normal response from getAllFaqIndividualAndQ operation
            */
           public void receiveResultgetAllFaqIndividualAndQ(
                    cn.sjxx.knowledge.GetAllFaqIndividualAndQResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllFaqIndividualAndQ operation
           */
            public void receiveErrorgetAllFaqIndividualAndQ(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBaseXml method
            * override this method for handling normal response from getBaseXml operation
            */
           public void receiveResultgetBaseXml(
                    cn.sjxx.knowledge.GetBaseXmlResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBaseXml operation
           */
            public void receiveErrorgetBaseXml(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for interactReasoning method
            * override this method for handling normal response from interactReasoning operation
            */
           public void receiveResultinteractReasoning(
                    cn.sjxx.knowledge.InteractReasoningResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from interactReasoning operation
           */
            public void receiveErrorinteractReasoning(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addAnnotations method
            * override this method for handling normal response from addAnnotations operation
            */
           public void receiveResultaddAnnotations(
                    cn.sjxx.knowledge.AddAnnotationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addAnnotations operation
           */
            public void receiveErroraddAnnotations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAnnotations method
            * override this method for handling normal response from getAnnotations operation
            */
           public void receiveResultgetAnnotations(
                    cn.sjxx.knowledge.GetAnnotationsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAnnotations operation
           */
            public void receiveErrorgetAnnotations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getIndividualType method
            * override this method for handling normal response from getIndividualType operation
            */
           public void receiveResultgetIndividualType(
                    cn.sjxx.knowledge.GetIndividualTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getIndividualType operation
           */
            public void receiveErrorgetIndividualType(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for getFAQContext method
            * override this method for handling normal response from getFAQContext operation
            */
           public void receiveResultgetFAQContext(
                    cn.sjxx.knowledge.GetFAQContextResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFAQContext operation
           */
            public void receiveErrorgetFAQContext(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFaqReasonerTreeXml method
            * override this method for handling normal response from getFaqReasonerTreeXml operation
            */
           public void receiveResultgetFaqReasonerTreeXml(
                    cn.sjxx.knowledge.GetFaqReasonerTreeXmlResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFaqReasonerTreeXml operation
           */
            public void receiveErrorgetFaqReasonerTreeXml(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteDescriptionOntologyObject_ method
            * override this method for handling normal response from deleteDescriptionOntologyObject_ operation
            */
           public void receiveResultdeleteDescriptionOntologyObject_(
                    cn.sjxx.knowledge.DeleteDescriptionOntologyObject_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteDescriptionOntologyObject_ operation
           */
            public void receiveErrordeleteDescriptionOntologyObject_(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBasicInformation method
            * override this method for handling normal response from getBasicInformation operation
            */
           public void receiveResultgetBasicInformation(
                    cn.sjxx.knowledge.GetBasicInformationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBasicInformation operation
           */
            public void receiveErrorgetBasicInformation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for login method
            * override this method for handling normal response from login operation
            */
           public void receiveResultlogin(
                    cn.sjxx.knowledge.LoginResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from login operation
           */
            public void receiveErrorlogin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNamedClassIndividual method
            * override this method for handling normal response from getNamedClassIndividual operation
            */
           public void receiveResultgetNamedClassIndividual(
                    cn.sjxx.knowledge.GetNamedClassIndividualResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNamedClassIndividual operation
           */
            public void receiveErrorgetNamedClassIndividual(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllFaqIndividual method
            * override this method for handling normal response from getAllFaqIndividual operation
            */
           public void receiveResultgetAllFaqIndividual(
                    cn.sjxx.knowledge.GetAllFaqIndividualResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllFaqIndividual operation
           */
            public void receiveErrorgetAllFaqIndividual(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for renameOntologyObject method
            * override this method for handling normal response from renameOntologyObject operation
            */
           public void receiveResultrenameOntologyObject(
                    cn.sjxx.knowledge.RenameOntologyObjectResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from renameOntologyObject operation
           */
            public void receiveErrorrenameOntologyObject(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for openOntologyFile method
            * override this method for handling normal response from openOntologyFile operation
            */
           public void receiveResultopenOntologyFile(
                    cn.sjxx.knowledge.OpenOntologyFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from openOntologyFile operation
           */
            public void receiveErroropenOntologyFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addOWLFaqDataProperty method
            * override this method for handling normal response from addOWLFaqDataProperty operation
            */
           public void receiveResultaddOWLFaqDataProperty(
                    cn.sjxx.knowledge.AddOWLFaqDataPropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addOWLFaqDataProperty operation
           */
            public void receiveErroraddOWLFaqDataProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for reBuildFAQ method
            * override this method for handling normal response from reBuildFAQ operation
            */
           public void receiveResultreBuildFAQ(
                    cn.sjxx.knowledge.ReBuildFAQResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from reBuildFAQ operation
           */
            public void receiveErrorreBuildFAQ(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for updateDescriptionOntologyObject method
            * override this method for handling normal response from updateDescriptionOntologyObject operation
            */
           public void receiveResultupdateDescriptionOntologyObject(
                    cn.sjxx.knowledge.UpdateDescriptionOntologyObjectResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateDescriptionOntologyObject operation
           */
            public void receiveErrorupdateDescriptionOntologyObject(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteOntologyDirectory method
            * override this method for handling normal response from deleteOntologyDirectory operation
            */
           public void receiveResultdeleteOntologyDirectory(
                    cn.sjxx.knowledge.DeleteOntologyDirectoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteOntologyDirectory operation
           */
            public void receiveErrordeleteOntologyDirectory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOntologyNamesFromMySQL method
            * override this method for handling normal response from getOntologyNamesFromMySQL operation
            */
           public void receiveResultgetOntologyNamesFromMySQL(
                    cn.sjxx.knowledge.GetOntologyNamesFromMySQLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOntologyNamesFromMySQL operation
           */
            public void receiveErrorgetOntologyNamesFromMySQL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteOntologyFile method
            * override this method for handling normal response from deleteOntologyFile operation
            */
           public void receiveResultdeleteOntologyFile(
                    cn.sjxx.knowledge.DeleteOntologyFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteOntologyFile operation
           */
            public void receiveErrordeleteOntologyFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addOntologyObject method
            * override this method for handling normal response from addOntologyObject operation
            */
           public void receiveResultaddOntologyObject(
                    cn.sjxx.knowledge.AddOntologyObjectResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addOntologyObject operation
           */
            public void receiveErroraddOntologyObject(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for renameOntologyDirectory method
            * override this method for handling normal response from renameOntologyDirectory operation
            */
           public void receiveResultrenameOntologyDirectory(
                    cn.sjxx.knowledge.RenameOntologyDirectoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from renameOntologyDirectory operation
           */
            public void receiveErrorrenameOntologyDirectory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateIndividualDataProperty method
            * override this method for handling normal response from updateIndividualDataProperty operation
            */
           public void receiveResultupdateIndividualDataProperty(
                    cn.sjxx.knowledge.UpdateIndividualDataPropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateIndividualDataProperty operation
           */
            public void receiveErrorupdateIndividualDataProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBaseNameSpeaceUrl method
            * override this method for handling normal response from getBaseNameSpeaceUrl operation
            */
           public void receiveResultgetBaseNameSpeaceUrl(
                    cn.sjxx.knowledge.GetBaseNameSpeaceUrlResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBaseNameSpeaceUrl operation
           */
            public void receiveErrorgetBaseNameSpeaceUrl(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for openOntologyFromDB method
            * override this method for handling normal response from openOntologyFromDB operation
            */
           public void receiveResultopenOntologyFromDB(
                    cn.sjxx.knowledge.OpenOntologyFromDBResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from openOntologyFromDB operation
           */
            public void receiveErroropenOntologyFromDB(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteOntologyFromDB method
            * override this method for handling normal response from deleteOntologyFromDB operation
            */
           public void receiveResultdeleteOntologyFromDB(
                    cn.sjxx.knowledge.DeleteOntologyFromDBResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteOntologyFromDB operation
           */
            public void receiveErrordeleteOntologyFromDB(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOntoBaseURL method
            * override this method for handling normal response from getOntoBaseURL operation
            */
           public void receiveResultgetOntoBaseURL(
                    cn.sjxx.knowledge.GetOntoBaseURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOntoBaseURL operation
           */
            public void receiveErrorgetOntoBaseURL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteIndividualDataProperty method
            * override this method for handling normal response from deleteIndividualDataProperty operation
            */
           public void receiveResultdeleteIndividualDataProperty(
                    cn.sjxx.knowledge.DeleteIndividualDataPropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteIndividualDataProperty operation
           */
            public void receiveErrordeleteIndividualDataProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setCharacteristics method
            * override this method for handling normal response from setCharacteristics operation
            */
           public void receiveResultsetCharacteristics(
                    cn.sjxx.knowledge.SetCharacteristicsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setCharacteristics operation
           */
            public void receiveErrorsetCharacteristics(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for simpleReasoning method
            * override this method for handling normal response from simpleReasoning operation
            */
           public void receiveResultsimpleReasoning(
                    cn.sjxx.knowledge.SimpleReasoningResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from simpleReasoning operation
           */
            public void receiveErrorsimpleReasoning(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addObjectByEquivalent method
            * override this method for handling normal response from addObjectByEquivalent operation
            */
           public void receiveResultaddObjectByEquivalent(
                    cn.sjxx.knowledge.AddObjectByEquivalentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addObjectByEquivalent operation
           */
            public void receiveErroraddObjectByEquivalent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAnnotationsType method
            * override this method for handling normal response from getAnnotationsType operation
            */
           public void receiveResultgetAnnotationsType(
                    cn.sjxx.knowledge.GetAnnotationsTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAnnotationsType operation
           */
            public void receiveErrorgetAnnotationsType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getIndividualObjectProperty method
            * override this method for handling normal response from getIndividualObjectProperty operation
            */
           public void receiveResultgetIndividualObjectProperty(
                    cn.sjxx.knowledge.GetIndividualObjectPropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getIndividualObjectProperty operation
           */
            public void receiveErrorgetIndividualObjectProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRDFType method
            * override this method for handling normal response from getRDFType operation
            */
           public void receiveResultgetRDFType(
                    cn.sjxx.knowledge.GetRDFTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRDFType operation
           */
            public void receiveErrorgetRDFType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createNewOntologyByDB method
            * override this method for handling normal response from createNewOntologyByDB operation
            */
           public void receiveResultcreateNewOntologyByDB(
                    cn.sjxx.knowledge.CreateNewOntologyByDBResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createNewOntologyByDB operation
           */
            public void receiveErrorcreateNewOntologyByDB(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateDescriptionOntologyObject_ method
            * override this method for handling normal response from updateDescriptionOntologyObject_ operation
            */
           public void receiveResultupdateDescriptionOntologyObject_(
                    cn.sjxx.knowledge.UpdateDescriptionOntologyObject_Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateDescriptionOntologyObject_ operation
           */
            public void receiveErrorupdateDescriptionOntologyObject_(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for reNameFaqIndividual method
            * override this method for handling normal response from reNameFaqIndividual operation
            */
           public void receiveResultreNameFaqIndividual(
                    cn.sjxx.knowledge.ReNameFaqIndividualResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from reNameFaqIndividual operation
           */
            public void receiveErrorreNameFaqIndividual(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUserReasonerTreeXml method
            * override this method for handling normal response from getUserReasonerTreeXml operation
            */
           public void receiveResultgetUserReasonerTreeXml(
                    cn.sjxx.knowledge.GetUserReasonerTreeXmlResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUserReasonerTreeXml operation
           */
            public void receiveErrorgetUserReasonerTreeXml(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFaqDataProperty method
            * override this method for handling normal response from getFaqDataProperty operation
            */
           public void receiveResultgetFaqDataProperty(
                    cn.sjxx.knowledge.GetFaqDataPropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFaqDataProperty operation
           */
            public void receiveErrorgetFaqDataProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for saveOntologyFile method
            * override this method for handling normal response from saveOntologyFile operation
            */
           public void receiveResultsaveOntologyFile(
                    cn.sjxx.knowledge.SaveOntologyFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from saveOntologyFile operation
           */
            public void receiveErrorsaveOntologyFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOntologyDescriptionObject method
            * override this method for handling normal response from getOntologyDescriptionObject operation
            */
           public void receiveResultgetOntologyDescriptionObject(
                    cn.sjxx.knowledge.GetOntologyDescriptionObjectResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOntologyDescriptionObject operation
           */
            public void receiveErrorgetOntologyDescriptionObject(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOntologyDirList method
            * override this method for handling normal response from getOntologyDirList operation
            */
           public void receiveResultgetOntologyDirList(
                    cn.sjxx.knowledge.GetOntologyDirListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOntologyDirList operation
           */
            public void receiveErrorgetOntologyDirList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addUserAnnotation method
            * override this method for handling normal response from addUserAnnotation operation
            */
           public void receiveResultaddUserAnnotation(
                    cn.sjxx.knowledge.AddUserAnnotationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addUserAnnotation operation
           */
            public void receiveErroraddUserAnnotation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteCharacteristics method
            * override this method for handling normal response from deleteCharacteristics operation
            */
           public void receiveResultdeleteCharacteristics(
                    cn.sjxx.knowledge.DeleteCharacteristicsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteCharacteristics operation
           */
            public void receiveErrordeleteCharacteristics(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteOntologyObject method
            * override this method for handling normal response from deleteOntologyObject operation
            */
           public void receiveResultdeleteOntologyObject(
                    cn.sjxx.knowledge.DeleteOntologyObjectResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteOntologyObject operation
           */
            public void receiveErrordeleteOntologyObject(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addIndividualType method
            * override this method for handling normal response from addIndividualType operation
            */
           public void receiveResultaddIndividualType(
                    cn.sjxx.knowledge.AddIndividualTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addIndividualType operation
           */
            public void receiveErroraddIndividualType(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                


    }
    