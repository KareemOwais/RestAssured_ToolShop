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
        private static final  String HASURA_ADMIN_SECRET = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY4MTdkMDY0YWYzMzhlZjAyMGE5ZWUzZSJ9LCJuaWNrbmFtZSI6ImthcmVlbW1vaGFtZWQ3MC5rbSIsIm5hbWUiOiJrYXJlZW1tb2hhbWVkNzAua21AZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyL2ZlMmU5MjQwNWQ2Y2Y2NTZhOTk3MTAxYTkxYWQ1ZDU1P3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGa2EucG5nIiwidXBkYXRlZF9hdCI6IjIwMjUtMDUtMTBUMDk6NDY6MDUuNTMwWiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwic3ViIjoiYXV0aDB8NjgxN2QwNjRhZjMzOGVmMDIwYTllZTNlIiwiaWF0IjoxNzQ2ODcwMzY3LCJleHAiOjE3NDY5MDYzNjcsInNpZCI6Ijlpb0lnRmVzZ3dUM0FwdjVsczlGMlB2anFYQzlrcG1hIiwiYXRfaGFzaCI6Ii1nVFpQUkZXSjJLcmRUcFhKTDNvNXciLCJub25jZSI6Ik1kNk1pQVJmbTk2T0pvVHpRd2dlNnFsSGRwSG9vX3lkIn0.gz877xtn0MLfAa4zzIYJixrpnN2Oug0IzOmvIVPzGy1ubIEC1f3HBYetiqKZJ973dmoFD4oAStxDMHDFzee18JY0azOqlxs3uSefcmD7Pi6Z_3Ix7pxHK5lOEM8_82a3YZbeW5zByWax-VmJ3v_TTMRb1kJ-9rwqeiNr_AQOen4PrCpzqdkh01cwyOWFWRS6EtE7qG-PSNgLyRqRkONAAjTO4U_s2f1lFPQGq15reTdswx8u4RJRXrgvuLQ4S9R3yBs1qU2kwbo0aLUChlrCayNrHJiGZrkSFJ7e5NxoqKgfadJ0Kr7S7o4EWBxSVwptgPUgSjf1T2bvaoIH86c8mQ";
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
