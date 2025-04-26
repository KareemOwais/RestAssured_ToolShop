package Utils;

public class Constants {
        public static String BASEURL = "https://api.practicesoftwaretesting.com";
        public static String LOGIN_ENDPOINT = "/users/login";
        public static String PRODUCT_ENDPOINT = "/products";
        public static String BRAND_ENDPOINT = "/brands";
        public static String Category_ENDPOINT = "/categories";
        public static String Image_ENDPOINT = "/images";
        public static String LOGOUT_ENDPOINT = "/users/logout";

        public static String ADMIN_USERNAME = "admin@practicesoftwaretesting.com";
        public static String ADMIN_PASSWORD = "welcome01";

        private static String TOKEN = null;

        public static String getToken() {
            return TOKEN;
        }
        public static void setToken(String token) {
            TOKEN = token;
        }

}
