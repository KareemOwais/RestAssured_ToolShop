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
        private static final  String HASURA_ADMIN_SECRET = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY4MTdkMDY0YWYzMzhlZjAyMGE5ZWUzZSJ9LCJuaWNrbmFtZSI6ImthcmVlbW1vaGFtZWQ3MC5rbSIsIm5hbWUiOiJrYXJlZW1tb2hhbWVkNzAua21AZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyL2ZlMmU5MjQwNWQ2Y2Y2NTZhOTk3MTAxYTkxYWQ1ZDU1P3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGa2EucG5nIiwidXBkYXRlZF9hdCI6IjIwMjUtMDUtMTBUMTY6MDA6NDUuMDY4WiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwic3ViIjoiYXV0aDB8NjgxN2QwNjRhZjMzOGVmMDIwYTllZTNlIiwiaWF0IjoxNzQ2OTc3MzAxLCJleHAiOjE3NDcwMTMzMDEsInNpZCI6IlFqb0UxUG9nYkN6OEktY2hOdU00aUl0ZEIzYmVFVWdzIiwiYXRfaGFzaCI6IkVLMEpfdXFvTkNHd2QxREdPV3RyaEEiLCJub25jZSI6InIuMW9mTzE0akhvYzJGTk9NQ2M1YVFFaFl-S243Unl2In0.pvV6GNczo-jvRdiK6ZWHC7fE_SIxRa8wOmHwokSLZqqEtk3D-U1IoL3QbqJSudqPXAVxU19ibQC5cbTTG5C_6Duc3Y5IA9PMkqujGTvPOwkga2mX8kyZ6VK_SVxrE9BrtEpHRCs42rj58qjMzkMAxhyCn9ouDb8LhKsIGW6WG0D4HPoc4qGILEbeUfq0_laVCO3tg2J740LJUxHKhUgoAncTzZ5j8pdKxAkC6GtmaRfKUGmiQSJA5yF_kNAs91u__Pz0AnOWB-iiW77DYCabmiGNHhnck1NiDV2T5StrR0NNvNKGlIH0wBN6XmutdZ8btdPIciU5MMvh0Jc7qchvpg";
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
