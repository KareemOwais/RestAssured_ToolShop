package Steps;

import POJO.Invoice;
import POJO.PaymentDetails;
import Utils.ApiClient;
import Utils.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class InvoicesSteps {
    protected static final Logger logger = LoggerFactory.getLogger(InvoicesSteps.class);
    public static String CreateInvoiceAndValidate(String CartID) {
        PaymentDetails paymentDetails = new PaymentDetails("BanqueMisr","kasdf","51651");

        Invoice invoice = new Invoice("string","string","string","string","sdfds", "bank-transfer",CartID , paymentDetails);
        Response response = ApiClient.sendPostRequestWithToken(invoice, Constants.INVOICE_ENDPOINT, Constants.getToken());
        Assert.assertEquals(response.getStatusCode(),201,"Invoice creation failed");
        logger.info("Invoice created successfully ");
        return response.jsonPath().getString("invoice_number");
    }



}
