
package com.lunna.insight.Core.commons;

/**
 *
 *
 */
public class Constants {
    /**
     * Actions
     */
    public static final String ACTION_CREATE = "create";
    public static final String ACTION_VIEW = "view";
    public static final String ACTION_UPDATE = "update";
    public static final String ACTION_ACTIVATE = "activate";
    public static final String ACTION_DEACTIVATE = "deactivate";
    public static final String ACTION_REPORT = "report";
    public static final String ACTION_PRINT = "print";

    /**
     * Auth
     */

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    /**
     * Module Name
     */
    public static final String MODULE_POS = "POS";
    /**
     * Screens - Resources
     */
    public static final String MM_POLICY_POST_PURCHASE = "PostInvoice";
    public static final String MM_POLICY_POST_PURCHASE_ABVR = "PINV";
    public static final int
        CRM_LEADS_MASTER = 0;
    //public static final String CRM_LEADS_MASTER = "CRM_LEADS_MASTER";


    public static final String LOCALES_RESOURCE_NAME = "Locale";
    public static final String ENTITY_RESOURCE_NAME = "Entity";
    public static final String MODULE_RESOURCE_NAME = "Module";
    public static final String PERMISSIONS_RESOURCE_NAME = "Permissions";
    public static final String POLICY_RESOURCE_NAME = "Policy";
    public static final String RESOURCE_RESOURCE_NAME = "Resource";
    public static final String ROLE_RESOURCE_NAME = "RolesMaster";
    public static final String UOM_RESOURCE_NAME = "UOM";
    public static final String USER_MASTER_RESOURCE_NAME = "UserMaster";


    public static final String AGENT_MASTER_RESOURCE_NAME = "AgentMaster";








    public static final String MM_POLICY_COUNTRY = "Country";
    public static final String MM_POLICY_CITY = "City";

    public static final String MM_POLICY_INVOICE = "Invoice";
    public static final String MM_POLICY_INVOICE_ABVR = "INV";

    public static final String MM_POLICY_POST_INVOICE = "PostInvoice";
    public static final String MM_POLICY_POST_INVOICE_ABVR = "PINV";

    public static final String MM_POLICY_POST_CREDITE_NOTE = "PostCreditNote";
    public static final String MM_POLICY_POST_CREDITE_NOTE_ABVR = "PINVCN";

    public static final String MM_POLICY_QUOTATION = "Quotation";
    public static final String MM_POLICY_QUOTATION_ABVR = "QTN";

    public static final String MM_POLICY_CUSTOMER_PAYMENT = "CustomerPayment";
    public static final String MM_POLICY_CUSTOMER_PAYMENT_ABVR = "CUP";


    public static final String MD_POLICY_USER_LOGIN_MODE = "LoginMode";


    public static final String POLICIES_EMAIL = "Email";

    public static final String USER_PROFILE = "UserProfile";

    public static final String PWD_MIN_LENGTH = "PswdMinLegth";
    public static final String PWD_REQ_SYMBOL = "PswdReqSym";
    public static final String PWD_NUM = "PswdReqNum";
    public static final String PWD_UPPER_CASE = "PswdReqUCase";
    public static final String PWD_Expiry = "PswdExpiry";
    public static final String EMAIL_HOST = "SmtpServer";
    public static final String EMAIL_PORT = "SmtpPort";
    public static final String EMAIL_REQUIRE_AUTH = "SmtpAuth";
    public static final String EMAIL_ADDRESS = "SmtpUser";
    public static final String EMAIL_PASSWORD = "SmtpPassword";


    public static final String PWD_MUST_CHANGE_OR_NOTIFICATION = "PswdMustChangeOrNotification";
    public static final String SYMBOLE_CHAR = "(.*)([!@#$$%^&*?]+)(.*)";


    /*
     * status code
     */
    public static final String STATUS_CODE_400_OR_STATUS_CODE_409 = "400_409";
    public static final String STATUS_CODE_401 = "401";
    public static final String STATUS_CODE_420 = "420";
    public static final String STATUS_CODE_403 = "403";
    public static final String STATUS_CODE_404 = "404";
    public static final String STATUS_CODE_500 = "500";

    public static final String STATUS_DEFAULT = "Status_Default";

    /*
     *
     *Image Upload Param_Name
     *
     */
    public static final String FILE_UPLOAD = "FileUpload";
    public static final String IMAGE_UPLOAD_PATH = "ImageUploadPath";
    public static final String THUMB_IMAGE_UPLOAD_PATH = "ThumbImageUploadPath";
    public static final String IMAGE_SCALE_WIDTH = "ImageScaleWidth";
    public static final String IMAGE_SCALE_HEIGHT = "ImageScaleHeight";
    public static final String IMAGE_FORMAT_JPG = "jpg";
    public static final String IMAGE_FORMAT_JPEG = "jpeg";
    public static final String IMAGE_FORMAT_PNG = "png";
    public static final String IMAGE_FORMAT_TIF = "tif";
    public static final String IMAGE_FORMAT_GIF = "gif";
    public static final String IMAGE_FORMAT_BMP = "bmp";
}

