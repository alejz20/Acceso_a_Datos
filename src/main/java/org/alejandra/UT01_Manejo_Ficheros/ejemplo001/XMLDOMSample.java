package org.alejandra.UT01_Manejo_Ficheros.ejemplo001;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLDOMSample {

    private static final File xml_file = new File("src/main/resources/weather-data.xml");



//         * El parser DOM de Java es muy sencillo de utilizar, y permite disponer de Ttodo el documento
//         * XML en memoria para acceder de manera muy rápida a sus contenidos . Las interfaces de
//         * programación de DOM permiten, no solo consultar los contenidos de un documento, sino
//         * también modificarlos.
//         * Tambén permite salir serializar un árbol DOM, es decir, generar un fichero
//         * con sus contenidos.
//         *
//         * Construir un documento DOM en memoria puede suponer un grave inconveniente para documentos muy grandes.
//         * XML se utiliza hoy en día para almacenar enormes volúmenes de datos.
//         * Para aplicacciones que necesitan consultar los contenidos de documentos muy grandes,
//         * pero no modificarlos, conviene utilizar otro tipo de parseer que permite acceder a ellos sin
//         * almacenar el documento en memoria, como por ejemplo un parser SAX.

    public static void main(String[] args)  throws SAXException, ParserConfigurationException , IOException {
        // Parsear
        var domDocument = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(xml_file);

        // URI xml
        System.out.println(" uri del xml: " + domDocument.getDocumentURI());

        //Obtener la cabeza del xml, tenemos que comprobar si es un nodo documento
        var header = domDocument.getNodeType();
        System.out.println("NODO DOCUMENTO: " + (header == Node.DOCUMENT_NODE) );
        var heager = domDocument.getDocumentElement();
        System.out.println("<br>" + "Imprimimos el nombre del NODO RAIZ: " + heager.getNodeName());

        //Obtener la version
        System.out.println("version: " + domDocument.getXmlVersion());

        //Obtener el encoding
        System.out.println("encoding: " + domDocument.getXmlEncoding());

        //Obtener nodos hijos
        System.out.println("Tamaño lista de nodos: " + domDocument.getChildNodes()
                                                                  .getLength());

        //Obtener elementos por etiqueta
        var weather_data = domDocument.getElementsByTagName("madrid");
        for (int i = 0; i < weather_data.getLength(); i++) {

            var weather_data_element = weather_data.item(i);

            System.out.println(weather_data_element.getTextContent());
            System.out.println("Parent: " + weather_data_element.getParentNode()
                                                                .getNodeName());

            System.out.println(" primer nodo valido: " + weather_data_element.getFirstChild()
                                                                             .getNextSibling() // El siguiente del primer nodo
                                                                             .getTextContent()); // obtiene el texto

            System.out.println(" ultimo nodo valido: " + weather_data_element.getLastChild()
                                                                             .getPreviousSibling() // El anterior del ultimo
                                                                             .getTextContent());

                var childNodes = weather_data_element.getChildNodes();
            System.out.println(childNodes.item(0)
                    .getParentNode()
                    .getAttributes()
                    .getNamedItem("station").getNodeValue());
        }


    }
}
