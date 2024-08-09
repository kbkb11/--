package com.example.BusQuerySystem.utils.gson;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationIpResponse {
    private String address;
    private Content content;
    private int status;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Content {
        private String address;
        private AddressDetail addressDetail;
        private Point point;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AddressDetail {
            private String adcode;
            private String city;
            private int cityCode;
            private String district;
            private String province;
            private String street;
            private String streetNumber;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Point {
            private String x;
            private String y;
        }
    }
}
