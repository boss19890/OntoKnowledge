
/**
 * AddDescriptionOntologyObject_.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package cn.sjxx.knowledge;
            

            /**
            *  AddDescriptionOntologyObject_ bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class AddDescriptionOntologyObject_
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://knowledge.sjxx.cn",
                "addDescriptionOntologyObject_",
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
                        * field for Property_description
                        */

                        
                                    protected java.lang.String localProperty_description ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localProperty_descriptionTracker = false ;

                           public boolean isProperty_descriptionSpecified(){
                               return localProperty_descriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getProperty_description(){
                               return localProperty_description;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Property_description
                               */
                               public void setProperty_description(java.lang.String param){
                            localProperty_descriptionTracker = true;
                                   
                                            this.localProperty_description=param;
                                    

                               }
                            

                        /**
                        * field for Values_description
                        */

                        
                                    protected java.lang.String localValues_description ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localValues_descriptionTracker = false ;

                           public boolean isValues_descriptionSpecified(){
                               return localValues_descriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getValues_description(){
                               return localValues_description;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Values_description
                               */
                               public void setValues_description(java.lang.String param){
                            localValues_descriptionTracker = true;
                                   
                                            this.localValues_description=param;
                                    

                               }
                            

                        /**
                        * field for Property_descriptionType
                        */

                        
                                    protected int localProperty_descriptionType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localProperty_descriptionTypeTracker = false ;

                           public boolean isProperty_descriptionTypeSpecified(){
                               return localProperty_descriptionTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getProperty_descriptionType(){
                               return localProperty_descriptionType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Property_descriptionType
                               */
                               public void setProperty_descriptionType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localProperty_descriptionTypeTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localProperty_descriptionType=param;
                                    

                               }
                            

                        /**
                        * field for Values_descriptionType
                        */

                        
                                    protected int localValues_descriptionType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localValues_descriptionTypeTracker = false ;

                           public boolean isValues_descriptionTypeSpecified(){
                               return localValues_descriptionTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getValues_descriptionType(){
                               return localValues_descriptionType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Values_descriptionType
                               */
                               public void setValues_descriptionType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localValues_descriptionTypeTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localValues_descriptionType=param;
                                    

                               }
                            

                        /**
                        * field for CardinalityType
                        */

                        
                                    protected int localCardinalityType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCardinalityTypeTracker = false ;

                           public boolean isCardinalityTypeSpecified(){
                               return localCardinalityTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getCardinalityType(){
                               return localCardinalityType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CardinalityType
                               */
                               public void setCardinalityType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localCardinalityTypeTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localCardinalityType=param;
                                    

                               }
                            

                        /**
                        * field for CardinalityNum
                        */

                        
                                    protected int localCardinalityNum ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCardinalityNumTracker = false ;

                           public boolean isCardinalityNumSpecified(){
                               return localCardinalityNumTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getCardinalityNum(){
                               return localCardinalityNum;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CardinalityNum
                               */
                               public void setCardinalityNum(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localCardinalityNumTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localCardinalityNum=param;
                                    

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
                           namespacePrefix+":addDescriptionOntologyObject_",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "addDescriptionOntologyObject_",
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
                             } if (localProperty_descriptionTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "property_description", xmlWriter);
                             

                                          if (localProperty_description==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localProperty_description);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localValues_descriptionTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "values_description", xmlWriter);
                             

                                          if (localValues_description==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localValues_description);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localProperty_descriptionTypeTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "property_descriptionType", xmlWriter);
                             
                                               if (localProperty_descriptionType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("property_descriptionType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProperty_descriptionType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localValues_descriptionTypeTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "values_descriptionType", xmlWriter);
                             
                                               if (localValues_descriptionType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("values_descriptionType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localValues_descriptionType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCardinalityTypeTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "cardinalityType", xmlWriter);
                             
                                               if (localCardinalityType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("cardinalityType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCardinalityType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCardinalityNumTracker){
                                    namespace = "http://knowledge.sjxx.cn";
                                    writeStartElement(null, namespace, "cardinalityNum", xmlWriter);
                             
                                               if (localCardinalityNum==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("cardinalityNum cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCardinalityNum));
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
                                    } if (localProperty_descriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "property_description"));
                                 
                                         elementList.add(localProperty_description==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProperty_description));
                                    } if (localValues_descriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "values_description"));
                                 
                                         elementList.add(localValues_description==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localValues_description));
                                    } if (localProperty_descriptionTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "property_descriptionType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProperty_descriptionType));
                            } if (localValues_descriptionTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "values_descriptionType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localValues_descriptionType));
                            } if (localCardinalityTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "cardinalityType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCardinalityType));
                            } if (localCardinalityNumTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://knowledge.sjxx.cn",
                                                                      "cardinalityNum"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCardinalityNum));
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
        public static AddDescriptionOntologyObject_ parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AddDescriptionOntologyObject_ object =
                new AddDescriptionOntologyObject_();

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
                    
                            if (!"addDescriptionOntologyObject_".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AddDescriptionOntologyObject_)cn.sjxx.knowledge.ExtensionMapper.getTypeObject(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","property_description").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setProperty_description(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","values_description").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setValues_description(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","property_descriptionType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"property_descriptionType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setProperty_descriptionType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setProperty_descriptionType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","values_descriptionType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"values_descriptionType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setValues_descriptionType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setValues_descriptionType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","cardinalityType").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"cardinalityType" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCardinalityType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setCardinalityType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://knowledge.sjxx.cn","cardinalityNum").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"cardinalityNum" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCardinalityNum(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setCardinalityNum(java.lang.Integer.MIN_VALUE);
                                           
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
           
    