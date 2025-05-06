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
        private static final  String HASURA_ADMIN_SECRET = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9F" +
                "WTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5" +
                "pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbI" +
                "nVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY4MTdkMDY0YWYzMzhlZjAyMGE5ZWUzZSJ9LCJuaWNrbmFtZSI6Imthc" +
                "mVlbW1vaGFtZWQ3MC5rbSIsIm5hbWUiOiJrYXJlZW1tb2hhbWVkNzAua21AZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8" +
                "vcy5ncmF2YXRhci5jb20vYXZhdGFyL2ZlMmU5MjQwNWQ2Y2Y2NTZhOTk3MTAxYTkxYWQ1ZDU1P3M9NDgwJnI9cGcmZD1odHRwcyU" +
                "zQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGa2EucG5nIiwidXBkYXRlZF9hdCI6IjIwMjUtMDUtMDVUMTc6MTQ6ND" +
                "cuNTAxWiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsImF1ZCI6IlAzOHFuRm8xbEZBUUpye" +
                "mt1bi0td0V6cWxqVk5HY1dXIiwic3ViIjoiYXV0aDB8NjgxN2QwNjRhZjMzOGVmMDIwYTllZTNlIiwiaWF0IjoxNzQ2NTQxNTU3" +
                "LCJleHAiOjE3NDY1Nzc1NTcsInNpZCI6IjRORlZmakVaRVkzSElLb0h6cmVRQzYxSHhXN253VF85IiwiYXRfaGFzaCI6IlpLQmF" +
                "3NlRNU2IwT1VocmFiZGlNTHciLCJub25jZSI6IllaMV9rN2xEeVZIM3ZVR3paRUZ0UGMwcmVxRG9-R0dNIn0.eMvNHujHEjM" +
                "RB-k3yjlA25JSozKjmuLOiE0_21ZTsXOq3Rc0Ssaf08pHC8Ld0zWfc6pWtc43TCq7y3oFxMDqAbzDkp9_Wqd8ZlrIIUdufJaqk" +
                "RTaDwcyWx6TPxi4nxiMZHGcG0V78VCDxWIE33OUkdUWzEtBpnxgAl9bQJqs7PQgsVuZTsHn5i9WIIxKBN_TGjC9rpodWP" +
                "0KxNSMlSyIqNE3B0J_NnhVxKfHAAkPbMLUeR5KfJ729t4jWh0A9WlYAODndtiqLpk8L9fbOCrIA69iDBaoCWbqG780RfrLdHs" +
                "MVrKRH78g0QLzXLhKURWNy57rDoI8wGcysTH83L-HAw";
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
