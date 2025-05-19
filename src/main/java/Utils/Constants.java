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

        public static final String GRAPHQL_URL = "https://hasura.io/learn/graphql";
        private static final  String HASURA_ADMIN_SECRET = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY4MTdkMDY0YWYzMzhlZjAyMGE5ZWUzZSJ9LCJuaWNrbmFtZSI6ImthcmVlbW1vaGFtZWQ3MC5rbSIsIm5hbWUiOiJrYXJlZW1tb2hhbWVkNzAua21AZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyL2ZlMmU5MjQwNWQ2Y2Y2NTZhOTk3MTAxYTkxYWQ1ZDU1P3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGa2EucG5nIiwidXBkYXRlZF9hdCI6IjIwMjUtMDUtMTZUMTc6MzA6MzQuMzMxWiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwic3ViIjoiYXV0aDB8NjgxN2QwNjRhZjMzOGVmMDIwYTllZTNlIiwiaWF0IjoxNzQ3NjcxMjU4LCJleHAiOjE3NDc3MDcyNTgsInNpZCI6IlBESWItSkIxTGNfNzAwTmRrWkxMdHE2TUhxUWpqVlhtIiwiYXRfaGFzaCI6IktQQmQ1d1Q5MFZUdlBHcDM1ZGdmVnciLCJub25jZSI6ImV2NTZFMFp6YUl0WmYtQ3dTa2k4TndtNVlNMWduYnRyIn0.C81d68y7Xy6nKiNYx8ykBwlJCbJij2UrOVc1dUAXIeTXDwSaq-aThPaQbBEme8peXL-iV0V8El0BXihBQpN_R5YCrfi7kv64329eu-xYdCxnn6SSfXVRLzPlIqLPiCSQi_-M_A5kwOxpxtudFpfYH_h4hiyCUwrSJkHrh1J5H4V0Xp3D0cLEgeFaeDQVwUCTBecFN1dRKYQiYPMmQDJoUdDDtQ6XX3VMKeE32LSvodtMY-FO2EG2dM46SpxwcQz4PohsXa7Z79XbmprmeDkdZk1HakfzpLswcIPUo78FRGoRDjMikOO9TRjZ8z1ogieJSseXycU-v-5jcRjlFyMQfw";
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
