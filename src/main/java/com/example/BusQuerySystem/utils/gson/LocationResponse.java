package com.example.BusQuerySystem.utils.gson;

import com.google.gson.annotations.SerializedName;

public class LocationResponse {
    @SerializedName("address")
    private String address;

    @SerializedName("content")
    private Content content;

    @SerializedName("status")
    private int status;

    // Getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    // Inner class for 'content' field
    public static class Content {
        @SerializedName("address")
        private String address;

        @SerializedName("address_detail")
        private AddressDetail addressDetail;

        @SerializedName("point")
        private Point point;

        // Getters and setters
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public AddressDetail getAddressDetail() {
            return addressDetail;
        }

        public void setAddressDetail(AddressDetail addressDetail) {
            this.addressDetail = addressDetail;
        }

        public Point getPoint() {
            return point;
        }

        public void setPoint(Point point) {
            this.point = point;
        }

        // Inner class for 'address_detail' field
        public static class AddressDetail {
            @SerializedName("adcode")
            private String adcode;

            @SerializedName("city")
            private String city;

            @SerializedName("city_code")
            private int cityCode;

            @SerializedName("district")
            private String district;

            @SerializedName("province")
            private String province;

            @SerializedName("street")
            private String street;

            @SerializedName("street_number")
            private String streetNumber;

            // Getters and setters
            public String getAdcode() {
                return adcode;
            }

            public void setAdcode(String adcode) {
                this.adcode = adcode;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getCityCode() {
                return cityCode;
            }

            public void setCityCode(int cityCode) {
                this.cityCode = cityCode;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreetNumber() {
                return streetNumber;
            }

            public void setStreetNumber(String streetNumber) {
                this.streetNumber = streetNumber;
            }
        }

        // Inner class for 'point' field
        public static class Point {
            @SerializedName("x")
            private String x;

            @SerializedName("y")
            private String y;

            // Getters and setters
            public String getX() {
                return x;
            }

            public void setX(String x) {
                this.x = x;
            }

            public String getY() {
                return y;
            }

            public void setY(String y) {
                this.y = y;
            }
        }
    }
}
