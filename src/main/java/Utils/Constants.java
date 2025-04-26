package Utils;

import java.util.UUID;

public class Constants {
        public static String BASEURL = "https://api.practicesoftwaretesting.com";
        public static String LOGIN_ENDPOINT = "/users/login";
        public static String REGISTER_ENDPOINT = "/users/register";
        public static String PRODUCT_ENDPOINT = "/products";
        public static String BRAND_ENDPOINT = "/brands";
        public static String Category_ENDPOINT = "/categories";
        public static String Image_ENDPOINT = "/images";
        public static String LOGOUT_ENDPOINT = "/users/logout";
        public static String CART_ENDPOINT = "/carts";
        public static String PAYMENT_ENDPOINT = "/payment/check";
        public static String INVOICE_ENDPOINT = "/invoices";

        public static String ADMIN_USERNAME = "admin@practicesoftwaretesting.com";
        public static String ADMIN_PASSWORD = "welcome01";
        public static String USERNAME = UUID.randomUUID().toString()+"@gmail.com";
        public static String PASSWORD = "wWlcodm@e01";

        private static String TOKEN = null;

        public static String getToken() {
            return TOKEN;
        }
        public static void setToken(String token) {
            TOKEN = token;
        }

}
