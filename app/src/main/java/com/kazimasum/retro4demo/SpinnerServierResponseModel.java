package com.kazimasum.retro4demo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpinnerServierResponseModel {

    @Expose
    @SerializedName("service_type")
    private List<Service_type> service_type;
    @Expose
    @SerializedName("status")
    private boolean status;

    public List<Service_type> getService_type() {
        return service_type;
    }

    public void setService_type(List<Service_type> service_type) {
        this.service_type = service_type;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class Service_type {
        @Expose
        @SerializedName("description")
        private String description;
        @Expose
        @SerializedName("role_id")
        private String role_id;
        @Expose
        @SerializedName("service_name")
        private String service_name;
        @Expose
        @SerializedName("service_id")
        private String service_id;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRole_id() {
            return role_id;
        }

        public void setRole_id(String role_id) {
            this.role_id = role_id;
        }

        public String getService_name() {
            return service_name;
        }

        public void setService_name(String service_name) {
            this.service_name = service_name;
        }

        public String getService_id() {
            return service_id;
        }

        public void setService_id(String service_id) {
            this.service_id = service_id;
        }
        @Override
        public String toString() {
            return this.service_name;
        }
    }
}
