package com.example.BusQuerySystem.utils.gson;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationNameResponse {
    private int status;
    private Result result;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {
        private Location location;
        private int precise;
        private int confidence;
        private int comprehension;
        private String level;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Location {
            private double lng;
            private double lat;
        }
    }
}
