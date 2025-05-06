package Utils;

import java.util.UUID;

public class Constants {

        public static final String BASEURL = "https://api.practicesoftwaretesting.com";
        public static final String LOGIN_ENDPOINT = "/users/login";
        public static final String REGISTER_ENDPOINT = "/users/register";
        public static final String PRODUCT_ENDPOINT = "/products";
        public static final String BRAND_ENDPOINT = "/brands";
        public static final String Category_ENDPOINT = "/categories";
        public static final String Image_ENDPOINT = "/images";
        public static final String LOGOUT_ENDPOINT = "/users/logout";
        public static String CART_ENDPOINT = "/carts";
        public static String PAYMENT_ENDPOINT = "/payment/check";
        public static final String INVOICE_ENDPOINT = "/invoices";

        public static final String ADMIN_USERNAME = "admin@practicesoftwaretesting.com";
        public static final String ADMIN_PASSWORD = "welcome01";
        public static final String USERNAME_User1 = UUID.randomUUID().toString()+"@dd.com";
        public static final String PASSWORD = "wWlcodm@e01";
        public static final String USERNAME_User2 = UUID.randomUUID().toString()+"@dd.com";



        public static final String GRAPHQL_URL = "https://hasura.io/learn/graphql";
        private static final  String HASURA_ADMIN_SECRET = "REDACTED";
        private static String TOKEN = null;

        public static String getToken() {
            return TOKEN;
        }
        public static void setToken(String token) {
            TOKEN = token;
        }
        public static String getHasuraAdminSecret() {
                return HASURA_ADMIN_SECRET;
        }



}
