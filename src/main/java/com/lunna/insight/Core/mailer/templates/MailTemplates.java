/*
 * Copyright (c) 2015 FC-ServiceStack Compulynx LTD.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are NOT permitted.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL COMPULYNX LTD BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.lunna.insight.Core.mailer.templates;

/**
 * @author Kushal
 * @Created On 5/20/2015.
 */
public class MailTemplates {

    public static String getResetPasswordTemplate(String userFullName, String userName, String newPassword, String uri) {

        String loginUri = uri + "/#/page/login";
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<head>\n" +
            "<!-- If you delete this meta tag, Half Life 3 will never be released. -->\n" +
            "<meta name=\"viewport\" content=\"width=device-width\" />\n" +
            "\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
            "<title>NexxRetail-Password Reset</title>\n" +
            "\t\n" +
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheets/email.css\" />\n" +
            "<style type=\"text/css\">\n" +
            "/* ------------------------------------- \n" +
            "\t\tGLOBAL \n" +
            "------------------------------------- */\n" +
            "* { \n" +
            "\tmargin:0;\n" +
            "\tpadding:0;\n" +
            "}\n" +
            "* { font-family: \"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif; }\n" +
            "\n" +
            "img { \n" +
            "\tmax-width: 100%; \n" +
            "}\n" +
            ".collapse {\n" +
            "\tmargin:0;\n" +
            "\tpadding:0;\n" +
            "}\n" +
            "body {\n" +
            "\t-webkit-font-smoothing:antialiased; \n" +
            "\t-webkit-text-size-adjust:none; \n" +
            "\twidth: 100%!important; \n" +
            "\theight: 100%;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tELEMENTS \n" +
            "------------------------------------- */\n" +
            "a { color: #2BA6CB;}\n" +
            "\n" +
            ".btn {\n" +
            "\ttext-decoration:none;\n" +
            "\tcolor: #FFF;\n" +
            "\tbackground-color: #666;\n" +
            "\tpadding:10px 16px;\n" +
            "\tfont-weight:bold;\n" +
            "\tmargin-right:10px;\n" +
            "\ttext-align:center;\n" +
            "\tcursor:pointer;\n" +
            "\tdisplay: inline-block;\n" +
            "}\n" +
            "\n" +
            "p.callout {\n" +
            "\tpadding:15px;\n" +
            "\tbackground-color:#ECF8FF;\n" +
            "\tmargin-bottom: 15px;\n" +
            "}\n" +
            ".callout a {\n" +
            "\tfont-weight:bold;\n" +
            "\tcolor: #2BA6CB;\n" +
            "}\n" +
            "\n" +
            "table.social {\n" +
            "/* \tpadding:15px; */\n" +
            "\tbackground-color: #ebebeb;\n" +
            "\t\n" +
            "}\n" +
            ".social .soc-btn {\n" +
            "\tpadding: 3px 7px;\n" +
            "\tfont-size:12px;\n" +
            "\tmargin-bottom:10px;\n" +
            "\ttext-decoration:none;\n" +
            "\tcolor: #FFF;font-weight:bold;\n" +
            "\tdisplay:block;\n" +
            "\ttext-align:center;\n" +
            "}\n" +
            "a.fb { background-color: #3B5998!important; }\n" +
            "a.tw { background-color: #1daced!important; }\n" +
            "a.gp { background-color: #DB4A39!important; }\n" +
            "a.ms { background-color: #000!important; }\n" +
            "\n" +
            ".sidebar .soc-btn { \n" +
            "\tdisplay:block;\n" +
            "\twidth:100%;\n" +
            "}\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tHEADER \n" +
            "------------------------------------- */\n" +
            "table.head-wrap { width: 100%;}\n" +
            "\n" +
            ".header.container table td.logo { padding: 15px; }\n" +
            ".header.container table td.label { padding: 15px; padding-left:0px;}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tBODY \n" +
            "------------------------------------- */\n" +
            "table.body-wrap { width: 100%;}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tFOOTER \n" +
            "------------------------------------- */\n" +
            "table.footer-wrap { width: 100%;\tclear:both!important;\n" +
            "}\n" +
            ".footer-wrap .container td.content  p { border-top: 1px solid rgb(215,215,215); padding-top:15px;}\n" +
            ".footer-wrap .container td.content p {\n" +
            "\tfont-size:10px;\n" +
            "\tfont-weight: bold;\n" +
            "\t\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tTYPOGRAPHY \n" +
            "------------------------------------- */\n" +
            "h1,h2,h3,h4,h5,h6 {\n" +
            "font-family: \"HelveticaNeue-Light\", \"Helvetica Neue Light\", \"Helvetica Neue\", Helvetica, Arial, \"Lucida Grande\", sans-serif; line-height: 1.1; margin-bottom:15px; color:#000;\n" +
            "}\n" +
            "h1 small, h2 small, h3 small, h4 small, h5 small, h6 small { font-size: 60%; color: #6f6f6f; line-height: 0; text-transform: none; }\n" +
            "\n" +
            "h1 { font-weight:200; font-size: 44px;}\n" +
            "h2 { font-weight:200; font-size: 37px;}\n" +
            "h3 { font-weight:500; font-size: 27px;}\n" +
            "h4 { font-weight:500; font-size: 23px;}\n" +
            "h5 { font-weight:900; font-size: 17px;}\n" +
            "h6 { font-weight:900; font-size: 14px; text-transform: uppercase; color:#444;}\n" +
            "\n" +
            ".collapse { margin:0!important;}\n" +
            "\n" +
            "p, ul { \n" +
            "\tmargin-bottom: 10px; \n" +
            "\tfont-weight: normal; \n" +
            "\tfont-size:14px; \n" +
            "\tline-height:1.6;\n" +
            "}\n" +
            "p.lead { font-size:17px; }\n" +
            "p.last { margin-bottom:0px;}\n" +
            "\n" +
            "ul li {\n" +
            "\tmargin-left:5px;\n" +
            "\tlist-style-position: inside;\n" +
            "}\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tSIDEBAR \n" +
            "------------------------------------- */\n" +
            "ul.sidebar {\n" +
            "\tbackground:#ebebeb;\n" +
            "\tdisplay:block;\n" +
            "\tlist-style-type: none;\n" +
            "}\n" +
            "ul.sidebar li { display: block; margin:0;}\n" +
            "ul.sidebar li a {\n" +
            "\ttext-decoration:none;\n" +
            "\tcolor: #666;\n" +
            "\tpadding:10px 16px;\n" +
            "/* \tfont-weight:bold; */\n" +
            "\tmargin-right:10px;\n" +
            "/* \ttext-align:center; */\n" +
            "\tcursor:pointer;\n" +
            "\tborder-bottom: 1px solid #777777;\n" +
            "\tborder-top: 1px solid #FFFFFF;\n" +
            "\tdisplay:block;\n" +
            "\tmargin:0;\n" +
            "}\n" +
            "ul.sidebar li a.last { border-bottom-width:0px;}\n" +
            "ul.sidebar li a h1,ul.sidebar li a h2,ul.sidebar li a h3,ul.sidebar li a h4,ul.sidebar li a h5,ul.sidebar li a h6,ul.sidebar li a p { margin-bottom:0!important;}\n" +
            "\n" +
            "\n" +
            "\n" +
            "/* --------------------------------------------------- \n" +
            "\t\tRESPONSIVENESS\n" +
            "\t\tNuke it from orbit. It's the only way to be sure. \n" +
            "------------------------------------------------------ */\n" +
            "\n" +
            "/* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\n" +
            ".container {\n" +
            "\tdisplay:block!important;\n" +
            "\tmax-width:600px!important;\n" +
            "\tmargin:0 auto!important; /* makes it centered */\n" +
            "\tclear:both!important;\n" +
            "}\n" +
            "\n" +
            "/* This should also be a block element, so that it will fill 100% of the .container */\n" +
            ".content {\n" +
            "\tpadding:15px;\n" +
            "\tmax-width:600px;\n" +
            "\tmargin:0 auto;\n" +
            "\tdisplay:block; \n" +
            "}\n" +
            "\n" +
            "/* Let's make sure tables in the content area are 100% wide */\n" +
            ".content table { width: 100%; }\n" +
            "\n" +
            "\n" +
            "/* Odds and ends */\n" +
            ".column {\n" +
            "\twidth: 300px;\n" +
            "\tfloat:left;\n" +
            "}\n" +
            ".column tr td { padding: 15px; }\n" +
            ".column-wrap { \n" +
            "\tpadding:0!important; \n" +
            "\tmargin:0 auto; \n" +
            "\tmax-width:600px!important;\n" +
            "}\n" +
            ".column table { width:100%;}\n" +
            ".social .column {\n" +
            "\twidth: 280px;\n" +
            "\tmin-width: 279px;\n" +
            "\tfloat:left;\n" +
            "}\n" +
            "\n" +
            "/* Be sure to place a .clear element after each set of columns, just to be safe */\n" +
            ".clear { display: block; clear: both; }\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------------- \n" +
            "\t\tPHONE\n" +
            "\t\tFor clients that support media queries.\n" +
            "\t\tNothing fancy. \n" +
            "-------------------------------------------- */\n" +
            "@media only screen and (max-width: 600px) {\n" +
            "\t\n" +
            "\ta[class=\"btn\"] { display:block!important; margin-bottom:10px!important; background-image:none!important; margin-right:0!important;}\n" +
            "\n" +
            "\tdiv[class=\"column\"] { width: auto!important; float:none!important;}\n" +
            "\t\n" +
            "\ttable.social div[class=\"column\"] {\n" +
            "\t\twidth:auto!important;\n" +
            "\t}\n" +
            "\n" +
            "}\n" +
            "</style\n" +
            "</head>\n" +
            " \n" +
            "<body bgcolor=\"#FFFFFF\">\n" +
            "\n" +
            "<!-- HEADER -->\n" +
            "<table class=\"head-wrap\" bgcolor=\"#23b7e5\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t\t<td class=\"header container\" >\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<div class=\"content\">\n" +
            "\t\t\t\t<table bgcolor=\"#23b7e5\">\n" +
            "\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t<td></td>\n" +
            "\t\t\t\t\t\t<td align=\"right\"><h6 class=\"collapse\" style=\"color:white;\">NexxRetail - Password Reset</h6></td>\n" +
            "\t\t\t\t\t</tr>\n" +
            "\t\t\t\t</table>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t\n" +
            "\t\t</td>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table><!-- /HEADER -->\n" +
            "\n" +
            "\n" +
            "<!-- BODY -->\n" +
            "<table class=\"body-wrap\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t\t<td class=\"container\" bgcolor=\"#FFFFFF\">\n" +
            "\n" +
            "\t\t\t<div class=\"content\">\n" +
            "\t\t\t<table>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t<h3>Hi, " + userFullName + "</h3>\n" +
            "\t\t\t\t\t\t<p>Your password has been reset successfully. Your new login credentials are as below</p>\n" +
            "\t\t\t\t\t\t<p style=\"color:#23b7e5; font-weight:bold;\">User Name : " + userName + "</p>\n" +
            "\t\t\t\t\t\t<p style=\"color:#23b7e5; font-weight:bold;\">Password : " + newPassword + "</p>\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<p>To Login to the application, please open the below link in your browser.</p>\n" +
            "\t\t\t\t\t\t<!-- Callout Panel -->\n" +
            "\t\t\t\t\t\t<p class=\"callout\">\n" +
            "\t\t\t\t\t\t\t<a href=\"" + loginUri + "\">" + loginUri + " &raquo;</a>\n" +
            "\t\t\t\t\t\t</p><!-- /Callout Panel -->\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t<h6>Kind Regards,</h6>\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t<h6>NexxRetail Administrator</h6>\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</table>\n" +
            "\t\t\t</div><!-- /content -->\n" +
            "\t\t\t\t\t\t\t\t\t\n" +
            "\t\t</td>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table><!-- /BODY -->\n" +
            "\n" +
            "<!-- FOOTER -->\n" +
            "<table class=\"footer-wrap\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t\t<td class=\"container\">\n" +
            "\t\t\t\n" +
            "\t\t\t\t<!-- content -->\n" +
            "\t\t\t\t<div class=\"content\">\n" +
            "\t\t\t\t<table>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t<p>\n" +
            "\t\t\t\t\t\t\tDesigned and Developed by Compulynx LTD 2015\n" +
            "\t\t\t\t\t\t</p>\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</table>\n" +
            "\t\t\t\t</div><!-- /content -->\n" +
            "\t\t\t\t\n" +
            "\t\t</td>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table><!-- /FOOTER -->\n" +
            "\n" +
            "</body>\n" +
            "</html>\n";

    }

    public static String getNewUserTemplate(String userFullName, String userName, String userPassword, String uri) {
        String loginUri = uri + "/#/page/login";
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<head>\n" +
            "<!-- If you delete this meta tag, Half Life 3 will never be released. -->\n" +
            "<meta name=\"viewport\" content=\"width=device-width\" />\n" +
            "\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
            "<title>NexxRetail-User Creation</title>\n" +
            "\t\n" +
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheets/email.css\" />\n" +
            "<style type=\"text/css\">\n" +
            "/* ------------------------------------- \n" +
            "\t\tGLOBAL \n" +
            "------------------------------------- */\n" +
            "* { \n" +
            "\tmargin:0;\n" +
            "\tpadding:0;\n" +
            "}\n" +
            "* { font-family: \"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif; }\n" +
            "\n" +
            "img { \n" +
            "\tmax-width: 100%; \n" +
            "}\n" +
            ".collapse {\n" +
            "\tmargin:0;\n" +
            "\tpadding:0;\n" +
            "}\n" +
            "body {\n" +
            "\t-webkit-font-smoothing:antialiased; \n" +
            "\t-webkit-text-size-adjust:none; \n" +
            "\twidth: 100%!important; \n" +
            "\theight: 100%;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tELEMENTS \n" +
            "------------------------------------- */\n" +
            "a { color: #2BA6CB;}\n" +
            "\n" +
            ".btn {\n" +
            "\ttext-decoration:none;\n" +
            "\tcolor: #FFF;\n" +
            "\tbackground-color: #666;\n" +
            "\tpadding:10px 16px;\n" +
            "\tfont-weight:bold;\n" +
            "\tmargin-right:10px;\n" +
            "\ttext-align:center;\n" +
            "\tcursor:pointer;\n" +
            "\tdisplay: inline-block;\n" +
            "}\n" +
            "\n" +
            "p.callout {\n" +
            "\tpadding:15px;\n" +
            "\tbackground-color:#ECF8FF;\n" +
            "\tmargin-bottom: 15px;\n" +
            "}\n" +
            ".callout a {\n" +
            "\tfont-weight:bold;\n" +
            "\tcolor: #2BA6CB;\n" +
            "}\n" +
            "\n" +
            "table.social {\n" +
            "/* \tpadding:15px; */\n" +
            "\tbackground-color: #ebebeb;\n" +
            "\t\n" +
            "}\n" +
            ".social .soc-btn {\n" +
            "\tpadding: 3px 7px;\n" +
            "\tfont-size:12px;\n" +
            "\tmargin-bottom:10px;\n" +
            "\ttext-decoration:none;\n" +
            "\tcolor: #FFF;font-weight:bold;\n" +
            "\tdisplay:block;\n" +
            "\ttext-align:center;\n" +
            "}\n" +
            "a.fb { background-color: #3B5998!important; }\n" +
            "a.tw { background-color: #1daced!important; }\n" +
            "a.gp { background-color: #DB4A39!important; }\n" +
            "a.ms { background-color: #000!important; }\n" +
            "\n" +
            ".sidebar .soc-btn { \n" +
            "\tdisplay:block;\n" +
            "\twidth:100%;\n" +
            "}\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tHEADER \n" +
            "------------------------------------- */\n" +
            "table.head-wrap { width: 100%;}\n" +
            "\n" +
            ".header.container table td.logo { padding: 15px; }\n" +
            ".header.container table td.label { padding: 15px; padding-left:0px;}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tBODY \n" +
            "------------------------------------- */\n" +
            "table.body-wrap { width: 100%;}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tFOOTER \n" +
            "------------------------------------- */\n" +
            "table.footer-wrap { width: 100%;\tclear:both!important;\n" +
            "}\n" +
            ".footer-wrap .container td.content  p { border-top: 1px solid rgb(215,215,215); padding-top:15px;}\n" +
            ".footer-wrap .container td.content p {\n" +
            "\tfont-size:10px;\n" +
            "\tfont-weight: bold;\n" +
            "\t\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tTYPOGRAPHY \n" +
            "------------------------------------- */\n" +
            "h1,h2,h3,h4,h5,h6 {\n" +
            "font-family: \"HelveticaNeue-Light\", \"Helvetica Neue Light\", \"Helvetica Neue\", Helvetica, Arial, \"Lucida Grande\", sans-serif; line-height: 1.1; margin-bottom:15px; color:#000;\n" +
            "}\n" +
            "h1 small, h2 small, h3 small, h4 small, h5 small, h6 small { font-size: 60%; color: #6f6f6f; line-height: 0; text-transform: none; }\n" +
            "\n" +
            "h1 { font-weight:200; font-size: 44px;}\n" +
            "h2 { font-weight:200; font-size: 37px;}\n" +
            "h3 { font-weight:500; font-size: 27px;}\n" +
            "h4 { font-weight:500; font-size: 23px;}\n" +
            "h5 { font-weight:900; font-size: 17px;}\n" +
            "h6 { font-weight:900; font-size: 14px; text-transform: uppercase; color:#444;}\n" +
            "\n" +
            ".collapse { margin:0!important;}\n" +
            "\n" +
            "p, ul { \n" +
            "\tmargin-bottom: 10px; \n" +
            "\tfont-weight: normal; \n" +
            "\tfont-size:14px; \n" +
            "\tline-height:1.6;\n" +
            "}\n" +
            "p.lead { font-size:17px; }\n" +
            "p.last { margin-bottom:0px;}\n" +
            "\n" +
            "ul li {\n" +
            "\tmargin-left:5px;\n" +
            "\tlist-style-position: inside;\n" +
            "}\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tSIDEBAR \n" +
            "------------------------------------- */\n" +
            "ul.sidebar {\n" +
            "\tbackground:#ebebeb;\n" +
            "\tdisplay:block;\n" +
            "\tlist-style-type: none;\n" +
            "}\n" +
            "ul.sidebar li { display: block; margin:0;}\n" +
            "ul.sidebar li a {\n" +
            "\ttext-decoration:none;\n" +
            "\tcolor: #666;\n" +
            "\tpadding:10px 16px;\n" +
            "/* \tfont-weight:bold; */\n" +
            "\tmargin-right:10px;\n" +
            "/* \ttext-align:center; */\n" +
            "\tcursor:pointer;\n" +
            "\tborder-bottom: 1px solid #777777;\n" +
            "\tborder-top: 1px solid #FFFFFF;\n" +
            "\tdisplay:block;\n" +
            "\tmargin:0;\n" +
            "}\n" +
            "ul.sidebar li a.last { border-bottom-width:0px;}\n" +
            "ul.sidebar li a h1,ul.sidebar li a h2,ul.sidebar li a h3,ul.sidebar li a h4,ul.sidebar li a h5,ul.sidebar li a h6,ul.sidebar li a p { margin-bottom:0!important;}\n" +
            "\n" +
            "\n" +
            "\n" +
            "/* --------------------------------------------------- \n" +
            "\t\tRESPONSIVENESS\n" +
            "\t\tNuke it from orbit. It's the only way to be sure. \n" +
            "------------------------------------------------------ */\n" +
            "\n" +
            "/* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\n" +
            ".container {\n" +
            "\tdisplay:block!important;\n" +
            "\tmax-width:600px!important;\n" +
            "\tmargin:0 auto!important; /* makes it centered */\n" +
            "\tclear:both!important;\n" +
            "}\n" +
            "\n" +
            "/* This should also be a block element, so that it will fill 100% of the .container */\n" +
            ".content {\n" +
            "\tpadding:15px;\n" +
            "\tmax-width:600px;\n" +
            "\tmargin:0 auto;\n" +
            "\tdisplay:block; \n" +
            "}\n" +
            "\n" +
            "/* Let's make sure tables in the content area are 100% wide */\n" +
            ".content table { width: 100%; }\n" +
            "\n" +
            "\n" +
            "/* Odds and ends */\n" +
            ".column {\n" +
            "\twidth: 300px;\n" +
            "\tfloat:left;\n" +
            "}\n" +
            ".column tr td { padding: 15px; }\n" +
            ".column-wrap { \n" +
            "\tpadding:0!important; \n" +
            "\tmargin:0 auto; \n" +
            "\tmax-width:600px!important;\n" +
            "}\n" +
            ".column table { width:100%;}\n" +
            ".social .column {\n" +
            "\twidth: 280px;\n" +
            "\tmin-width: 279px;\n" +
            "\tfloat:left;\n" +
            "}\n" +
            "\n" +
            "/* Be sure to place a .clear element after each set of columns, just to be safe */\n" +
            ".clear { display: block; clear: both; }\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------------- \n" +
            "\t\tPHONE\n" +
            "\t\tFor clients that support media queries.\n" +
            "\t\tNothing fancy. \n" +
            "-------------------------------------------- */\n" +
            "@media only screen and (max-width: 600px) {\n" +
            "\t\n" +
            "\ta[class=\"btn\"] { display:block!important; margin-bottom:10px!important; background-image:none!important; margin-right:0!important;}\n" +
            "\n" +
            "\tdiv[class=\"column\"] { width: auto!important; float:none!important;}\n" +
            "\t\n" +
            "\ttable.social div[class=\"column\"] {\n" +
            "\t\twidth:auto!important;\n" +
            "\t}\n" +
            "\n" +
            "}\n" +
            "</style\n" +
            "</head>\n" +
            " \n" +
            "<body bgcolor=\"#FFFFFF\">\n" +
            "\n" +
            "<!-- HEADER -->\n" +
            "<table class=\"head-wrap\" bgcolor=\"#23b7e5\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t\t<td class=\"header container\" >\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<div class=\"content\">\n" +
            "\t\t\t\t<table bgcolor=\"#23b7e5\">\n" +
            "\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t<td></td>\n" +
            "\t\t\t\t\t\t<td align=\"right\"><h6 class=\"collapse\" style=\"color:white;\">NexxRetail - User Creation</h6></td>\n" +
            "\t\t\t\t\t</tr>\n" +
            "\t\t\t\t</table>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t\n" +
            "\t\t</td>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table><!-- /HEADER -->\n" +
            "\n" +
            "\n" +
            "<!-- BODY -->\n" +
            "<table class=\"body-wrap\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t\t<td class=\"container\" bgcolor=\"#FFFFFF\">\n" +
            "\n" +
            "\t\t\t<div class=\"content\">\n" +
            "\t\t\t<table>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t<h3>Hi, " + userFullName + "</h3>\n" +
            "\t\t\t\t\t\t<p>The NexxRetail team would like to welcome you to use the application. The administrator has already filled in the basic details in your profile. Below are your login credentials</p>\n" +
            "\t\t\t\t\t\t<p style=\"color:#23b7e5; font-weight:bold;\">User Name : " + userName + "</p>\n" +
            "\t\t\t\t\t\t<p style=\"color:#23b7e5; font-weight:bold;\">Password : " + userPassword + "</p>\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<p>To Login to the application, please open the below link in your browser.</p>\n" +
            "\t\t\t\t\t\t<!-- Callout Panel -->\n" +
            "\t\t\t\t\t\t<p class=\"callout\">\n" +
            "\t\t\t\t\t\t\t<a href=\"" + loginUri + "\">" + loginUri + " &raquo;</a>\n" +
            "\t\t\t\t\t\t</p><!-- /Callout Panel -->\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t<h6>Kind Regards,</h6>\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t<h6>NexxRetail Administrator</h6>\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</table>\n" +
            "\t\t\t</div><!-- /content -->\n" +
            "\t\t\t\t\t\t\t\t\t\n" +
            "\t\t</td>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table><!-- /BODY -->\n" +
            "\n" +
            "<!-- FOOTER -->\n" +
            "<table class=\"footer-wrap\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t\t<td class=\"container\">\n" +
            "\t\t\t\n" +
            "\t\t\t\t<!-- content -->\n" +
            "\t\t\t\t<div class=\"content\">\n" +
            "\t\t\t\t<table>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t<p>\n" +
            "\t\t\t\t\t\t\tDesigned and Developed by Compulynx LTD 2015\n" +
            "\t\t\t\t\t\t</p>\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</table>\n" +
            "\t\t\t\t</div><!-- /content -->\n" +
            "\t\t\t\t\n" +
            "\t\t</td>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table><!-- /FOOTER -->\n" +
            "\n" +
            "</body>\n" +
            "</html>\n";
    }

    public static String getUpdateUserTemplate(String userFullName, String userName, String userPassword, String uri) {
        String loginUri = uri + "/#/page/login";
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<head>\n" +
            "<!-- If you delete this meta tag, Half Life 3 will never be released. -->\n" +
            "<meta name=\"viewport\" content=\"width=device-width\" />\n" +
            "\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
            "<title>NexxRetail-User Modification</title>\n" +
            "\t\n" +
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheets/email.css\" />\n" +
            "<style type=\"text/css\">\n" +
            "/* ------------------------------------- \n" +
            "\t\tGLOBAL \n" +
            "------------------------------------- */\n" +
            "* { \n" +
            "\tmargin:0;\n" +
            "\tpadding:0;\n" +
            "}\n" +
            "* { font-family: \"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif; }\n" +
            "\n" +
            "img { \n" +
            "\tmax-width: 100%; \n" +
            "}\n" +
            ".collapse {\n" +
            "\tmargin:0;\n" +
            "\tpadding:0;\n" +
            "}\n" +
            "body {\n" +
            "\t-webkit-font-smoothing:antialiased; \n" +
            "\t-webkit-text-size-adjust:none; \n" +
            "\twidth: 100%!important; \n" +
            "\theight: 100%;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tELEMENTS \n" +
            "------------------------------------- */\n" +
            "a { color: #2BA6CB;}\n" +
            "\n" +
            ".btn {\n" +
            "\ttext-decoration:none;\n" +
            "\tcolor: #FFF;\n" +
            "\tbackground-color: #666;\n" +
            "\tpadding:10px 16px;\n" +
            "\tfont-weight:bold;\n" +
            "\tmargin-right:10px;\n" +
            "\ttext-align:center;\n" +
            "\tcursor:pointer;\n" +
            "\tdisplay: inline-block;\n" +
            "}\n" +
            "\n" +
            "p.callout {\n" +
            "\tpadding:15px;\n" +
            "\tbackground-color:#ECF8FF;\n" +
            "\tmargin-bottom: 15px;\n" +
            "}\n" +
            ".callout a {\n" +
            "\tfont-weight:bold;\n" +
            "\tcolor: #2BA6CB;\n" +
            "}\n" +
            "\n" +
            "table.social {\n" +
            "/* \tpadding:15px; */\n" +
            "\tbackground-color: #ebebeb;\n" +
            "\t\n" +
            "}\n" +
            ".social .soc-btn {\n" +
            "\tpadding: 3px 7px;\n" +
            "\tfont-size:12px;\n" +
            "\tmargin-bottom:10px;\n" +
            "\ttext-decoration:none;\n" +
            "\tcolor: #FFF;font-weight:bold;\n" +
            "\tdisplay:block;\n" +
            "\ttext-align:center;\n" +
            "}\n" +
            "a.fb { background-color: #3B5998!important; }\n" +
            "a.tw { background-color: #1daced!important; }\n" +
            "a.gp { background-color: #DB4A39!important; }\n" +
            "a.ms { background-color: #000!important; }\n" +
            "\n" +
            ".sidebar .soc-btn { \n" +
            "\tdisplay:block;\n" +
            "\twidth:100%;\n" +
            "}\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tHEADER \n" +
            "------------------------------------- */\n" +
            "table.head-wrap { width: 100%;}\n" +
            "\n" +
            ".header.container table td.logo { padding: 15px; }\n" +
            ".header.container table td.label { padding: 15px; padding-left:0px;}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tBODY \n" +
            "------------------------------------- */\n" +
            "table.body-wrap { width: 100%;}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tFOOTER \n" +
            "------------------------------------- */\n" +
            "table.footer-wrap { width: 100%;\tclear:both!important;\n" +
            "}\n" +
            ".footer-wrap .container td.content  p { border-top: 1px solid rgb(215,215,215); padding-top:15px;}\n" +
            ".footer-wrap .container td.content p {\n" +
            "\tfont-size:10px;\n" +
            "\tfont-weight: bold;\n" +
            "\t\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tTYPOGRAPHY \n" +
            "------------------------------------- */\n" +
            "h1,h2,h3,h4,h5,h6 {\n" +
            "font-family: \"HelveticaNeue-Light\", \"Helvetica Neue Light\", \"Helvetica Neue\", Helvetica, Arial, \"Lucida Grande\", sans-serif; line-height: 1.1; margin-bottom:15px; color:#000;\n" +
            "}\n" +
            "h1 small, h2 small, h3 small, h4 small, h5 small, h6 small { font-size: 60%; color: #6f6f6f; line-height: 0; text-transform: none; }\n" +
            "\n" +
            "h1 { font-weight:200; font-size: 44px;}\n" +
            "h2 { font-weight:200; font-size: 37px;}\n" +
            "h3 { font-weight:500; font-size: 27px;}\n" +
            "h4 { font-weight:500; font-size: 23px;}\n" +
            "h5 { font-weight:900; font-size: 17px;}\n" +
            "h6 { font-weight:900; font-size: 14px; text-transform: uppercase; color:#444;}\n" +
            "\n" +
            ".collapse { margin:0!important;}\n" +
            "\n" +
            "p, ul { \n" +
            "\tmargin-bottom: 10px; \n" +
            "\tfont-weight: normal; \n" +
            "\tfont-size:14px; \n" +
            "\tline-height:1.6;\n" +
            "}\n" +
            "p.lead { font-size:17px; }\n" +
            "p.last { margin-bottom:0px;}\n" +
            "\n" +
            "ul li {\n" +
            "\tmargin-left:5px;\n" +
            "\tlist-style-position: inside;\n" +
            "}\n" +
            "\n" +
            "/* ------------------------------------- \n" +
            "\t\tSIDEBAR \n" +
            "------------------------------------- */\n" +
            "ul.sidebar {\n" +
            "\tbackground:#ebebeb;\n" +
            "\tdisplay:block;\n" +
            "\tlist-style-type: none;\n" +
            "}\n" +
            "ul.sidebar li { display: block; margin:0;}\n" +
            "ul.sidebar li a {\n" +
            "\ttext-decoration:none;\n" +
            "\tcolor: #666;\n" +
            "\tpadding:10px 16px;\n" +
            "/* \tfont-weight:bold; */\n" +
            "\tmargin-right:10px;\n" +
            "/* \ttext-align:center; */\n" +
            "\tcursor:pointer;\n" +
            "\tborder-bottom: 1px solid #777777;\n" +
            "\tborder-top: 1px solid #FFFFFF;\n" +
            "\tdisplay:block;\n" +
            "\tmargin:0;\n" +
            "}\n" +
            "ul.sidebar li a.last { border-bottom-width:0px;}\n" +
            "ul.sidebar li a h1,ul.sidebar li a h2,ul.sidebar li a h3,ul.sidebar li a h4,ul.sidebar li a h5,ul.sidebar li a h6,ul.sidebar li a p { margin-bottom:0!important;}\n" +
            "\n" +
            "\n" +
            "\n" +
            "/* --------------------------------------------------- \n" +
            "\t\tRESPONSIVENESS\n" +
            "\t\tNuke it from orbit. It's the only way to be sure. \n" +
            "------------------------------------------------------ */\n" +
            "\n" +
            "/* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\n" +
            ".container {\n" +
            "\tdisplay:block!important;\n" +
            "\tmax-width:600px!important;\n" +
            "\tmargin:0 auto!important; /* makes it centered */\n" +
            "\tclear:both!important;\n" +
            "}\n" +
            "\n" +
            "/* This should also be a block element, so that it will fill 100% of the .container */\n" +
            ".content {\n" +
            "\tpadding:15px;\n" +
            "\tmax-width:600px;\n" +
            "\tmargin:0 auto;\n" +
            "\tdisplay:block; \n" +
            "}\n" +
            "\n" +
            "/* Let's make sure tables in the content area are 100% wide */\n" +
            ".content table { width: 100%; }\n" +
            "\n" +
            "\n" +
            "/* Odds and ends */\n" +
            ".column {\n" +
            "\twidth: 300px;\n" +
            "\tfloat:left;\n" +
            "}\n" +
            ".column tr td { padding: 15px; }\n" +
            ".column-wrap { \n" +
            "\tpadding:0!important; \n" +
            "\tmargin:0 auto; \n" +
            "\tmax-width:600px!important;\n" +
            "}\n" +
            ".column table { width:100%;}\n" +
            ".social .column {\n" +
            "\twidth: 280px;\n" +
            "\tmin-width: 279px;\n" +
            "\tfloat:left;\n" +
            "}\n" +
            "\n" +
            "/* Be sure to place a .clear element after each set of columns, just to be safe */\n" +
            ".clear { display: block; clear: both; }\n" +
            "\n" +
            "\n" +
            "/* ------------------------------------------- \n" +
            "\t\tPHONE\n" +
            "\t\tFor clients that support media queries.\n" +
            "\t\tNothing fancy. \n" +
            "-------------------------------------------- */\n" +
            "@media only screen and (max-width: 600px) {\n" +
            "\t\n" +
            "\ta[class=\"btn\"] { display:block!important; margin-bottom:10px!important; background-image:none!important; margin-right:0!important;}\n" +
            "\n" +
            "\tdiv[class=\"column\"] { width: auto!important; float:none!important;}\n" +
            "\t\n" +
            "\ttable.social div[class=\"column\"] {\n" +
            "\t\twidth:auto!important;\n" +
            "\t}\n" +
            "\n" +
            "}\n" +
            "</style\n" +
            "</head>\n" +
            " \n" +
            "<body bgcolor=\"#FFFFFF\">\n" +
            "\n" +
            "<!-- HEADER -->\n" +
            "<table class=\"head-wrap\" bgcolor=\"#23b7e5\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t\t<td class=\"header container\" >\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<div class=\"content\">\n" +
            "\t\t\t\t<table bgcolor=\"#23b7e5\">\n" +
            "\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t<td></td>\n" +
            "\t\t\t\t\t\t<td align=\"right\"><h6 class=\"collapse\" style=\"color:white;\">NexxRetail - User Modification</h6></td>\n" +
            "\t\t\t\t\t</tr>\n" +
            "\t\t\t\t</table>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t\n" +
            "\t\t</td>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table><!-- /HEADER -->\n" +
            "\n" +
            "\n" +
            "<!-- BODY -->\n" +
            "<table class=\"body-wrap\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t\t<td class=\"container\" bgcolor=\"#FFFFFF\">\n" +
            "\n" +
            "\t\t\t<div class=\"content\">\n" +
            "\t\t\t<table>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t<h3>Hi, " + userFullName + "</h3>\n" +
            "\t\t\t\t\t\t\t<p>Your user information has been modified. Below are your new credentials</p>\n" +
            "\t\t\t\t\t\t\t<p style=\"color:#23b7e5; font-weight:bold;\">User Name : " + userName + "</p>\n" +
            "\t\t\t\t\t\t\t<p style=\"color:#23b7e5; font-weight:bold;\">Password  : " + userPassword + "</p>\n" +
            "\t\t\t\t\t\t\t<p>To Login to the application, please open the below link in your browser.</p>\n" +
            "\t\t\t\t\t\t<!-- Callout Panel -->\n" +
            "\t\t\t\t\t\t<p class=\"callout\">\n" +
            "\t\t\t\t\t\t\t<a href=\"" + loginUri + "\">" + loginUri + " &raquo;</a>\n" +
            "\t\t\t\t\t\t</p><!-- /Callout Panel -->\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t<h6>Kind Regards,</h6>\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t<h6>NexxRetail Administrator</h6>\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</table>\n" +
            "\t\t\t</div><!-- /content -->\n" +
            "\t\t\t\t\t\t\t\t\t\n" +
            "\t\t</td>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table><!-- /BODY -->\n" +
            "\n" +
            "<!-- FOOTER -->\n" +
            "<table class=\"footer-wrap\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t\t<td class=\"container\">\n" +
            "\t\t\t\n" +
            "\t\t\t\t<!-- content -->\n" +
            "\t\t\t\t<div class=\"content\">\n" +
            "\t\t\t\t<table>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t<p>\n" +
            "\t\t\t\t\t\t\tDesigned and Developed by Compulynx LTD 2015\n" +
            "\t\t\t\t\t\t</p>\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</table>\n" +
            "\t\t\t\t</div><!-- /content -->\n" +
            "\t\t\t\t\n" +
            "\t\t</td>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table><!-- /FOOTER -->\n" +
            "\n" +
            "</body>\n" +
            "</html>\n";
    }
}
