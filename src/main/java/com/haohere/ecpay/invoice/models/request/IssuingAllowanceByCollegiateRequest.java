package com.haohere.ecpay.invoice.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haohere.ecpay.invoice.models.base.BaseDataRequest;

import java.util.List;

/**
 * @author haohao
 * @date 2022/6/11
 */
public class IssuingAllowanceByCollegiateRequest extends BaseDataRequest {

    @JsonProperty(value = "InvoiceNo")
    public String invoiceNo;

    @JsonProperty(value = "InvoiceDate")
    public String invoiceDate;

    /**
     * 通知類別
     * 開立折讓後，寄送將相關發票折讓資訊通知消費者
     * S：簡訊
     * E：電子郵件
     * A：皆通知時
     * N：皆不通知
     */
    @JsonProperty(value = "AllowanceNotify")
    public String allowanceNotify;

    @JsonProperty(value = "CustomerName")
    public String customerName;

    /**
     * 通知電子信箱
     * 1. 若通知類別[AllowanceNotify]為電子郵件(E)，此欄位須有值
     * 2. 需為有效的 Email 格式
     * 3. 將參數值做 UrlEncode
     * 4. 可帶入多組 Email，並以分號區隔 ex: aa@aa.aa;bb@bb.bb
     */
    @JsonProperty(value = "NotifyMail")
    public String notifyMail;

    /**
     * 通知手機號碼
     */
    @JsonProperty(value = "NotifyPhone")
    public String notifyPhone;

    /**
     * 折讓單總金額(含稅)
     */
    @JsonProperty(value = "AllowanceAmount")
    public int allowanceAmount;

    @JsonProperty(value = "Items")
    public List<ItemDataModel> items;

    @JsonProperty(value = "Reason")
    public String reason;

    @JsonProperty(value = "ReturnURL")
    public String returnUrl;
}
