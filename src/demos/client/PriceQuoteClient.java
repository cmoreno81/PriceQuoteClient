/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demos.client;

import demos.client.ws.PriceQuote;
import demos.client.ws.PriceQuoteService;
import demos.client.ws.Products;
import demos.client.ws.Quote;
import demos.client.ws.QuoteFault;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristina
 */
public class PriceQuoteClient {

    private static final Logger LOG = Logger.getLogger(PriceQuoteClient.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Servicio que crea el SOAP
            PriceQuoteService service = new PriceQuoteService();
            PriceQuote port = service.getPriceQuote();
            Products request = new Products();
            List<Integer> ids = request.getProductId();
            ids.add(1);
            ids.add(2);
            Quote quote = port.getQuote(request);
            System.out.println(quote.getQuotedPrice());

        } catch (QuoteFault ex) {
            LOG.log(Level.INFO, ex.getFaultInfo().getMessage());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

}
