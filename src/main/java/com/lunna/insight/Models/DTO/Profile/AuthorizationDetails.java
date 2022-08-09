package com.lunna.insight.Models.DTO.Profile;

public class AuthorizationDetails {

        private int id;
        private int authId;
        private String propertyName;
        private String value;

        public AuthorizationDetails() {
        }

        public AuthorizationDetails(int id, int authId, String propertyName, String value) {
            this.id = id;
            this.authId = authId;
            this.propertyName = propertyName;
            this.value = value;
        }

        public AuthorizationDetails(int authId) {
            this.authId = authId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAuthId() {
            return authId;
        }

        public void setAuthId(int authId) {
            this.authId = authId;
        }

        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
