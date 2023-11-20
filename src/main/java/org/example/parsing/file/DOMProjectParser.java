package org.example.parsing.file;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMProjectParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        List<String> list = parsingFile(
                "src\\main\\java\\org\\example\\folders\\input\\first.txt");

        for(String str : list){
            System.out.println(str);
        }
    }

    /**
     *
     * @param str - абсолютный путь к файлу
     * @return - list  с тремя значениями
     * 1. Номер счёта отправителя
     * 2. Номер счёта получателя
     * 3. Сумма перевода
     */
    public static List<String> parsingFile(String str) throws ParserConfigurationException, IOException, SAXException {
        List<String> list = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(str));

        Node transferMoneyRequestNode = document.getFirstChild();
        NodeList transferMoneyRequestChilds = transferMoneyRequestNode.getChildNodes();

        Node senderNode = null;
        Node receiverNode = null;
        Node transferNode = null;

        for(int i = 0; i < transferMoneyRequestChilds.getLength();i++){

            if(transferMoneyRequestChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }

            switch (transferMoneyRequestChilds.item(i).getNodeName()){
                case "Sender": {
                    senderNode = transferMoneyRequestChilds.item(i);
                }break;
                case "Receiver": {
                    receiverNode = transferMoneyRequestChilds.item(i);
                }break;
                case "Transfer": {
                    transferNode = transferMoneyRequestChilds.item(i);
                }break;
            }
        }

        NodeList senderChilds = senderNode.getChildNodes();
        String senderAccountNumber = null;

        for(int i = 0; i < senderChilds.getLength();i++){
            if(senderChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }

            if(senderChilds.item(i).getNodeName().equals("SenderAccountNumber")){
                senderAccountNumber = senderChilds.item(i).getTextContent(); //номер счёта отправителя
                list.add(senderAccountNumber);
            }
        }

        NodeList receiverChilds = receiverNode.getChildNodes();
        String receiverAccountNumber = null;

        for(int i = 0; i < receiverChilds.getLength();i++){
            if(receiverChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }

            if(receiverChilds.item(i).getNodeName().equals("ReceiverAccountNumber")){
                receiverAccountNumber = receiverChilds.item(i).getTextContent(); // номер счёта получателя
                list.add(receiverAccountNumber);
            }
        }

        NodeList transferChilds = transferNode.getChildNodes();
        String sumTransfer = null;

//        Integer sumTransfer = null;

        for(int i = 0 ; i  < transferChilds.getLength(); i++){
            if(transferChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }

            if(transferChilds.item(i).getNodeName().equals("SUM"));{
                sumTransfer = transferChilds.item(i).getTextContent(); //сумма операции
                list.add(sumTransfer);
//                sumTransfer = Integer.parseInt(transferChilds.item(i).getTextContent());
            }

        }
        return list;
    }

}
