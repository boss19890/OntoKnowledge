
/**
 * UpdateDescriptionOntologyObject_.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package cn.sjxx.knowledge;
            

            /**
            *  UpdateDescriptionOntologyObject_ bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class UpdateDescriptionOntologyObject_
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://knowledge.sjxx.cn",
                "updateDescriptionOntologyObject_",
                "ns1");

            

                        /**
                        * field for Token
                        */

                        
                                    protected java.lang.String localToken ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTokenTracker = false ;

                           public boolean isTokenSpecified(){
                               return localTokenTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getToken(){
                               return localToken;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Token
                               */
                               public void setToken(java.lang.String param){
                            localTokenTracker = true;
                                   
                                            this.localToken=param;
                                    

                               }
                            

                        /**
                        * field for ObjectName
                        */

                        
                                    protected java.lang.String localObjectName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localObjectNameTracker = false ;

                           public boolean isObjectNameSpecified(){
                               return localObjectNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getObjectName(){
                               return localObjectName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ObjectName
                               */
                               public void setObjectName(java.lang.String param){
                            localObjectNameTracker = true;
                                   
                                            this.localObjectName=param;
                                    

                               }
                            

                        /**
                        * field for OldProperty_description
                        */

                        
                                    protected java.lang.String localOldProperty_description ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOldProperty_descriptionTracker = false ;

                           public boolean isOldProperty_descriptionSpecified(){
                               return localOldProperty_descriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOldProperty_description(){
                               return localOldProperty_description;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OldProperty_description
                               */
                               public void setOldProperty_description(java.lang.String param){
                            localOldProperty_descriptionTracker = true;
                                   
                                            this.localOldProperty_description=param;
                                    

                               }
                            

                        /**
                        * field for OldValues_description
                        */

                        
                                    protected java.lang.String localOldValues_description ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOldValues_descriptionTracker = false ;

                           public boolean isOldValues_descriptionSpecified(){
                               return localOldValues_descriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOldValues_description(){
                               return localOldValues_description;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OldValues_description
                               */
                               public void setOldValues_description(java.lang.String param){
                            localOldValues_descriptionTracker = true;
                                   
                                            this.localOldValues_description=param;
                                    

                               }
                            

                        /**
                        * field for NewProperty_description
                        */

                        
                                    protected java.lang.String localNewProperty_description ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNewProperty_descriptionTracker = false ;

                           public boolean isNewProperty_descriptionSpecified(){
                               return localNewProperty_descriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNewProperty_description(){
                               return localNewProperty_description;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NewProperty_description
                               */
                               public void setNewProperty_description(java.lang.String param){
                            localNewProperty_descriptionTracker = true;
                                   
                                            this.localNewProperty_description=param;
                                    

                               }
                            

                        /**
                        * field for NewValues_description
                        */

                        
                                    protected java.lang.String localNewValues_description ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNewValues_descriptionTracker = false ;

                           public boolean isNewValues_descriptionSpecified(){
                               return localNewValues_descriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNewValues_description(){
                               return localNewValues_description;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NewValues_description
                               */
                               public void setNewValues_description(java.lang.String param){
                            localNewValues_descriptionTracker = true;
                                   
                                            this.localNewValues_description=param;
                                    

                               }
                            

                        /**
                        * field for OldProperty_descriptionType
                        */

                        
                                    protected int localOldProperty_descriptionType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOldProperty_descriptionTypeTracker = false ;

                           public boolean isOldProperty_descriptionTypeSpecified(){
                               return localOldProperty_descriptionTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getOldProperty_descriptionType(){
                               return localOldProperty_descriptionType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OldProperty_descriptionType
                               */
                               public void setOldProperty_descriptionType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localOldProperty_descriptionTypeTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localOldProperty_descriptionType=param;
                                    

                               }
                            

                        /**
                        * field for OldValues_descriptionType
                        */

                        
                                    protected int localOldValues_descriptionType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOldValues_descriptionTypeTracker = false ;

                           public boolean isOldValues_descriptionTypeSpecified(){
                               return localOldValues_descriptionTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getOldValues_descriptionType(){
                               return localOldValues_descriptionType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OldValues_descriptionType
                               */
                               public void setOldValues_descriptionType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localOldValues_descriptionTypeTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localOldValues_descriptionType=param;
                                    

                               }
                            

                        /**
                        * field for NewProperty_descriptionType
                        */

                        
                                    protected int localNewProperty_descriptionType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNewProperty_descriptionTypeTracker = false ;

                           public boolean isNewProperty_descriptionTypeSpecified(){
                               return localNewProperty_descriptionTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getNewProperty_descriptionType(){
                               return localNewProperty_descriptionType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NewProperty_descriptionType
                               */
                               public void setNewProperty_descriptionType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localNewProperty_descriptionTypeTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localNewProperty_descriptionType=param;
                                    

                               }
                            

                        /**
                        * field for NewValues_descriptionType
                        */

                        
                                    protected int localNewValues_descriptionType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNewValues_descriptionTypeTracker = false ;

                           public boolean isNewValues_descriptionTypeSpecified(){
                               return localNewValues_descriptionTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getNewValues_descriptionType(){
                               return localNewValues_descriptionType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NewValues_descriptionType
                               */
                               public void setNewValues_descriptionType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localNewValues_descriptionTypeTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localNewValues_descriptionType=param;
                                    

                               }
                            

                        /**
                        * field for OldCardinalityType
                        */

                        
                                    protected int localOldCardinalityType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOldCardinalityTypeTracker = false ;

                           public boolean isOldCardinalityTypeSpecified(){
                               return localOldCardinalityTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getOldCardinalityType(){
                               return localOldCardinalityType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OldCardinalityType
                               */
                               public void setOldCardinalityType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localOldCardinalityTypeTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localOldCardinalityType=param;
                                    

                               }
                            

                        /**
                        * field for OldCardinalityNum
                        */

                        
                                    protected int localOldCardinalityNum ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOldCardinalityNumTracker = false ;

                           public boolean isOldCardinalityNumSpecified(){
                               return localOldCardinalityNumTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getOldCardinalityNum(){
                               return localOldCardinalityNum;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OldCardinalityNum
                               */
                               public void setOldCardinalityNum(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localOldCardinalityNumTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localOldCardinalityNum=param;
                                    

                               }
                            

                        /**
                        * field for NewCardinalityType
                        */

                        
                                    protected int localNewCardinalityType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNewCardinalityTypeTracker = false ;

                           public boolean isNewCardinalityTypeSpecified(){
                               return localNewCardinalityTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getNewCardinalityType(){
                               return localNewCardinalityType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NewCardinalityType
                               */
                               public void setNewCardinalityType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localNewCardinalityTypeTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localNewCardinalityType=param;
                                    

                               }
                            

                        /**
                        * field for NewCardinalityNum
                        */

                        
                                    protected int localNewCardinalityNum ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNewCardinalityNumTracker = false ;

                           public boolean isNewCardinalityNumSpecified(){
                               return localNewCardinalityNumTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getNewCardinalityNum(){
                               return localNewCardinalityNum;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NewCardinalityNum
                               */
                               public void setNewCardinalityNum(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localNewCardinalityNumTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localNewCardinalityNum=param;
                                    

                               }
                            

                        /**
                        * field for DescriptionType
                        */

                        
                                    protected int localDescriptionType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDescriptionTypeTracker = false ;

                           public boolean isDescriptionTypeSpecified(){
                               return localDescriptionTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getDescriptionType(){
                               return localDescriptionType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DescriptionType
                               */
                               public void setDescriptionType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localDescriptionTypeTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localDescriptionType=param;
                                    

                               }
                            

     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME);
               return factory.createOMElement(dataSource,MY_QNAME);
            
        }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://knowledge.sjxx.cn");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":updateDescriptionOntologyObject_",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "updateDescriptionOntologyObject_",
                           xmlWriter);
                   }

               
                   }
                if (localTokenTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "token", xmlWriter);
                             

                                          if (localToken==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localToken);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localObjectNameTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "objectName", xmlWriter);
                             

                                          if (localObjectName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localObjectName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOldProperty_descriptionTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "oldProperty_description", xmlWriter);
                             

                                          if (localOldProperty_description==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOldProperty_description);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOldValues_descriptionTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "oldValues_description", xmlWriter);
                             

                                          if (localOldValues_description==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOldValues_description);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNewProperty_descriptionTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "newProperty_description", xmlWriter);
                             

                                          if (localNewProperty_description==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNewProperty_description);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNewValues_descriptionTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "newValues_description", xmlWriter);
                             

                                          if (localNewValues_description==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNewValues_description);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOldProperty_descriptionTypeTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "oldProperty_descriptionType", xmlWriter);
                             
                                               if (localOldProperty_descriptionType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("oldProperty_descriptionType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOldProperty_descriptionType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOldValues_descriptionTypeTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "oldValues_descriptionType", xmlWriter);
                             
                                               if (localOldValues_descriptionType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("oldValues_descriptionType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOldValues_descriptionType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNewProperty_descriptionTypeTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "newProperty_descriptionType", xmlWriter);
                             
                                               if (localNewProperty_descriptionType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("newProperty_descriptionType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewProperty_descriptionType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNewValues_descriptionTypeTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "newValues_descriptionType", xmlWriter);
                             
                                               if (localNewValues_descriptionType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("newValues_descriptionType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewValues_descriptionType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOldCardinalityTypeTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "oldCardinalityType", xmlWriter);
                             
                                               if (localOldCardinalityType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("oldCardinalityType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOldCardinalityType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOldCardinalityNumTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "oldCardinalityNum", xmlWriter);
                             
                                               if (localOldCardinalityNum==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("oldCardinalityNum cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOldCardinalityNum));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNewCardinalityTypeTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "newCardinalityType", xmlWriter);
                             
                                               if (localNewCardinalityType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("newCardinalityType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewCardinalityType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNewCardinalityNumTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "newCardinalityNum", xmlWriter);
                             
                                               if (localNewCardinalityNum==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("newCardinalityNum cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewCardinalityNum));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDescriptionTypeTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "descriptionType", xmlWriter);
                             
                                               if (localDescriptionType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("descriptionType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescriptionType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://knowledge.sjxx.cn")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace,attName,attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localTokenTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "token"));
                                 
                                         elementList.add(localToken==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localToken));
                                    } if (localObjectNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "objectName"));
                                 
                                         elementList.add(localObjectName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localObjectName));
                                    } if (localOldProperty_descriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "oldProperty_description"));
                                 
                                         elementList.add(localOldProperty_description==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOldProperty_description));
                                    } if (localOldValues_descriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "oldValues_description"));
                                 
                                         elementList.add(localOldValues_description==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOldValues_description));
                                    } if (localNewProperty_descriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "newProperty_description"));
                                 
                                         elementList.add(localNewProperty_description==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewProperty_description));
                                    } if (localNewValues_descriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "newValues_description"));
                                 
                                         elementList.add(localNewValues_description==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewValues_description));
                                    } if (localOldProperty_descriptionTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "oldProperty_descriptionType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOldProperty_descriptionType));
                            } if (localOldValues_descriptionTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "oldValues_descriptionType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOldValues_descriptionType));
                            } if (localNewProperty_descriptionTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "newProperty_descriptionType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewProperty_descriptionType));
                            } if (localNewValues_descriptionTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "newValues_descriptionType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewValues_descriptionType));
                            } if (localOldCardinalityTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "oldCardinalityType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOldCardinalityType));
                            } if (localOldCardinalityNumTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "oldCardinalityNum"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOldCardinalityNum));
                            } if (localNewCardinalityTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "newCardinalityType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewCardinalityType));
                            } if (localNewCardinalityNumTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "newCardinalityNum"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewCardinalityNum));
                            } if (localDescriptionTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "descriptionType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescriptionType));
                            }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static UpdateDescriptionOntologyObject_ parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            UpdateDescriptionOntologyObject_ object =
                new UpdateDescriptionOntologyObject_();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"updateDescriptionOntologyObject_".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (UpdateDescriptionOntologyObject_)cn.sjxx.knowledge.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","token").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setToken(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","objectName").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setObjectName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","oldProperty_description").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOldProperty_description(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","oldValues_description").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOldValues_description(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","newProperty_description").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNewProperty_description(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","newValues_description").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNewValues_description(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","oldProperty_descriptionType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"oldProperty_descriptionType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOldProperty_descriptionType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setOldProperty_descriptionType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","oldValues_descriptionType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"oldValues_descriptionType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOldValues_descriptionType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setOldValues_descriptionType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","newProperty_descriptionType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"newProperty_descriptionType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNewProperty_descriptionType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setNewProperty_descriptionType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","newValues_descriptionType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"newValues_descriptionType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNewValues_descriptionType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setNewValues_descriptionType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","oldCardinalityType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"oldCardinalityType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOldCardinalityType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setOldCardinalityType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","oldCardinalityNum").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"oldCardinalityNum" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOldCardinalityNum(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setOldCardinalityNum(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","newCardinalityType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"newCardinalityType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNewCardinalityType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setNewCardinalityType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","newCardinalityNum").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"newCardinalityNum" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNewCardinalityNum(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setNewCardinalityNum(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","descriptionType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"descriptionType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDescriptionType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setDescriptionType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    