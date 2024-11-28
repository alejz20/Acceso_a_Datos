//package org.alejandra.UT01_Manejo_Ficheros;
//
//import org.xml.sax.Attributes;
//import org.xml.sax.SAXException;
//import org.xml.sax.helpers.DefaultHandler;
//
//public class WeatherHandler extends DefaultHandler {
//
//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        switch (qName.toLowerCase()){
//            case "city":
//                enCity = true;
//                cityId = attributes.getValue("id");
//                cityName = attributes.getValue("name");
//                break;//        if(qName.equals("city")
////                || qName.equals("temperature")
////                || qName.equals("humidity")
////                || qName.equals("pressure")){
////
////        }
////        System.out.printf("Inicio de: %s\n" ,qName);
//
//    }
//
//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        switch (qName.toLowerCase()){
//            case "city":
//                enCity = true;
//                cityId = attributes.getValue("id");
//                cityName = attributes.getValue("name");
//                break;
//
//            case "temperature":
//
//            case "humidity":
//            case "pressure":
//        }
//        System.out.printf("Fin de: %s\n" ,qName);
//    }
//}
